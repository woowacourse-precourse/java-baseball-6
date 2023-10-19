package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 랜덤하게 숫자 1~9 로 이루어진 3자리 숫자 생성
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = makeRandomNum();

        // 2. 숫자 입력
        System.out.printf("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try {
            int number = Integer.parseInt(input);
            if (input.contains("0")){   // 0이 포함된 숫자를 가졌을 경우
                throw new IllegalArgumentException("contains '0'");
            }
            if (number < 100 || number > 999){  // 숫자가 세자리 수가 아닌 경우
                throw new IllegalArgumentException("not three digit number");
            }
            List<Integer> player = new ArrayList<>();
            for (int i = 100; i > 0; i /= 10){
                int digit = number / i;
                number %= i;
                if (player.contains(digit)) {   // 서로 다른 세 자리의 수가 아닐 경우
                    throw new IllegalArgumentException("contains duplicate numbers");
                }
                player.add(digit);
            }
        } catch (NumberFormatException e){  // 숫자가 아닌 이상한 값일 경값
            throw new IllegalArgumentException("not number");
        }
    }

    private static List<Integer> makeRandomNum(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) { // 서로 다른 숫자들로만 구성하게하는 부분.
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
