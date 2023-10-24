package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameService {
    private static GameService instance;

    /* GameService 싱글톤 인스턴스 반환  */
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    private GameService() {
    }

    /* Test용 ONLY :: GameService 싱글톤 인스턴스 반환  */
    protected static void clearInstance() {
        instance = null;
    }

    public boolean hasGameEnded(List<Integer> randomNumbers) {
        // 게임 싸이클 시작
        while (true) {
            if (doBaseballGame(randomNumbers)) {
                break;
            }
        }

        // 게임 완료 후
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        // 재시작 여부 입력
        String userOption = Console.readLine();
        Integer wouldRestartGame = User.getWouldRestartGame(userOption); // 검증 후, 숫자로 변환
        System.out.println(wouldRestartGame);

        // 재시작 / 종료 실행
        return hasSelectedRestartOrEnd(wouldRestartGame);
    }

    private boolean doBaseballGame(List<Integer> randomNumbers) {
        // 사용자 정답값 리스트
        List<Integer> userAnswerInputs = getUserAnswerInputs();
        System.out.println(userAnswerInputs.toString());

        // 정답이라면 게임 싸이클 탈출
        if (hasRightAnswer(userAnswerInputs, randomNumbers)) {
            return true;
        }
        return false;
    }

    private static boolean hasSelectedRestartOrEnd(Integer wouldRestartGame) {
        // 게임 종료 선택 했다면
        if (wouldRestartGame == GameOption.END.getOption()) {
            // 게임 종료
            System.out.println("게임 종료");
            return true;
        }
        return false;
    }

    // 주어진 랜덤값과 사용자 입력값 정답 비교
    public boolean hasRightAnswer(List<Integer> userAnswerInputs, List<Integer> randomNumbers)
            throws IllegalArgumentException {
        // 컴퓨터 인스턴스 :: 정답 계산
        Computer computer = new Computer();
        System.out.println(computer.getStrikeCount());
        System.out.println(computer.getBallCount());

        // 숫자 입력 안내 뷰
        System.out.print("숫자를 입력해주세요 : ");

        // 정답 여부 판단
        boolean isAnswer = computer.isAnswer(userAnswerInputs, randomNumbers);

        System.out.println(computer.getStrikeCount());
        System.out.println(computer.getBallCount());
        System.out.println(computer.showResult());

        if (isAnswer) {
            // 정답이라면 게임 종료
            return true;
        }
        return false;
    }

    public static List<Integer> getUserAnswerInputs() throws IllegalArgumentException {
        // 사용자 정답입력값  입력
        String userAnswer = Console.readLine();
        // 사용자 정답입력값 파싱
        return User.parseUserAnswer(userAnswer);
    }
}
