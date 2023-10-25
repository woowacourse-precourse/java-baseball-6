package baseball.core;

import baseball.view.OutputView;

public class ResultOutputGenerate {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String SUCCESS = "개의 숫자를 모두 맞히셨습니다! 게임 종료";



    public static void generateAllResultTextForOutput(int ball_count, int strike_count){
        String result = ball_count+BALL+" "+strike_count+STRIKE;
        OutputView.outputForBallAndStrikeScore(result);
    }

    public static void generateBallResultTextForOutput(int ball_count){
        String result = ball_count+BALL;
        OutputView.outputForBallScore(result);
    }

    public static void generateStrikeResultTextForOutput(int strike_count){
        String result = strike_count+STRIKE;
        OutputView.outputForStrikeScore(result);
    }

    public static void generateNothingResultTextForOutput(){
        String result = NOTHING;
        OutputView.outputForNothingScore(result);
    }

    public static void generateSuccessResultTextForOutput(int strike_count){
        String result = strike_count+STRIKE+"\n"+strike_count+SUCCESS;
        OutputView.outputForGameSuccess(result);
    }

}
