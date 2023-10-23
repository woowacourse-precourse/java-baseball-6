package baseball;

import java.util.Scanner;

public class BaseballGame {

    private Scanner sc;

    public BaseballGame(Scanner sc) {
        this.sc = sc;
    }

    public void play() {
        System.out.println(SimpleMessageBundle.START);
        boolean wannaPlay = true;

        while (wannaPlay) {
            newGame();
            wannaPlay = restart();
        }
    }

    private void newGame() {
        Num target = Num.random();
        boolean correct = false;

        while (!correct) {
            Num guess = input();
            Score score = new Score(target, guess);
            score.printScore();
            correct = score.isCorrect();
            if (correct) {
                System.out.println(SimpleMessageBundle.CORRECT);
            }
        }
    }

    private boolean restart() {
        System.out.println(SimpleMessageBundle.RESTART);
        return sc.nextInt() == 1;
    }

    private Num input() {
        System.out.print(SimpleMessageBundle.INPUT_NUM);
        int input;
        try {
            input = sc.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException(SimpleMessageBundle.WRONG_INPUT);
        }
        return new Num(input);
    }

}
