package baseball.View;

import camp.nextstep.edu.missionutils.Console;

public class Output {
    public static void printStartMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printStrikeMessage(){
       System.out.print("스트라이크 ");
    }

    public static void printBallMessage(){
        System.out.print("볼 ");
    }

    public static void printNothingMessage(){
        System.out.print("낫싱");
    }

    public static void print(){
        System.out.println();
    }

    public static void printCount(int count){
        System.out.print(count);
    }

    public static void printEndMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}