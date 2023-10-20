package baseball.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUM_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String inputNum(){
        System.out.print(INPUT_NUM_MESSAGE);
        String inputNum = Console.readLine();
        return inputNum;
    }
    public static int restart(){
        System.out.println(GAME_RESTART_MESSAGE);
        int num = Integer.parseInt(Console.readLine());
        return num;
    }

    public static void correctInputnum(String num){

    }


}
