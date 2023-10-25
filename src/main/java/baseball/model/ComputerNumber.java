package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// 일급 컬렉션
public class ComputerNumber {
    private final List<Integer> computerNumber = new ArrayList<>();

    public ComputerNumber() {
        while (computerNumber.size() < 3) {
            generateRandomNumber(computerNumber);
        }
    }

    public ComputerNumber(String strComputer) {
        for (int i = 0; i < strComputer.length(); i++) {
            char c = strComputer.charAt(i);
            addDigit(c);
        }
    }

    private void addDigit(char c) {
        if (Character.isDigit(c)) {
            int digit = Character.getNumericValue(c);
            computerNumber.add(digit);
        }
    }

    // 컴퓨터 번호를 랜덤으로 생성해주는 함수
    private void generateRandomNumber(List<Integer> computerNumber) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    // 컴퓨터 번호를 반환해주는 함수
    public List<Integer> getComputerNumber() {
        return this.computerNumber;
    }
}
