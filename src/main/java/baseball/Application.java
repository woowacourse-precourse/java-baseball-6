package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int power = 0;  // 1 = restart , 2 = exit

        while (power != 2) {
            // 컴퓨터 임의 숫자 3개 생성
            List<Integer> computer = CptGetNum();

            // 변수 초기화 부분
            int ball = 0;
            int strike = 0;

            // 게임 시작문구 출력
            System.out.println("숫자 야구 게임을 시작합니다.");

            while (strike != 3) {
                ball = 0;
                strike = 0;

                // 사용자 입력
                List<Integer> user = UserInput();

                // 비교
                int[] result = new int[2];
                List_compare(computer, user, result);
                ball = result[0];
                strike = result[1];

                // 비교결과 출력
                Result_print(ball, strike);

                // 게임 재시작 or 종료 입력 받기
                power = userChoice(strike, power);
            }
        }
        Console.close();
    }

    private static int userChoice(int strike, int power) {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            //게임 종료 -> 재시작 여부 확인
            power = Integer.parseInt(Console.readLine());

        }
        return power;
    }

    private static void Result_print(int ball, int strike) {
        // 둘다 0인경우
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }

        // ball 만 0인 경우
        else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }

        // strike 만 0인경우
        else if (strike == 0) {
            System.out.println((ball + "볼"));
        }

        // 나머지
        else {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }
    }

    private static List<Integer> CptGetNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> UserInput() {
        // 사용자 입력
        System.out.println("숫자를 입력해주세요: ");
        List<Integer> user = new ArrayList<>();
        String input = Console.readLine();

        // 예외처리
        if (Integer.parseInt(input) < 100 || Integer.parseInt(input) > 999) {
            throw new IllegalArgumentException();
        }

        user.add(Integer.parseInt(String.valueOf(input.charAt(0))));
        user.add(Integer.parseInt(String.valueOf(input.charAt(1))));
        user.add(Integer.parseInt(String.valueOf(input.charAt(2))));
        return user;
    }

    private static void List_compare(List<Integer> computer, List<Integer> user, int[] result) {
        int ball = 0;
        int strike = 0;
        // 비교하는 부분
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Objects.equals(computer.get(i), user.get(j))) {
                    if (i == j) {
                        strike++;
                        break;
                    }
                    ball++;
                }
            }
        }
        result[0] = ball;
        result[1] = strike;
    }

}
