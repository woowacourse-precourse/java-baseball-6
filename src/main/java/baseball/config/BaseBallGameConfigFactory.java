package baseball.config;

import baseball.domain.baseballplayer.referee.Referee;
import baseball.domain.baseballplayer.referee.Rule;
import baseball.domain.baseballplayer.team.Computer;
import baseball.domain.baseballplayer.team.User;
import baseball.domain.baseballplayer.team.validator.UserInputValidator;
import baseball.domain.game.BaseBallGame;
import baseball.domain.game.BaseBallGameExitManager;
import baseball.domain.game.Game;
import baseball.domain.stadium.BaseBallStadium;
import baseball.domain.baseballplayer.team.BaseBallTeam;

public class BaseBallGameConfigFactory {
    private static Game baseBallGame;
    private static BaseBallStadium baseBallStadium;
    private static BaseBallGameExitManager baseBallGameExitManager;
    private static BaseBallTeam defenseTeam;
    private static BaseBallTeam offenseTeam;
    private static Referee referee;
    private static Rule rule;
    private static UserInputValidator userInputValidator;

    private BaseBallGameConfigFactory() {
    }

    public static Game createBaseBallGame() {
        if (baseBallGame == null) {
            baseBallGame = BaseBallGame.of(createBaseBallStadium(), createBaseBallGameExitManager());
        }
        return baseBallGame;
    }

    private static BaseBallStadium createBaseBallStadium() {
        if (baseBallStadium == null) {
            baseBallStadium = BaseBallStadium.of(createDefenseBaseBallTeam(), createOffenseBaseBallTeam(), createReferee());
        }
        return baseBallStadium;
    }

    private static BaseBallGameExitManager createBaseBallGameExitManager() {
        if (baseBallGameExitManager == null) {
            baseBallGameExitManager = BaseBallGameExitManager.newInstance();
        }
        return baseBallGameExitManager;
    }

    private static BaseBallTeam createDefenseBaseBallTeam() {
        if (defenseTeam == null) {
            defenseTeam = Computer.newInstance();
        }
        return defenseTeam;
    }

    private static BaseBallTeam createOffenseBaseBallTeam() {
        if (offenseTeam == null) {
            offenseTeam = User.newInstance(createUserInputValidator());
        }
        return offenseTeam;
    }

    private static Referee createReferee() {
        if (referee == null) {
            referee = Referee.newInstance(createRule());
        }
        return referee;
    }

    private static Rule createRule() {
        if (rule == null) {
            rule = Rule.newInstance();
        }
        return rule;
    }

    private static UserInputValidator createUserInputValidator() {
        if (userInputValidator == null) {
            userInputValidator = UserInputValidator.newInstance();
        }
        return userInputValidator;
    }

}
