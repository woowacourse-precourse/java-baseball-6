package baseball;

public enum GameMessage {
    WELCOME("숫자 야구 게임을 시작합니다.\n"),
    WIN("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    GAME_RESTART_PROMPT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    INPUT_PROMPT("숫자를 입력해주세요 : "),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.print(message);
    }

    public void print(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("prefix cannot br null");
        }
        System.out.print(prefix + message);
    }

    public static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            GameMessage.NOTHING.print();
        } else if (strike == 3) {
            GameMessage.STRIKE.print("3");
        } else {
            GameMessage.BALL.print(String.valueOf(ball));
            GameMessage.STRIKE.print(" " + String.valueOf(strike));
        }
        System.out.println();
    }
}
