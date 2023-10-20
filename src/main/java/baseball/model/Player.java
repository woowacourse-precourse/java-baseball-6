package baseball.model;

import java.util.ArrayList;

public class Player {
    ArrayList<Integer> player = new ArrayList<>();
    boolean flag;
    public Player(ArrayList<Integer> player){
        this.player = player;
        this.flag = false;
    }

    public boolean getFlag() {
        return this.flag;
    }

    public ArrayList<Integer> getPlayer() {
        return this.player;
    }
}
