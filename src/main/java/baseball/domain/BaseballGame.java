package baseball.domain;

import baseball.policy.BaseballJudgmentPolicy;
import baseball.policy.JudgmentPolicy;
import baseball.utility.BaseballScore;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame implements Game {

    private BaseballComputer computer;
    private BaseballUser user;
    private BaseballJudgmentPolicy baseballJudgmentPolicy;

    public BaseballGame(BaseballComputer computer, BaseballUser user, BaseballJudgmentPolicy baseballJudgmentPolicy) {
        this.computer = computer;
        this.user = user;
        this.baseballJudgmentPolicy = baseballJudgmentPolicy;
    }

    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다");

        Boolean exit = false;
        while (!exit) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            user.setNumbers(userInput);

            BaseballScore baseballScore = this.baseballJudgmentPolicy.compareNumbers(computer.getNumbers(),
                    user.getNumbers());
            System.out.println(baseballScore.explainScore());

            if (baseballScore.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String isEnd = Console.readLine();
                if (!isRestartGame(isEnd)) {
                    return;
                }
            }
        }

    }

    private boolean isRestartGame(String input) {
        if ("2".equals(input)) {
            return false;
        } else if ("1".equals(input)) {
            computer.createNumbers();
            System.out.println("숫자 야구 게임을 시작합니다");
        }
        return true;
    }
}
