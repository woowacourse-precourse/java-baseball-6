package baseball;

import static baseball.Constant.CORRECT_MESSAGE;
import static baseball.Constant.INPUT_MESSAGE;
import static baseball.Constant.RESTART_MESSAGE;
import static baseball.Constant.START_MESSAGE;

import java.util.List;

public class Game {

    Validator validator = new Validator();

    public void start() {
        System.out.println(START_MESSAGE);
    }

    public boolean run() {
        Computer computer = new Computer();
        Player player = new Player();

        computer.createNumber();
        play(player, computer.answer);
        return askRestart();
    }

    public void play(Player player, List<Integer> answer) {
        while (true) {
            List<Integer> guess = askGuess(player);
            boolean isCorrect = judgeGuess(answer, guess);

            if (isCorrect) {
                System.out.println(CORRECT_MESSAGE);
                break;
            }
        }
    }

    public List<Integer> askGuess(Player player) {
        System.out.println(INPUT_MESSAGE);
        String[] input = camp.nextstep.edu.missionutils.Console.readLine().split("");
        return player.makeGuess(input);
    }

    public boolean judgeGuess(List<Integer> answer, List<Integer> guess) {
        Judge judge = new Judge(answer, guess);
        judge.calcResult();
        judge.printResult();
        return judge.isCorrect();
    }

    public boolean askRestart() {
        System.out.println(RESTART_MESSAGE);
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        validator.validateOption(input);
        return input.equals("1");
    }
}
