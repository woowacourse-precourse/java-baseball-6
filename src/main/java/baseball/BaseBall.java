package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBall {

    private List<Integer> computer, user;
    private int ball, strike;
    private boolean gameOver;

    public BaseBall() {
        createComputerNumber();
    }

    public boolean start() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();

            isValidNumber(input);
            createUserNumber(input);

            check(); // 결과 계산
            printResult(); // 결과 출력

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                input = readLine();

                if (input.equals("2")) {
                    gameOver = true;
                } else if (input.equals("1")) {
                    gameOver = false;
                } else {
                    throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
                }

                break;
            }
        }
        
        return gameOver;
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

    private void isValidNumber(String s) {
        Set<Integer> hashSet = new HashSet<>();

        if (s.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }

        for (int i = 0; i < 3; i++) {
            int j = s.charAt(i) - '0';

            if (!(j >= 1 && j <= 9)) {
                throw new IllegalArgumentException("1에서 9사이의 숫자만 입력해주세요.");
            }

            if (hashSet.contains(j)) {
                throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해주세요.");
            }

            hashSet.add(j);
        }
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
