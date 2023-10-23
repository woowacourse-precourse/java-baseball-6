package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class ConsoleInputView implements InputView {
    private static final String MORE_TEXT = "1";
    private static final String STOP_TEXT = "2";

    @Override
    public List<Integer> getPlayerNumbers() {
        return readLine()
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

    @Override
    public String moreGameValue() {
        return MORE_TEXT;
    }

    @Override
    public String stopGameValue() {
        return STOP_TEXT;
    }

    @Override
    public boolean isWantStopGame() {
        String input = readLine();

        if (MORE_TEXT.equals(input)) {
            return false;
        }

        if (STOP_TEXT.equals(input)) {
            return true;
        }

        throw new IllegalArgumentException();
    }
}
