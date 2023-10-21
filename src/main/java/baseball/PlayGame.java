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
            if (strike_ball[0]==3){
                allStrike=false;
            }
            String result = PrintResult.print(strike_ball);
            System.out.println(result);
        }
    }
}
