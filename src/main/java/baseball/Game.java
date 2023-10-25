package baseball;

public class Game {
    private final Player player;
    private final Questioner questioner;

    public Game(Player player, Questioner questioner) {
        this.player = player;
        this.questioner = questioner;
    }

    public void play() {
        while (true) {
            GameNumber guessed = player.guess();
            GameResult result = questioner.judge(guessed);
            result.announce();

            if (result.isCorrectAnswer()) {
                break;
            }
        }
    }
}
