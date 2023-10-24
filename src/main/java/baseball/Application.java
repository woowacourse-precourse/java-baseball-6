package baseball;

import baseball.computer.NumberBaseballGameComputerPlayer;
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

        NumberBaseballGameComputerPlayer computerPlayer = new NumberBaseballGameComputerPlayer(
                numberGenerator.generateUniqueNumbers());

        UserIo userIo = new UserIo();

        userIo.print("숫자 야구 게임을 시작합니다.");
        NumberBaseballGame game = new NumberBaseballGame(baseballGameRules, computerPlayer, userIo);
        game.run();
    }
}
