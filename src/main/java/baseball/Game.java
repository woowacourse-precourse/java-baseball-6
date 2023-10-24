package baseball;

public class Game {
    private static Preference settings;

    public static void start(Preference preference) {
        settings = preference;

        Player pitcher = new Player(settings);
        Result result;

        do {
            Player hitter = new Player(Reader.readNumber(settings));
            result = pitcher.compareWith(hitter);
            Printer.printResult(result);
        } while (!foundAnswer(result));
    }

    public static boolean foundAnswer(Result result) {
        if (result.strike() == settings.answerSize()) {
            System.out.printf("%d%s\n", settings.answerSize(), Printer.TERMINATE_MESSAGE);
            return true;
        }
        return false;
    }
}
