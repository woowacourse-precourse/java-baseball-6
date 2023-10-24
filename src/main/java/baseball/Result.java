package baseball;


public record Result(Integer strike, Integer ball) {

    public void print() {
        String message = "";
        if (strike == 0 && ball == 0) {
            message += Message.NOTHING;
        }
        if(ball > 0) {
            message += ball + Message.BALL;
        }
        if (strike > 0) {
            if (!message.isEmpty()) {
                message += " ";
            }
            message += strike + Message.STRIKE;
        }

        System.out.println(message);
    }

    public boolean isCorrect(int answerLength) {
        return strike == answerLength;
    }
}