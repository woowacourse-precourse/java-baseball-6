package baseball.view;

public class RequestMessage {

    private static final String REQUEST_INPUT ="숫자를 입력해주세요 : ";
    private static final String REQUEST_EXIT ="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void requestInput(){
        System.out.print(REQUEST_INPUT);
    }

    public static void requestExit(){
        System.out.println(REQUEST_EXIT);
    }
}
