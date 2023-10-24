package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다");
        int cmd;
        List<Integer> computer;
        Scanner sc = new Scanner(System.in);
        do {
            computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            String input;
            int b, s;
            while(true) {
                System.out.print("숫자를 입력해주세요 : ");
                input = sc.next();
                System.out.println(input);

                if(input.length() != 3) {
                    throw new IllegalArgumentException();
                }

                b = 0; s = 0;
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        if(input.charAt(i) - '0' == computer.get(j)) {
                            if(i == j) s++;
                            else b++;
                            break;
                        }
                    }
                }

                if(s == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                if(b == 0 && s == 0) System.out.println("낫싱");
                else System.out.println(b+"볼 "+s+"스트라이크");
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            cmd = sc.nextInt();
            if(cmd == 2) break;
            if(cmd != 1) {
                throw new IllegalArgumentException();
            }
            sc.nextLine();
        }while(true);
    }
}
