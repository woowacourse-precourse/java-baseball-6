package baseball.view;

public class Output {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String ALL_CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStart() {
        System.out.println(START_GAME);
    }

    public static void printAllCorrect() {
        System.out.println(ALL_CORRECT);
    }

}
