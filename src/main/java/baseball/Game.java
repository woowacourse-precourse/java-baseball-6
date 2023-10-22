package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private Computer computer = new Computer();
    private User user = new User();


    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            computer.setRandomNum();
            int randNum = computer.getRandomNum();
            int userNum = user.getUserNum();

            List<Integer> randomDigits = getDigits(randNum);
            List<Integer> userDigits = getDigits(userNum);

            int strike = countStrike(randomDigits, userDigits);
            int ball = countBall(randomDigits, userDigits);

            printResult(strike, ball);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String quitInput = Console.readLine();
                if (quitInput.equals(2)) {  // java의 equals()에 대해서?
                    break;
                }
            }
        }
    }

    private List<Integer> getDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        return Arrays.asList(new Integer[3 - digits.size()]);  // Arrays의 asList()는 무엇인가?
    }

    private int ca

    private void initRandomNum() {
        user.setUserNum();

    }
}

