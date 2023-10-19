package baseball.View;

public class OutputView {

    private static final String START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_USER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String GAME_OVER = " 3개의 숫자를 모두 맞히셨습니다! 게임 종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫띵";

    public static void startBaseBallGame(){
        System.out.println(START_BASEBALL_GAME);
    }

    public static void inputUserNumber(){
        System.out.print(INPUT_USER_NUMBER);
    }

    public static void showCompareResult(int strikeNum, int ballNum){

        StringBuilder sb = new StringBuilder();

        if(ballNum > 0){
            sb.append(strikeNum + BALL);
        }

        if(strikeNum > 0){
            sb.append(strikeNum + STRIKE);
        }

        if(sb.length() == 0){ // 스트라이크, 볼 둘다 없는 경우
            sb.append(NOTHING);
        }

        System.out.println(sb);
    }

    public static void gameOver(){
        System.out.println(GAME_OVER);
    }
}
