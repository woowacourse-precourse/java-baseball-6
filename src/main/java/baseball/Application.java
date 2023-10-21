package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> numbers = randomComputerNumber();

        System.out.println("randomComputerNumber() = " + numbers);

        int cnt_strike = 0;
        int cnt_ball = 0;

        while (cnt_strike != 3) {
            cnt_strike = 0;
            cnt_ball = 0;

            System.out.print("숫자를 입력해주세요 : ");
//            String input = Console.readLine();
            int input = Integer.parseInt(Console.readLine());

            int[] input_arr = new int[3];

            input_arr[0] = input / 100;  // 100의 자리
            input_arr[1] = (input % 100) / 10;  // 10의 자리
            input_arr[2] = input % 10;  // 1의 자리

            // 스트라이크, 볼 판정
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.contains(input_arr[i])) {
                    cnt_ball++;
                    if (numbers.get(i) == input_arr[i]) {
                        cnt_strike++;
                        cnt_ball--;
                    }
                }
            }
        }
    }

    private static List<Integer> randomComputerNumber() { // 랜덤 숫자를 뽑는 메서드
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) { // 3자리 숫자를 뽑기 위함
            int randomNumber = Randoms.pickNumberInRange(1, 9); // 1부터 9까지의 랜덤 수

            if (!computer.contains(randomNumber)) { // 서로 같은 수의 중복을 피하기 위함
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
