package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int INPUT_LENGTH = 3;
    private static final String SEPARATOR  = "";


    private InputView(){
    }
    public static String[] readPlayerNumber(){
        System.out.print(INPUT_MESSAGE);

        String[] input = Console.readLine().split(SEPARATOR);

        validation(input);

        return  input;
    }
    private static void validation(String[] input){
        validationLength(input);
        validationNumeric(input);
    }
    private static void validationLength(String[] input){
        if(input.length != INPUT_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    private static void validationNumeric(String[] input){
        for(int i = 0 ; i < input.length ; i++){
            isNumeric(input[i]);
        }
    }
    private static void isNumeric(String s) {
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

}
