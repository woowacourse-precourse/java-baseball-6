package baseball;

public class Game {
    private Player player;
    private Questioner questioner;

    public Game(Player player, Questioner questioner) {
        this.player = player;
        this.questioner = questioner;
    }

    public void play() {
        System.out.println("TODO: 게임 플레이");
    }
}
