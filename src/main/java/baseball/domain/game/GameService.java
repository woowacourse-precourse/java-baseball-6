package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.domain.utils.RandomGenerator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameService {
    private static GameService instance;
    private User user = new User();
    private Computer computer = new Computer();

    /* GameService 싱글톤 인스턴스 반환  */
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    private GameService() {
    }


    // 한 싸이클의 야구 게임 시작
    public void startGame(List<Integer> randomNumbers) throws IllegalArgumentException {

        System.out.println(randomNumbers.toString());

        // 랜덤수 , 사용자 정답입력값 비교 :: 맞다면 게임 종료 이후, 재시작 여부 / 아니라면 계속 비교
        while (true) {
            // Computer 초기화 :: ballCount,strikeCount 초기화
            computer.clear();

            // 숫자 입력 안내 뷰
            System.out.print("숫자를 입력해주세요 : ");

            // 사용자 정답값 리스트
            List<Integer> userAnswerInputs = getUserAnswerInputs();

            // 정답 여부 판단
            System.out.println(userAnswerInputs.toString());

            boolean isAnswer = computer.isAnswer(userAnswerInputs, randomNumbers);
            System.out.println(computer.showResult());

            if (isAnswer) {
                // 정답이라면 게임 종료
                break;
            }
        }
    }

    public static List<Integer> getUserAnswerInputs() throws IllegalArgumentException {
        // 사용자 정답입력값  입력
        String userAnswer = Console.readLine();
        // 사용자 정답입력값 파싱
        List<Integer> parsedUserAnswer = User.parseUserAnswer(userAnswer);
//        List<Integer> userInputs = User.getUserAnswerInputs();
        return parsedUserAnswer;
    }
}
