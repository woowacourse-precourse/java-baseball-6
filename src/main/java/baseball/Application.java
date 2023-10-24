package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException{
        System.out.println("숫자 야구 게임을 시작합니다.");

        ComputerNum computer = new ComputerNum();
        UserInput userInput = new UserInput();
        Compare compare = new Compare();
        Restart retry = new Restart();

        boolean again = true;

        while(again) {
            List<Integer> com_num = computer.ComputerNumber();

            String result = "";

            while(!result.equals("3스트라이크")) {
                result = compare.Classification(com_num, userInput.player_num());
                System.out.println(result);
            }

            again = retry.retry();
        }
    }
}