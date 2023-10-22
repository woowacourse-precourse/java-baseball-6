package baseball.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void startMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void inputMessage(){
        System.out.printf("숫자를 입력해주세요 : ");
    }

    public static void resultCheck(int[] result){
        int ballCount = result[0];
        int strikeCount = result[1];
        List<String> message = new ArrayList<>();
        if(ballCount == 0 && strikeCount == 0){
            message.add("낫싱");
        }
        if(ballCount != 0){
            message.add(ballCount+"볼");
        }
        if(strikeCount != 0){
            message.add(strikeCount+"스트라이크");
        }
        System.out.println(String.join(" ",message));
    }

    public static void clearMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void reStartOrOverMessage(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
