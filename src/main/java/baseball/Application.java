package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        List<Integer> user = new ArrayList<>();

        // 게임 시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 사용자 입력
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String line = Console.readLine();

            // 예외처리 1. 길이
            if (line.length() != 3) {
                throw new IllegalArgumentException("Length Problem");
            }
            int ball = 0;
            int strike = 0;

            for (int i = 0; i < 3; i++){
                char ch = line.charAt(i);
                int userNumber = (int) ch - 48;

                // 에외처리 2. 범위
                if (userNumber > 9 || userNumber < 0) {
                    throw new IllegalArgumentException("OutOfRange");
                }
                System.out.println("userNumber : " + userNumber);

                if (!user.contains(userNumber)) {
                    user.add(userNumber);
                } else {
                    // 예외처리 3. 중복
                    throw new IllegalArgumentException("Duplicate");
                }
            }

            System.out.println(user);

            for (int i = 0; i < 3; i++) {
                int user_num = user.get(i);
                int com_num = computer.get(i);

                // 1. ball count
                if (computer.contains(user_num)) {
                    ball++;
                }

                // 2. strike count
                if (user_num == com_num) {
                    ball--;
                    strike++;
                }
            }

            if (strike == 3) {
                // 게임 종료
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String s = Console.readLine();
                if (s.equals("2")) {
                    break;
                } else if (s.equals("1")) {
                    computer.clear();
                    while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                    }
                } else throw new IllegalArgumentException();

            } else if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else {
                String out = "";
                if (ball > 0) {
                    out += ball + "볼";
                }
                if (strike > 0) {
                    if (out.length() == 0) {
                        out += strike + "스트라이크";
                    } else {
                        out += " " + strike + "스트라이크";
                    }
                }
                System.out.println(out);
            }
            // 재입력을 위한 리스트 초기화
            user.clear();
        }
    }
}
