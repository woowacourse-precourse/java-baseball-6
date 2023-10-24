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

        System.out.println(randomNumbers);

        List<Integer> userAnswers = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        if (input.length() != 3) {

            throw new IllegalArgumentException("입력 값이 3자리가 아닙니다.");

        }

        for (int i = 0; i < input.length(); i++) {

            if (!Character.isDigit(input.charAt(i))) {

                throw new IllegalArgumentException("입력 값은 모두 숫자여야 합니다.");

            }

            int number = Character.getNumericValue(input.charAt(i));

            userAnswers.add(number);

        }

        long distinctNumber = userAnswers.stream().distinct().count();

        if (distinctNumber != 3) {

            throw new IllegalArgumentException("입력 값은 서로 다른 숫자여야 합니다.");

        }

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < randomNumbers.size(); i++) {

            if (randomNumbers.get(i).equals(userAnswers.get(i))) {

                strike++;

            } else {

                if (randomNumbers.contains(userAnswers.get(i))) {

                    ball++;

                }
            }
        }

        if (strike != 0 && ball != 0) {

            System.out.println(ball + "볼 " + strike + "스트라이크");

        } else {

            if (strike != 0) {

                System.out.println(strike + "스트라이크");

            } else if (ball != 0) {

                System.out.println(ball + "볼");

            } else {

                System.out.println("낫싱");

            }
        }




    }
}
