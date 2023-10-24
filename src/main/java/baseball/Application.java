package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        //1부터 9까지 서로 다른 임의의 수 3개 선택하여 정답 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);

        while (true) {
            //서로 다른 3자리 수 입력받고 잘못된 값 입력 시 예외 발생 후 프로그램 종료
            List<Integer> user = new ArrayList<>();
            IllegalArgumentException exp = new IllegalArgumentException();

            System.out.print("숫자를 입력해주세요 : ");
            String str = Console.readLine();
            if (str.length() != 3) {
                throw exp;
            }
            for (int i = 0; i < 3; i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    throw exp;
                } else {
                    user.add(str.charAt(i) - '0');
                }
            }
            System.out.println(user);

            //숫자의 포함여부와 자리를 확인하여 볼, 스트라이크, 낫싱 판단하여 결과 출력하기
            int ball = 0;
            int strike = 0;
            for (int i = 0; i < 3; i++) {
                if (computer.contains(user.get(i))) {
                    if (user.get(i) == computer.get(i)) {
                        strike += 1;
                    }
                    else {
                        ball += 1;
                    }
                }
            }
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }

            //정답인 경우, 종료 문구 출력 후 재시작 혹은 종료를 나타내는 수 입력받기
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int restart = Integer.parseInt(Console.readLine());
                System.out.println(restart);
            }
        }

    }
}
