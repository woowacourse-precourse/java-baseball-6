package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static void validate(char[] user) {
        if (user.length == 3) {
            if (user[0] == user[1] || user[0] == user[2] || user[1] == user[2]) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    static int[] compare(List<Integer> com, char[] user) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.getNumericValue(user[i]) == com.get(j) && i == j) {
                    strike++;
                } else if (Character.getNumericValue(user[i]) == com.get(j)) {
                    ball++;
                }
            }
        }
        int[] result = {ball, strike};
        return result;
    }

    static void gameEnd(String answer) {
        if (!Objects.equals(answer, "1") && !Objects.equals(answer, "2")) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> com = generate();
        String ans = "0";
        while (!Objects.equals(ans, "2")) {
            try {
                System.out.println(com);
                System.out.print("숫자를 입력해주세요 : ");
                String num = Console.readLine();
                char[] user = num.toCharArray();
                validate(user);
                int[] res = compare(com, user);
                if (res[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    ans = Console.readLine();
                    gameEnd(ans);
                    if (Objects.equals(ans, "1")) {
                        com = generate();
                    }
                } else if (res[0] == 0 && res[1] == 0) {
                    System.out.println("낫싱");
                } else if (res[0] > 0 && res[1] == 0) {
                    System.out.println(res[0] + "볼");
                } else if (res[1] > 0 && res[0] == 0) {
                    System.out.println(res[1] + "스트라이크");
                } else {
                    System.out.println(res[0] + "볼 " + res[1] + "스트라이크");
                }
            } catch (IllegalArgumentException e) {
                break;
            }
        }
    }
}
