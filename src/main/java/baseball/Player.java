package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private String input;

//    Player() {
//        input = Console.readLine();
//    }

//    public void setInput() {
//        inputBeforeValidation = Console.readLine();
//
//        input = validateInput(inputBeforeValidation);
//    }

    public void setThreeNumbersInput() throws IllegalArgumentException {
        int inputToInteger = Integer.parseInt(Console.readLine()); // 변환 실패 시 NumberFormatException 예외 던짐. IllegalArgumentException의 조상 클래스

        if (!(111 <= inputToInteger && inputToInteger <= 999)) {
            throw new IllegalArgumentException();
        }

        if (!(validateUniqueness(inputToInteger))) {
            throw new IllegalArgumentException();
        }

        input = inputToInteger + "";
    }

    private boolean validateUniqueness(int num) {
        char[] numToCharArr = (num+"").toCharArray();

        for (int i=0; i<numToCharArr.length; i++) {
            for (int j=i+1; j<numToCharArr.length; j++) {
                if (numToCharArr[i] == numToCharArr[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setGameRestartInput() throws IllegalArgumentException {
        int inputToInteger = Integer.parseInt(Console.readLine()); // 변환 실패 시 NumberFormatException 예외 던짐. IllegalArgumentException의 조상 클래스

        if (!(inputToInteger == 1 || inputToInteger == 2)) {
            throw new IllegalArgumentException();
        }

        input = inputToInteger + "";
    }

//    private String validateInput(String inputBeforeValidation) throws IllegalArgumentException {
//        int inputBeforeValidationToInteger = Integer.parseInt(inputBeforeValidation);
//
//        if (!(inputBeforeValidationToInteger == 1 || inputBeforeValidationToInteger == 2 || (111 <= inputBeforeValidationToInteger && inputBeforeValidationToInteger <= 999))) {
//            throws new IllegalArgumentException();
//        }
//    }

    public String getInput() {
        return input;
    }
}
