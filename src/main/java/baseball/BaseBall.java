package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBall {

    private List<Integer> computer, user;
    private int ball, strike;

    public boolean start() {
        init();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = readLine();
            if (!isValidNumber(input)) {
                try {
                    throwInputError();
                } catch (IllegalArgumentException e) {
                    return false;
                }
            }
            createUserNumber(input);

            check();
        }
    }

    private void init() {
        computer = new ArrayList<>(3);
        user = new ArrayList<>(3);

        createComputerNumber();
    }

    private void createComputerNumber() {
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
        for (int i = 0; i < 3; i++) {
            user.add(input.charAt(i) - '0');
        }
    }

    private boolean isValidNumber(String s) {
        if (s.length() != 3) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            int j = s.charAt(i) - '0';

            if (!(j >= 1 && j <= 9)) {
                return false;
            }
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
            // ball
            if (idx != i) {
                ball++;
            }
            // strike
            else {
                strike++;
            }
        }
    }

    private void throwInputError() {
        throw new IllegalArgumentException();
    }
}
