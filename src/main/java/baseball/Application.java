package baseball;

public class Application {

    static class Game{
        public void play(){
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }


}