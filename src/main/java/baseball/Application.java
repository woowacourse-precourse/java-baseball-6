package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Game {

    Game() {
        System.out.println();
    }

    private static boolean isDistinct(String x){
        int []check = new int[10];
        for(int i=0; i < 3; i++){
            int k = check[x.charAt(i)-'0'];
            if(k > 0)
        }
    }
    private static int genearteRandomNumber() {

        return 1;
    }

    static void start() {
        while (true) {
            play(getRandomNumber());
        }
    }

}


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game play = new Game();
        Game.start();
        int a = Game.getRandomNumber();
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            String b = "";
            StringBuffer sb = new StringBuffer();
            boolean[] vis = new boolean[10];
            while (true) {
                int rand = Randoms.pickNumberInRange(1, 9);
                if (vis[rand]) {
                    continue;
                }
                sb.append(rand);
                if (sb.length() == 3) {
                    break;
                }
                vis[rand] = true;
            }
            b = sb.toString();
            while (true) {

                String a = Console.readLine();

                boolean flag = false;
                if (a.length() != 3) {
                    flag = true;
                }
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) < '1' || a.charAt(i) > '9') {
                        flag = true;
                    }
                }
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == j) {
                            continue;
                        }
                        if (a.charAt(i) == a.charAt(j)) {
                            flag = true;
                        }
                    }
                }
                if (flag) {
                    throw new IllegalArgumentException("올바른 수를 입력해 주세요");
                }

                int strike = 0;
                int ball = 0;
                for (int i = 0; i < 3; i++) {
                    if (a.charAt(i) == b.charAt(i)) {
                        strike++;
                    }
                }

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == j) {
                            continue;
                        }
                        if (a.charAt(i) == b.charAt(j)) {
                            ball++;
                        }
                    }
                }

                if (ball > 0) {
                    System.out.printf(ball + "볼");
                    if (strike > 0) {
                        System.out.print(" ");
                    } else {
                        System.out.println();
                    }
                }
                if (strike > 0) {
                    System.out.println(strike + "스트라이크");
                }
                if (ball == 0 && strike == 0) {
                    System.out.println("낫싱");
                }
                if (strike == 3) {
                    break;
                }

            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String e = Console.readLine();
            if (e.equals("1")) {
                continue;
            }
            if (e.equals("2")) {
                break;
            }
            throw new IllegalArgumentException("올바른 수를 입력해 주세요");
        }
    }
}
