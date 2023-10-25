package baseball.player;

import java.util.List;

public class Attacker {

    private List<Integer> attackerNums;


    public List<Integer> getAttackerNums() {
        return attackerNums;
    }
    public static Attacker create(){
        return  new Attacker();
    }
    public void inputDefendNums(List<Integer> attackerNums){
        this.attackerNums = attackerNums;
    }
}
