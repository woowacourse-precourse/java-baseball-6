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
        }
    }
}
