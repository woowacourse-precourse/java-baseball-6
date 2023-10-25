package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

public class BaseballGameRuleTest extends BaseballGameRule {
    public Integer getGameMinValue(){
        return PLAY_BASEBALL_GAME;
    }
    public Integer getPlayBaseballGame() {
        return PLAY_BASEBALL_GAME;
    }

    public Integer getNoHit() {
        return NO_HIT;
    }

    public Integer getBaseballMinValue() {
        return BASEBALL_MIN_VALUE;
    }

    public Integer getBaseballMaxValue() {
        return BASEBALL_MAX_VALUE;
    }

    public Integer getBaseballMaxAmount() {
        return BASEBALL_MAX_AMOUNT;
    }

    public Integer getBaseballStartPosition() {
        return BASEBALL_START_POSITION;
    }

    public Integer getBaseballGameRestart() {
        return BASEBALL_GAME_RESTART;
    }

    public Integer getBaseballGameFinish() {
        return BASEBALL_GAME_FINISH;
    }

    public String getBaseballGameMessageNothingKor() {
        return BASEBALL_GAME_MESSAGE_NOTHING_KOR;
    }

    public String getBaseballGameMessageBallKor() {
        return BASEBALL_GAME_MESSAGE_BALL_KOR;
    }

    public String getBaseballGameMessageStrikeKor() {
        return BASEBALL_GAME_MESSAGE_STRIKE_KOR;
    }
}