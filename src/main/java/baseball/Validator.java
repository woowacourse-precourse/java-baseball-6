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


}
