package baseball.View;

public class OutputView {

    private static final String START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String SPACE = " ";

    public static void startBaseBallGame(){
        System.out.println(START_BASEBALL_GAME);
    }

    public static void showCompareResult(int strikeNum, int ballNum){

        StringBuilder sb = new StringBuilder();

        if(ballNum > 0){
            sb.append(ballNum + BALL + SPACE);
        }

        if(strikeNum > 0){
            sb.append(strikeNum + STRIKE);
        }

        if(sb.length() == 0){
            sb.append(NOTHING);
        }

        System.out.println(sb);
    }
}
