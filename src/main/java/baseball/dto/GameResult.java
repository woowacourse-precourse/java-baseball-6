package baseball.dto;

public record GameResult() {  //보일러 플레이트 코드 비대해지는 것 방지 record 사용
    public static final String NO_CONUT_MESSAGE = "낫싱";
    public static final String BALL_MESSAGE = "볼";
    public static final String STRIKE_MESSAGE = "스트라이크";

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    public static final String SUCCESS_AND_EXIT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";



}
