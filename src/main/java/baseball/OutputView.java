package baseball;

import baseball.Score;



public final class OutputView {
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";
    private final String DELIMITER = " ";

    public void printResult(Score userScore){
        System.out.println(makeUserScoreMessage(userScore));
    }

    private String makeUserScoreMessage(Score score){
        if(score.isZeroPoint()){
            return NOTHING;
        }
        return makeBallMessage(score.getBall()) +
                makeStrikeMessage(score.getStrike());
    }

    private String makeBallMessage(int ballCount){
        if(ballCount ==0){
            return "";
        }
        return ballCount + BALL+ DELIMITER;
    }

    private String makeStrikeMessage(int strikeCount){
        if(strikeCount ==0){
            return "";
        }
        return strikeCount + STRIKE;
    }
}
