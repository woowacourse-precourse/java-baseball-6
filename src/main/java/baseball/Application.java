package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        CPU cpu = new CPU();
        Compare compare = new Compare();
        Init_game init = new Init_game();
        Retry retry = new Retry();

        boolean again = true;

        while(again) {
            List<Integer> cpu_num = cpu.CPUNum();

            String result = "";

            while(!result.equals("3스트라이크")) {
                result = compare.Classification(cpu_num, init.player_num());
                System.out.println(result);
            }

            again = retry.retry();
        }
    }
}

