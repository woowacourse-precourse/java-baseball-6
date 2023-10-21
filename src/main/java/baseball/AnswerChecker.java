package baseball;

import java.util.List;

public class AnswerChecker {

    private static final String CORRECT_ANSWER = "03";
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;
    private static final int ANSWER_SIZE = 3;

    private int strikeCount = 0;
    private int ballCount = 0;

    private String gameResult = "";

    public String checkAnswer(List<Integer> answer, List<Integer> myAnswer){
        if(answer.equals(myAnswer)){
            return CORRECT_ANSWER;
        }
            gameResult = countBallAndStrike(answer, myAnswer);
            return gameResult;
    }

    private String countBallAndStrike(List<Integer> answer, List<Integer> myAnswer){
        for (int i = 0; i < ANSWER_SIZE; i++) {
            if (answer.get(i).equals(myAnswer.get(i))) {
                strikeCount++;
            } else if (myAnswer.contains(answer.get(i))) {
                ballCount++;
            }
        }
        return "" + ballCount + strikeCount;
    }

    public void printResult(String gameResult){
        int ballResult = (int) gameResult.charAt(BALL_INDEX) - 48;
        int strikeResult = (int) gameResult.charAt(STRIKE_INDEX) - 48;

        gameResultPrint(ballResult, strikeResult);
        clearBallCountAndStrikeCount();
    }

    private void clearBallCountAndStrikeCount(){
        ballCount=0;
        strikeCount=0;
    }

    private void gameResultPrint(int ballResult, int strikeResult){
        String gameResultForPrint = "";

        if(ballResult==0 && strikeResult==0)
            gameResultForPrint += "낫싱";
        if(ballResult>0)
            gameResultForPrint += ballResult + "볼 ";
        if(strikeResult>0)
            gameResultForPrint += strikeResult + "스트라이크";

        System.out.println(gameResultForPrint);
    }
}
