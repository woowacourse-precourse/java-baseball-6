package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.randomNumberGenerate();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int strike = 0;
            int ball = 0;

            System.out.printf("숫자를 입력하세요 : ");
            String inputString = Console.readLine();
            Set<Character> inputArr = new HashSet<>();
            for (char c : inputString.toCharArray()) {
                inputArr.add(c);
            }
            if (inputArr.size() != 3 || inputString.contains("0")) {
                throw new IllegalArgumentException();
            }

            for (int i = 0; i < inputString.length(); i++) {
                if (randomNumber.getRandomNumber().get(i).equals(Character.getNumericValue(inputString.charAt(i)))) {
                    strike += 1;
                } else if (randomNumber.getRandomNumber().contains(Character.getNumericValue(inputString.charAt(i)))) {
                    ball += 1;
                }
            }

            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하시면 2를 입력하세요.");
                String restartNum = Console.readLine();
                if (Integer.parseInt(restartNum) != 1 && Integer.parseInt(restartNum) != 2) {
                    throw new IllegalArgumentException();
                } else if (Integer.parseInt(restartNum) == 2) {
                    break;
                } else {
                    randomNumber.randomNumberGenerate();
                    System.out.println(randomNumber.getRandomNumber());
                }
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
    }
}
