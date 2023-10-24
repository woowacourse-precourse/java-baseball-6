package baseball;

import java.util.List;

public class BaseballGame implements NumberGame {

    private NumberGameConfiguration baseballGameConfiguration;

    public BaseballGame(NumberGameConfiguration baseballGameConfiguration) {
        this.baseballGameConfiguration = baseballGameConfiguration;
    }

    @Override
    public void play() {
        while (true) {
            proceedGame();
        }
    }

    private void proceedGame() {
        List<Integer> randomNumber = NumberFactory.createByComputer(baseballGameConfiguration);

        while (true) {
            List<Integer> userGuessNumber = NumberFactory.createByUser();
            Score score = ScoreFactory.calculateScore(randomNumber, userGuessNumber);
            printHint(score);

            if(randomNumber.equals(userGuessNumber)){
                break;
            }
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void printHint(Score score) {
        StringBuilder hint = new StringBuilder();
        int strikeCount = score.getStrikeCount();
        int ballCount = score.getBallCount();

        if (ballCount != 0) {
            hint.append(ballCount).append("볼 ");
        }

        if (strikeCount != 0) {
            hint.append(strikeCount).append("스트라이크");
        }

        if (ballCount == 0 && strikeCount == 0) {
            hint.append("낫싱");
        }

        System.out.println(hint);
    }
}
