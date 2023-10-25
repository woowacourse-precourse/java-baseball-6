package baseball.finishProcess;

import java.util.Scanner;

public class finishProcess {
    String finishAnswer;

    public finishProcess() {
        printFinishPhrase();
        inputFinishAnswer();
    }

    private void printFinishPhrase() {
        System.out.println(finishNotice.finishQuestionPhrase);
    }

    private void inputFinishAnswer() {
        Scanner sc = new Scanner(System.in);
        finishAnswer = sc.next();
    }
}
