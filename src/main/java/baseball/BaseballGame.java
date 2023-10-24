package baseball;

import camp.nextstep.edu.missionutils.Console;

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

            if (shouldRepeatGame()) {
                continue;
            }
            break;
        }
    }

    private void proceedGame() {
        List<Integer> randomNumber = NumberFactory.createByComputer(baseballGameConfiguration);

        while (true) {
            List<Integer> userGuessNumber = NumberFactory.createByUser();
            validateUserGuessNumber(userGuessNumber);
            Score score = ScoreFactory.calculateScore(randomNumber, userGuessNumber);
            printHint(score);

            if (randomNumber.equals(userGuessNumber)) {
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

    private boolean shouldRepeatGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (userInput.equals("2")) {
            return false;
        }

        return true;
    }

    private void validateUserGuessNumber(List<Integer> userGuessNumber) {
        if (userGuessNumber.size() != baseballGameConfiguration.getNumberOfDigits()) {
            throw new IllegalArgumentException();
        }

        for (int number : userGuessNumber) {
            if (number < baseballGameConfiguration.getMinimumNumberOfRange()) {
                throw new IllegalArgumentException();
            }

            if (number > baseballGameConfiguration.getMaximumNumberOfRange()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
