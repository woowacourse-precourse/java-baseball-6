package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 랜덤 번호 선택
        Computer computer = new Computer(Randoms.pickUniqueNumbersInRange(1,9,3));

        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));

        System.out.println("computer.guessNumbers(arr) = " + computer.guessNumbers(arr));


        // 2. 번호 입력 받기
//        String s = Console.readLine();

        // 3. 스트라이크 / 볼 / 낫싱 결과 판단 후 결과 출력

//        computer.guessNumbers(s);

        // 4. 게임 재시작 or 종료
    }
}
