package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        String restart = "1";
        while (restart.equals("1")) {

//    	랜덤 세자리 수 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
//		세자리 수 입력 받기
            List<Integer> user;
            while (true) {
                user = new ArrayList<>();
                int strike = 0, ball = 0;
                System.out.println("숫자를 입력해주세요 :");
                String[] Input = Console.readLine().split("");

                if (Input.length != 3) {
                    throw new IllegalArgumentException();
                }
                for (String s : Input) {
                    if (!user.contains(Integer.parseInt(s))) {
                        user.add(Integer.parseInt(s));
                    }
                }
                if (user.size() != 3) {
                    throw new IllegalArgumentException();
                }
//		야구 게임
                for (int i = 0; i < 3; i++) {
                    if (Objects.equals(computer.get(i), user.get(i))) {
                        strike++;
                        continue;
                    } else if (computer.contains(user.get(i))) {
                        ball++;
                    }
                }
//		출력
                if (ball == 0 && strike == 0) {
                    System.out.println("낫싱");
                    continue;
                }
                if (ball != 0) {
                    System.out.println(ball + "볼 ");
                }
                if (strike != 0) {
                    System.out.println(strike + "스트라이크");
                }

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    restart = Console.readLine();
                    break;
                }
            }
        }
    }
}
