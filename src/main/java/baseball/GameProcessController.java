package baseball;

public class GameProcessController {
    public static void start() {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 게임 엔터티 생성
            GameEntities entities = GameEntities.createEntities();
            Computer computer = entities.getComputer();
            Challenger player = entities.getChallenger();

            // 게임 진행
            GameManager.playGame(computer, player);

            try {
                if (!GameManager.askContinue()) {
                    GameManager.stop();
                    return;
                }
            } catch (IllegalArgumentException e) {
                GameManager.stop();
                return; // 여기서도 게임 종료
            }
        }
    }
}
