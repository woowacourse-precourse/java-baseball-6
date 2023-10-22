package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.domain.utils.RandomGenerator;

import java.util.List;

public class GameService {
    private static GameService instance;
    private static User user;
    private static Computer computer;

    /* GameService 싱글톤 인스턴스 반환  */

    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    /* User,Computer를 가지고 있는 GameService 싱글톤 인스턴스 반환 */
    public static GameService getInstance(User user, Computer computer) {
        if (instance == null) {
            instance = new GameService(user, computer);
        }
        return instance;
    }

    private GameService() {
    }

    private GameService(User user, Computer computer) {
        this.user = user;
        this.computer = computer;
    }


    public void startGame() throws Exception {
        // 랜덤수 리스트 생성
        List<Integer> randomNumbers = RandomGenerator.getRandomNumbers();

        // 숫자 입력 안내 뷰
        System.out.print("숫자를 입력해주세요 : ");

        try {
            // 랜덤수 , 사용자 값 비교 :: 맞다면 게임 종료 이후, 재시작 여부 / 아니라면 계속 비교
            while (true) {
                // 사용자 값 입력
                user.getInputsFromUser();
                List<Integer> userInputs = user.getUserInputs();
                if (computer.isAnswer(userInputs, randomNumbers)) {
                    // 정답이라면 상태 출력 후, 게임 종료
                    System.out.println(computer.showResult());
                    break;
                } else {
                    // 오답이라면 상태 출력 후 재시도
                    System.out.println(computer.showResult());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
