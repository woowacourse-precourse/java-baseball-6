package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";


    public static void getStartMessage(){
        System.out.println(START_MESSAGE);
    }

    public static int[] userInputNumber(){
        System.out.print(USER_INPUT_MESSAGE);

        try{
            String input = Console.readLine();

            checkInput(input);

            int[] userInput = convertInputFormat(input);

            return userInput;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static int[] convertInputFormat(String input){

        int[] userInput = new int[10];

        for(int i =0 ; i< 3; i++){

            int eachNumber = input.charAt(i)-'0';

            checkInputDuplicate(userInput, eachNumber);

            userInput[eachNumber]++;

        }

        return userInput;

    }

    public static void checkInput(String input){

        checkInputLength(input);

        checkInputNotNumber(input);

    }

    public static void checkInputLength(String input){

        if(input.length() !=3){
            throw new IllegalArgumentException("길이가 너무 짧습니다!");
        }
    }

    public static void checkInputNotNumber(String input){

        for(char eachNumber : input.toCharArray()){
            if(eachNumber < 49) throw new IllegalArgumentException("올바른 숫자가 아닙니다");
            else if(eachNumber>57) throw new IllegalArgumentException("올바른 숫자가 아닙니다");
        }

    }

    public static void checkInputDuplicate(int[] userInput, int eachNumber){

        if(userInput[eachNumber] !=0) throw new IllegalArgumentException("중복된 숫자가 있습니다");


    }
}
