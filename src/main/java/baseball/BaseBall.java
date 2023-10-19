package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBall {

    private int[] computer, user;

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
        }
    }

    private void init() {
        computer = new int[3];
        user = new int[3];

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
            computer[i] = iterator.next();
        }
    }

    private void createUserNumber(String input) {
        for (int i = 0; i < 3; i++) {
            user[i] = input.charAt(i) - '0';
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

    private void throwInputError() {
        throw new IllegalArgumentException();
    }
}
