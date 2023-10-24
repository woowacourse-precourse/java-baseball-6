package baseball.play;

import baseball.exception.BaseballExceptionMassage;
import baseball.model.Computer;
import baseball.model.Hint;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class PlayGame {

    public final static String RESTART = "1";
    public final static String END = "2";

    private final Print print;
    private final Computer computer;
    private final User user;

    public PlayGame(Print print, Computer computer, User user) {
        this.print = print;
        this.computer = computer;
        this.user = user;
    }

    public void startGame() {
        print.printStart();

        while (true) {
            runBaseBallGame();
            if (!wantToRestartOrEnd()) {
                break;
            }
        }
    }

    private void runBaseBallGame() {
        computer.generateNumber();

        while (true) {
            print.printInputNumber();
            user.inputAnswer();
            Hint hint = computer.compareNumber(user.getAnswer());
            if (Print.printResult(hint)) {
                break;
            }
        }
    }

    private boolean wantToRestartOrEnd() {
        print.printWantToRestartOrEnd();
        String answer = Console.readLine();

        return switch (answer) {
            case RESTART -> true;
            case END -> false;
            default -> throw new IllegalArgumentException(BaseballExceptionMassage.ONLY_ONE_OR_TWO);
        };
    }

}
