package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int ANSWER_LENGTH = 3;

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isPlayingGame = true;

        while (isPlayingGame) {
            List<Integer> computerAnswer = createRandomAnswer();
            boolean isVictory = false;

            while (!isVictory) {
                List<Integer> userGuessAnswer = guessComputerAnswer();
                isVictory = evaluateGuess(computerAnswer, isVictory, userGuessAnswer);
            }

            isPlayingGame = askToPlayAgain(isPlayingGame);

        }
    }

    private static boolean evaluateGuess(List<Integer> computerAnswer, boolean isVictory,
                                         List<Integer> userGuessAnswer) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userGuessAnswer.size(); i++) {
            if (computerAnswer.get(i).equals(userGuessAnswer.get(i))) {
                strike++;
            } else if (computerAnswer.contains(userGuessAnswer.get(i))) {
                ball++;
            }
        }

        isVictory = evaluateGuessResult(isVictory, strike, ball);

        return isVictory;
    }

    private static boolean evaluateGuessResult(boolean isVictory, int strike, int ball) {

        if (strike != 0 && ball == 0) { // 스트라이크가 있고 볼은 없는 경우
            System.out.println(strike + "스트라이크");
            if (strike == 3) {
                System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isVictory = true;
            }
        } else if (strike == 0 && ball != 0) { // 스트라이크는 없고 볼만 있는 경우
            System.out.println(ball + "볼");
        } else if (strike != 0 && ball != 0) { // 스트라이크와 볼이 둘 다 있는 경우
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

        return isVictory;
    }

    private static boolean askToPlayAgain(boolean isPlayingGame) {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int playAgain = Integer.parseInt(Console.readLine());

        if (playAgain == 1) {
            isPlayingGame = true;
        } else if (playAgain == 2) {
            isPlayingGame = false;
        }

        return isPlayingGame;
    }

    private static List<Integer> createRandomAnswer() {

        final List<Integer> computerAnswer = new ArrayList<>();

        while (computerAnswer.size() < ANSWER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }

        return computerAnswer;
    }

    private static List<Integer> guessComputerAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userGuessAnswer = new ArrayList<>();
        String userInput = Console.readLine();

        handleGuessInput(ANSWER_LENGTH, userGuessAnswer, userInput);

        return userGuessAnswer;
    }

    private static void handleGuessInput(int ANSWER_LENGTH, List<Integer> userGuessAnswer, String userInput) {
        if (userInput.length() != ANSWER_LENGTH) {
            throw new IllegalArgumentException("입력한 숫자의 개수가 3개가 아닙니다.");
        }

        for (char c : userInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자가 아닌 입력이 포함되어 있습니다.");
            }

            int userGuessNumber = Character.getNumericValue(c);
            if (userGuessNumber < MIN_NUMBER || userGuessNumber > MAX_NUMBER) {
                throw new IllegalArgumentException("1부터 9까지의 범위 밖의 숫자가 포함되어 있습니다.");
            }

            if (userGuessAnswer.contains(userGuessNumber)) {
                throw new IllegalArgumentException("중복된 숫자가 포함되어 있습니다.");
            }

            userGuessAnswer.add(userGuessNumber);
        }
    }

}
