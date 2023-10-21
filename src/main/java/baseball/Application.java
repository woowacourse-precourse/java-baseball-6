package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean stateReplayGame = true;

        displayGameStartMessage();

        while (stateReplayGame) {
            playGame();
            stateReplayGame = getAnswerReplayGame();
        }
    }

    public static void displayGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void playGame() {
        boolean stateRepeatGuess = true;
        List<Integer> computerNumbers = generateComputerNumbers();

        while (stateRepeatGuess) {
            List<Integer> playerGuessNumbers = getPlayerGuessNumbers();
            String resultOfGuess = getResultOfGuess(computerNumbers, playerGuessNumbers);
            displayResultOfGuess(resultOfGuess);
            stateRepeatGuess = getStateRepeatGuess(resultOfGuess);
        }

        displayTerminateGame();
    }

    public static boolean getAnswerReplayGame() {
        String answerReplayGame = askReplayGame();

        if (answerReplayGame.equals("1")) {
            return true;
        } else if (answerReplayGame.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }

    public static String askReplayGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public static List<Integer> generateComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    public static List<Integer> getPlayerGuessNumbers() {
        String playerGuess = askPlayerGuess();
        validatePlayerGuess(playerGuess);
        return convertStringToIntList(playerGuess);
    }

    public static String askPlayerGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void validatePlayerGuess(final String inputNumbers) {
        if (!isThreeLength(inputNumbers)) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        } else if (!isEachDigitBetween1and9(inputNumbers)) {
            throw new IllegalArgumentException("1~9로 이루어진 3자리의 수를 입력해주세요.");
        } else if (!isEachDigitDuplicated(inputNumbers)) {
            throw new IllegalArgumentException("서로 다른 3개의 숫자로 이루어진 수를 입력해주세요.");
        }
    }

    public static boolean isThreeLength(final String inputString) {
        return inputString.length() == 3;
    }

    public static boolean isEachDigitBetween1and9(final String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (!isBetween1and9(inputString.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBetween1and9(final char inputChar) {
        return inputChar >= '1' && inputChar <= '9';
    }

    public static boolean isEachDigitDuplicated(final String inputDigits) {
        String[] digitArray = inputDigits.split("");
        Set<String> digitSet = new HashSet<>(Arrays.asList(digitArray));

        return digitSet.size() == digitArray.length;
    }

    public static List<Integer> convertStringToIntList(final String inputString) {
        List<Integer> outputIntegerList = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            outputIntegerList.add(inputString.charAt(i) - '0');
        }
        return outputIntegerList;
    }

    public static int countStrike(final List<Integer> computerNumbers, final List<Integer> playerGuessNumbers) {
        int skrikes = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i).equals(playerGuessNumbers.get(i))) {
                skrikes++;
            }
        }
        return skrikes;
    }

    public static int countBall(final List<Integer> computerNumbers, final List<Integer> playerGuessNumbers) {
        int balls = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            if (!computerNumbers.get(i).equals(playerGuessNumbers.get(i))
                    && computerNumbers.contains(playerGuessNumbers.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    public static String getResultOfGuess(final List<Integer> computerNumbers,
                                          final List<Integer> playerGuessNumbers) {
        int balls = countBall(computerNumbers, playerGuessNumbers);
        int strikes = countStrike(computerNumbers, playerGuessNumbers);

        if (balls == 0 && strikes == 0) {
            return "낫싱";
        } else if (balls == 0) {
            return strikes + "스트라이크";
        } else if (strikes == 0) {
            return balls + "볼";
        }

        return balls + "볼 " + strikes + "스트라이크";
    }

    public static void displayResultOfGuess(final String resultOfGuess) {
        System.out.println(resultOfGuess);
    }

    public static boolean getStateRepeatGuess(final String resultOfGuess) {
        return !(resultOfGuess.equals("3스트라이크"));
    }

    public static void displayTerminateGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
