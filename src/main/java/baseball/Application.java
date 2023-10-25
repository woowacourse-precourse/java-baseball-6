package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {

            int strike;

            List<Integer> computer = Computer.getComputer();

            do {

                System.out.print("숫자를 입력해주세요 : ");

                Player player = new Player(new InputValidation(Console.readLine()).getValidationList());

                Comparison compare = new Comparison(computer, player.input());

                strike = compare.getMatchValue().size();
            } while (strike != 3);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        } while (Integer.parseInt(Console.readLine()) == 1);

    }
}
