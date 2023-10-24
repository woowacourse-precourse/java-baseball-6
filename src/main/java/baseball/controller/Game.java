package baseball.controller;

import static baseball.Constants.END_STRIKE_COUNT;

import baseball.service.Hint;
import baseball.validation.ComputerNumber;
import baseball.validation.ContinueNumber;
import baseball.validation.UserNumber;
import baseball.view.Input;
import baseball.view.Output;
import java.util.List;

public class Game {

    private final ComputerNumber computerNumber;
    private final UserNumber userNumber;
    private final Hint hint;
    private final ContinueNumber continueNumber;
    private final Output output;
    private final Input input;

    public Game() {
        this.computerNumber = new ComputerNumber();
        this.userNumber = new UserNumber();
        this.hint = new Hint();
        this.continueNumber = new ContinueNumber();
        this.output = new Output();
        this.input = new Input();
    }

    public void start() {
        List<Integer> computer = computerNumber.createComputerNumber();
        output.printStart();
        boolean check = true;
        while (check) {
            output.printInput();
            String readLine = input.getReadLine();
            List<Integer> user = userNumber.getUserNumber(readLine);
            int strikeCount = hint.getStrikeCount(computer, user);
            int ballCount = hint.getBallCount(computer, user);
            output.printHint(strikeCount, ballCount);
            if (strikeCount == END_STRIKE_COUNT) {
                output.printContinue();
                check = continueCheck();
            }
            if (strikeCount == END_STRIKE_COUNT && check) {
                computer = computerNumber.createComputerNumber();
            }
        }
    }

    private boolean continueCheck() {
        boolean checked = true;
        String readLine = input.getReadLine();
        String restart = continueNumber.getContinueNumber(readLine);
        if (restart.equals("2")) {
            checked = false;
        }
        return checked;
    }
}
