package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {

            int number = Randoms.pickNumberInRange(0, 9);

            if (!randomNumbers.contains(number)) {

                randomNumbers.add(number);

            }
        }

        List<Integer> userAnswers = new ArrayList<>();

        String input = Console.readLine();

        try {

            if (input.length() != 3) {

                throw new IllegalArgumentException("입력 값이 3자리가 아닙니다.");

            }

            for (int i = 0; i < input.length(); i++) {

                int number = Character.getNumericValue(input.charAt(i));

                userAnswers.add(number);

            }

        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException(e.getMessage());

        }




    }
}
