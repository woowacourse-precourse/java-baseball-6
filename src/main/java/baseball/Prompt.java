package baseball;

public enum Prompt {
    GAME_START("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : "),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    CONTINUE_OR("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String ko;

    public static String printResult(int numberOfBalls, int numberOfStrikes) {
        if (numberOfBalls == 0 && numberOfStrikes != 0) {
            return numberOfStrikes + STRIKE.ko;
        } else if (numberOfBalls != 0 && numberOfStrikes == 0) {
            return numberOfBalls + BALL.ko;
        } else if (numberOfBalls == 0 && numberOfStrikes == 0) {
            return NOTHING.ko;
        }
        return numberOfBalls + BALL.ko + " " + numberOfStrikes + STRIKE.ko;
    }

    Prompt(String ko) {
        this.ko = ko;
    }

    public void println() {
        System.out.println(ko);
    }

    public void print() {
        System.out.print(ko);
    }
}
