package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameView {

    public static boolean Game() {
        boolean result = true;
        BaseballGame baseballGame = new BaseballGame();
        InputException inputException = new InputException();

        List<Integer> computerNumber = baseballGame.createRandomNumber();

        while(result){
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> inputNumber = baseballGame.stringToIntList(input);

            System.out.println(input);

            inputException.checkInput(input);

            baseballGame.strikeBallOut(inputNumber, computerNumber);
            result = baseballGame.checkResult();
        }

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        System.out.println(input);

        if (input.equals("1")){
            Game();
        }
        if (input.equals("2")){
            System.out.println("게임종료");
        }
        return result;
    }


}
