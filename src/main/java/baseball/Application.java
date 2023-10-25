package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ComputerSetting computerSetting = new ComputerSetting();
        PlayerGame playerGame = new PlayerGame();
        Game game = new Game(computerSetting, playerGame);
        game.gameInit();
    }
}
