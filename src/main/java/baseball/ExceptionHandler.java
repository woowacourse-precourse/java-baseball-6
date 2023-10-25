package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ExceptionHandler {

    private final static ExceptionHandler Instance = new ExceptionHandler();
    private ExceptionHandler() {

    }

    public static ExceptionHandler getInstance() {
        return Instance;
    }

    public void userInputLengthValidation(String input) {

        if(input.length() != 3) throw new IllegalArgumentException();


    }

    public void userInputValidation(List<Integer> inputList) {

        for(int i=0; i<inputList.size(); i++) {
            int idx = inputList.get(i);
            for(int j=0; j<inputList.size(); j++) {
                if(i == j) continue;

                if (idx == inputList.get(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }



    }

    public void afterValidation(String input) {

        if(input.length() != 1) throw new IllegalArgumentException();

        if((input.charAt(0) - '0') != 1 || (input.charAt(0) - '0') != 2) throw new IllegalArgumentException();



    }

}
