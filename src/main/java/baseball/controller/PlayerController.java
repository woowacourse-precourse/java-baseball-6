package baseball.controller;

public interface PlayerController {
    void reset(final int numberSize);
    int getStrikeCount(String userStr);
    int getBallCount(String userStr);
}
