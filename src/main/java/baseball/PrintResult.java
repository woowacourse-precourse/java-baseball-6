package baseball;

public enum PrintResult {

    START("숫자 야구 게임을 시작합니다.\n"),
    WRITE("숫자를 입력해주세요 : "),
    BALL("볼\n"),
    STRIKE("스트라이크\n"),
    BOTH("%d볼 %d스트라이크\n"),
    NOTHING("낫싱\n"),
    CORRECT("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    NEXT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private final String message;

    PrintResult(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.print(message);
    }

    public void printMessage(int count) {
        System.out.print(count + message);
    }

    public void printMessage(int ball, int strike) {
        System.out.printf(message, ball, strike);
    }
}