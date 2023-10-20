package baseball.view;


public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private OutputView() {
    }
    public static void printStartMessage(){
        System.out.println(START_MESSAGE );
    }
    public static void printResult(String result){
        System.out.println(result);
    }

}
