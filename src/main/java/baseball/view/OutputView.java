package baseball.view;
public class OutputView {
    private static final String GAME_START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_FINISH_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void gameStartMsg() {
        System.out.println(GAME_START_MSG);
    }

    public void gameFinishMsg() {
        System.out.println(GAME_FINISH_MSG);
    }

    public void countResultMsg(String totalCount) {
        System.out.println(totalCount);
    }
}