package baseball.domain.result.resultnum;

import baseball.domain.result.BallResult;

import java.util.Optional;

public interface ResultNum {
    ResultNum update(BallResult ballResult);

    Optional<String> getResult();

    boolean isGameEnd();
}