package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

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

    public static void main(String[] args) {
        Application app = new Application();
        app.startGame();    // 게임 시작

    }
}
