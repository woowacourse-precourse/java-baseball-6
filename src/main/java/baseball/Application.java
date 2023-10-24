package baseball;

/**
 * 숫자 야구 게임의 흐름을 제어하기 위한 클래스.
 */
public class Application {
    private static final int ANSWER_SIZE = 3;
    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 1;

    public static void main(String[] args) {
        Preference preference = new Preference(ANSWER_SIZE, LOWER_BOUND, UPPER_BOUND);
        System.out.println(Printer.START_MESSAGE);
        do {
            Game.start(preference);
        } while (wantsReplay());
    }

    static boolean wantsReplay() {
        System.out.println(Printer.REPLAY_MESSAGE);
        return Reader.checkReplay();
    }
}
