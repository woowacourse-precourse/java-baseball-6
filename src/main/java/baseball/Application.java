package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answerNumbers = answerNumbers();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            System.out.println("---");
            System.out.println(input);
            System.out.println("---");
            validInput(input);

            int strike = 0, ball = 0;
            List<Integer> inputList = stringToList(input);
            for (int i = 0; i < inputList.size(); i++) {
                if (!answerNumbers.contains(inputList.get(i))) {
                    continue;
                }
                if (answerNumbers.get(i).equals(inputList.get(i))) {
                    strike++;
                } else {
                    ball++;
                }
            }

            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String retryInput = Console.readLine();

                System.out.println("---");
                System.out.println(retryInput);
                System.out.println("---");
                if (retryInput.equals("1")) {
                    answerNumbers = answerNumbers();
                    continue;
                } else if (retryInput.equals("2")) {
                    break;
                }
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else {
                System.out.println(String.format("%d볼 %d스트라이크", ball, strike));
            }
        }

    }

    public static List<Integer> answerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void validInput(String input) throws IllegalArgumentException {
        // 3글자 아닐 때, 숫자가 아닐 때, 중복 숫자일 때
        if (input.length() != 3) {
            throw new IllegalArgumentException(input);
        }
//        if (!input.matches("^(?!.*(.).*\\1)[1-9]{3}$\n")) {
//            throw new IllegalArgumentException(input);
//        }
    }

    static List<Integer> stringToList(String input){
        List<Integer> list = new ArrayList<>();
        String[] arr = input.split("");
        for(String s : arr) list.add(Integer.parseInt(s));
        return list;
    }

}

