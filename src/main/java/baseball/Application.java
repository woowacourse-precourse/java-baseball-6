package baseball;

import baseball.Io.Input;
import baseball.Io.Output;
import baseball.util.CompareNumber;
import baseball.util.RandomNumberGenerator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Output.printGameStart();
        boolean gameEndFlag = true;
        while(gameEndFlag) {
            List<Integer> computer = RandomNumberGenerator.generate();
            while (true) {
                List<Integer> user = Input.numbers();

                int strikeCount = CompareNumber.countStrike(computer, user);
                int ballCount = CompareNumber.countBall(computer, user);

                Output.printGameResult(strikeCount, ballCount);

                if (strikeCount == 3) {
                    Output.printGameEnd();
                    break;
                }
            }

            gameEndFlag = Input.gameEndFlag();
        }
    }
}
