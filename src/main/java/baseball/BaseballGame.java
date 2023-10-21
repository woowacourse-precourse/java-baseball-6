package baseball;

import camp.nextstep.edu.missionutils.Console;
public class BaseballGame {

    private final BaseballGameReferee baseballGameReferee = new BaseballGameReferee();

    public void runBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            BaseballGameNumber.validateBaseballGameNumber(input);
            BaseballGameJudgement judgement = baseballGameReferee.judgement(new BaseballGameNumber(input));
            judgement.printJudgement();

            if(judgement.isThreeStrike()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if(Integer.parseInt(Console.readLine())==1) {
                    baseballGameReferee.refreshAnswer();
                    continue;
                }
                break;
            }
        }
    }


}
