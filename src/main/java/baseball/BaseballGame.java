package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private static final int MAX_STRIKE = 3;
    private final BaseballGameLogic baseballGameLogic;
    private final BaseballGameView baseballGameView;

    public BaseballGame() {
        baseballGameLogic = new BaseballGameLogic();
        baseballGameView = new BaseballGameView();
    }

    public void start() {
        boolean keepPlaying = true;

        while (keepPlaying) {
            baseballGameView.printStartMessage();
            playUntilThreeStrikes(baseballGameLogic.getRandomThreeDigitNonZero());
            keepPlaying = baseballGameView.selectRestartOrQuit();
        }
    }

    private void playUntilThreeStrikes(List<Integer> randomThreeDigits) {
        boolean isThreeStrike = false;

        while (!isThreeStrike) {
            String playerNumbers = baseballGameView.getPlayerNumbers();

            BallCount ballCount = baseballGameLogic.checkBallCount(
                    randomThreeDigits,
                    changeStringToDigit(playerNumbers)
            );

            baseballGameView.printBallCount(ballCount);

            if (ballCount.getStrike() == MAX_STRIKE) {
                baseballGameView.printEndMessage();
                isThreeStrike = true;
            }
        }
    }

    private List<Integer> changeStringToDigit(String numberFromPlayer) {
        ArrayList<Integer> digitList = new ArrayList<>();

        for (int i = 0; i < numberFromPlayer.length(); i++) {
            char digitChar = numberFromPlayer.charAt(i); // 각 자리의 문자를 가져옴
            int digit = Character.getNumericValue(digitChar); // 문자를 정수로 변환
            digitList.add(digit); // 정수를 리스트에 추가
        }

        return digitList;
    }
}
