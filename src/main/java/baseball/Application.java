package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<Integer> pickRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static int parseInt(String target) {
        try {
            return Integer.parseInt(target);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    static List<Integer> convertUserInput(String input) {
        List<Integer> user = new ArrayList<>();
        String[] numbers = input.split("");
        for (String element: numbers) {
            int number = parseInt(element);
            user.add(number);
        }
        return user;
    }

    static List<Integer> readUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return convertUserInput(input);
    }

    static void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = pickRandomNumbers();
        List<Integer> user = readUserNumbers();
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        play();
    }
}
