package model.domain;

import java.util.List;

public class Discriminator {

    List<Integer> computer;
    String player;

    public Discriminator(List<Integer> computer, String player){
        this.computer = computer;
        this.player = player;
    }

    public List<Integer> getComputer() {
        return computer;
    }

    public String getPlayer() {
        return player;
    }

}
