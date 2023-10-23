package baseball.v5;

import baseball.v5.player.ChallengerPlayerV5;
import baseball.v5.player.ComputerPlayerV5;
import baseball.v5.player.PlayerManagerV5;

public class GameProcessControllerV5 {
    public static void start() {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");

            // 객체 생성
            ComputerPlayerV5 computerPlayer = new ComputerPlayerV5();
            ChallengerPlayerV5 challengerPlayer = new ChallengerPlayerV5();

            // 플레이어 관리자 객체 생성 및 추가
            PlayerManagerV5 playerManager = new PlayerManagerV5(computerPlayer, challengerPlayer);

            // 게임 진행
            GameManagerV5.playGame(playerManager);

            try {
                if (!GameManagerV5.askContinue()) {
                    GameManagerV5.stop();
                    return;
                }
                // 게임 재시작 시 숫자를 다시 설정
                playerManager.managePlayers();
            } catch (IllegalArgumentException e) {
                GameManagerV5.stop();
                return;
            }
        }
    }
}







