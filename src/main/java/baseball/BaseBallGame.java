package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class BaseBallGame {

    Computer computer = Computer.getInstance();
    User user = User.getInstance();
    Score score = Score.getInstance();

    private static BaseBallGame baseBallGame;

    private BaseBallGame() {
    }

    public static BaseBallGame getInstance() {
        if (baseBallGame == null) {
            baseBallGame = new BaseBallGame();
        }
        return baseBallGame;
    }

    public void run() {
        do {
            System.out.print(OutputMessage.START_GAME);

            computer.setRandomNumber();
            // 정답 확인용 임시 코드
            System.out.println(Arrays.toString(computer.getRandomNumber().toArray()));

            guessNumber(computer);

            System.out.println(OutputMessage.END_OR_NOT);

        } while (!askWhetherToEnd());
    }

    private void guessNumber(Computer computer) {
        while (true) {
            System.out.print(OutputMessage.ENTER_NUMBER);
            User user = new User();
            Score score = new Score(0, 0);
            Score finalScore = score.returnScore(computer, user);
            finalScore.printOutScore();
            if (finalScore.isSuccess()) {
                break;
            }
        }
    }

    private static boolean askWhetherToEnd() {
        String st = Console.readLine();
        throwException2(st);
        return Integer.parseInt(st) == 2;
    }

    private static void throwException2(String st) {
        if (!st.matches("[12]")) {
            throw new IllegalArgumentException();
        }
    }
}
