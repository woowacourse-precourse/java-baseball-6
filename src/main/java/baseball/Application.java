package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        String booter = "1";

        if (game().get(0) == 3) {
            System.out.println(game().get(0) + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input2 = Console.readLine();
            if (input2.equals("1")){
                game();
            }
        }


    }
    public static List<Integer> game() throws IllegalArgumentException {
        int ball = 0;
        int strike = 0;
        String input = new String();

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int inputNum = Integer.parseInt(input);
        int inputNum1 = inputNum / 100;
        int inputNum2 = inputNum % 100 / 10;
        int inputNum3 = inputNum % 10;

        List<Integer> user = new ArrayList<>(Arrays.asList(inputNum1, inputNum2, inputNum3));

        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j <user.size(); j++) {
                if (computer.get(i) == user.get(i)) {
                    strike ++;
                }
                else if (computer.get(i) == user.get(j)) {
                    ball ++;
                }
                else continue;
            }
        }

        List<Integer> result = new ArrayList<>(Arrays.asList(strike, ball));
        return result;
    }
}