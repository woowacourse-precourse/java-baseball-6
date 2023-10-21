package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Application {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        String randomNumber = computer.stream()
                .map(Object::toString)
                .collect(joining(""));
        return randomNumber;
    }

    public void validateInputNumber(String input) {
        if (input.length() != 3 || !input.matches("\\d+")) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }

    }

    public String getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        return input;
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.startGame();    // 게임 시작
    }
}
