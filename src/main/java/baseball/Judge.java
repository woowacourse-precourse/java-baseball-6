package baseball;

import java.util.List;

public class Judge {

    public boolean compare(Computer computer, Player player){
        List<Integer> a = computer.getRandomNum();
        List<Integer> b = player.getSelectedNums();

        int sameNum = countSameNum(a,b);
        int strikes = countStrike(a,b);
        int balls = sameNum-strikes;
        boolean nothing = false;

        if(strikes == 0 && balls == 0)
            nothing = true;

        Score score = new Score(strikes, balls, nothing);

        boolean success = score.print(score);
        if(success){
            Restart restart = new Restart();
            restart.askPlayer();
        }
        return success;
    }

    public int countSameNum(List<Integer> a, List<Integer> b){
        int result = 0;
        for(int i=0; i<3; i++){
            if(a.contains(b.get(i)))
                result++;
        }
        return result;
    }

    public int countStrike(List<Integer> a, List<Integer> b){
        int result = 0;
        for(int i=0; i<3; i++){
            if(a.get(i) == b.get(i))
                result++;
        }
        return result;
    }

}

