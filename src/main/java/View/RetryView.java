package View;

import static Util.Validator.validateMenuChoice;

import camp.nextstep.edu.missionutils.Console;

public class RetryView {

    private static final RetryView INSTANCE = new RetryView();

    private RetryView() {
    }

    public static RetryView getInstance() {
        return INSTANCE;
    }

    public boolean printRetryMessage() {
        System.out.println(Message.GAME_END_RETRY.getMessage());
        String retryNumber = Console.readLine();
        validateMenuChoice(retryNumber);
        if(retryNumber.equals(Message.RETRYGAME.getMessage())){
            return true;
        }
        if(retryNumber.equals(Message.ENDGAME.getMessage())){
            return false;
        }

        return false;
    }

    public enum Message {
        GAME_END_RETRY("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        RETRYGAME("1"),
        ENDGAME("2");

        private String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
