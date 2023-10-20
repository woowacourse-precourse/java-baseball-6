package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<String> numberAnswer = generateRandomNumber();
        }
    }

    public static List<String> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3)
                .stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }
}
