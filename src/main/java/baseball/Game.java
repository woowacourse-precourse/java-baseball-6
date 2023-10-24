package baseball;

import java.util.List;

public class Game {

    public void start() {
        ComputerNumber computerNumber = new ComputerNumber();
        UserNumber userNumber = new UserNumber();
        Hint hint = new Hint();
        ContinueNumber continueNumber = new ContinueNumber();
        Output output = new Output();

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
