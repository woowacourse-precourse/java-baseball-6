package Controller;

import Model.Player;
import Model.Refree;

public class BaseBallGame {
    private Player player;
    private Refree refree;
    public BaseBallGame(){
        player=new Player();
        refree=new Refree();
    }
    public void run(){

    }
}
