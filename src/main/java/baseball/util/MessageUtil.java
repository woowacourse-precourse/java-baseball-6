package baseball.util;

public enum MessageUtil {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_BASEBALL_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    GAME_SUCCESS_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RETRY_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    MessageUtil(String message){
        this.message = message;
    }

    public void messagePrintln(){
        System.out.println(this.message);
    }

    public void messagePrint(){
        System.out.print(this.message);
    }
}
