package baseball;

import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        ComputerNum computer = new ComputerNum();
        Init_game init = new Init_game();
        CompareNum compare = new CompareNum();
        Retry retry = new Retry();

        boolean again = true;

        while(again) {
            List<Integer> com_num = computer.RandomNumber();

            String result = "";

            while(!result.equals("3스트라이크")) {
                result = compare.Classification(com_num, init.player_num());
                System.out.println(result);
            }
            again = retry.retry();
        }

    }
}
