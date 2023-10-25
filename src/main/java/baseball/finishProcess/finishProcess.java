package baseball.finishProcess;

import java.util.Scanner;

public class finishProcess {
    int finishAnswer;
    boolean isExit;

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
        if (finishAnswer == finishNotice.restartCode) isExit = false;
        else if (finishAnswer == finishNotice.exitCode) isExit = true;
        else throw new IllegalArgumentException();
    }

    public boolean isExitGame() {
        if (isExit) return true;
        else return false;
    }
}
