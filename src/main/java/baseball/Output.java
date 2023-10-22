package baseball;

public class Output {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_CLEAR_MESSAGE = String.format("%d스트라이크\n %d개의 숫자를 모두 맞히셨습니다! 게임 종료",
            BaseballGame.GAME_NUMBER_DIGIT, BaseballGame.GAME_NUMBER_DIGIT);
    private static final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크";
    private static final String NO_BALL_AND_STRIKE_MESSAGE = "낫싱";
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";


    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputNumbersMessage() {
        System.out.println(INPUT_NUMBERS_MESSAGE);
    }

    public static void printStrikeBallMessage(int strike,int ball) {
        System.out.println(chooseStrikeBallMessage(strike, ball));
    }

    private static String chooseStrikeBallMessage(int strike, int ball) {
        if(strike==BaseballGame.GAME_NUMBER_DIGIT) {
            return GAME_CLEAR_MESSAGE;
        }
        if(strike==0 && ball==0) {
            return NO_BALL_AND_STRIKE_MESSAGE;
        }
        return String.format(BALL_STRIKE_MESSAGE,ball,strike);
    }

    public static void printRestartMessage(String doRestart, String dontRestart) {
        System.out.printf(INPUT_RESTART_MESSAGE, doRestart, dontRestart);
    }
}
