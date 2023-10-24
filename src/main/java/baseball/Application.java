package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        R_numGenerate r_num = new R_numGenerate();
        Input_user input = new Input_user();
        result_input judge = new result_input();
        Again playagain = new Again();
        boolean again = true;

        while (again) {
            List<Integer> computer = r_num.generate();
            System.out.println("숫자 야구 게임을 시작합니다.");
            String result = "";
            while (!result.equals("3스트라이크")) {
                result = judge.result_user(computer, input.player());
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            again = playagain.playAgain();
        }


    }
}
