package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUserNumber {
    private List<Integer> user;

    private InputUserNumber(List<Integer> user){
        this.user = user;
    }

    public static InputUserNumber inputUSerNumber(){
        String inputNumber = Console.readLine();

        isNumber(inputNumber);
        checkLength(inputNumber);
        List<Integer> number = stringToList(inputNumber);
        isOK(number);

        return new InputUserNumber(number);
    }

    public static void isNumber(String inputNumber){
        try{
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public static void checkLength(String inputNumber){
        if(inputNumber.length() != 3){
            throw new IllegalArgumentException();
        }

    }

    public static List<Integer> stringToList(String inputNumber){
        List<Integer> number = new ArrayList<>();

        for(int i=0;i<3;i++){
            number.add(inputNumber.charAt(i) - '0');
        }
        return number;
    }

    public static void isOK(List<Integer> number){
        if(number.contains(0))
            throw new IllegalArgumentException();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(number.get(i) == number.get(j) && i != j)
                    throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getUser(){
        return user;
    }

}
