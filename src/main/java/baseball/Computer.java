package baseball;

import camp.nextstep.edu.missionutils.Randoms;


public class Computer {
    private String randomNumber;
    private int size;

    Computer() {
        randomNumber = "";
        size = 0;
    }

    public String generate() {

        while (size < 3) {
            String number = createOne(); // 숫자 하나 생성

            boolean check = checkDuplication(randomNumber, number); // 중복체크
            if (!check) {
                randomNumber += number; // 중복이 아니므로 이어 붙이기
                addSize();
            }
        }
        return randomNumber;
    }

    private String createOne() {
        return String.valueOf(Randoms.pickNumberInRange(1, 9)); // 1~9 사이의 번호 하나 생성
    }

    private boolean checkDuplication(String number, String num) { // 중복 체크
        if(number.contains(num)) return true;
        return false;
    }

    private void addSize() { // 사이즈 증가
        size++;
    }

    public void reset() { // 초기화
        randomNumber = "";
        size = 0;
    }

}