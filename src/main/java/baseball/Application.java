package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    private static int NUM_OF_BASEBALL = 3;
    private static int ASCIIONE = 49;
    private static int ASCIININE = 57;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
    }

    private static void gameStart() {
        final List<Integer> computerNumbers = getComputerNumbers();

        boolean gameFlag = true;
        while (gameFlag) {
            final List<Integer> userNumbers = getUserNumbers();
            System.out.println(computerNumbers);
            System.out.println(userNumbers);

            if (getResult(computerNumbers, userNumbers)) {
                gameFlag = false;
            }
        }
    }

    private static boolean getResult(final List<Integer> computerNumbers, final List<Integer> userNumbers) {
        if (checkGameOver(computerNumbers, userNumbers)) {
            return true;
        }

        int strikeNums = getStrikes(computerNumbers, userNumbers);
        int ballNums = getBalls(computerNumbers, userNumbers);

        if(strikeNums == 0 && ballNums == 0) {
            System.out.println("낫싱");
        }
        else {
            System.out.println(String.format("%d볼 %d스트라이크", ballNums, strikeNums));
        }

        return false;
    }

    private static int getBalls(final List<Integer> computerNumbers, final List<Integer> userNumbers) {
        int ballNums = 0;

        for(int i = 0; i < NUM_OF_BASEBALL; i++) {
            if ((!computerNumbers.get(i).equals(userNumbers.get(i)))
                    && computerNumbers.contains(userNumbers.get(i))) {
                ballNums++;
            }
        }

        return ballNums;
    }

    private static int getStrikes(final List<Integer> computerNumbers, final List<Integer> userNumbers) {
        int strikeNums = 0;

        for(int i = 0; i < NUM_OF_BASEBALL; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikeNums++;
            }
        }

        return strikeNums;
    }

    private static boolean checkGameOver(final List<Integer> computerNumbers, final List<Integer> userNumbers) {
        if(computerNumbers.equals(userNumbers)) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
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
        System.out.print("숫자를 입력해주세요 : ");
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
        if(ASCIIONE > number.charAt(0) || ASCIININE < number.charAt(0)) {
            return false;
        }

        return true;
    }

    private static List<Integer> stringToIntegerList(String inputNumbers) {
        return Stream.of(inputNumbers.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
