package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int retry = 0;
        while(retry < 2) {
            if (retry == 1){
                retry = 0;
                computer.clear();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
            }
            int num = 0;
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();
            if (input.length() != 3) {
                throw new IllegalArgumentException("입력한 값이 올바르지 않습니다. 3자리 숫자를 입력해주세요.");
            }
            num = Integer.parseInt(input);


            List<Integer> digits = new ArrayList<>();
            digits.add(num / 100);        // 백의 자리
            digits.add((num / 10) % 10);  // 십의 자리
            digits.add(num % 10);         // 일의 자리

            int ball = 0;
            int strike = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (computer.get(i) == digits.get(j)) {
                        if (i == j) {
                            strike += 1;
                        } else if (i != j) {
                            ball += 1;
                        }
                    }
                }
            }
            if (ball > 0) {
                System.out.print(ball + "볼");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            if (ball == 0 && strike == 0){
                System.out.print("낫싱");
            }
            System.out.println();
            if (strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                retry = Integer.parseInt(Console.readLine());
                if (retry != 1 && retry != 2) {
                    throw new IllegalArgumentException("입력한 값이 올바르지 않습니다. 1 또는 2를 입력해주세요.");
                }
            }
        }
    }
}
