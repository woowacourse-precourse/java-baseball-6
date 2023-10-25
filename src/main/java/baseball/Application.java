package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;




public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> numberOfComputer = createNumberOfComputer();
        while (true) {
            List<Integer> userNumber = inputNumber();
            int[] result = compareNumbers(numberOfComputer, userNumber);
            StringBuilder resultString = new StringBuilder();
            if(result[1] != 0) resultString.append(result[1]).append("볼 ");
            if(result[0] != 0) {
                resultString.append(result[0]).append("스트라이크");
            }
            else {
                System.out.println("낫싱");

            }
            System.out.println(resultString.toString());

            if (result[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String restart = Console.readLine();
                if (restart.equals("1") ) {
                    numberOfComputer = createNumberOfComputer();
                } else {
                    break;

                }
            }
        }
    }


    public static List<Integer> createNumberOfComputer() {
        List<Integer> RandomNumberOfComputer = new ArrayList<>();
        while (RandomNumberOfComputer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!RandomNumberOfComputer.contains(number)) {
                RandomNumberOfComputer.add(number);
                }
        }
        return RandomNumberOfComputer;
    }
    public static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String numberOfUser = Console.readLine();
        List<Integer> userNum = new ArrayList<>();
        for (int i = 0; i < numberOfUser.length(); i++) {
            char digitChar = numberOfUser.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            userNum.add(digit);
        }

        if (userNum.size() != 3) {
            throw new IllegalArgumentException("자릿수가 맞지 않음");
            }

        return userNum;
    }

    public static int[] compareNumbers(List<Integer> computerNumber, List<Integer> userGuess) {
        int[] result = new int[2];

        for (int i = 0; i < computerNumber.size(); i++) {
            int computerDigit = computerNumber.get(i);
            int userDigit = userGuess.get(i);

            if (computerDigit == userDigit) {
                result[0]++;
            }
            else if (computerNumber.contains(userDigit)) {
                        result[1]++;
            }
        }

        return result;
    }

}
