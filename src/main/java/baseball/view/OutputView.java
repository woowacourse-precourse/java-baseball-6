package baseball.view;

import baseball.domain.GameResult;

public class OutputView {
    public void printStart() {
        println(OutputMessage.START_MESSAGE);
    }

    public void printAskNumber() {
        print(OutputMessage.ASK_NUMBER_MESSAGE);
    }

    public void printResult(GameResult result) {
        StringBuilder sb = new StringBuilder();
        boolean hasFrontSb = false;

        if (result.isNothing()) {
            println(OutputMessage.RESULT_NOTHING);
            return;
        }

        if (result.hasBall()) {
            sb.append(result.getBall()).append(OutputMessage.RESULT_BALL.getMessage());
            hasFrontSb = true;
        }
        if (result.hasStrike()) {
            if (hasFrontSb) {
                sb.append(" ");
            }
            sb.append(result.getStrike()).append(OutputMessage.RESULT_STRIKE.getMessage());
        }

        System.out.println(sb);
    }

    public void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printAskRestart() {
        print(OutputMessage.ASK_RESTART_MESSAGE);
    }

    private void println(OutputMessage message){
        System.out.println(message.getMessage());
    }
    private void print(OutputMessage message){
        System.out.print(message.getMessage());
    }
}
