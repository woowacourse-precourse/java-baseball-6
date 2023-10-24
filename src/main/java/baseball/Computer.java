package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static List<Integer> computerNumbers;

    public Computer() {
        computerNumbers = new ArrayList<>();
        generateNumbers();
    }

    private void generateNumbers() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        System.out.println(computerNumbers);  // 리스트 출력. 필요에 따라 삭제 가능
    }

    public static List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
