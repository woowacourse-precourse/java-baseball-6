package baseball;


public class Application {
    public static void main(String[] args) {
        NumberBaseball game = new NumberBaseball();
        GameMaster<NumberBaseball> gameMaster = new GameMaster<>(game);
        gameMaster.play();
    }
}
