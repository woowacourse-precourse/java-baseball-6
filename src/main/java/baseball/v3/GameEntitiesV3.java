package baseball.v3;

public class GameEntitiesV3 {
    private final ComputerV3 computer;
    private final PlayerV3 player;

    private GameEntitiesV3(ComputerV3 computer, PlayerV3 player) {
        this.computer = computer;
        this.player = player;
    }

    public static GameEntitiesV3 createEntities() {
        ComputerV3 computer = new ComputerV3();
        PlayerV3 player = new PlayerV3();
        return new GameEntitiesV3(computer, player);
    }

    public ComputerV3 getComputer() {
        return computer;
    }

    public PlayerV3 getPlayer() {
        return player;
    }
}

