package baseball;

public class Referee {

    private final Computer computer;
    private final Player player;

    private Referee(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public static Referee getInstance(Computer computer, Player player) {
        return new Referee(computer, player);
    }

}
