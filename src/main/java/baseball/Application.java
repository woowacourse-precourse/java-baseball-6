package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {

        startPrint();

        List<Integer> computerNumbers = generateRandomNumbers();

        while (true) {

            List<Integer> userNumbers = inputNumberOfUser();

        }

    }

    private static List<Integer> inputNumberOfUser() {
        System.out.print("숫자를 입력해주세요 : ");

        int number = Integer.parseInt(Console.readLine());

        List<Integer> userNumber = new ArrayList<>();

        for (int i = 0; i < 3; i ++){
            userNumber.add(number % 10);
            number /=10;
        }

        return userNumber;
    }

    private static boolean isNumber(String inputString) {
        return inputString.matches("\\d+");
    }

    private static void startPrint() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    private static boolean areDistinctNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }


}