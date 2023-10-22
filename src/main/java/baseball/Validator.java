package baseball;

public class Validator {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final int INPUT_LENGTH = 3;


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

}
