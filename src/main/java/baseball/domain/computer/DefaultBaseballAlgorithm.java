package baseball.domain.computer;

import static baseball.domain.computer.BallAndStrike.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultBaseballAlgorithm implements BaseballAlgorithm {

    @Override
    public String calculateBaseballResult(List<Integer> randomNumber, String userInput) {
        List<String> inputNumbers = new ArrayList<>(List.of(userInput.split("")));
        BallAndStrikeResult ballAndStrikeResult = new BallAndStrikeResult();

        for (int i = 0; i < inputNumbers.size(); i++) {
            int number = Integer.parseInt(inputNumbers.get(i));
            if (randomNumber.contains(number)) {
                countStrikeAndBall(randomNumber, inputNumbers, number, ballAndStrikeResult);
            }
        }

        String baseballResultMessage = makeBaseballResultMessage(ballAndStrikeResult);
        ballAndStrikeResult.cleansingResult();
        return baseballResultMessage;
    }

    private String makeBaseballResultMessage(BallAndStrikeResult ballAndStrikeResult) {
        int ballCount = ballAndStrikeResult.getBallCount();
        int strikeCount = ballAndStrikeResult.getStrikeCount();

        if (ballCount + strikeCount == 0) {
            return nothing.getKoreanTag();
        }
        if (ballCount != 0 && strikeCount == 0) {
            return ballCount + ball.getKoreanTag();
        }
        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + strike.getKoreanTag();
        }
        return ballCount + ball.getKoreanTag() + " " + strikeCount + strike.getKoreanTag();
    }

    private void countStrikeAndBall(List<Integer> randomNumber, List<String> inputNumber, int number,
                                    BallAndStrikeResult ballAndStrikeResult) {
        if (randomNumber.indexOf(number) == inputNumber.indexOf(String.valueOf(number))) {
            ballAndStrikeResult.addResult(strike);
            return;
        }
        ballAndStrikeResult.addResult(ball);
    }
}
