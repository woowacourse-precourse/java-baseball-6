package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static List<Integer> getComputerNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static boolean isInpValid(String inp) {
        boolean res = true;

        // 입력 길이가 3이 아닌 경우
        if (inp.length() != 3) {
            res = false;
        } else {
            for (int i = 0; i < 3; i++) {
                // 입력이 숫자가 아닌 경우
                if (Character.getNumericValue(inp.charAt(i)) < 0) {
                    res = false;
                    break;
                }
                // 입력된 숫자가 중복인 경우
                for (int j = 0; j < 3; j++) {
                    int comp_i = Character.getNumericValue(inp.charAt(i));
                    int comp_j = Character.getNumericValue(inp.charAt(j));
                    if (i != j && comp_i == comp_j) {
                        res = false;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static boolean baseballGame(List<Integer> computer, String inp){
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int com_val = computer.get(i);
            int use_val = Character.getNumericValue(inp.charAt(i));
            if (com_val == use_val) {
                strike++;
            } else {
                for (int j = 0; j < 3; j++) {
                    if (i != j && com_val == Character.getNumericValue(inp.charAt(j))) {
                        ball++;
                    }
                }
            }
        }

        if (strike != 3) {
            // 실패
            if (ball == 0 && strike == 0) {
                System.out.printf("낫싱%n", ball);
            } else if (ball > 0 && strike == 0) {
                System.out.printf("%d볼%n", ball);
            } else if (ball == 0 && strike > 0) {
                System.out.printf("%d스트라이크%n", strike);
            } else {
                System.out.printf("%d볼 %d스트라이크%n", ball, strike);
            }
            return false;
        } else {
            // 성공
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = getComputerNum();

        while (true) {
            String inp;
            System.out.print("숫자를 입력해주세요 : ");
            inp = camp.nextstep.edu.missionutils.Console.readLine();

            // 입력 유효 확인
            if (!isInpValid(inp)) {
                throw new IllegalArgumentException();
            }

            // 게임 진행
            if (!baseballGame(computer, inp)) {
                continue;
            }

            // 게임 종료
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            inp = camp.nextstep.edu.missionutils.Console.readLine();

            if (inp.equals("1")) {
                computer = getComputerNum();
                continue;
            } else if (inp.equals("2")) {
                break;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
