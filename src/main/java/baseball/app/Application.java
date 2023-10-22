package baseball.app;

import baseball.domain.computer.Computer;
import baseball.domain.game.GameOption;
import baseball.domain.game.GameService;
import baseball.domain.user.User;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    private static User user = new User();
    private static Computer computer = new Computer();
    private static GameService gameService = GameService.getInstance(user, computer);

    public static void main(String[] args) {
        try {
            while (true) {
                // 게임 시작
                gameService.startGame();

                // 게임 완료 후
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                // 재시작 여부
                Integer wouldRestartGame = user.getWouldRestartGame();
                System.out.println(wouldRestartGame);

                // 재시작 / 종료 실행
                if (wouldRestartGame == GameOption.RESTART.getOption()) {
                    continue;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        // 인스턴스 메모리 해제
        closeAll();
    }

    // 인스턴스 메모리 해제
    private static void closeAll() {
        user = null;
        computer = null;
        gameService = null;
        Console.close();
    }
}
