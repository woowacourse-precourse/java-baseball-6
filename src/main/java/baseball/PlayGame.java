package baseball;

import java.util.List;

public class PlayGame {
    public void play(){
        CreateNumber createNumber = new CreateNumber();
        List<Integer> computer = createNumber.getComputer();
        boolean restart = true;
        while (restart){
            List<Integer> player = createNumber.getPlayerNumber();
            int[] strike_ball = CompareNumber.checkNumber(computer, player);
            String result = PrintResult.print(strike_ball);
            if (strike_ball[0]==3){
                restart=false;
            }
            System.out.println(result);
        }
    }
}
