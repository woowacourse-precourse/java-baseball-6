package baseball.view;

public class OutputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";


    private static OutputView instance = new OutputView();




    private OutputView() {
    }
    public static OutputView getInstance(){
        return instance;
    }


    public void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printInputInitMessage() {
        System.out.println(INPUT_MESSAGE);
    }
}
