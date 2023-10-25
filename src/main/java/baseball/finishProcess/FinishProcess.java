package baseball.finishProcess;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class FinishProcess {
    private int finishAnswer;
    private boolean isContinue;

    public boolean isContinueGame() {
        return isContinue;
    }

    public FinishProcess() throws IllegalArgumentException {
        try {
            initVariables();
            printFinishPhrase();
            inputFinishAnswer();
            checkFinishAnswer();
        } catch (IllegalArgumentException e){
            throw e;
        }
    }

    private void initVariables() {
        finishAnswer = 0;
        isContinue = true;
    }

    private void printFinishPhrase() {
        System.out.println(FinishNotice.finishQuestionPhrase);
    }

    private void inputFinishAnswer() throws IllegalArgumentException {
        try {
            finishAnswer = Integer.parseInt(readLine());
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkFinishAnswer() throws IllegalArgumentException {
        if (finishAnswer == FinishNotice.restartCode) isContinue = true;
        else if (finishAnswer == FinishNotice.exitCode) isContinue = false;
        else throw new IllegalArgumentException();
    }
}
