package baseball.message;

public enum GameMessage {
    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_MESSAGE("숫자를 입력해주세요 : "),
    ClEAR_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_STATUS_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    GameMessage(String message) {
    }
}
