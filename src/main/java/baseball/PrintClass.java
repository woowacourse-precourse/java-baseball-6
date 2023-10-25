package baseball;

import java.util.List;

public class PrintClass {
    public static void printList(List<Integer> list){
        for(Integer value: list){
            System.out.print(value);
        }
        System.out.println();
    }
    public static void printGetNum(){
        System.out.print("숫자를 입력해주세요:");
    }

    public static void printEndGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printGetRestartNum(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printScore(Score score){
        if(score.strike == 0 && score.ball == 0)
            System.out.println("낫싱");
        else if(score.strike == 0)
            System.out.println(score.ball + "볼");
        else if(score.ball == 0)
            System.out.println(score.strike + "스트라이크");
        else
            System.out.println(score.ball + "볼 " + score.strike + "스트라이크");
    }
}
