package baseball;

import camp.nextstep.edu.missionutils.Console;

public class IO { //입출력을 담당하는 클래스입니다.

    public String input() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String success() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    public void BallStrikePrint(int strike, int ball){
        if(ball>0&&strike>0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
        else if(ball>0&&strike==0) {
            System.out.println(ball+"볼");
        }
        else if(ball==0&&strike>0) {
            System.out.println(strike+"스트라이크");
        }
        else {
            System.out.println("낫싱");
        }
    }

}
