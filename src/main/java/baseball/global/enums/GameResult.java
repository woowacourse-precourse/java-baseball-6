package baseball.global.enums;

/**
 * 야구게임 매 라운드마다 가능한 결과 케이스의 출력 메시지
 */
public enum GameResult {

    STRIKE("%d스트라이크"),
    BALL("%d볼"),
    NOTHING("낫싱"),
    PERFECT("3스트라이크");  // 종료 Case는 특수한 상황으로 따로 생성

    public final String name;

    GameResult(String name) {
        this.name = name;
    }
}
