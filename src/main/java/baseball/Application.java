package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNumbers = randomNums();

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(computerNumbers);

        while (true) {
            List<Integer> userNumbers = inputNums();
            List<Integer> result = compareNumbers(computerNumbers, userNumbers);

            if (result.get(0) == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else {
                System.out.println(resultToString(result));
            }
        }
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

    private static List<Integer> compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (computerNumber == userNumber) {
                strike++;
            } else if (userNumbers.contains(computerNumber)) {
                ball++;
            }
        }

        return List.of(strike, ball);
    }

    private static String resultToString(List<Integer> result) {

        if (result.get(0) == 0 && result.get(1) == 0) {
            return "낫싱";
        } else {
            if (result.get(0) == 0) {
                return result.get(1) + "볼";
            }else if (result.get(1)==0) {
                return result.get(0) + "스트라이크";
            }else {
                return result.get(0) + "볼 " + result.get(1) + "스트라이크";
            }
        }
    }

}
