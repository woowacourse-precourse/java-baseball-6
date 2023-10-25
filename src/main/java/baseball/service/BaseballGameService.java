package baseball.service;

import baseball.domain.BallCount;
import baseball.domain.Computer;

public interface BaseballGameService {

    Computer setComputerNumbers();

    BallCount playGame(Computer computer, String inputNumbers);

}
