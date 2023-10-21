package baseball.view;


public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String PLAYER_NUMBER_INPUT_PROMPT = "숫자를 입력해주세요 : ";
    private static final String CONTINUE_GAME_CHOICE_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameClearMessage() {
        System.out.println(GAME_CLEAR_MESSAGE);
    }

    public void printPlayerNumberInputPrompt() {
        System.out.println(PLAYER_NUMBER_INPUT_PROMPT);
    }

    public void printContinueGameChoicePrompt() {
        System.out.println(CONTINUE_GAME_CHOICE_PROMPT);
    }

    public void printBaseBallHint(int ballCount, int strikeCount) {
        System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
    }
}
