package baseball;

public class AnswerChecker {
    int ballCount = 0;
    int strikeCount = 0;
    AnswerState answerState = AnswerState.WRONG;
    String resultMessage;

    public void check(Number answer, Number input) {
        for (int i = 0; i < answer.getSize(); i++) {
            int answerDigit = answer.getValues().get(i);
            int inputDigit = input.getValues().get(i);

            if (answerDigit == inputDigit) {
                strikeCount++;
            } else if (answer.getValues().contains(inputDigit)) {
                ballCount++;
            }
        }

        printResultMessage();

        if(strikeCount == answer.getSize()) {
            answerState = AnswerState.CORRECT;
        }
    }

    public boolean isAnswer() {
        return this.answerState == AnswerState.CORRECT;
    }

    public void printResultMessage(){
        if(ballCount == 0 && strikeCount == 0) {
            resultMessage = "낫싱";
        }
        else {
            String ballCountStr = (ballCount == 0) ? "" : String.format("%d볼 ", ballCount);
            String strikeCountStr = (strikeCount == 0) ? "" : String.format("%d스트라이크", strikeCount);
            resultMessage = ballCountStr + strikeCountStr;
            }
        System.out.println(resultMessage);
    }

    public AnswerChecker(){}
}
