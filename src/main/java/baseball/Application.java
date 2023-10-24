package baseball;

import camp.nextstep.edu.missionutils.*;

public class Application {
    static int[] randNum = new int[3];
    static int[] userNum = new int[3];
    static int strike = 0;
    static int ball = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            randNum[0] = Randoms.pickNumberInRange(1, 9);
            randNum[1] = Randoms.pickNumberInRange(1, 9);
            randNum[2] = Randoms.pickNumberInRange(1, 9);

            while((randNum[0] == randNum[1]) || (randNum[1] == randNum[2]) || (randNum[0] == randNum[2])) {
                randNum[1] = Randoms.pickNumberInRange(1, 9);
                randNum[2] = Randoms.pickNumberInRange(1, 9);
            }

            while(true) {
                System.out.print("숫자를 입력해주세요 : "); // "345"
                String[] str = Console.readLine().split("");

                if(str.length != 3) {
                    System.out.println("Wrong Input");
                    throw new IllegalArgumentException();
                }

                for(int i = 0; i < 3; i++) {
                    userNum[i] = Integer.parseInt(str[i]);
                }

                if((userNum[0] == 0) || (userNum[1] == 0) || (userNum[2] == 0)) {
                    throw new IllegalArgumentException();
                }

                if((userNum[0] == userNum[1]) || (userNum[1] == userNum[2]) || (userNum[0] == userNum[2])) {
                    throw new IllegalArgumentException();
                }

                strike = 0;
                ball = 0;

                for(int i = 0; i < 3; i++) {
                    if(randNum[i] == userNum[i]) {
                        strike++;
                    }
                }

                if(randNum[0] == userNum[1] || randNum[0] == userNum[2]) { ball++; }
                if(randNum[1] == userNum[0] || randNum[1] == userNum[2]) { ball++; }
                if(randNum[2] == userNum[0] || randNum[2] == userNum[1]) { ball++; }

                if(strike == 0 && ball == 0) {
                    System.out.print("낫싱");
                }
                else {
                    if (ball > 0) {
                        System.out.print(ball + "볼 ");
                    }
                    if (strike > 0) {
                        System.out.print(strike + "스트라이크");
                    }
                }
                System.out.println();

                if(strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String s = Console.readLine();
            if(s.equals("1")) {
                continue;
            }
            else if(s.equals("2")) {
                System.out.println("게임을 완전히 종료합니다.");
                break;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
    }
}
