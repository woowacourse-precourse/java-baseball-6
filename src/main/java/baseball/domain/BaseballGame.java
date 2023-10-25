package baseball.domain;

import baseball.policy.JudgmentPolicy;
import baseball.utility.Score;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame implements Game {

    BaseballComputer computer;
    BaseballUser user;
    private JudgmentPolicy judgmentPolicy;

    public BaseballGame(BaseballComputer computer, BaseballUser user, JudgmentPolicy judgmentPolicy) {
        this.computer = computer;
        this.user = user;
        this.judgmentPolicy = judgmentPolicy;
    }

    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다");

        Boolean exit = false;
        do {
            String userInput = Console.readLine();
            user.setNumbers(userInput);

            Score score = this.judgmentPolicy.compareNumbers(computer.getNumbers(), user.getNumbers());
            if (score.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                if(!isRestartGame()) return;
            } else {
                System.out.println(score.explainScore());
            }

        } while(!exit);

        System.out.println("숫자 야구 게임을 종료합니다.");
    }



    private boolean isRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String isRestart = Console.readLine();
        if ("2".equals(isRestart)) {
            return true;
        } else if ("1".equals(isRestart)) {
            computer.createNumbers();
        }
        return false;
    }
}
