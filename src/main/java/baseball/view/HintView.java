package baseball.view;

public class HintView {
    private static final String ASK_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BALL_WORD = "볼";
    private static final String STRIKE_WORD = "스트라이크";
    private static final String NOTHING_WORD = "낫싱";
    private static final String SEPARATOR = " ";

    public static void askInputNumber(){
        System.out.print(ASK_INPUT_NUMBER_MESSAGE);
    }

    public static void printBallAndStrikeHint(int ball, int strike){
        System.out.println(ball + BALL_WORD + SEPARATOR + strike + STRIKE_WORD);
    }

    public static void printBallHint(int ball){
        System.out.println(ball + BALL_WORD);
    }

    public static void printStrikeHint(int strike){
        System.out.println(strike + STRIKE_WORD);
    }

    public static void printNothingHint(){
        System.out.println(NOTHING_WORD);
    }
}
