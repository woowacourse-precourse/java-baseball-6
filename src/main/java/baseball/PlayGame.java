package baseball;

import java.util.List;

public class PlayGame {
    public void play(){
        CreateNumber createNumber = new CreateNumber();
        //computer를 123보다 크거나 같고 987보다 작거나 같은 랜덤수로 초기화
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
