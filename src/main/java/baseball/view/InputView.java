package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int INPUT_LENGTH = 3;


    private InputView(){
    }
    public static String readPlayerNumber(){
        System.out.print(INPUT_MESSAGE);

        String input = Console.readLine();

        validation(input);

        return input;
    }
    private static void validation(String input){
        validationLength(input);
        validationNumeric(input);
    }
    private static void validationLength(String input){
        if(input.length() != INPUT_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    private static void validationNumeric(String input){
        for(int i = 0 ; i < input.length() ; i++){
            isNumeric(input.charAt(i));
        }
    }
    private static void isNumeric(char c) {
        if(!Character.isDigit(c)){
            throw new IllegalArgumentException();
        }
    }

}
