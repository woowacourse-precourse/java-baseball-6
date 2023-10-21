package baseball.constants;

public class Printer {
    private final String START_PHRASES = "숫자 야구 게임을 시작합니다";

    private final String INSERT_ANSWER_PHRASES = "숫자를 입력해주세요 : ";

    private final String THREE_STRIKE_PHRASES = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private final String SELECT_CONTINUE_PHRASES= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final String NOTHING_PHRASES= "낫싱";

    private final String BALL_PHRASES = "볼";
    private final String STRIKE_PHRASES = "스트라이크";

    public static  String ERROR_PHRASES = "1~9까지의 서로 다른 세 자리 숫자만 입력하세요";


    public void printStart(){
        System.out.println(START_PHRASES);
    }

    public void printInsertAnswer(){
        System.out.print(INSERT_ANSWER_PHRASES);
    }

    public void printThreeStrike(){
        System.out.println(THREE_STRIKE_PHRASES);
    }
    public void printSelectContinue(){
        System.out.println(SELECT_CONTINUE_PHRASES);
    }

    public void printNothing(){
        System.out.println(NOTHING_PHRASES);
    }

    public void printBall(int ball){
        System.out.println(ball+BALL_PHRASES);
    }

    public void printStrike(int strike){
        System.out.println(strike+STRIKE_PHRASES);
    }

    public void printBallAndStrike(int ball,int strike){
        System.out.println(ball+BALL_PHRASES+" "+strike+STRIKE_PHRASES);
    }
}
