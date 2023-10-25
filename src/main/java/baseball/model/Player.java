package baseball.model;

import baseball.model.generator.PlayerGenerator;

import java.util.List;

public class Player {
    private final PlayerGenerator playerGenerator;
    private List<Integer> userNumberList;

    public Player(PlayerGenerator playerGenerator) {
        this.playerGenerator = playerGenerator;
    }


    public List<Integer> speakNumbers() {
        chooseNumbers();
        return userNumberList;
    }

    private void chooseNumbers() {
        this.userNumberList = playerGenerator.generateList();
    }
    
    public boolean speakRestart() {
        return playerGenerator.generateRestart();
    }
}
