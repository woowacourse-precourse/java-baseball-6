package baseball;


import baseball.data.BaseballDataBuilderForThreeNumber;
import baseball.data.IBaseballDataBuilder;
import baseball.game.Game;
import baseball.game.IMessage;
import baseball.game.NumberBaseBallGameMessage;
import baseball.util.IRandomValueGenerator;
import baseball.util.ISystemConsole;
import baseball.util.RandomNumberGeneratorUsingMissionUtil;
import baseball.util.SystemConsoleUsingMissionUtil;

public class Application {

    public static void main(String[] args) {

        ISystemConsole systemConsole = new SystemConsoleUsingMissionUtil();
        IMessage message = new NumberBaseBallGameMessage();
        IRandomValueGenerator<Integer> randomValueGenerator = new RandomNumberGeneratorUsingMissionUtil();
        IBaseballDataBuilder<Integer> dataBuilder = new BaseballDataBuilderForThreeNumber(
                randomValueGenerator
        );

        Game<Integer> game = new Game<>(systemConsole, dataBuilder, message);

        game.run();
    }


}
