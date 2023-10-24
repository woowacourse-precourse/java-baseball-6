package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String play = "1";

        while (play.equals("1")) {
            List<Integer> computer = createComputerNumber();
            System.out.println("숫자 야구 게임을 시작합니다.");

            while(true) {
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                break;
            }
                play = "2";
        }
    }
    private static List<Integer> createComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

