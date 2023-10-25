package baseball.finishProcess;

import java.util.Scanner;

public class finishProcess {
    int finishAnswer;
    boolean isRestart;

    public finishProcess() {
        printFinishPhrase();
        inputFinishAnswer();
        checkFinishAnswer();
    }

    private void printFinishPhrase() {
        System.out.println(finishNotice.finishQuestionPhrase);
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
        if (finishAnswer == finishNotice.restartCode) isRestart = false;
        else if (finishAnswer == finishNotice.exitCode) isRestart = true;
        else throw new IllegalArgumentException();
    }

    public boolean isRestartGame() {
        if (isRestart) return true;
        else return false;
    }
}
