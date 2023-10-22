package baseball;

import baseball.util.NumberGenerator;

import java.util.HashMap;
import java.util.List;

public class Game {

    private final Player player;
    private List<Integer> answer;

    public Game(Player player) {
        this.player = player;
    }

    private List<Integer> generateNumber() {
        NumberGenerator generator = new NumberGenerator();
        answer = generator.generate();
        return answer;
    }

    private HashMap<String, Integer> scoring() {
        HashMap<String, Integer> gameScore = new HashMap<>();
        gameScore.put("볼", 0);
        gameScore.put("스트라이크", 0);
        return gameScore;
    }

}
