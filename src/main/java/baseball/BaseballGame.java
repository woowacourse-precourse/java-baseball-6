package baseball;

/* 게임을 반복 진행 */
public class BaseballGame {
    private final BaseballInputView baseballInputView; // 입력문
    private final BaseballOutputView baseballOutputView; // 출력문
    private final BaseballComputer baseballComputer; // 게임에 필요한 숫자를 생성
    private final BaseballUmpire baseballUmpire; // 유저가 입력한 숫자를 판정

    public BaseballGame(BaseballInputView baseballInputView, BaseballOutputView baseballOutputView,
                        BaseballComputer baseballComputer, BaseballUmpire baseballUmpire) {
        this.baseballInputView = baseballInputView;
        this.baseballOutputView = baseballOutputView;
        this.baseballComputer = baseballComputer;
        this.baseballUmpire = baseballUmpire;
    }

    public void start() {
        do {
            String computerNumber = baseballComputer.createComputerNumber(); // 컴퓨터 숫자 생성
            System.out.println(computerNumber);
            do {
                String userNumber = baseballInputView.inputUserNumber(); // 유저 숫자 입력
                printGameResult(umpire(computerNumber, userNumber)); // 판정 결과 출력
            } while (!isThreeStrike());
        } while (!isGameEnd());
    }

    private int[] umpire(String computerNumber, String userNumber) {
        return baseballUmpire.umpire(computerNumber, userNumber);
    }

    private void printGameResult(int[] results) {
        int ballCount = results[0];
        int strikeCount = results[1];

        printNothing(ballCount, strikeCount);
        printBall(ballCount, strikeCount);
        printStrike(strikeCount);
    }

    private void printStrike(int strikeCount) {
        if (isStrike(strikeCount)) {
            baseballOutputView.outputCount(strikeCount);
            baseballOutputView.outputResultStrike();
        }
    }

    private void printBall(int ballCount, int strikeCount) {
        if (isBall(ballCount)) {
            if (isStrike(strikeCount)) {
                baseballOutputView.outputCount(ballCount);
                baseballOutputView.outputResultBallWithStrike();
            } else {
                baseballOutputView.outputCount(ballCount);
                baseballOutputView.outputResultBallWithoutStrike();
            }
        }
    }

    private void printNothing(int ballCount, int strikeCount) {
        if (isNothing(ballCount, strikeCount)) {
            baseballOutputView.outputResultNothing();
        }
    }

    private boolean isNothing(int ball, int strike) {
        return ball == 0 && strike == 0;
    }

    private boolean isBall(int ball) {
        return ball != 0;
    }

    private boolean isStrike(int strike) {
        return strike != 0;
    }

    private boolean isThreeStrike() {
        // 3 strike인지 확인
        if (checkThreeStrike()) {
            baseballOutputView.outputFinishGame();
            return true;
        }
        return false;
    }

    private boolean checkThreeStrike() {
        return baseballUmpire.getStrike() >= 3;
    }

    private boolean isGameEnd() {
        // 게임 종료 여부, 1 = 재시작, 2 = 종료
        return checkGameEnd();
    }

    private boolean checkGameEnd() {
        return baseballInputView.inputSelectRestartOrEnd().equals("2");
    }
}