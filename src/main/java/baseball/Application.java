package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNumbers = randomNums();

        List<Integer> userNumbers = inputNums();

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(computerNumbers);
        System.out.println(userNumbers);

    }

    private static List<Integer> randomNums(){
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }
        return randomNums;
    }

    private static List<Integer> inputNums() {
        String inputNumber = Console.readLine();

        String[] inputNumberArray = inputNumber.split("");

        List<Integer> numbers = new ArrayList<>();

        try {
            if (inputNumberArray.length != 3) {
                throw new IllegalArgumentException("3자리의 수가 아닙니다.");
            }

            for (String digit : inputNumberArray) {
                int number = Integer.parseInt(digit);

                if (number < 1 || number > 9) {
                    throw new IllegalArgumentException("1부터 9까지의 수가 아닙니다.");
                } else if (numbers.contains(number)) {
                    throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
                } else {
                    numbers.add(number);
                }

            }
        } catch (NumberFormatException e1) {
            throw new IllegalArgumentException("숫자가 아닌 문자를 입력했습니다.");
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }

        return numbers;
    }

}
