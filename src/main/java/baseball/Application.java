package baseball;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int game_start = 1;
        while (game_start==1){
            PlayGame playGame = new PlayGame();
            playGame.play();
            game_start = CheckRestart.check();
        }
    }
}
