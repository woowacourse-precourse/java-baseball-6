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

    /* Test용 ONLY :: GameService 싱글톤 인스턴스 null 처리  */
    protected static void clearInstance() {
        instance = null;
    }

    /* 게임을 시작하고, 정답이라면 true를 반환합니다. */
    public boolean hasGameEnded(List<Integer> randomNumbers) {
        // 게임 싸이클 시작
        while (true) {
            if (doBaseballGame(randomNumbers)) {
                break;
            }
        }
        return true;
    }

    /* 사용자로부터 입력을 받고, 종료를 선택했는지 판별합니다. */
    public boolean hasSelectedEndGame() {
        // 게임 완료 후
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        // 재시작 여부 입력
        String userOption = Console.readLine();

        // 종료를 선택했다면 true를 반환합니다.
        return isEndOption(userOption);
    }

    /* 사용자로부터 정답값을 입력받고, 정답인지 판별합니다. */
    protected boolean doBaseballGame(List<Integer> randomNumbers) {
        // 사용자 정답값 리스트
        List<Integer> userAnswerInputs = getUserAnswerInputs();
        System.out.println(userAnswerInputs.toString());

        // 정답이라면 true를 반환합니다.
        if (hasRightAnswer(userAnswerInputs, randomNumbers)) {
            return true;
        }
        return false;
    }

    /* 사용자가 게임종료를 선택했는지 판별합니다. */
    protected boolean isEndOption(String userOption) {
        // 검증 후, 숫자로 변환
        Integer wouldRestartGame = User.getWouldRestartGame(userOption);
        System.out.println(wouldRestartGame);

        // 게임 종료 선택 했다면 true를 반환합니다.
        if (wouldRestartGame == GameOption.END.getOption()) {
            System.out.println("게임 종료");
            return true;
        }
        return false;
    }

    // 주어진 랜덤값과 사용자 입력값 정답 비교
    protected boolean hasRightAnswer(List<Integer> userAnswerInputs, List<Integer> randomNumbers)
            throws IllegalArgumentException {
        // 컴퓨터 인스턴스 :: 정답 계산
        Computer computer = new Computer();

        // 숫자 입력 안내 뷰
        System.out.print("숫자를 입력해주세요 : ");

        // 정답 여부 판단
        boolean isAnswer = computer.isAnswer(userAnswerInputs, randomNumbers);

        // 볼, 스트라이크 상태 출력
        System.out.println(computer.showResult());

        // 정답이라면 게임 종료
        if (isAnswer) {
            return true;
        }
        return false;
    }

    /* 정답값을 사용자로부터 입력받고 파싱합니다. 이 때, 파싱과정에서 User가 검증을 처리합니다. */
    protected List<Integer> getUserAnswerInputs() throws IllegalArgumentException {
        // 사용자 정답입력값 입력
        String userAnswer = Console.readLine();
        // 사용자 정답입력값 파싱
        return User.parseUserAnswer(userAnswer);
    }
}
