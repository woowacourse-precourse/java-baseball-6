package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBall {

    private List<Integer> computer, user;
    private int ball, strike;

    public boolean start() {
        createComputerNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = readLine();
            if (!isValidNumber(input)) {
                throw new IllegalArgumentException();
            }

            createUserNumber(input);

            check(); // 결과 계산
            printResult(); // 결과 출력

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                input = readLine();

                if (input.equals("2")) {
                    return true;
                } else if (!input.equals("1")) {
                    throw new IllegalArgumentException();
                }

                createComputerNumber();
            }
        }
    }

    private void createComputerNumber() {
        computer = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();

        while (hashSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            hashSet.add(randomNumber);
        }

        Iterator<Integer> iterator = hashSet.iterator();
        for (int i = 0; i < 3; i++) {
            computer.add(iterator.next());
        }
    }

    private void createUserNumber(String input) {
        user = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            user.add(input.charAt(i) - '0');
        }
    }

    private boolean isValidNumber(String s) {
        Set<Integer> hashSet = new HashSet<>();

        if (s.length() != 3) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            int j = s.charAt(i) - '0';

            if (!(j >= 1 && j <= 9)) {
                return false;
            }

            if (hashSet.contains(j)) {
                return false;
            }

            hashSet.add(j);
        }

        return true;
    }

    private void check() {
        ball = strike = 0;

        for (int i = 0; i < 3; i++) {
            int n = user.get(i);

            // out
            if (!computer.contains(n)) {
                continue;
            }

            int idx = computer.indexOf(n);
            if (idx != i) {
                ball++;
            } else {
                strike++;
            }
        }
    }

    private void printResult() {
        StringBuilder sb = new StringBuilder();

        if (ball > 0 && strike > 0) {
            sb.append(ball).append("볼").append(' ').append(strike).append("스트라이크");
        } else if (ball > 0) {
            sb.append(ball).append("볼");
        } else if (strike > 0) {
            sb.append(strike).append("스트라이크");
        } else {
            sb.append("낫싱");
        }

        System.out.println(sb);
    }
}
