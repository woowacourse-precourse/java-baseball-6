package baseball;

import java.util.List;

public class Application {
    private final static int ON = 1;
    private final static int OFF = 2;
    public static void main(String[] args){
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game();
        while(game.getStatus()==ON){
            game.start();
        }
       

    }
}
