package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {

    // 숫자 여부를 확인하는 유틸리티 메서드
    public static boolean isNum(String str) {
        try {
            return str.matches("-?\\d+(\\.\\d+)?"); // 정규 표현식을 사용하여 숫자 여부 확인
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while(true) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            System.out.println(computer);


            while(true) {
                try {
                    System.out.println("숫자 야구 게임을 시작합니다.");
                    System.out.println("숫자를 입력해주세요. : ");


                    Scanner s = new Scanner(System.in);
                    String n = s.next();

                    if (!isNum(n)) {
                        throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
                    }

                    int strike = 0; // 스트라이크 횟수
                    int ball = 0;


                    List<Integer> user = new ArrayList<>();
                    user.add(n.charAt(0) - '0'); // 사용자가 입력한 첫 번째 수
                    user.add(n.charAt(1) - '0'); // 사용자가 입력한 두 번째 수
                    user.add(n.charAt(2) - '0'); // 사용자가 입력한 세 번째 수

                    System.out.println(user);


                    for (int i = 0; i < computer.size(); i++) {
                        if (computer.contains(user.get(i))) {
                            if (computer.get(i) == user.get(i)) {
                                strike++;
                            } else {
                                ball++;
                            }
                        }
                    }


                    if (strike == 3) break;


                    StringBuilder sb = new StringBuilder();


                    if (ball != 0) {
                        sb.append(ball);
                        sb.append("볼 ");
                    }

                    if (strike != 0) {
                        sb.append(strike);
                        sb.append("스트라이크");
                    }

                    if (ball == 0 && strike == 0) {
                        sb.append("낫싱");
                    }

                    System.out.println(sb.toString());


//            Scanner s = new Scanner(System.in);

                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int menu = s.nextInt();

                    if (menu == 1) {
                    } else if (menu == 2) {
                        return;

                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 숫자를 입력해주세요.");
                    return;
                }
            }
        }


    }
}
