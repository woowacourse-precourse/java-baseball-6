package view;

public class OutputView {

    private final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_NUMBER_PLEASE = "숫자를 입력해주세요 : ";
    private final String GAME_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String TO_BE_CONTINUED = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void gameStartMessage(){
        System.out.println(GAME_START);
    }

    public void inputNumberPleaseMessage(){
        System.out.print(INPUT_NUMBER_PLEASE);
    }

    public void gameResultMessage(String resultMessage) {
        System.out.println(resultMessage);
    }

    public void gameFinishMessage() {
        System.out.println(GAME_FINISH);
    }

    public void tobeContinueMessage() {
        System.out.println(TO_BE_CONTINUED);
    }

}
