package baseball.controller;

import baseball.member.ComputerNumbers;
import baseball.member.PlayerNumbers;

public interface StrikeBallCountable {
    void countStrikeAndBall(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers);
    boolean isGameClear();
}
