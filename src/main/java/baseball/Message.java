package baseball;

import org.w3c.dom.ls.LSOutput;

public class Message {
    private static final String strike = "스트라이크";
    private static final String ball = "볼";
    private static final String nothing = "낫싱";
    private static final String startMsg = "숫자 야구 게임을 시작합니다.%n숫자를 입력해 주세요 : ";
    private static final String success = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String newGame = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static void makeMessage(int[] flag){
        String message = "";
        if (flag[1] > 0)
            message += flag[1] + ball;
        if (flag[1] > 0 && flag[0] > 0)
            message += " ";
        if (flag[0] > 0)
            message += flag[0] + strike;
        if (flag[1] <= 0 && flag[0] <= 0)
            message += nothing;
        System.out.println(message);
    }
    public static void getSuccessMsg(){
        System.out.println(success);
    }
    public static void newGameMsg(){
        System.out.println(newGame);
    }
    public static void getStartMsg(){
        System.out.printf(startMsg);
    }

}
