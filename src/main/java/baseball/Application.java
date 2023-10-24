package baseball;

import baseball.numbergenerator.NumberGenerator;
import baseball.numbergenerator.RandomNumberGenerator;
import baseball.user.UserIo;

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

        userIo.print("숫자 야구 게임을 시작합니다.");
        NumberBaseballGame game = new NumberBaseballGame(baseballGameRules, numberGenerator, userIo);
        try {
            game.run();
        } catch (Exception exception) {
            userIo.print(exception.getMessage());
        }
    }
}
