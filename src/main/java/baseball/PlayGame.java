package baseball;

import java.util.List;

public class PlayGame {
    // computer의 수를 만들고 사용자의 수를 입력받아 게임 시작 strike가 이 될 때까지 반복
    public void play(){
        CreateNumber createNumber = new CreateNumber();
        List<Integer> computer = createNumber.getComputer();
        boolean allStrike = true;
        while (allStrike){
            List<Integer> player = createNumber.getPlayerNumber();
            int[] strike_ball = CompareNumber.checkNumber(computer, player);
            allStrike= (strike_ball[0] != 3);
            PrintResult.print(strike_ball);
        }
    }
    //게임이 종료된 후 사용자가 2를 입력할 떄까지 반복
    public void playGame(){
        int game_start = 1;
        while (game_start==1){
            play();
            game_start = GameOver.checkRestart();
        }
    }
}