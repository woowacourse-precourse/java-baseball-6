package baseball;

import static baseball.SimpleMessageBundle.CORRECT;
import static baseball.SimpleMessageBundle.INPUT_NUM;
import static baseball.SimpleMessageBundle.RESTART;
import static baseball.SimpleMessageBundle.START;
import static baseball.SimpleMessageBundle.WRONG_INPUT;

import java.util.Scanner;

public class BaseballGame {

    private final Scanner sc;

    public BaseballGame(Scanner sc) {
        this.sc = sc;
    }

    public void play() {
        System.out.println(START);
        boolean continuePlaying = true;

        while (continuePlaying) {
            playRound();
            continuePlaying = confirmRestart();
        }
    }

    private void playRound() {
        Num target = Num.random();
        boolean correct = false;

        while (!correct) {
            Num guess = createNumFromInput();
            Score score = new Score(target, guess);
            score.printScore();
            correct = score.isCorrect();
            if (correct) {
                System.out.println(CORRECT);
            }
        }
    }

    private boolean confirmRestart() {
        System.out.println(RESTART);
        return sc.nextInt() == 1;
    }

    private Num createNumFromInput() {
        System.out.print(INPUT_NUM);
        int input;
        try {
            input = sc.nextInt();
            return new Num(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }
    }

}
