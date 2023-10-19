package baseball;


import baseball.service.RandomNum;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.service.GuessNum.getHint;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
        RandomNum randomNumGenerator = new RandomNum();

        while (true) {
            List<Integer> generatedNumbers = randomNumGenerator.generateNum(); // 새로운 숫자 생성
            System.out.println(generatedNumbers);

            while (true) {
                List<Integer> userInputNumbers = new ArrayList<>();
                System.out.print("숫자를 입력해주세요 : ");
                String number = Console.readLine();

                for (char c : number.toCharArray()) {
                    userInputNumbers.add(Character.getNumericValue(c));
                }

                if (userInputNumbers.equals(generatedNumbers)) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    break;
                } else {
                    System.out.println(getHint(generatedNumbers, userInputNumbers));
                    userInputNumbers.clear();
                }
            }
            String stopNum = Console.readLine();
            if (stopNum.equals("1")) {
                continue;
            } else if (stopNum.equals("2")) {
                break;
            }
        }
    }
}
