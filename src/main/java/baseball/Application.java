package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();
        InitGame init = new InitGame();
        Check check = new Check();
        Restart restart = new Restart();

        boolean playAgain = true;

        while (playAgain) {
            List<Integer> com_num = computer.ComputerNumber();

            String result = "";

            while (!result.equals("3 스트라이크")) {
                result = check.Classification(com_num, init.playerNum());
                System.out.println(result);
            }

            playAgain = restart.restart();
        }
    }
}