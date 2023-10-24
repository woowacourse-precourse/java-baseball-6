package baseball;

import camp.nextstep.edu.missionutils.Console;
public class BaseBallGame {

    public static final String CONTINUE_NUMBER = "1";
    public static final String END_NUMBER = "2";


    /* 숫자 야구 게임을 시작하는 메서드 */
    public void play() {
        do{
            startGame();
        } while (restartGame());
    }

    /* 게임 시작 메소드 */
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Balls computerBalls = Balls.makeRandomBalls();
        Balls userBalls;
        Result result;
        do {
            String input = inputUserBalls();
            userBalls = Balls.makeInputToBalls(input);
            result = Result.makeResult(computerBalls, userBalls);
            Result.printResult(result);
        } while (!result.isAllStrike());
    }

    private String inputUserBalls(){
        System.out.print("숫자를 입력해 주세요 : ");
        String input = getUserInput();
        validateUserInput(input);
        return input;
    }

    /* 게임을 종료하는 메소드 */
    private boolean restartGame() {
        printRestart();
        String input = getUserInput();
        validateInput(input);
        return input.equals(CONTINUE_NUMBER);
    }

    private String getUserInput() {
        return Console.readLine();
    }

    private void printRestart(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    /* 종료시, 사용자 입력 값의 유효성 확인 메서드 */
    private void validateInput(String input) {
        if (!input.equals(CONTINUE_NUMBER) && !input.equals(END_NUMBER)) {
            throw new IllegalArgumentException( "1 또는 2만 입력하세요" );
        }
    }

    /* 사용자가 제대로된 값을 입력했는지 확인하는 메소드 */
    private void validateUserInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 값의 길이가 잘못 되었습니다.");
        }
    }
}
