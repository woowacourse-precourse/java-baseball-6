package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int flag = 0;
        // TODO: 프로그램 구현
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }  // 컴퓨터 3자리 수 완성
//            System.out.println(computer.toString());
            Integer n;
            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String num = Console.readLine();

                if (num.isEmpty() || !num.matches("\\d+") || num.length() != 3) {
                    throw new IllegalArgumentException();
                }
                List<Integer> user = getNumList((num));
                int strikes = countStrikes(computer, user);
                int balls = countBalls(computer, user);

                if (balls > 0 && strikes > 0) {
                    System.out.println(balls + "볼 " + strikes + "스트라이크");
                } else if (balls > 0 && strikes == 0) {
                    System.out.println(balls + "볼");
                } else if (balls == 0 && strikes > 0) {
                    System.out.println(strikes + "스트라이크");
                } else if (balls == 0 && strikes == 0){
                    System.out.println("낫싱");
                }
                if (strikes == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {  // 탈출 조건.
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                n = Integer.valueOf(Console.readLine());
                if (n == 2) { // 종료
                    break;
                }
            }
        }
    }

    private static List<Integer> getNumList(String num) {
        List<Integer> result = new ArrayList<>();
        for (char c : num.toCharArray()) {
            result.add(Character.getNumericValue(c));
        }
        return result;
    }

    private static int countStrikes(List<Integer> computer, List<Integer> user) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikes += 1;
            }
        }
        return strikes;
    }

    private static int countBalls(List<Integer> computer, List<Integer> user) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                balls += 1;
            }
        }
        return balls;
    }


}
