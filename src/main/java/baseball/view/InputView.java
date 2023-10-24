package baseball.view;


import baseball.constant.ChoiceNumberConstant;
import baseball.constant.message.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;

//TODO: 추후삭제


public class InputView {
    public Integer inputPlayerNumber(){
        try{
            //Scanner in = new Scanner(System.in); // Scanner 객체 생성

            //String playerString = in.nextLine();

            String playerString = Console.readLine();

            Integer playerNumber = Integer.valueOf(playerString);
            return playerNumber;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INTEGER_EXCEPTION_MESSAGE);
        }


    }

    public Integer inputChoiceNumber(){
        try{
            //Scanner in = new Scanner(System.in); // Scanner 객체 생성

            // String playerString = in.nextLine();
            String playerString = Console.readLine();
            Integer playerNumber = Integer.valueOf(playerString);

            if(this.checkChoiceNumber(playerNumber)){
                return playerNumber;
            }

            throw new Exception();

        }catch(Exception e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INTEGER_EXCEPTION_MESSAGE);
        }


    }

    private Boolean checkChoiceNumber(Integer inputNumber){
        if(inputNumber!= ChoiceNumberConstant.CONTINUE && inputNumber!=ChoiceNumberConstant.END){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CHOICE_NUMBER_EXCEPTION_MESSAGE);
        }

        return true;
    }


}
