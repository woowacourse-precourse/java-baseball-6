package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberControl {
    private String computerNumber;
    private String playerNumber;
    ArrayList<String> ClearNumberList = new ArrayList<>();

    public void generateComputerNumber() { //컴퓨터 난수 생성
        ClearNumberList.clear();
        String randomNumber;
        while (ClearNumberList.size() < 3) {
            randomNumber = Integer.toString(Randoms.pickNumberInRange(1, 9));
            if (ClearNumberList.contains(randomNumber)) {
                continue;
            }
            ClearNumberList.add(randomNumber);
        }
        this.computerNumber = String.join("", ClearNumberList);

    }

    public String getComputerNumber() {
        generateComputerNumber();
        return this.computerNumber;
    }

    public void getNumberAfterFinish() {
        int setNumberCheck = Integer.parseInt(Console.readLine());
        isCorrectRetryNumber(setNumberCheck);
        Application.setNumber = setNumberCheck;

    }

    public void isCorrectRetryNumber(int number) throws IllegalArgumentException {
        if (number != 1 && number != 2) {
            throw new IllegalArgumentException("1과 2 이외의 값을 입력했습니다.");
        }
    }

    public void checkPlayerNumber(String userNumber) {
        isWrongLength(userNumber);
        isSameNumber(userNumber);
        isNotDigitNumber(userNumber);
        playerNumber = userNumber;
    }

    public String getPlayerNumber(String userNumber) {
        checkPlayerNumber(userNumber);
        return playerNumber;
    }

    public void isWrongLength(String userNumber) throws IllegalArgumentException {
        if (userNumber.length() != 3) {
            throw new IllegalArgumentException("입력하는 숫자는 3자리여야 합니다.");
        }
    }

    public void isNotDigitNumber(String userNumber) throws IllegalArgumentException {
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(userNumber.charAt(i))) {
                throw new IllegalArgumentException("자연수가 아닙니다.");
            }
        }
    }

    public void isSameNumber(String userNumber) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(userNumber.charAt(i));
        }
        if (set.size() != userNumber.length()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }


}
