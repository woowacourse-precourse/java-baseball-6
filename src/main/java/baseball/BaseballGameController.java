package baseball;

public class BaseballGameController {

    public BaseballGameModel guess(Player computer, String input) {
        NumberBoard computerAnswer = computer.getNumberBoard();
        NumberBoard playerAnswer = new NumberBoard(input);

        int[] ballCount = countBallByAnswer(computerAnswer, playerAnswer);
        int size = computerAnswer.size();
        return new BaseballGameModel(ballCount, size);
    }

    private static int[] countBallByAnswer(NumberBoard computerAnswer, NumberBoard myAnswer) {
        int strike = 0;
        int ball = 0;
        int size = computerAnswer.size();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (computerAnswer.get(i) == myAnswer.get(j) && i == j) {
                    strike++;
                    break;
                }
                if (computerAnswer.get(i) == myAnswer.get(j) && i != j) {
                    ball++;
                    break;
                }
            }
        }

        int[] result = new int[2];
        result[0] = strike;
        result[1] = ball;
        return result;
    }
}
