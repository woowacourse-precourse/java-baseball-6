package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        String Number;
        String[] tempNumber;

        System.out.println("숫자를 입력해주세요 : ");
        Number = Console.readLine();

        tempNumber = Number.split("");
        for (String s : tempNumber) {
            userNumber.add(Integer.parseInt(s));
        }

        return userNumber;
    }
}