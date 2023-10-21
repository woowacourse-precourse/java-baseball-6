package baseball.Domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumbers = new ArrayList<>();

    public Player() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }
}

