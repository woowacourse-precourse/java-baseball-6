package baseball.service;

import baseball.domain.BallCount;

public interface BaseballGameService {

    void setComputerNumbers();

    BallCount playGame(String inputNumbers);
    
}
