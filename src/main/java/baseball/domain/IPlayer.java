package baseball.domain;

import java.util.List;

public interface IPlayer {

    void generatePlayerNumber(final int NUMBER_BALLS);

    List<Integer> respondsTo(IPlayer opponentUser);

    boolean checkIfIsStrike(int ball, int index);

    boolean checkIfIsBall(int ball);

}
