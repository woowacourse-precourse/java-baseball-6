package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {

    public static final int RESTART_OPERATION = 1;
    public static final int EXIT_OPERATION = 2;
    int exitNumber = 0;
    Baseball answer;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        resetGame();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            Baseball expected = new Baseball(readLine());

            Score resultScore = expected.checkResult(answer);
            printGameResult(resultScore);

            if (resultScore.getIsCompleted() && isExit()) {
                return;
            }
        }
    }

    private void resetGame() {
        answer = new Baseball();
        exitNumber = 0;
    }

    private void printGameResult(Score score) {
        if (score.getBallCount() != 0) {
            System.out.print(score.getBallCount() + "볼 ");
        }
        if (score.getStrikeCount() != 0) {
            System.out.print(score.getStrikeCount() + "스트라이크");
        }
        if (score.getBallCount() == 0 && score.getStrikeCount() == 0) {
            System.out.print("낫싱");
        }

        System.out.println();

        if (score.getIsCompleted()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public boolean isExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        readExitNumber(readLine());

        switch (exitNumber) {
            case RESTART_OPERATION:
                resetGame();
                break;
            case EXIT_OPERATION:
                return true;
            default:
                throw new IllegalArgumentException(RESTART_OPERATION + " 또는 " + EXIT_OPERATION + "를 입력해야 합니다.");
        }
        return false;
    }

    public void readExitNumber(String input) {
        try {
            exitNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
