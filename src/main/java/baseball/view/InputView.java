package baseball.view;


import baseball.constant.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;

//TODO: 추후삭제

import java.util.Scanner;


public class InputView {
    public int inputPlayerNumber(){
        try{
            //Scanner in = new Scanner(System.in); // Scanner 객체 생성

            //String playerString = in.nextLine();

            String playerString = Console.readLine();

            int playerNumber = Integer.parseInt(playerString);
            return playerNumber;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INTEGER_EXCEPTION_MESSAGE);
        }


    }

    public int inputChoiceNumber(){
        try{
            //Scanner in = new Scanner(System.in); // Scanner 객체 생성

            // String playerString = in.nextLine();
            String playerString = Console.readLine();
            int playerNumber = Integer.parseInt(playerString);

            return this.checkChoiceNumber(playerNumber);


        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INTEGER_EXCEPTION_MESSAGE);
        }


    }

    private int checkChoiceNumber(int inputNumber){
        if(inputNumber!=1&&inputNumber!=2){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CHOICE_NUMBER_EXCEPTION_MESSAGE);
        }

        return inputNumber;
    }


}
