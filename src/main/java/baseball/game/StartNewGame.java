package baseball.game;

import java.util.List;

public class StartNewGame {
    public static void startNewGame(){
        PlayBaseballGame playGame = new PlayBaseballGame();
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(!playGame.getFlag()) {
            playGame.input();

            try {
                playGame.findErrors();
            }catch(IllegalArgumentException e){
                throw e;
            }
            List<Integer> list = playGame.countMatch();
            int strike = list.get(0);
            int ball = list.get(1);

            playGame.printResult(strike, ball);
        }
    }
}
