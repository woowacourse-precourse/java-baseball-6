package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> ansArray = randomNum(); // 랜덤 난수 생성 함수

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            try {
                String numInput = Console.readLine();

                //입력이 3자리 아닐 경우
                if (numInput.length() != 3) {
                    throw new IllegalArgumentException();
                }
                List<Integer> numArray = new ArrayList<>();
                for (char digit : numInput.toCharArray()) {
                    numArray.add(Character.getNumericValue(digit));
                }

                int[] result = check(numArray, ansArray);
                int strike = result[0];
                int ball = result[1];

                if (strike > 0 && ball > 0) {
                    System.out.println(ball + "볼, " + strike + "스트라이크");
                } else if (strike > 0) {
                    System.out.println(strike + "스트라이크");
                } else if (ball > 0) {
                    System.out.println(ball + "볼");
                } else {
                    System.out.println("낫싱");
                }

                //다 맞추면 반복문 종료
                if (strike == 3) {
                    System.out.println(("3개의 숫자를 모두 맞히셨습니다! 게임 종료"));
                    System.out.println(("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."));
                    int restart = Integer.parseInt(Console.readLine());
                    if (restart == 1) {
                        ansArray = randomNum();
                    } else {
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다." + e.getMessage());
            }
        }
    }

    public static List<Integer> randomNum() {
        List<Integer> ansArray = new ArrayList<>();
        while (ansArray.size() < 3) {
            int numbers = Randoms.pickNumberInRange(1,9);
            if (!ansArray.contains(numbers)) {
                ansArray.add(numbers);
            }
        }
        return ansArray;
    }

    public static int[] check(List<Integer> numArray, List<Integer> ansArray) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (numArray.get(i) == ansArray.get(i)) {
                strike++;
            }
            else if (ansArray.contains(numArray.get(i))) {
                ball++;
            }
        }
        int[] result = {strike, ball};
        return result;
    }
}
