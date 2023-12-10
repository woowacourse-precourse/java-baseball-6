package view;

public class OutputView {

    private final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_NUMBER_PLEASE = "숫자를 입력해주세요 : ";
    private final String GAME_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void gameStartMessage(){
        System.out.println(GAME_START);
    }

    public void inputNumberPleaseMessage(){
        System.out.print(INPUT_NUMBER_PLEASE);
    }

    public void gameFinishMessage() { }

}
