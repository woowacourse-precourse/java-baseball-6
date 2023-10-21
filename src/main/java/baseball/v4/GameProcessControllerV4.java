package baseball.v4;

public class GameProcessControllerV4 {
    public static void start() {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 게임 엔터티 생성
            GameEntitiesV4 entities = GameEntitiesV4.createEntities();
            ComputerV4 computer = entities.getComputer();
            ChallengerV4 player = entities.getChallenger();

            // 게임 진행
            GameManagerV4.playGame(computer, player);

            try {
                if (!GameManagerV4.askContinue()) {
                    GameManagerV4.stop();
                    return;
                }
            } catch (IllegalArgumentException e) {
                GameManagerV4.stop();
                return; // 여기서도 게임 종료
            }
        }
    }
}
