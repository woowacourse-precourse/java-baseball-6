package baseball;

public class Application {
    private GameParticipant player;
    private GameStatus replay;
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
    public void run(){
        while(this.replay != GameStatus.STOP){
            player = new GameParticipant();
            replay = player.playGameByRequest();
           System.out.println("3개의 숫자를 모두 맞췄습니다. 게임 종료");
        }
    }
}
