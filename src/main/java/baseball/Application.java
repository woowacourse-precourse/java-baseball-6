package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 랜덤 번호 선택
        Computer computer = new Computer(Randoms.pickUniqueNumbersInRange(1,9,3));

        // 2. 번호 입력 받기
        String s = Console.readLine();
        int[] arr = Stream.of(s.split("")).mapToInt(Integer::parseInt).toArray();
        List<Integer> guess = Arrays.stream(arr).boxed().toList();

        // 3. 스트라이크 / 볼 / 낫싱 결과 판단 후 결과 출력

        String guessResult = computer.getGuessResult(guess);
        System.out.println(guessResult);

        // 4. 게임 재시작 or 종료
    }
}
