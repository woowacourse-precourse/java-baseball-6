package baseball.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private final static String StartMessage = "숫자 야구 게임을 시작합니다.";
    private final static String userInputMessage = "숫자를 입력해주세요 : ";
    private final static String nothingMessage = "낫싱";
    private final static String ballMessage = "볼";
    private final static String strikeMessage = "스트라이크";
    private final static String clearMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String gameReStartOrOverMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void startMessage(){
        System.out.println(StartMessage);
    }
    public static void inputMessage(){
        System.out.printf(userInputMessage);
    }

    public static void resultCheck(int[] result){
        int ballCount = result[0];
        int strikeCount = result[1];
        List<String> message = new ArrayList<>();
        if(ballCount == 0 && strikeCount == 0){
            message.add(nothingMessage);
        }
        if(ballCount != 0){
            message.add(ballCount+ballMessage);
        }
        if(strikeCount != 0){
            message.add(strikeCount+strikeMessage);
        }
        System.out.println(String.join(" ",message));
    }

    public static void clearMessage(){
        System.out.println(clearMessage);
    }

    public static void reStartOrOverMessage(){
        System.out.println(gameReStartOrOverMessage);
    }
}
