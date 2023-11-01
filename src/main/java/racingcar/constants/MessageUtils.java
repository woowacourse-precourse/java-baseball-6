package racingcar.constants;

public enum MessageUtils {

    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    GAME_CYCLE("시도할 회수는 몇회인가요?"),
    RACE_RESULT("실행 결과"),
    GAME_WINNER_MSG("최종 우승자 : ");

    private final String message;

    MessageUtils(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
