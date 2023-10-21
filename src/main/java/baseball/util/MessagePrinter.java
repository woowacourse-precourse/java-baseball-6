package baseball.util;

import baseball.domain.score.ImmutableBallStrikeCount;

public interface MessagePrinter {

    void printStartMessage();

    void printBatterRequest();

    void printBallAndStrike(ImmutableBallStrikeCount ballStrikeCount);

    void printEndAndRequestCommand();
}
