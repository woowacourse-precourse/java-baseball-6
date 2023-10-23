package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballApp {
    private RandomNum randomNum;
    private InputNum inputNum;
    private CheckNum checkNum;

    public BaseballApp(RandomNum randomNum, InputNum inputNum, CheckNum checkNum) {
        this.randomNum = randomNum;
        this.inputNum = inputNum;
        this.checkNum = checkNum;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> answer = randomNum.makeRandomNum();

            do {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> input = inputNum.getInputNum();
                checkNum.checkNumber(answer, input);

            } while (checkNum.finalStrike < 3);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String exit = Console.readLine();

            if (exit.equals("2")) {
                break;
            }
        }
    }
}
