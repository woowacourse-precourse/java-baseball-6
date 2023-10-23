package baseball.app;

import baseball.domain.computer.Computer;
import baseball.domain.game.GameOption;
import baseball.domain.game.GameService;
import baseball.domain.user.User;
import baseball.domain.utils.RandomGenerator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {

    private static GameService gameService = GameService.getInstance();

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            // 랜덤수 리스트 생성
            List<Integer> randomNumbers = new RandomGenerator().getRandomNumbers();

            // 게임 싸이클 시작
            gameService.startGame(randomNumbers);

            // 게임 완료 후
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            // 재시작 여부
            String userOption = Console.readLine();
            Integer wouldRestartGame = User.getWouldRestartGame(userOption);
            System.out.println(wouldRestartGame);

            // 재시작 / 종료 실행
            if (wouldRestartGame == GameOption.RESTART.getOption()) {
                continue;
            } else {
                // 게임 종료 안내
                System.out.println("게임 종료");
                // 인스턴스 메모리 해제
                closeAll();
                break;
            }
        }

    }

    // 인스턴스 메모리 해제
    private static void closeAll() {
        gameService = null;
        Console.close();
    }
}
