package baseball;

/* 게임을 반복 진행 */
public class BaseballGame {
    private final BaseballView baseballView; // 입출력 스크립트
    private final BaseballComputer baseballComputer; // 게임에 필요한 숫자를 생성
    private final BaseballUmpire baseballUmpire; // 유저가 입력한 숫자를 판정

    public BaseballGame(BaseballView baseballView, BaseballComputer baseballComputer, BaseballUmpire baseballUmpire) {
        this.baseballView = baseballView;
        this.baseballComputer = baseballComputer;
        this.baseballUmpire = baseballUmpire;
    }

    public void start() {
        do {
            String computerNumber = baseballComputer.createComputerNumber(); // 컴퓨터 숫자 생성
            do {
                String userNumber = baseballView.inputUserNumber(); // 유저 숫자 입력
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

        if (isNothing(ballCount, strikeCount)) {
            baseballView.printResultNothing();
        } else {
            if (isBall(ballCount)) {
                baseballView.printResultBall(ballCount);
            }
            if (isStrike(strikeCount)) {
                baseballView.printResultStrike(strikeCount);
            }
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
            baseballView.printFinishGame();
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
        return baseballView.inputSelectRestartOrEnd() == 2;
    }
}