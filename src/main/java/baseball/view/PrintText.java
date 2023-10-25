package baseball.view;

public class PrintText {
    private static final String MESSAGE_GAME_START = "숫자 야구 게임을 시작합니다.\n";
    private static final String MESSAGE_INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String MESSAGE_PLAY_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public static void gameStart() {
        System.out.print(MESSAGE_GAME_START);
        return;
    }

    public static void inputNumber() {
        System.out.print(MESSAGE_INPUT_NUMBER);
        return;
    }

    public static void success() {
        System.out.print(MESSAGE_SUCCESS);
        return;
    }

    public static void playAgain() {
        System.out.print(MESSAGE_PLAY_AGAIN);
        return;
    }

    // 게임 출력하게 함
    public static void calculateResult(int cnt_nothing, int cnt_ball, int cnt_strike) {
        // if ALL nothing
        if (cnt_nothing == 3) {
            System.out.print("낫싱\n");
            return;
        }

        if (cnt_ball == 0) {
            System.out.printf("%d스트라이크\n", cnt_strike);

        } else if (cnt_strike == 0) {
            System.out.printf("%d볼\n", cnt_ball);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", cnt_ball, cnt_strike);
        }

    }

}
