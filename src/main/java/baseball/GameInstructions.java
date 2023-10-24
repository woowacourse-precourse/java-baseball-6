package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameInstructions {

    public static void startInstruction(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static int[] makeInput(){
       System.out.println("숫자를 입력해주세요 : ");
       return Number.getUserInput();
    }

    public static void printWinningMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static int askRetryOrExit(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void printTurnResult(int strike, int ball){
        if(strike==0 && ball==0){
            System.out.println("낫싱");
        }
        if(strike!=0 && ball==0){
            System.out.println(strike+"스트라이크");
        }
        if(strike==0 && ball!=0){
            System.out.println(ball+"볼");
        }
        if(strike!=0 && ball!=0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }
}
