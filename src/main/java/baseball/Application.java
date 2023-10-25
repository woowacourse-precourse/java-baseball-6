package baseball;

import baseball.domain.game.GameService;
import baseball.domain.utils.RandomGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private static GameService gameService = GameService.getInstance();

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            // 랜덤수 리스트 생성
            List<Integer> randomNumbers = RandomGenerator.getRandomNumbers();
            System.out.println(randomNumbers.toString());

            // 정답을 맞추어 게임이 끝난 경우라면
            if (gameService.hasGameEnded(randomNumbers)) {
                // 게임 종료 선택 시 시스템 종료
                if (gameService.hasSelectedEndGame()) {
                    break;
                }
            }
        }

    }

    // 인스턴스 메모리 해제
    private static void closeAll() {
        gameService = null; //gc가 collect 할 수 있게함
        Console.close();
    }
}
