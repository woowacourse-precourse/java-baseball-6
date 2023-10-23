package baseball;

import baseball.Io.Input;
import baseball.Io.Output;
import baseball.service.CompareNumber;
import baseball.service.RandomNumberGenerator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Output.printGameStart();
        boolean gameEndFlag = true;
        while(gameEndFlag) {
            List<Integer> computer = RandomNumberGenerator.generate();
            while (true) {
                List<Integer> user = Input.Numbers();

                int strikeCount = CompareNumber.CountStrike(computer, user);
                int ballCount = CompareNumber.CountBall(computer, user);

                Output.printGameResult(strikeCount, ballCount);

                if (strikeCount == 3) {
                    Output.printGameEnd();
                    break;
                }
            }

            gameEndFlag = Input.GameEndFlag();
        }
    }
}
