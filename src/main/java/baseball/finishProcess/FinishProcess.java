package baseball.finishProcess;

import java.util.Scanner;

public class FinishProcess {
    private int finishAnswer;
    private boolean isContinue;

    public FinishProcess() {
        initVariables();
        printFinishPhrase();
        inputFinishAnswer();
        checkFinishAnswer();
    }

    private void initVariables() {
        finishAnswer = 0;
        isContinue = true;
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
        if (finishAnswer == FinishNotice.restartCode) isContinue = true;
        else if (finishAnswer == FinishNotice.exitCode) isContinue = false;
        else throw new IllegalArgumentException();
    }

    public boolean isContinueGame() {
        return isContinue;
    }
}
