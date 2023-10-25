package baseball;

public class Writer {

    private static final String START_MENT = "숫자 야구 게임을 시작합니다";
    private static final String INPUT_MENT = "숫자를 입력해주세요 : ";
    private static final String CORRECT_MENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void writeStartMent() {
        System.out.println(START_MENT);
    }

    public static void writeInputMent() {
        System.out.print(INPUT_MENT);
    }

    public static void writeGradeResult(GradeResult gradeResult) {
        System.out.println(gradeResult);
    }

    public static void writeCorrectMent() {
        System.out.println(CORRECT_MENT);
    }

    public static void writeRestartMent() {
        System.out.println(RESTART_MENT);
    }

}
