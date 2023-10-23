package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
//import java.util.Random;


public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        method();
    }

    private static void method() {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);

                System.out.println(randomNumber); // 나중에 지워야 함.
            }
        }
//        // 1에서 9까지 서로 다른 임의의 수 3개
//        List<Integer> list = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < 3; i++) {
//            int number = (random.nextInt(9) + 1);
//            list.add(i, number);
//        }
//        System.out.println(list);
        while (true) {
            System.out.println("숫자를 입력해주세요 :");
            Scanner scanner = new Scanner(System.in);
            String n = scanner.next();
            String[] arr = String.valueOf(n).split("");
            int count = 0;
            int countS = 0;
            int countB = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < computer.size(); j++) {
                    if (arr[i].contains(String.valueOf(computer.get(j)))) {
                        count++;
                        if (i == j) {
                            countS++;
                            break;
                        } else {
                            countB++;
                            break;
                        }
                    }
                }
            }
            if (count == 0) {
                System.out.println("낫싱");
            }
            if (count > 0) {
                if (countB > 0 && countS == 0) {
                    System.out.println(countB + "볼");
                }
                if (countS > 0 && countB == 0) {
                    System.out.println(countS + "스트라이크");
                }
                if (countB > 0 && countS > 0) {
                    System.out.println(countB + "볼 " + countS + "스트라이크");
                }
                if (countS == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    // 게임 재시작
                    Scanner s = new Scanner(System.in);
                    String in = s.next();
                    if (in.equals("1")) {
                        method();
                    }
                    if (in.equals("2")) {
                        return;
                    }
                }
            }
        }
    }
}



