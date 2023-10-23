package baseball;

import baseball.utils.CheckNumber;
import baseball.utils.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    public void start() {
        final RandomNumberGenerator randomNumber = new RandomNumberGenerator();
        final List<Integer> computer = randomNumber.generate();
        while (true) {
            final CheckNumber checkNumber = new CheckNumber();
            System.out.print("숫자를 입력해주세요 : ");
            if (checkNumber.check(computer, Console.readLine())) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final String restart = Console.readLine();
        if(restart.equals("1")){
            start();
        }
    }
}
