package baseball.model;
import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class GameData {
    final int strikeCount;
    boolean gameStatus;
    final List<Integer> randomNumbers;

    public GameData() {
        this.strikeCount = 3;
        this.gameStatus = true;
        this.randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public boolean isGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Integer> getComputerNumbers() {
        return randomNumbers;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
