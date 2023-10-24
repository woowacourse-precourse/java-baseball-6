package baseball;

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
                List<Integer> player = inputNum.getPlayerNum();
                checkNum.checkNumber(answer, player);

            } while (checkNum.finalStrike < 3);

            String exit = inputNum.getExitNum();

            if (exit.equals("2")) {
                break;
            }
        }
    }
}
