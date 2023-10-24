package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean quit = true;
        while (quit) {
            List<Integer> computer = randomNumberGen();
            while (true) {
                List<Integer> user = scanUserInput(sc);
                String result = chk(computer, user);
                System.out.println(result);
                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    quit = quit(sc);
                    break;
                }
            }
        }
        sc.close();
    }

    public static List<Integer> randomNumberGen() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) computer.add(randomNum);
        }
        return computer;
    }

    public static List<Integer> scanUserInput(Scanner sc) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = sc.next();
        String[] tempInput = input.split("");
        if (tempInput.length != 3) {
            throw new IllegalArgumentException();
        }
        List<Integer> returnVal = Arrays.stream(tempInput).map(Integer::parseInt).toList();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < returnVal.size(); i++) {
            if (returnVal.get(i) < 1 || returnVal.get(i) > 9) {
                throw new IllegalArgumentException();
            }
            if (!set.contains(returnVal.get(i))) {
                set.add(returnVal.get(i));
            } else {
                throw new IllegalArgumentException();
            }
        }
        return returnVal;
    }

    public static String chk(List<Integer> computer, List<Integer> user) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i) == user.get(i)) {
                strike += 1;
            } else if (computer.contains(user.get(i))) {
                ball += 1;
            }
        }
        String result = "";

        if (strike != 0) {
            if (ball != 0) {
                result += ball + "볼 " + strike + "스트라이크";
            } else {
                result += strike + "스트라이크";
            }
        } else if (ball != 0) {
            result += ball + "볼";
        } else {
            result += "낫싱";
        }

        return result;
    }

    public static boolean quit(Scanner sc) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String answer = sc.next();
        if (answer.equals("1")) {
            return true;
        } else if (answer.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
