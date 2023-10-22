package baseball;

    import java.util.ArrayList;
    import java.util.List;

    import baseball.constant.NumberConst;
    import baseball.util.MessageUtil;

    import baseball.validation.InputValidator;

public class Game {
    private static final int RESTART_NUMBER = NumberConst.RESTART_NUMBER; // 중지 목적 종료 숫자 확인
    private static final int STOP_NUMBER = NumberConst.STOP_NUMBER;
    private static final int INPUT_NUM_LENGTH = NumberConst.EXPECTED_INPUT_LENGTH; // 입력할 수 있는 숫자의 최대 길이(3)
    private static final MessageUtil MESSAGE_UTIL = new MessageUtil(); // 메시지 출력 용도
    private static final InputValidator VALIDATOR = new InputValidator(); // 유효성 검사 용도
    private static final int MAX_COUNT_STRIKE = NumberConst.MAX_COUNT_STRIKE; // 성공의 기준이 되는 스트라이크 개수

    private int compareRestartNum = RESTART_NUMBER; // 재시작, 종료 여부를 입력받기 위한 변수
    private String InputString; // 입력받은 숫자 리스트로 변환하기 위한 임시 변수
    private List<Integer> user = new ArrayList<>(); // user 에게 입력받은 숫자
    private int countBall; // Ball 개수 확인 용도
    private int countStrike; // Strike 개수 확인 용도

    public void startGame() {
        // TODO: Game 진행
    }

    public Game() {}

    /* *
     * 컴퓨터가 생성하는 랜덤 숫자 (3자리 수이며 각 숫자 간 중복은 없음)
     */
    private List<Integer> createRandomNumber() {
        // TODO: 랜덤 숫자 생성 (3자리 수)
    }

    /*
     * 컴퓨터가 생성한 숫자와 유저에게 입력 받은 숫자를 확인하여 Strike, Ball 개수 증가
     * 매개 변수:
     *  1. computer : 컴퓨터가 랜덤으로 생성한 숫자
     *  2. user : 유제에게 입력받은 숫자
     */
    private void updateBallAndStrikeCounts(List<Integer> user, List<Integer> computer) {
        // TODO: 입력받은 값과 생성한 랜덤 숫자 비교하여 Ball, Strike 개수 증가
    }
}
