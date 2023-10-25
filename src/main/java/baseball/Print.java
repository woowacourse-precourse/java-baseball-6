package baseball;

public class Print {
    public static String START_GAME = "숫자 야구 게임을 시작합니다.";
    public static String GET_INPUT = "숫자를 입력 해 주세요 : ";
    public static String ASK_REPLAY_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String THREE_STRIKE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String N_BALL_N_STRIKE(int ballCnt, int strikeCnt){
        return ballCnt+"볼 "+strikeCnt+"스트라이크";
    }
    public static String ONLY_STRIKE(int strikeCnt){
        return strikeCnt+"스트라이크";
    }
    public static String ONLY_BALL(int ballCnt) {
        return ballCnt + "스트라이크";
    }
    public static String NOTHING = "낫싱";
}
