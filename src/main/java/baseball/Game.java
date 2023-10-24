package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final int INPUT_LENGTH = 3;
    private static final String EXCEPTION_MESSAGE = "1 또는 2를 입력하세요.";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String QUIT_MESSAGE = "게임 종료";
    private static final String RESTART_NUMBER = "1";
    private static final String QUIT_NUMBER = "2";

    private int ballCount = 0;
    private int strikeCount = 0;

    Computer computer = new Computer();
    User user = new User();

    private void initializeRandomNumber() {
        computer.setComputerNumber();
    }

    private void getUserInput() {
        user.setUserInput();
    }

    private void checkStrike() {
        strikeCount = 0;

        for(int numberIndex_i = 0; numberIndex_i < INPUT_LENGTH; numberIndex_i++) {
            countStrike(numberIndex_i);
        }
    }

    private void countStrike(int numberIndex_i) {
        if(user.userInput[numberIndex_i] == computer.computerNumber[numberIndex_i]) {
            strikeCount++;
        }
    }
    private void checkBall() {
        ballCount = 0;

        for(int userIndex_i = 0; userIndex_i < INPUT_LENGTH; userIndex_i++){
            ballCount += countSameNumber(userIndex_i);
        }

        if(strikeCount > 0) {
            ballCount -= strikeCount;
        }
    }

    private int countSameNumber(int userIndex_i) {
        for(int computerIndex_j = 0; computerIndex_j < INPUT_LENGTH; computerIndex_j++) {
            if(user.userInput[userIndex_i] == computer.computerNumber[computerIndex_j]) {
                return 1;
            }
        }
        return 0;
    }

    private void printResultMessage() {
        String result = "";

        if(ballCount > 0 && strikeCount > 0){
            result = ballCount + BALL_MESSAGE + " " + strikeCount + STRIKE_MESSAGE;
        } else if(ballCount > 0 && strikeCount == 0) {
            result = ballCount + BALL_MESSAGE;
        } else if(ballCount == 0 && strikeCount > 0) {
            result = strikeCount + STRIKE_MESSAGE;
        } else if(ballCount == 0 && strikeCount == 0) {
            result = NOTHING_MESSAGE;
        }
        System.out.println(result);
    }

    public void startGame(){
        System.out.println(START_MESSAGE);
        game();
    }

    private void game() {
        boolean quit = false;
        initializeRandomNumber();

        while(!quit) {
            getUserInput();
            checkStrike();
            checkBall();
            printResultMessage();
            quit = isGameEnd();
        }
    }

    private boolean isGameEnd() {
        if(strikeCount == INPUT_LENGTH) {
            System.out.println(WIN_MESSAGE);
            return askRetry();
        }
        return false;
    }

    private boolean askRetry() {
        System.out.println(RETRY_MESSAGE);
        String quitInput = Console.readLine();

        if(quitInput.equals(RESTART_NUMBER)) {
            initializeRandomNumber();
            return false;
        }
        if(quitInput.equals(QUIT_NUMBER)) {
            System.out.println(QUIT_MESSAGE);
            return true;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

}
