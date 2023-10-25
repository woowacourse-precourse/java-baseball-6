package baseball.domain;

import baseball.console.Constant;
import baseball.console.Input;
import baseball.console.Output;
import baseball.util.Computer;
import baseball.util.GameFactory;

/**
 * 게임의 시작부터 정답까지 전체 진행을 관리하는 클래스.
 * 컴퓨터의 3자리 수를 생성한 후 사용자로부터 3자리 수 입력을 받는다. 이 때 1회 입력을 게임 1회 시도라고 간주한다.
 * 매 시도 마다, 컴퓨터와 사용자의 수를 비교한 후 힌트를 출력한 후, 정답 여부를 확인하여 정답일 경우 게임을 종료한다.
 */
public class BaseballGame {

    private BaseballNumbers computerNumbers;
    private BaseballNumbers userNumbers;

    public void playGame() {
        computerNumbers = Computer.generateComputerNumbers();
        do {
            tryGame();
        } while (!isCorrect());
        Output.printBaseballGameTermination();
    }

    private void tryGame() {
        userNumbers = receiveUserNumbers();
        Output.printBaseballGameHint(printResult());
    }

    private BaseballNumbers receiveUserNumbers() {
        return GameFactory.createUserNumbers(Input.receiveBaseballNumber());
    }

    private String printResult() {

        StringBuilder stringBuilder = new StringBuilder();

        int strikeCount = computerNumbers.getStrikeCount(userNumbers);
        int ballCount = computerNumbers.getBallCount(userNumbers);

        if (strikeCount == Constant.INT_ZERO && ballCount == Constant.INT_ZERO) {
            stringBuilder.append(Constant.RESULT_NOTHING);
        } else if (strikeCount != Constant.INT_ZERO && ballCount != Constant.INT_ZERO) {
            stringBuilder.append(ballCount).append(Constant.RESULT_BALL).append(" ")
                    .append(strikeCount).append(Constant.RESULT_STRIKE);
        } else if (strikeCount != Constant.INT_ZERO) {
            stringBuilder.append(strikeCount).append(Constant.RESULT_STRIKE);
        } else if (ballCount != Constant.INT_ZERO) {
            stringBuilder.append(ballCount).append(Constant.RESULT_BALL);
        }
        return stringBuilder.toString();
    }

    private boolean isCorrect() {
        return computerNumbers.equals(userNumbers);
    }
}
