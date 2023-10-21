package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public void startGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        //예외 확인
        return number;
    }

    public void printResult(int cntStrike, int cntBall) {
        if(cntStrike == 0 && cntBall == 0)
            System.out.println("낫싱");
        else if(cntStrike == 0)
            System.out.println(cntBall+"볼");
        else if(cntBall == 0)
            System.out.println(cntStrike+"스트라이크");
        else
            System.out.println(cntBall + "볼 " + cntStrike+"스트라이크");
    }

    public void printCorrect() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean inputRestartNumber() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String number = Console.readLine();
        //예외 확인
        if(Integer.parseInt(number) == 1)
            return true;
        else
            return false;
    }

}
