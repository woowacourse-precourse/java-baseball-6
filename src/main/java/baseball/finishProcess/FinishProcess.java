package baseball.finishProcess;

import java.util.Scanner;

public class FinishProcess {
    private int finishAnswer;
    private boolean isExit;

    public FinishProcess() {
        initVariables();
        printFinishPhrase();
        inputFinishAnswer();
        checkFinishAnswer();
    }

    private void initVariables() {
        finishAnswer = 0;
        isExit = false;
    }

    private void printFinishPhrase() {
        System.out.println(FinishNotice.finishQuestionPhrase);
    }

    private void inputFinishAnswer() {
        Scanner sc = new Scanner(System.in);

        try {
            finishAnswer = sc.nextInt();
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkFinishAnswer() {
        if (finishAnswer == FinishNotice.restartCode) isExit = false;
        else if (finishAnswer == FinishNotice.exitCode) isExit = true;
        else throw new IllegalArgumentException();
    }

    public boolean isExitGame() {
        if (isExit) return true;
        else return false;
    }
}
