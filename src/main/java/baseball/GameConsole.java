package baseball;

import camp.nextstep.edu.missionutils.Console;
public class GameConsole {
    private static final String REGEX_RESTART_OR_END = "^[1-2]{1}"; // 1개의 1 또는 2

    public static void play(Game game){
        game.initGame();
        do{
            game.playGame();
        } while (restartOrEnd());
        Console.close();
    }

    private static boolean restartOrEnd(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String inputValue = Console.readLine();
        ValidateInput.validate(inputValue, REGEX_RESTART_OR_END, "1 또는 2숫자를 입력해주세요.");
        return inputValue.equals("1");
    }
}
