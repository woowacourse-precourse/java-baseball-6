package baseball.console.game.numberbaseball.domain.user;

import baseball.console.game.numberbaseball.domain.system.GameNumber;

public class UserPrediction {
    private final GameNumber number;

    public UserPrediction(String userPrediction) {
        UserPredictionValidator.validate(userPrediction);
        number = new GameNumber(parseStringToInt(userPrediction));
    }
    private int parseStringToInt(String userPrediction) {
       return Integer.parseInt(userPrediction);
    }

    public GameNumber getNumber() {
        return number;
    }
}
