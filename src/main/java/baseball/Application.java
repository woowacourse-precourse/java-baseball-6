package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        ComputerRandom computer = new ComputerRandom();
        InputGame input = new InputGame();
        Check compare = new Check();
        Again again = new Again();
        //System.out.println("숫자 야구 게임을 시작합니다.");

        Integer restart = 1;

        while(restart == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computerNum = computer.ComputerNumber();
            String result = "";

            while(!result.equals("3스트라이크")) {
                result = compare.Classification(computerNum, input.playerNum());
                System.out.println(result);
            }

            restart = again.again();

        }
    }
}
