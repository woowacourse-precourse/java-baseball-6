package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 랜덤 번호 선택
//        Computer computer = new Computer(Randoms.pickUniqueNumbersInRange(1, 9, 3));
        Computer computer = new Computer();
        System.out.println("computer.getTarget() = " + computer.getTarget());
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            String input = null;
            // 2. 번호 입력 받기
            try {
                System.out.print("숫자를 입력하세요: ");
                input = Console.readLine();
                if (input.length() != 3) {
                    throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("잘못된 입력입니다.", e);
            }

            int[] arr = Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();
            List<Integer> guess = Arrays.stream(arr).boxed().toList();

            // 3. 스트라이크 / 볼 / 낫싱 결과 판단 후 결과 출력

            String guessResult = computer.getGuessResult(guess);
            System.out.println("computer.getTarget() = " + computer.getTarget());
            System.out.println(guessResult);

            // 4. 게임 재시작 or 종료
            if (computer.getSolved()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String choice = Console.readLine();
                // 게임 재시작
                if (choice.equals("1")) {
//                    computer.changeTarget(Randoms.pickUniqueNumbersInRange(1, 9, 3));
                    computer = new Computer();
                }
                // 게임 종료
                else if (choice.equals("2")) {
                    break;
                }
            }
        }
        Console.close();
    }
}
