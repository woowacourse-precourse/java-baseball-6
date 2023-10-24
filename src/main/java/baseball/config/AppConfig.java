package baseball.config;

import baseball.game.Game;
import baseball.game.impl.BaseballGames;
import baseball.launcher.GameLauncher;
import baseball.service.MessageGenerateService;
import baseball.service.ValidateJudgeService;
import baseball.service.impl.MessageGenerateServiceImpl;
import baseball.service.impl.ValidateJudgeServiceImpl;

public class AppConfig {

    public MessageGenerateService messageGenerateService() {
        return new MessageGenerateServiceImpl();
    }

    public ValidateJudgeService validateJudgeService() {
        return new ValidateJudgeServiceImpl();
    }

    public Game baseballGame() {
        return new BaseballGames(validateJudgeService(), messageGenerateService());
    }

    public GameLauncher gameLauncher() {
        return new GameLauncher(baseballGame(), validateJudgeService());
    }
}
