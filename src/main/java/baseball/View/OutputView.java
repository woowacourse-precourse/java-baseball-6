package baseball.View;

public class OutputView {
    private static final String GAME_START_MASSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MASSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartGame() {
        System.out.println(GAME_START_MASSAGE);
    }

    public void printEndGame() {
        System.out.println(GAME_END_MASSAGE);
    }

    public void printHint(String hintMassage) {
        System.out.println(hintMassage);
    }
}
