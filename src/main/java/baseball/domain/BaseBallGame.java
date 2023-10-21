package baseball.domain;

public class BaseBallGame {

    public static final int STRIKE = 0;
    public static final int BALL = 1;
    public static final int OUT = 2;

    private static final String GAME_START_MESSAGE = "숫자야구 게임을 시작합니다";

    private Player player1;
    private Player player2;

    private BaseBallGame(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public static BaseBallGame startNewGame(Player player1, Player player2){
        System.out.println(GAME_START_MESSAGE);
        return new BaseBallGame(player1,player2);
    }


    @Override
    public String toString() {
        return
                player1.playerType.name()+": " + player1 +"\n"+
                player2.playerType.name()+": " + player2
                ;
    }
}
