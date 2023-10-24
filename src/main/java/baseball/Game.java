package baseball;

import static baseball.Result.STRIKE;

public class Game {
    private static Preference settings;

    public static void start(Preference preference) {
        settings = preference;

        Player pitcher = new Player(settings);
        int[] result;

        do {
            Player hitter = new Player(Application.readNumber());
            result = pitcher.compareWith(hitter);
            Application.printResult(result);
        } while (!foundAnswer(result));
    }

    public static boolean foundAnswer(int[] result) {
        if (result[STRIKE.getIndex()] == settings.answerSize()) {
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", settings.answerSize());
            return true;
        }
        return false;
    }
}
