package baseball;

import camp.nextstep.edu.missionutils.Console;
public class StartOrQuitGame {

    public static void startOrQuitGame(){

        String input = "";

        input = Console.readLine();

        while (true) {
            if ("1".equals(input)) {
                Application.play();

            } else if ("2".equals(input)){
                break;
            }
        }

    }
}
