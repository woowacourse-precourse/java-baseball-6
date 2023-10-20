package baseball;

public class GameEntities {
    private final ComputerV3 computer;
    private final PlayerV3 player;

    private GameEntities(ComputerV3 computer, PlayerV3 player) {
        this.computer = computer;
        this.player = player;
    }

    public static GameEntities createEntities() {
        //여기에 넣는게 맞는지 모르겠다.
        System.out.println("숫자 야구 게임을 시작합니다.");
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

