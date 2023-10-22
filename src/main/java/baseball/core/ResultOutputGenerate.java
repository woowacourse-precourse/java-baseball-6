package baseball.core;

import baseball.view.OutputView;

public class ResultOutputGenerate {

    public static void generateAllResultTextForOutput(int ball_count, int strike_count){
        String result = ball_count+"볼 "+strike_count+"스트라이크";
        OutputView.outputForBallAndStrikeScore(result);
    }

    public static void generateBallResultTextForOutput(int ball_count){
        String result = ball_count+"볼";
        OutputView.outputForBallScore(result);
    }

    public static void generateStrikeResultTextForOutput(int strike_count){
        String result = strike_count+"스트라이크";
        OutputView.outputForStrikeScore(result);
    }

    public static void generateNothingResultTextForOutput(){
        String result = "낫싱";
        OutputView.outputForNothingScore(result);
    }

    public static void generateSuccessResultTextForOutput(int strike_count){
        String result = strike_count+"스트라이크\n"+strike_count+"개의 숫자를 모두 맞히셨습니다! 게임 종료";
        OutputView.outputForGameSuccess(result);
    }

}
