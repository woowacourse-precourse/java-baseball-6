package baseball.view;

public class GameMessage {

    private static final String GAME_START ="숫자 야구 게임을 시작합니다.";
    private static final String NOTHING = "낫싱";
    private static final String BALL="볼";
    private static final String STRIKE = "스트라이크";
    private static final String GAME_COMPLETE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartMessage(){
        System.out.println(GAME_START);
    }

    public void printResultMessage(int ball, int strike){
        if (ball==0 && strike==0)
            System.out.println(NOTHING);
        if (ball!=0 && strike==0)
            System.out.println(ball+BALL);
        if (ball==0&&strike!=0)
            System.out.println(strike + STRIKE);
        if (ball!=0 && strike!=0)
            System.out.println(ball+BALL+" "+strike+STRIKE);
    }

    public static void printGameCompleteMessage(){
        System.out.println(GAME_COMPLETE);
    }
}
