package baseball;

public class Message {
    private static final String strike = "스트라이크";
    private static final String ball = "볼";
    private static final String nothing = "낫싱";
    private static final String startMsg = "숫자를 입력해 주세요 : ";

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
    public static void getStartMsg(){
        System.out.print(startMsg);
    }

}
