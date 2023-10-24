package baseball.config;

import baseball.game.Game;
import baseball.game.impl.BaseballGames;
import baseball.ioadapter.IoAdapter;
import baseball.ioadapter.impl.StandardIoAdapter;
import baseball.launcher.GameLauncher;
import baseball.service.InputConvertService;
import baseball.service.MessageGenerateService;
import baseball.service.ValidateJudgeService;
import baseball.service.impl.InputConvertServiceImpl;
import baseball.service.impl.MessageGenerateServiceImpl;
import baseball.service.impl.ValidateJudgeServiceImpl;

public class AppConfig {

    public IoAdapter ioAdapter() {
        return new StandardIoAdapter();
    }

    public MessageGenerateService messageGenerateService() {
        return new MessageGenerateServiceImpl();
    }

    public ValidateJudgeService validateJudgeService() {
        return new ValidateJudgeServiceImpl();
    }

    public Game baseballGame() {
        return new BaseballGames(validateJudgeService(), messageGenerateService(), ioAdapter(), inputConvertService());
    }

    public GameLauncher gameLauncher() {
        return new GameLauncher(baseballGame(), validateJudgeService(), inputConvertService(), ioAdapter());
    }

    public InputConvertService inputConvertService() {
        return new InputConvertServiceImpl(ioAdapter());
    }
}
