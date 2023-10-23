package baseball.model;

import baseball.dto.GameResultDto;

public class GameResult {
    private final GameResultDto gameDto;

    public GameResult(GameResultDto gameDto) {
        this.gameDto = gameDto;
    }

    public void result(int strike, int ball) {
        String resultMessage = "";
        boolean correctAnswered = false;

        if (strike == 0 && ball == 0) {
            resultMessage = "낫싱";
        } else if (strike == 3) {
            resultMessage = "3스트라이크";
            correctAnswered = true;
        } else if (strike != 0 && ball == 0) {
            resultMessage = strike + "스트라이크";
        } else if (strike >= 1 && ball >= 1) {
            resultMessage = ball + "볼 " + strike + "스트라이크";
        } else if (strike == 0 && ball != 0) {
            resultMessage = ball + "볼";
        }
        gameDto.setGameResultMessage(resultMessage);
        gameDto.setIsCorrectAnswer(correctAnswered);
    }
}
