package baseball.launcher;

import baseball.game.Game;
import baseball.ioadapter.IoAdapter;
import baseball.message.GameMessages;
import baseball.service.InputConvertService;
import baseball.service.ValidateJudgeService;
import baseball.vo.BaseballCode;
import baseball.vo.RestartDecisionCode;
import java.util.ArrayList;

public class GameLauncher {
    private final Game baseballGames;
    private final ValidateJudgeService validateJudgeService;

    private final InputConvertService inputConvertService;

    private final IoAdapter ioAdapter;

    public GameLauncher(Game baseballGames, ValidateJudgeService validateJudgeService,
                        InputConvertService inputConvertService, IoAdapter ioAdapter) {
        this.baseballGames = baseballGames;
        this.validateJudgeService = validateJudgeService;
        this.inputConvertService = inputConvertService;
        this.ioAdapter = ioAdapter;
    }

    public void playGame() {
        BaseballCode baseballCode = new BaseballCode(new ArrayList<>());
        GameMessages startComment = GameMessages.START_COMMENT;
        GameMessages finishComment = GameMessages.FINISH_COMMENT;
        GameMessages restartComment = GameMessages.RESTART_COMMENT;

        ioAdapter.printMessage(startComment);
        while (true) {
            baseballGame(baseballCode);
            ioAdapter.printMessage(restartComment);
            boolean restartStatus = gameRestartDecision();
            if (restartStatus) {
                continue;
            }
            ioAdapter.printMessage(finishComment);
            break;
        }
    }

    private void baseballGame(BaseballCode baseballCode) {
        BaseballCode baseballCodes = baseballCode.makeNewBaseballCode();
        baseballGames.playBaseball(baseballCodes);
    }

    private boolean gameRestartDecision() {
        RestartDecisionCode decisionCode = new RestartDecisionCode(null);
        RestartDecisionCode restartDecisionCode = decisionCode.makeRestartDecisionCode(inputConvertService);
        return validateJudgeService.restartValidateCode(restartDecisionCode);
    }
}
