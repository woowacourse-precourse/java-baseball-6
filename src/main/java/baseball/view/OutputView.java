package baseball.view;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";


    private static OutputView instance = new OutputView();




    private OutputView() {
    }
    public static OutputView getInstance(){
        return instance;
    }


    public void startMessage() {
        System.out.println(START_MESSAGE);
    }
}
