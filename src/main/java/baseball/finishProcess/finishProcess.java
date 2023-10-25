package baseball.finishProcess;

import java.util.Scanner;

public class finishProcess {
    int finishAnswer;

    public finishProcess() {
        printFinishPhrase();
        inputFinishAnswer();
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
}
