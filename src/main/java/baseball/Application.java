package baseball;

import baseball.view.InputView;
import java.util.StringJoiner;

public class Application {

    private enum Format {
        BALL("%d볼"),
        STRIKE("%d스트라이크");

        private final String format;

        Format(final String format) {
            this.format = format;
        }

        public String toMessage(Object... args) {
            return String.format(format, args);
        }
    }

    private enum ConsoleMessage {
        GAME_START("숫자 야구 게임을 시작합니다."),
        RESULT_NOTHING("낫싱"),
        RESULT_ALL_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        private final String message;

        ConsoleMessage(final String message) {
            this.message = message;
        }
    }

    public static void main(String[] args) {
        System.out.println(ConsoleMessage.GAME_START.message);
        run();
    }

    private static void run() {
        process();
        askForContinue();
    }

    private static void process() {
        Computer computer = ComputerGenerator.generate();

        while (true) {
            PlayResult playResult = play(computer);
            printResult(playResult);

            if (playResult.isAllStrike()) {
                break;
            }
        }
    }

    private static PlayResult play(final Computer computer) {
        final Player player = new Player(InputView.readNumbers());
        return player.play(computer);
    }

    private static void printResult(final PlayResult result) {
        System.out.println(formatPlayResult(result));
    }

    private static String formatPlayResult(final PlayResult result) {
        if (result.isNothing()) {
            return ConsoleMessage.RESULT_NOTHING.message;
        }
        final StringJoiner sj = new StringJoiner(" ");
        sj.add(formatBall(result));
        sj.add(formatStrike(result));
        return sj.toString()
                .strip();
    }

    private static CharSequence formatBall(final PlayResult result) {
        return formatCountOf(Format.BALL, result.getBalls());
    }

    private static String formatStrike(final PlayResult result) {
        final StringJoiner sj = new StringJoiner("\n");
        sj.add(formatCountOf(Format.STRIKE, result.getStrikes()));

        if (result.isAllStrike()) {
            sj.add(ConsoleMessage.RESULT_ALL_STRIKE.message);
        }
        return sj.toString();
    }

    private static String formatCountOf(final Format format, final long count) {
        if (count == 0L) {
            return "";
        }
        return format.toMessage(count);
    }

    private static void askForContinue() {
        final GameOption option = createGameOption();

        if (option.isContinue()) {
            run();
        }
    }

    private static GameOption createGameOption() {
        return GameOption.of(InputView.readOptionNumber());
    }
}
