package baseball.controller;

import baseball.member.ComputerNumbers;
import baseball.member.PlayerNumbers;

public interface StrikeBallCountService {
    void countStrikeAndBall(PlayerNumbers playerNumbers, ComputerNumbers computerNumbers);
    boolean isGameClear();
}
