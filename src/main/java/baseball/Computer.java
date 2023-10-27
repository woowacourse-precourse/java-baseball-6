package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Computer {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    private int[] computerNumbers;

    public Computer() { //컴퓨터 숫자 초기화
        this.computerNumbers = new int[3];
        setComputerNumbers();
    }
    public int[] getComputerNumbers() {
        return this.computerNumbers;
    }

    private void setComputerNumbers() {
            HashSet<Integer> numbers = new LinkedHashSet<>();
            while (numbers.size() < 3) {
                int num = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
                System.out.println(num);
                numbers.add(num);
            }

            this.computerNumbers = numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}
