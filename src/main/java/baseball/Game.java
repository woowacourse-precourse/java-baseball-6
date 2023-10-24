package baseball;

import java.util.List;

public class Game {

    private final ComputerNumber computerNumber;
    private final UserNumber userNumber;
    private final Hint hint;
    private final ContinueNumber continueNumber;
    private final Output output;

    public Game() {
        this.computerNumber = new ComputerNumber();
        this.userNumber = new UserNumber();
        this.hint = new Hint();
        this.continueNumber = new ContinueNumber();
        this.output = new Output();
    }

    public void start() {
        List<Integer> computer = computerNumber.createComputerNumber();
        output.printStart();
        boolean check = true;
        while (check) {
            List<Integer> user = userNumber.getUserNumber();
            int strikeCount = hint.getStrikeCount(computer, user);
            int ballCount = hint.getBallCount(computer, user);
            output.printHint(strikeCount, ballCount);
            if (strikeCount == 3) {
                output.printContinue();
                check = continueCheck();
            }
            if (strikeCount == 3 && check) {
                computer = computerNumber.createComputerNumber();
            }
        }
    }

    private boolean continueCheck() {
        boolean checked = true;
        String restart = continueNumber.getContinueNumber();
        if (restart.equals("2")) {
            checked = false;
        }
        return checked;
    }
}
