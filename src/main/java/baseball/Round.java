package baseball;

public class Round {
    private final ThreeBalls targetBalls;

    public Round(ThreeBalls targetBalls) {
        this.targetBalls = targetBalls;
    }

    public void start() {
        while (true) {
            ThreeBalls userAnswer = inputUserAnswer();

            int strikeCount = RoundEvaluator.calculateStrikeCount(targetBalls, userAnswer);
            if (strikeCount == GameConfig.SUCCESS_STRIKE_COUNT.getValue()) {
                PromptHandler.displayScore(strikeCount, GameConfig.ZERO.getValue());
                System.out.println(GameMessage.SUCCESS_ROUND.getMessage());
                break;
            }

            int ballCount = RoundEvaluator.calculateBallCount(targetBalls, userAnswer, strikeCount);
            PromptHandler.displayScore(strikeCount, ballCount);
        }
    }

    private ThreeBalls inputUserAnswer() {
        System.out.printf(GameMessage.INPUT_NUMBER.getMessage());
        int[] inputNumber = PromptHandler.readThreeBallsNumber();

        return new ThreeBalls(inputNumber);
    }
}
