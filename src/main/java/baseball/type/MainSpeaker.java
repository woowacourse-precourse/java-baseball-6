package baseball.type;

public enum MainSpeaker {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("숫자 야구 게임을 종료합니다."),
    GUESS_NUMBER("숫자를 입력해주세요 : "),
    CORRECT_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ONE_MORE_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    MainSpeaker(String mainCall){
        this.mainCall = mainCall;
    }
    final private String mainCall;
    public String getMainCall() {
        return mainCall;
    }

}
