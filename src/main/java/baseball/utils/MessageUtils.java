package baseball.utils;

public class MessageUtils {

    public static void startGame() {
        String START_GAME_MESSAFE = "숫자야구 게임을 시작합니다.";
        System.out.println(START_GAME_MESSAFE);
    }

    public static void enterNumber() {
        String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
        System.out.print(ENTER_NUMBER_MESSAGE);
    }

    public static void result(Integer ball, Integer strike, Integer max) {
        if(ball == 0 && strike == 0) {
            String RESULT_MESSAGE_NOTHING = "낫싱";
            System.out.println(RESULT_MESSAGE_NOTHING);
            return;
        }

        if(ball > 0) {
            String RESULT_MESSAGE_BALL = "볼";
            System.out.print(ball + RESULT_MESSAGE_BALL + " ");
        }

        if(strike > 0) {
            String RESULT_MESSAGE_STRIKE = "스트라이크";
            System.out.print(strike + RESULT_MESSAGE_STRIKE);

            if(strike.equals(max)) {
                System.out.println();
                String RESULT_MESSAGE_WINNING = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
                System.out.print(max + RESULT_MESSAGE_WINNING);
            }
        }
        System.out.println();
    }

    public static void restartOrQuit() {
        String RESTART_OR_QUIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        System.out.println(RESTART_OR_QUIT_MESSAGE);
    }
}
