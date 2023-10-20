package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Baseball {

    Utils utils = new Utils();
    Exceptions exception = new Exceptions();

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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String n = Console.readLine();
        restartBall(n);
    }

    public boolean restartBall(String input){
        exception.isInvalidNumberRestart(input);
        if (input == "1"){
            run();
        }else if (input == "2") {
            return true;
        }
        return false;
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
