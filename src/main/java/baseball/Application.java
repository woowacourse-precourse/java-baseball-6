package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        displayGameStartMessage();
        playGame();
    }

    public static void playGame() {
        List<Integer> computerNumbers = generateComputerNumbers();
        List<Integer> playerGuessNumbers = getPlayerGuessNumbers();

        System.out.println(computerNumbers);
        System.out.println(playerGuessNumbers);
    }

    public static void displayGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
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
        String playerGuess = getPlayerGuess();
        validatePlayerGuess(playerGuess);
        return convertStringToIntList(playerGuess);
    }

    public static String getPlayerGuess() {
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

    public static boolean isBetween1and9(final char inputChar) {
        return inputChar >= '1' && inputChar <= '9';
    }

    public static boolean isEachDigitBetween1and9(final String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (!isBetween1and9(inputString.charAt(i))) {
                return false;
            }
        }
        return true;
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
}
