package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.util.ConsoleStopGameDecisionMapper;

public class ConsoleInputView {

    public String request() {
        return readLine();
    }

    public String moreGameText() {
        return ConsoleStopGameDecisionMapper.MORE_TEXT;
    }

    public String stopGameText() {
        return ConsoleStopGameDecisionMapper.STOP_TEXT;
    }

    public boolean isWantStopGame() {
        String input = readLine();
        return ConsoleStopGameDecisionMapper.getDecision(input);
    }
}
