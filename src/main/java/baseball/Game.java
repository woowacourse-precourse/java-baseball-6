package baseball;

import java.util.List;

class Game {
    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final GameResultHandler gameResultHandler = new GameResultHandler();
    private List<Integer> answerNumber;

    public void init() {
        answerNumber = RandomNumbers.generateRandom(3); 
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다");
        while (true) {
            String userInput = userInputHandler.getUserInput();
            if (userInputHandler.isValid(userInput)) {
                handleValidInput(userInput);
            } else {
                handleInvalidInput();
            }
        }
    } 

    private void handleValidInput(String userInput) {
        ResultCount result = getResult(userInput);
        gameResultHandler.displayResult(result);
        if (gameResultHandler.isEnd(userInput, answerNumber) && gameResultHandler.handleGameEnd()) {
        restartGame();
        }
    }

    private ResultCount getResult(String userInput) {
        return ResultCount.fromUserInput(userInput, answerNumber);
    }

    private void handleInvalidInput() {
        System.out.println("잘못된 입력입니다.");
        throw new IllegalArgumentException("게임 종료");
    }

    private void restartGame() {
        answerNumber.clear();
        init();
    }
    }