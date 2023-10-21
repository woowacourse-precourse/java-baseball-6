package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {
    String inputNumber;

    public User() {
        inputNumber = "";
    }

    public String generateInput() {
        inputNumber = enterNum(); // 숫자 입력
        validation(inputNumber);

        // 검증 파트를 큰 틀을 하나두고, 안에서 다 검증하는 것이 낫냐
        // 아니면, 그냥 하나씩 다 검증하는 것이 낫냐, 고민해보기
        return inputNumber;
    }

    private void validation(String inputNumber) {
        validLength(inputNumber); // 3개만 입력했는가
        validType(inputNumber); // 숫자만 입력했는가
        validRange(inputNumber); // 1~9 사이만 입력했는가
        validDuplication(inputNumber); // 중복된 값을 입력했는가
    }


    private String enterNum() {
        String input = Console.readLine(); // 숫자 입력
        return input;
    }

    private void validLength(String inputNumber) {
        if (inputNumber.length() > 3) {
            throw new IllegalArgumentException("Over the length");
        }
    }

    private void validType(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) { // 숫자만 입력했는지 확인
            int num = inputNumber.charAt(i) -'0';
            if(num > 10 || num < 0){
                throw new IllegalArgumentException("contains non-number");
            }
        }
    }

    private void validRange(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) { // 1~9 사이의 범위만 입력했는지 확인
            if(inputNumber.contains("0")){
                throw new IllegalArgumentException("have to enter only range 1~9");
            }
        }
    }

    private void validDuplication(String inputNumber) { // 들여쓰기 2 초과
        for (int i = 0; i < inputNumber.length()-1; i++) {
            for (int j = i+1; j < inputNumber.length(); j++) {
                if (inputNumber.charAt(i) == inputNumber.charAt(j)) {
                    throw new IllegalArgumentException("have be duplicated number");
                }
            }
        }
    }

    public void reset() {
        inputNumber = "";
    }

}
