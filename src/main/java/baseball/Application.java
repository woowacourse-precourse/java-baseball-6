package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        //랜덤 숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while(true) {
            //사용자 입력
            System.out.print("숫자를 입력해주세요 : ");
            String s = Console.readLine();

            //예외처리
            if (s.length() != 3) {
                throw new IllegalArgumentException("숫자는 3자리만 입력 가능합니다.");
            }
            if (s.chars().anyMatch(c -> c < '0' || c > '9')) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
            if (s.chars().distinct().count() != 3) {
                throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
            }

            //사용자 입력 숫자 리스트로 변환
            List<Integer> list = new ArrayList<>();
            Arrays.stream(s.split(""))
                    .map(Integer::parseInt)
                    .forEach(list::add);

            //스트라이크, 볼 판별
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < list.size(); i++) {
                if (computer.get(i).equals(list.get(i))) {
                    strike++;
                } else if (computer.contains(list.get(i))) {
                    ball++;
                }
            }

            //결과 출력
            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = Console.readLine();
                if (input.equals("1")) {
                    computer.clear();
                    while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }
                    continue;
                } else if (input.equals("2")) {
                    break;
                }
                else {
                    throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
                }
            } else if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball == 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }

    }

}
