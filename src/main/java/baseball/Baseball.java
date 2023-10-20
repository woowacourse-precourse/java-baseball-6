package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Baseball {

    Utils utils = new Utils();

    public void run() {
        Units units = new Units();
        List<Integer> computer = utils.makeBaseball();
        while (units.getStrike() != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNum = Console.readLine();
            playBall(computer, inputNum, units);
            result(units);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    }


    public void playBall(List<Integer> computer, String inputNum,Units units){
        int strike = utils.strikeCount(computer,inputNum);
        int ball = utils.ballCount(computer,inputNum);
        units.setUnits(strike,ball);
    }

    public void result(Units units){
        utils.isCountMsg(units.getStrike(), units.getBall());
    }
}
