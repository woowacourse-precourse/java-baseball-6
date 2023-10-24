package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

public class Application {
    private static final String REGEXP_PATTERN_NUMBER = "^[1-9]{3}$";

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = getRandomNumbers();

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userNumbersString = Console.readLine();

            if (!Pattern.matches(REGEXP_PATTERN_NUMBER, userNumbersString)) {
                throw new IllegalArgumentException("일치하지 않는 입력 방식입니다!");
            }

            System.out.println(userNumbersString);
            Score score = new Score(userNumbersString, computer);
            score.calculate();
            String result = score.extractResult();
            System.out.println(result);

            if (score.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String isClose = Console.readLine();
                System.out.println(isClose);

                if (isClose.equals("1")) {
                    computer = getRandomNumbers();
                } else if (isClose.equals("2")) {
                    break;
                } else {
                    throw new IllegalArgumentException("1 또는 2 이외의 문자가 입력되었습니다.");
                }
            }
        }
    }

    static List<Integer> getRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
