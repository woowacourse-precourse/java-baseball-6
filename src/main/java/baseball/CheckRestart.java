package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class CheckRestart {
    public  User user = new User();
    public CheckBallStrike checkBallStrike = new CheckBallStrike();
    public String strikeNum(List<Integer> computerNumber) {
        int strike = 0;
        while (strike != Constant.MAX_STRIKE) {
            System.out.print("숫자를 입력해주세요 : ");
            String userNum = user.inputNum();

            strike = checkBallStrike.checkBallStrike(computerNumber, userNum);
        }
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return Console.readLine();
    }
}