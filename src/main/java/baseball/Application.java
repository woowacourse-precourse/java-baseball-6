package baseball;

public class Application {

    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster();
        while (gameMaster.play()) {
            gameMaster.prepareGame();
//            System.out.println(gameMaster.getCorrectAnswer());
            gameMaster.playOneRound();
        }
    }
}
