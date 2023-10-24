package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Baseball {

    Utils utils = new Utils();
    Exceptions exception = new Exceptions();

    public void run() { // 야구게임 시작 및 숫자 입력
        Units units = new Units();
        List<Integer> computer = utils.makeBaseball();
        while (units.getStrike() != 3) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNum = Console.readLine();
            exception.isInvalidNumberDuplication(inputNum);
            exception.isInvalidNumberLength(inputNum);
            exception.isInvalidZero(inputNum);
            playBall(computer, inputNum, units);
            result(units);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String n = Console.readLine();
        restartBall(n);
    }

    public boolean restartBall(String input){ // 재시작 메서드
        exception.isInvalidNumberRestart(input);
        if (input.equals("1")){
            run();
        }else if (input.equals("2")) {
            return true;
        }
        return false;
    }


    public void playBall(List<Integer> computer, String inputNum,Units units){ // 스트라이크, 볼 값 선언
        int strike = utils.strikeCount(computer,inputNum);
        int ball = utils.ballCount(computer,inputNum);
        units.setUnits(strike,ball);
    }

    public void result(Units units){ // 스트라이크, 볼 결과값 출력
        utils.isCountMsg(units.getStrike(), units.getBall());
    }
}
