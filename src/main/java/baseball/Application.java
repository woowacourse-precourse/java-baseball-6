package baseball;

/**
 * 숫자 야구 게임의 흐름을 제어하기 위한 클래스.
 * <p>
 * 사용자에게 입력값을 받고 각 클래스에게 전달합니다. 각 클래스의 출력값을 사용자에게 전달합니다.
 * <p>
 * 잘못된 입력값을 받을 경우 IllegalArgumentException을 던질 수 있습니다.
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
