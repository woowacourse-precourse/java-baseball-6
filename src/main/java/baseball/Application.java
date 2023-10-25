package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static char flag = 'N';

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> question = computerNumbers();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> solution = userNumbers();

            String result = calculateResult(question, solution);

            System.out.println(result);

            if (flag == 'Y') {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String userSelect = Console.readLine();

                if (!userSelect.equals("1") && !userSelect.equals("2")) {
                    throw new IllegalArgumentException();
                }

                if (userSelect.equals("1")) {
                    flag = 'N';
                    question = computerNumbers();
                    continue;
                }

                if (userSelect.equals("2")) {
                    break;
                }
            }
        }

    }

    public static List<Integer> computerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> userNumbers() {
        List<Integer> user = new ArrayList<>();
        String userNumbers = Console.readLine();
        for (char digit : userNumbers.toCharArray()) {
            user.add(Character.getNumericValue(digit));
        }
        inputValidation(userNumbers);

        return user;
    }

    public static boolean inputValidation(String str) {
        char inputChar = ' ';

        if (str.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < str.length(); i++) {
            inputChar = str.charAt(i);
            int num = Character.getNumericValue(inputChar);
            if (num > 9 || num < 1) {
                throw new IllegalArgumentException();
            }
        }

        return true;
    }

    public static String calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            flag = 'Y';
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        String nothing = (strike == 0 && ball == 0) ? "낫싱" : "";
        return (ball > 0 ? ball + "볼 " : "") + (strike > 0 ? strike + "스트라이크" : "") + nothing;
    }
}