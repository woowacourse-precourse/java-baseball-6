package baseball;

public class GameEndView {
    private static final String GAME_ENDING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASKING_REGAME_INTENTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printGameEndingMessage() {
        System.out.println(GAME_ENDING_MESSAGE);
    }

    public void printAskingRegameIntentionMessage() {
        System.out.println(ASKING_REGAME_INTENTION_MESSAGE);
    }

    public boolean checkWhetherToRegameOrNot(String toRegameOrNotString) {
        return toRegameOrNotString.equals("1");
    }
}
