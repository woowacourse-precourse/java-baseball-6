package baseball;


import baseball.data.BaseballDataBuilderForThreeNumber;
import baseball.data.IBaseballDataBuilder;
import baseball.game.Game;
import baseball.game.IMessage;
import baseball.game.NumberBaseBallGameMessage;
import baseball.util.ISystemConsole;
import baseball.util.RandomNumberGeneratorUsingMissionUtil;
import baseball.util.SystemConsoleUsingMissionUtil;

public class Application {

    public static void main(String[] args) {

        ISystemConsole systemConsole = new SystemConsoleUsingMissionUtil();
        IBaseballDataBuilder dataBuilder = new BaseballDataBuilderForThreeNumber(
                new RandomNumberGeneratorUsingMissionUtil());
        IMessage message = new NumberBaseBallGameMessage();
        Game game = new Game(systemConsole, dataBuilder, message);

        game.run();
    }


}
