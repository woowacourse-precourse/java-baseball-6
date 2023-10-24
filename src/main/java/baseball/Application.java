package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {

    public static Boolean decideResult(ArrayList<Integer> computer, ArrayList<Integer> me) {

        int ballCnt = 0;
        int strikeCnt = 0;

        for( int i = 0; i < 3; i++ ) {
               int myNum = me.get(i);

            if( computer.contains(myNum) ) {

                if( computer.indexOf(myNum) == i ) {
                    strikeCnt++;
                } else {
                    ballCnt++;
                }
            }
        }

        if( strikeCnt == 3 ) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if( ballCnt == 0 && strikeCnt == 0 ) {
            System.out.println("낫싱");
            return false;
        } else {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
            return false;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputValidCheck ivc = new InputValidCheck();
        MakeNumber mn = new MakeNumber();

        String input = "";
        ArrayList<Integer> computer = mn.makeComputerNum();

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();

            ivc.isValidLength(input);
            ivc.isDigit(input);
            ivc.isRepeat(input);

            ArrayList<Integer> my = mn.makeMynum(input);

            if ( decideResult(computer, my) ) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    input = Console.readLine();
                    ivc.isReOrStopNum(input);

                if (input.equals("1")) {
                    computer = mn.makeComputerNum();
                }
            }
        } while( !input.equals("2") );
    }
}