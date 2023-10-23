package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    private static int asciiOne = 49;
    private static int asciiNine = 57;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    private static void gameStart() {
        final List<Integer> computerNumbers = getComputerNumbers();

        boolean gameFlag = true;
        while (gameFlag) {
            final List<Integer> userNumbers = getUserNumbers();
            System.out.println(userNumbers);
        }

    }

    private static List<Integer> getComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static List<Integer> getUserNumbers() {
        String inputNumbers = Console.readLine();

        if (!validateUserInput(inputNumbers)) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }

        return stringToIntegerList(inputNumbers);
    }

    private static boolean validateUserInput(String inputNumbers) {
        if (validateInputLength(inputNumbers)
                && validateInputDuplication(inputNumbers)
                && validateInputCharacters(inputNumbers)) {
            return true;
        }

        return false;
    }

    private static boolean validateInputLength(String inputNumbers) {
        if(inputNumbers.length() == 3) {
            return true;
        }

        return false;
    }

    private static boolean validateInputDuplication(String inputNumbers) {
        String[] inputNumberSplits = inputNumbers.split("");
        if(inputNumberSplits[0].equals(inputNumberSplits[1])
                || inputNumberSplits[0].equals(inputNumberSplits[2])
                || inputNumberSplits[1].equals(inputNumberSplits[2])) {
            return false;
        }

        return true;
    }

    private static boolean validateInputCharacters(String inputNumbers) {
        String[] inputNumberSplits = inputNumbers.split("");
        if(checkOneToNine(inputNumberSplits[0])
                && checkOneToNine(inputNumberSplits[1])
                && checkOneToNine(inputNumberSplits[2])) {
            return true;
        }

        return false;
    }

    private static boolean checkOneToNine(String number) {
        if(asciiOne > number.charAt(0) || asciiNine < number.charAt(0)) {
            return false;
        }

        return true;
    }

    private static List<Integer> stringToIntegerList(String inputNumbers) {
        return Stream.of(inputNumbers.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

}
