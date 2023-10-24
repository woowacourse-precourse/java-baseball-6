package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        ComputerNumbers computer = new ComputerNumbers();
        Playball playball = new Playball();
        Playing playing = new Playing();
        Retry retry = new Retry();

        boolean again = true;

        while(again) {
            List<Integer> com_num =computer.ComputerNumbersList();

            String result = "";

            while(!result.equals("3스트라이크")) {
                result = playing.Classification(com_num, playball.PlayersNumbersList());
                System.out.println(result);
            }

            again = retry.retry();
        }
    }
}
