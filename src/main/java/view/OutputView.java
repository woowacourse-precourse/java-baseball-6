package view;

public class OutputView {

    private final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_NUMBER_PLEASE = "숫자를 입력해주세요 : ";

    public void gameStartMessage(){
        System.out.println(GAME_START);
    }

    public void inputNumberPleaseMessage(){
        System.out.print(INPUT_NUMBER_PLEASE);
    }

}
