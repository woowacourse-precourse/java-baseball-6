package baseball;

import baseball.io.UserIo;
import baseball.numbergenerator.NumberGenerator;
import baseball.numbergenerator.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        int minNumber = 1;
        int maxNumber = 9;
        int numberCount = 3;
        BaseballGameRules baseballGameRules = new BaseballGameRules(minNumber, maxNumber, numberCount);

        NumberGenerator numberGenerator = new RandomNumberGenerator(
                baseballGameRules.getMinNumber(),
                baseballGameRules.getMaxNumber(),
                baseballGameRules.getNumberCount()
        );

        UserIo userIo = new UserIo();

        userIo.print("숫자 야구 게임을 시작합니다.\n");
        boolean continueGame = true;

        while (continueGame) {
            NumberBaseballGame game = new NumberBaseballGame(baseballGameRules, numberGenerator, userIo);
            try {
                game.run();

                userIo.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                int gameOption = userIo.readInt();
                if (gameOption == 2) {
                    continueGame = false;
                }
            } catch (Exception exception) {
                userIo.print(exception.getMessage());
                throw exception;
            }
        }
        Console.close();
    }
}
