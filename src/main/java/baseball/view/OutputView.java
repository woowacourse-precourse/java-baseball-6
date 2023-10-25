package baseball.view;

public class OutputView {

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";


    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

}
