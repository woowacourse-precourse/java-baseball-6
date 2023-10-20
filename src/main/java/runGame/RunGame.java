package runGame;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import error.ErrorManage;
import java.util.List;

public class RunGame {
    String computer_num;

    public RunGame() {
        List<Integer> c_num = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        String List_to_String = c_num.toString();
        computer_num = List_to_String.replaceAll("[^0-9]", "");
    }

    public void run() {
        ErrorManage errorManage = new ErrorManage();
        Judge judge = new Judge();
        String exit; // 종료
        String number; // 유저가 입력한 숫자
        String result; // 유저가 입력한 숫자에 대한 결과

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            do {
                System.out.print("숫자를 입력해주세요 : ");
                number = Console.readLine();
                errorManage.inputNumberErrorManage(number);
                result = judge.isStrike(number, computer_num);
                System.out.println(result);
            } while (!result.equals("3스트라이크"));

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            exit = Console.readLine();
            errorManage.exitNumberErrorManage(exit);
        } while (!exit.equals("2"));

        Console.close();
    }


}
