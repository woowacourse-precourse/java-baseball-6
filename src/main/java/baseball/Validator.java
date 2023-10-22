package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Validator {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final int INPUT_LENGTH = 3;
    private static final String EXCEPTION_MESSAGE = "1 또는 2를 입력하세요.";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_NUMBER = "1";
    private static final String QUIT_NUMBER = "2";


    Computer computer = new Computer();
    User user = new User();
    private int ballCount = 0;
    private int strikeCount = 0;

    private void initializeRandomNumber() {
        this.computer.setComputerNumber();
    }
    private void checkStrike() {
        this.strikeCount = 0;
        for(int i = 0; i < INPUT_LENGTH; i++) {
            if (this.user.userInput[i] == this.computer.computerNumber[i]) {
                this.strikeCount++;
            }
        }
    }
    private void checkBall(){
        this.ballCount = 0;
        for(int i = 0; i < INPUT_LENGTH; i ++){
            this.ballCount += countSameNumber(i);
        }
        if(this.strikeCount > 0) {
            this.ballCount -= this.strikeCount;
        }
    }
    private int countSameNumber(int i) {
        for(int j = 0; j < INPUT_LENGTH; j++) {
            if(this.user.userInput[i] == this.computer.computerNumber[j]) {
                return 1;
            }
        }
        return 0;
    }
    private void printResultMessage() {
        String result = "";
        if(this.ballCount > 0 && this.strikeCount > 0){
            result = ballCount + BALL_MESSAGE + " " + strikeCount + STRIKE_MESSAGE;
        }
        if(this.ballCount > 0 && this.strikeCount == 0) {
            result = ballCount + BALL_MESSAGE;
        }
        if(this.ballCount == 0 && this.strikeCount > 0) {
            result = strikeCount + STRIKE_MESSAGE;
        }
        if(this.ballCount == 0 && this.strikeCount == 0) {
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
            this.user.setUserInput();
            checkStrike();
            checkBall();
            printResultMessage();
            if(strikeCount == INPUT_LENGTH) {
                quit = askRetry();
            }
        }
    }
    private boolean askRetry() {
        System.out.println(RETRY_MESSAGE);
        String quitInput = Console.readLine();
        if(quitInput.equals(RESTART_NUMBER)) {
            initializeRandomNumber();
            return false;
        }
        if(quitInput.equals(QUIT_NUMBER)) {
            return true;
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

}
