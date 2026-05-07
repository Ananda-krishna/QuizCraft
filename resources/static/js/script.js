document.addEventListener('DOMContentLoaded', () => {
    // ---- Navigation Elements ----
    const tabTake = document.getElementById('tab-take');
    const tabBuild = document.getElementById('tab-build');
    const takeMode = document.getElementById('take-mode');
    const buildMode = document.getElementById('build-mode');

    // ---- Quiz Taker Elements ----
    const categoryCards = document.querySelectorAll('.category-card');
    const categorySelection = document.getElementById('category-selection');
    const difficultySelection = document.getElementById('difficulty-selection');
    const quizPlayer = document.getElementById('quiz-player');
    const quizScoreView = document.getElementById('quiz-score');
    const gameOverView = document.getElementById('game-over');
    const healthHearts = document.getElementById('health-hearts');
    const respawnBtn = document.getElementById('respawn-btn');
    const gameOverScoreEl = document.getElementById('game-over-score');
    const difficultyBtns = document.querySelectorAll('.difficulty-btn');
    const backToCategoriesBtnHeader = document.getElementById('back-to-categories-btn-header');
    
    const playerQuizTitle = document.getElementById('player-quiz-title');
    const playerProgress = document.getElementById('player-progress');
    const playerQuestionText = document.getElementById('player-question-text');
    const playerOptions = document.getElementById('player-options');
    const playerNextBtn = document.getElementById('player-next-btn');
    
    const finalScoreEl = document.getElementById('final-score');
    const scoreMessageEl = document.getElementById('score-message');
    const backToCategoriesBtn = document.getElementById('back-to-categories-btn');

    // ---- Quiz Builder Elements ----
    const questionsContainer = document.getElementById('questions-container');
    const addQuestionBtn = document.getElementById('add-question-btn');
    const saveQuizBtn = document.getElementById('save-quiz-btn');
    const statusMessage = document.getElementById('status-message');
    const questionTemplate = document.getElementById('question-template');
    const optionTemplate = document.getElementById('option-template');
    let questionCount = 0;

    const exitQuizBtn = document.getElementById('exit-quiz-btn');
    const confirmModal = document.getElementById('confirm-modal');
    const confirmExitBtn = document.getElementById('confirm-exit-btn');
    const cancelExitBtn = document.getElementById('cancel-exit-btn');

    // ---- State ----
    let activeQuiz = null;
    let fullQuestionPool = [];
    let currentQuestionIndex = 0;
    let score = 0;
    let currentHealth = 10;
    const maxHealth = 10;
    let selectedCategory = '';
    let selectedDifficulty = '';

    // ---- 1. Tab Navigation & Modal Logic ----
    tabTake.addEventListener('click', () => switchTab('take'));
    tabBuild.addEventListener('click', () => switchTab('build'));

    exitQuizBtn.addEventListener('click', () => {
        confirmModal.classList.remove('hidden');
    });

    cancelExitBtn.addEventListener('click', () => {
        confirmModal.classList.add('hidden');
    });

    confirmExitBtn.addEventListener('click', () => {
        confirmModal.classList.add('hidden');
        quizPlayer.classList.add('hidden');
        difficultySelection.classList.add('hidden');
        categorySelection.classList.remove('hidden');
    });

    backToCategoriesBtnHeader.addEventListener('click', () => {
        difficultySelection.classList.add('hidden');
        categorySelection.classList.remove('hidden');
    });

    function switchTab(tab) {
        if (tab === 'take') {
            tabTake.classList.add('active');
            tabBuild.classList.remove('active');
            takeMode.classList.remove('hidden');
            buildMode.classList.add('hidden');
        } else {
            tabBuild.classList.add('active');
            tabTake.classList.remove('active');
            buildMode.classList.remove('hidden');
            takeMode.classList.add('hidden');
        }
    }

    // ---- 2. Quiz Taker Logic ----
    
    categoryCards.forEach(card => {
        card.addEventListener('click', () => {
            const category = card.dataset.category;
            fetchQuizByCategory(category);
        });
    });

    async function fetchQuizByCategory(category) {
        try {
            const response = await fetch(`/api/quizzes/category/${category}`);
            const quizzes = await response.json();
            
            if (quizzes.length > 0) {
                selectedCategory = category;
                fullQuestionPool = quizzes[0].questions;
                
                // Show difficulty selection
                categorySelection.classList.add('hidden');
                difficultySelection.classList.remove('hidden');
            } else {
                alert(`No quizzes found for category: ${category}. Build one first!`);
            }
        } catch (error) {
            console.error('Error fetching quiz:', error);
        }
    }

    difficultyBtns.forEach(btn => {
        btn.addEventListener('click', () => {
            selectedDifficulty = btn.dataset.difficulty;
            const filteredQuestions = fullQuestionPool.filter(q => q.difficulty === selectedDifficulty);
            
            if (filteredQuestions.length === 0) {
                alert(`No ${selectedDifficulty} questions found for this category!`);
                return;
            }
            
            startQuiz(filteredQuestions);
        });
    });

    function shuffleAndPick(arr, n) {
        // Fisher-Yates shuffle then slice
        const copy = [...arr];
        for (let i = copy.length - 1; i > 0; i--) {
            const j = Math.floor(Math.random() * (i + 1));
            [copy[i], copy[j]] = [copy[j], copy[i]];
        }
        return copy.slice(0, n);
    }

    function startQuiz(questions) {
        // Pick 10 random questions from the filtered pool
        activeQuiz = {
            title: `${selectedCategory} - ${selectedDifficulty}`,
            questions: shuffleAndPick(questions, 10)
        };
        currentQuestionIndex = 0;
        score = 0;
        currentHealth = maxHealth;
        renderHealth();
        
        difficultySelection.classList.add('hidden');
        quizScoreView.classList.add('hidden');
        gameOverView.classList.add('hidden');
        quizPlayer.classList.remove('hidden');
        
        playerQuizTitle.textContent = activeQuiz.title;
        loadQuestion();
    }

    function renderHealth() {
        healthHearts.innerHTML = '';
        for (let i = 0; i < maxHealth; i++) {
            const img = document.createElement('img');
            img.src = i < currentHealth ? '/images/heart_full.svg' : '/images/heart_empty.svg';
            img.className = 'heart-icon';
            healthHearts.appendChild(img);
        }
    }

    function loadQuestion() {
        const question = activeQuiz.questions[currentQuestionIndex];
        playerProgress.textContent = `${currentQuestionIndex + 1} / ${activeQuiz.questions.length}`;
        playerQuestionText.textContent = question.text;
        
        playerOptions.innerHTML = '';
        playerNextBtn.classList.add('hidden');
        
        question.options.forEach((optText, index) => {
            const btn = document.createElement('button');
            btn.className = 'player-option-btn';
            btn.textContent = optText;
            btn.addEventListener('click', () => handleAnswerSelection(index, btn, question.correctOptionIndex));
            playerOptions.appendChild(btn);
        });
    }

    function handleAnswerSelection(selectedIndex, btnElement, correctIndex) {
        // Disable all buttons
        const allBtns = playerOptions.querySelectorAll('.player-option-btn');
        allBtns.forEach(b => b.disabled = true);

        if (selectedIndex === correctIndex) {
            btnElement.classList.add('correct');
            score++;
        } else {
            btnElement.classList.add('wrong');
            allBtns[correctIndex].classList.add('correct');
            
            // Heart shatter logic
            const hearts = healthHearts.querySelectorAll('.heart-icon');
            if (currentHealth > 0) {
                const heartToShatter = hearts[currentHealth - 1];
                
                // Add shatter effect to specific heart
                heartToShatter.classList.add('shatter');
                
                // Red flash overlay effect on the player container
                quizPlayer.style.backgroundColor = 'rgba(255, 0, 0, 0.2)';
                setTimeout(() => {
                    quizPlayer.style.backgroundColor = 'rgba(255, 255, 255, 0.9)';
                }, 150);
                
                // Screen shake
                quizPlayer.classList.add('shake');
                setTimeout(() => quizPlayer.classList.remove('shake'), 400);
                
                // Wait for shatter to finish before redrawing health
                setTimeout(() => {
                    currentHealth--;
                    renderHealth();
                    if (currentHealth <= 0) showGameOver();
                }, 600);
            }
            
            if (currentHealth <= 0) return;
        }

        playerNextBtn.classList.remove('hidden');
    }

    function showGameOver() {
        quizPlayer.classList.add('hidden');
        gameOverView.classList.remove('hidden');
        gameOverScoreEl.textContent = score;
    }

    respawnBtn.addEventListener('click', () => {
        gameOverView.classList.add('hidden');
        categorySelection.classList.remove('hidden');
    });

    playerNextBtn.addEventListener('click', () => {
        currentQuestionIndex++;
        if (currentQuestionIndex < activeQuiz.questions.length) {
            loadQuestion();
        } else {
            showScore();
        }
    });

    function showScore() {
        quizPlayer.classList.add('hidden');
        quizScoreView.classList.remove('hidden');
        
        finalScoreEl.textContent = `${score}/${activeQuiz.questions.length}`;
        
        const percentage = score / activeQuiz.questions.length;
        if (percentage === 1) scoreMessageEl.textContent = "Perfect! You're a genius! 🌟";
        else if (percentage >= 0.5) scoreMessageEl.textContent = "Good job! Keep practicing! 👍";
        else scoreMessageEl.textContent = "Better luck next time! 📚";
    }

    backToCategoriesBtn.addEventListener('click', () => {
        quizScoreView.classList.add('hidden');
        categorySelection.classList.remove('hidden');
    });

    // ---- 3. Quiz Builder Logic (Existing) ----
    
    addQuestionBtn.addEventListener('click', addQuestion);
    saveQuizBtn.addEventListener('click', saveQuiz);

    // Initialize with one question
    addQuestion();

    function addQuestion() {
        questionCount++;
        const questionNode = questionTemplate.content.cloneNode(true);
        const questionBlock = questionNode.querySelector('.question-block');
        
        questionNode.querySelector('.question-number').textContent = `Question ${questionCount}`;
        
        const optionsContainer = questionNode.querySelector('.options-container');
        const questionId = `q_${Date.now()}`;
        questionBlock.dataset.id = questionId;

        addOption(optionsContainer, questionId);
        addOption(optionsContainer, questionId);

        questionNode.querySelector('.remove-question-btn').addEventListener('click', (e) => {
            e.target.closest('.question-block').remove();
            updateQuestionNumbers();
        });

        questionNode.querySelector('.add-option-btn').addEventListener('click', (e) => {
            addOption(e.target.previousElementSibling, questionId);
        });

        questionsContainer.appendChild(questionNode);
    }

    function addOption(container, questionId) {
        const optionNode = optionTemplate.content.cloneNode(true);
        const radioBtn = optionNode.querySelector('.correct-option-radio');
        radioBtn.name = `correct_${questionId}`;
        
        if (container.children.length === 0) {
            radioBtn.checked = true;
        }

        optionNode.querySelector('.remove-option-btn').addEventListener('click', (e) => {
            const block = e.target.closest('.option-block');
            const radio = block.querySelector('.correct-option-radio');
            if (radio.checked) {
                const otherRadios = container.querySelectorAll('.correct-option-radio');
                for (let r of otherRadios) {
                    if (r !== radio) {
                        r.checked = true;
                        break;
                    }
                }
            }
            if (container.children.length > 2) {
                block.remove();
            } else {
                showStatus('Questions must have at least 2 options.', 'error');
            }
        });

        container.appendChild(optionNode);
    }

    function updateQuestionNumbers() {
        const blocks = questionsContainer.querySelectorAll('.question-block');
        questionCount = blocks.length;
        blocks.forEach((block, index) => {
            block.querySelector('.question-number').textContent = `Question ${index + 1}`;
        });
    }

    async function saveQuiz() {
        const title = document.getElementById('quiz-title').value.trim();
        const description = document.getElementById('quiz-desc').value.trim();
        const categoryElement = document.querySelector('input[name="quiz-category"]:checked');
        const category = categoryElement ? categoryElement.value : 'Science';

        if (!title) {
            showStatus('Please enter a quiz title.', 'error');
            return;
        }

        const questionBlocks = questionsContainer.querySelectorAll('.question-block');
        if (questionBlocks.length === 0) {
            showStatus('Please add at least one question.', 'error');
            return;
        }

        const questions = [];
        let isValid = true;

        questionBlocks.forEach(block => {
            const text = block.querySelector('.question-text').value.trim();
            if (!text) isValid = false;

            const optionBlocks = block.querySelectorAll('.option-block');
            const options = [];
            let correctOptionIndex = -1;

            optionBlocks.forEach((optBlock, index) => {
                const optText = optBlock.querySelector('.option-text').value.trim();
                if (!optText) isValid = false;
                options.push(optText);

                if (optBlock.querySelector('.correct-option-radio').checked) {
                    correctOptionIndex = index;
                }
            });

            questions.push({ text, options, correctOptionIndex });
        });

        if (!isValid) {
            showStatus('Please fill out all question and option fields.', 'error');
            return;
        }

        const quizData = { title, category, description, questions };

        const originalText = saveQuizBtn.textContent;
        saveQuizBtn.textContent = 'Saving...';
        saveQuizBtn.disabled = true;

        try {
            const response = await fetch('/api/quizzes', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(quizData)
            });

            if (response.ok) {
                showStatus('Quiz saved successfully!', 'success');
            } else {
                showStatus('Failed to save quiz.', 'error');
            }
        } catch (error) {
            console.error('Error saving quiz:', error);
            showStatus('Error saving quiz. Check console.', 'error');
        } finally {
            saveQuizBtn.textContent = originalText;
            saveQuizBtn.disabled = false;
        }
    }

    function showStatus(message, type) {
        statusMessage.textContent = message;
        statusMessage.className = `status-${type}`;
        statusMessage.classList.remove('hidden');
        setTimeout(() => {
            statusMessage.classList.add('hidden');
        }, 3000);
    }
});
