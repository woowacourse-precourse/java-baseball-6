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
        do {
            List<Integer> user = userNumber.getUserNumber();
            int strikeCount = hint.getStrikeCount(computer, user);
            int ballCount = hint.getBallCount(computer, user);
            output.printHint(strikeCount, ballCount);
            if (strikeCount == 3) {
                String restart = continueNumber.getContinueNumber();
                if (restart.equals("1")) {
                    computer = computerNumber.createComputerNumber();
                } else if (restart.equals("2")) {
                    check = false;
                }
            }
        } while (check);
    }
}
