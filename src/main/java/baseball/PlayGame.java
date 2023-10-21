package baseball;

import java.util.List;

public class PlayGame {
    public void play(){
        CreateNumber createNumber = new CreateNumber();
        List<Integer> computer = createNumber.getComputer();
        boolean allStrike = true;
        while (allStrike){
            List<Integer> player = createNumber.getPlayerNumber();
            int[] strike_ball = CompareNumber.checkNumber(computer, player);
            allStrike= (strike_ball[0] != 3);
            String result = PrintResult.print(strike_ball);
            System.out.println(result);
        }
    }
    public void repeatGame(){
        int game_start = 1;
        while (game_start==1){
            play();
            game_start = CheckRestart.check();
        }
    }
}