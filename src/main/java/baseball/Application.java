package baseball;

import static baseball.Constant.CORRECT_MESSAGE;
import static baseball.Constant.INPUT_MESSAGE;
import static baseball.Constant.RESTART_ERROR_MESSAGE;
import static baseball.Constant.RESTART_MESSAGE;
import static baseball.Constant.START_MESSAGE;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(START_MESSAGE);
        boolean game = true;
        while(game) {
            Computer computer = new Computer();
            computer.createNumber();

            Player player = new Player();

            while (true) {
                System.out.println(INPUT_MESSAGE);
                String input = camp.nextstep.edu.missionutils.Console.readLine();
                List<Integer> guess = player.makeGuess(input);

                Judge judge = new Judge(computer.answer, guess);
                judge.calcResult();
                judge.printResult();

                if(judge.isCorrect()) {
                    System.out.println(CORRECT_MESSAGE);
                    System.out.println(RESTART_MESSAGE);
                    String restart = camp.nextstep.edu.missionutils.Console.readLine();
                    if (restart.equals("1")) {
                        break;
                    } else if (restart.equals("2")) {
                        game = false;
                        break;
                    } else {
                        throw new IllegalArgumentException(RESTART_ERROR_MESSAGE);
                    }
                }
            }
        }
    }
}
