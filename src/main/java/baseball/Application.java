package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    // 숫자 여부를 확인하는 메서드
    public static boolean isNum(String str) {
        try {
            return str.matches("-?\\d+(\\.\\d+)?"); // 정규 표현식을 사용하여 숫자 여부 확인
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while (true) {
            Scanner s = new Scanner(System.in);

            try {
                // 게임 시작 문구 출력
                System.out.println("숫자 야구 게임을 시작합니다.");

                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }

                while (true) {
                    System.out.println("숫자를 입력해주세요. : ");

                    String n = s.next();

                    if (!isNum(n)) {
                        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
                    }

                    int strike = 0; // 스트라이크 횟수
                    int ball = 0; // 볼 횟수

                    List<Integer> user = new ArrayList<>();
                    user.add(n.charAt(0) - '0'); // 사용자가 입력한 첫 번째 수
                    user.add(n.charAt(1) - '0'); // 사용자가 입력한 두 번째 수
                    user.add(n.charAt(2) - '0'); // 사용자가 입력한 세 번째 수

                    for (int i = 0; i < computer.size(); i++) {
                        if (computer.contains(user.get(i))) {
                            if (Objects.equals(computer.get(i), user.get(i))) {
                                strike++;
                            } else {
                                ball++;
                            }
                        }
                    }

                    // 3개의 숫자를 모두 맞힐 경우
                    if (strike == 3) break;

                    // 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
                    StringBuilder sb = new StringBuilder();

                    if (ball != 0) {
                        sb.append(ball);
                        sb.append("볼 ");
                    }

                    if (strike != 0) {
                        sb.append(strike);
                        sb.append("스트라이크");
                    }

                    // 하나도 없는 경우
                    if (ball == 0 && strike == 0) {
                        sb.append("낫싱");
                    }
                    System.out.println(sb);
                }
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                try {
                    int menu = s.nextInt();

                    if(menu == 1) {
                    } else if (menu == 2) {
                        return;
                    } else {
                        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("잘못된 값을 입력했습니다.");
                    return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 값을 입력했습니다.");
                return;
            }
        }
    }
}
