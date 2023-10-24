package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        ComputerNum computer = new ComputerNum();
        GameTry gameTry = new GameTry();
        Compare compare = new Compare();
        Retry retry = new Retry();

        boolean again = true;

        while(again) {
            List<Integer> com_num = computer.ComputerNumber();

            String result = "";

            while(!result.equals("3스트라이크")) {
                result = compare.classification(com_num, gameTry.player_num());
                System.out.println(result);
            }

            again = retry.retry();
        }
    }
}