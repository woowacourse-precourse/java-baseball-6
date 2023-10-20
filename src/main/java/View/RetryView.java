package View;

public class RetryView {

    private static final RetryView retryview = new RetryView();

    private RetryView(){};

    public static RetryView getInstance(){
        return retryview;
    }

    public void RetryPrint(){
        System.out.println(Message.GAME_END_RETRY.message);
    }


    public enum Message {
        GAME_END_RETRY("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        private String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

}