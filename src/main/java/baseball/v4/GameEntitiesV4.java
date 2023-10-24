package baseball.v4;

// 게임의 주요 엔터티(컴퓨터와 사용자)를 생성하고 관리하는 클래스
public class GameEntitiesV4 {
    private final ComputerV4 computer;
    private final ChallengerV4 challenger;

    private GameEntitiesV4(ComputerV4 computer, ChallengerV4 challenger) {
        this.computer = computer;
        this.challenger = challenger;
    }

    public static baseball.v4.GameEntitiesV4 createEntities() {
        ComputerV4 computer = new ComputerV4();
        ChallengerV4 challenger = new ChallengerV4();
        return new baseball.v4.GameEntitiesV4(computer, challenger);
    }

    public ComputerV4 getComputer() {
        return computer;
    }

    public ChallengerV4 getChallenger() {
        return challenger;
    }
}