package baseball.view;

import baseball.domain.BaseBallHint;
import baseball.domain.Player;

public class SinglePlayerConsole implements Player {

    private static final String RESTART_CODE = "1";
    private static final String END_CODE = "2";

    @Override
    public void showStartGameMessage() {
        OutputConsole.printStartGameMessage();
    }

    @Override
    public String getBaseballNumbers() {
        OutputConsole.requestInputMessage();
        return InputConsole.readConsole();
    }

    @Override
    public boolean checkRestart() {
        OutputConsole.requestRestartOrEndMessage();
        String input = InputConsole.readConsole();
        return isRestart(input);
    }

    private boolean isRestart(String input) {
        return switch (input) {
            case RESTART_CODE -> true;
            case END_CODE -> false;
            default -> throw new IllegalStateException("올바르지 않은 입력입니다.");
        };
    }

    @Override
    public void printBaseBallHint(BaseBallHint baseBallHint) {
        StringBuilder stringBuilder = new StringBuilder();
        if (baseBallHint.isNothing()) {
            OutputConsole.printHint("낫싱");
            return;
        }
        if (baseBallHint.hasBall()) {
            stringBuilder.append(String.format("%d볼 ", baseBallHint.ball()));
        }
        if (baseBallHint.hasStrike()) {
            stringBuilder.append(String.format("%d스트라이크", baseBallHint.strike()));
        }
        OutputConsole.printHint(stringBuilder.toString());
    }

    @Override
    public void printEndGameMessage() {
        OutputConsole.printEndMessage();
    }
}
