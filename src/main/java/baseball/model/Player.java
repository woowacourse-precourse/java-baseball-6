package baseball.model;

import baseball.model.generator.PlayerNumberGenerator;

import java.util.List;

public class Player {
    private final PlayerNumberGenerator playerNumberGenerator;
    private List<Integer> userNumberList;

    public Player(PlayerNumberGenerator playerNumberGenerator) {
        this.playerNumberGenerator = playerNumberGenerator;
    }


    public List<Integer> speakNumbers() {
        chooseNumbers();
        return userNumberList;
    }

    private void chooseNumbers() {
        this.userNumberList = playerNumberGenerator.generateList();
    }
    
    public boolean speakRestart() {
        return playerNumberGenerator.generateRestart();
    }
}
