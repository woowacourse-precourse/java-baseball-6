package baseball.resources;

public class GameConst {
    public static final int NUM_SIZE = 3; //정해진 숫자 자리수
    public static final int RANGE_START = 1; //가능한 Number 범위 시작 값
    public static final int RANGE_END = 9; //가능한 Number 범위 끝 값
    public static final int ZERO = 0;
    public static final int ALL_STRIKE = 3; //게임이 종료되는 스트라이크 개수
    public static final int WANT_RESTART = 1; //재시작을 위한 값
    public static final int WANT_EXIT = 2; //종료를 위한 값
    public static final boolean GAME_OVER = true; //게임 성공
    public static final boolean NOT_GAME_OVER = false; //게임 실패
    public static final boolean RESTART = true; //재시작
    public static final boolean EXIT_GAME = false; //게임종료

    public GameConst() {
    }
}
