package baseball;

import java.util.List;

public class Judge {

    public boolean compare(Computer computer, Player player){
        List<Integer> a = computer.getRandomNums();
        List<Integer> b = player.getSelectedNums();

        int sameNum = countSameNum(a,b);
        int strikes = countStrike(a,b);
        int balls = sameNum-strikes;

        Score score = new Score();

        if(strikes == 0 && balls == 0)
            score.setNothing(true);

        score.setStrike(strikes);
        score.setBall(balls);

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

