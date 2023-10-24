package baseball;


public record Result(Integer strike, Integer ball) {

    public void print() {
        String message = "";
        if (strike == 0 && ball == 0) {
            message += "낫싱";
        }
        if(ball > 0) {
            message += ball + "볼";
        }
        if (strike > 0) {
            if (!message.isEmpty()) {
                message += " ";
            }
            message += strike + "스트라이크";
        }

        System.out.println(message);
    }

    public boolean isCorrect(int answerLength) {
        return strike == answerLength;
    }
}