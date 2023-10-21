package baseball;

public class GameEntities {
    private final ComputerV3 computer;
    private final PlayerV3 player;

    private GameEntities(ComputerV3 computer, PlayerV3 player) {
        this.computer = computer;
        this.player = player;
    }

    public static GameEntities createEntities() {
        ComputerV3 computer = new ComputerV3();
        PlayerV3 player = new PlayerV3();
        return new GameEntities(computer, player);
    }

    public ComputerV3 getComputer() {
        return computer;
    }

    public PlayerV3 getPlayer() {
        return player;
    }
}

