package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final View view = new View();
    private static final int ZERO = 0;
    private static final int NUMBER_SIZE = 3;
    private static final int END_NUMBER = 2;
    private static final int START_RANGE_NUMBER = 1;
    private static final int END_RANGE_NUMBER = 9;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        view.printStart();
        while (true) {
            List<Integer> correct = createNumber();
            int ball = ZERO;
            int strike = ZERO;

            while (true) {
                view.printInput();
                String inputNumber = Console.readLine();
                validatedNum(inputNumber);
                String[] strings = inputNumber.split("");

                for (int i = ZERO; i < correct.size(); i++) {
                    if (correct.get(i) == Integer.parseInt(strings[i])) {
                        strike++;
                        continue;
                    }
                    if (correct.contains(Integer.parseInt(strings[i]))){
                        ball++;
                    }
                }


                if (ball == ZERO && strike == ZERO) {
                    view.printNotting();
                }

                if (ball != ZERO) {
                    view.printBall(ball);
                    ball = ZERO;
                    if (strike == ZERO) {
                        view.printBlank();
                    }
                }

                if (strike != ZERO) {
                    if (strike == NUMBER_SIZE) {
                        view.printStrike(strike);
                        break;
                    }
                    view.printStrike(strike);
                    strike = ZERO;
                }
            }
            view.printCorrect();
            view.printEnd();

            int endNumber = Integer.parseInt(Console.readLine());

            if (endNumber == END_NUMBER) {
                break;
            }
        }
    }

    private static boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private static List<Integer> createNumber() {
        List<Integer> correct = new ArrayList<>();
        while (correct.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_RANGE_NUMBER, END_RANGE_NUMBER);
            if (!correct.contains(randomNumber)) {
                correct.add(randomNumber);
            }
        }
        return correct;
    }

    private static void validatedNum(String number) {
        if (number.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException("3자리 수를 입력해주세요.");
        }

        if (!isNumberic(number)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }


}
