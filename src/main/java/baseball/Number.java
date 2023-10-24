package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.NavigableMap;

public class Number {

    private static final int NUM_COUNT=3;
    private final int NUM_START=1;
    private final int NUM_END=9;
    int[] randomNumber;

    public Number(){
    }

    static int[] stringToIntArray(String string){
        int[] array=new int[3];
        for(int i=0;i<3;i++){
            array[i]=string.charAt(i)-'0';
        }
        return array;
    }

    public static boolean checkLength(String input){
        return input.length() == NUM_COUNT;
    }

    public static boolean checkDigit(String input){
        for(int i=0;i<NUM_COUNT;i++) {
            if(!Character.isDigit(input.charAt(i)) || input.charAt(i)=='0'){
                return false;
            }
        }
        return true;
    }

    public static boolean checkUnique(String input){
        if(input.charAt(0)==input.charAt(1)){
            return false;
        }
        if(input.charAt(1)==input.charAt(2)){
            return false;
        }
        if(input.charAt(2)==input.charAt(0)){
            return false;
        }
        return true;
    }

    public static void isValid(String input){
        if(!checkLength(input)){
            throw new IllegalArgumentException();
        }
        if(!checkDigit(input)){
            throw new IllegalArgumentException();
        }
        if(!checkUnique(input)){
            throw new IllegalArgumentException();
        }
    }

    public static int[] getUserInput(){
        String string=Console.readLine();
        isValid(string);
        return stringToIntArray(string);
    }

    public int[] makeComputerAnswer(){
        randomNumber=new int[NUM_COUNT];

        int index=0;
        while(index<NUM_COUNT){
            int number=Randoms.pickNumberInRange(NUM_START,NUM_END);
            if(isUnique(randomNumber,number)){
                randomNumber[index]=number;
                index++;
            }
        }
        return randomNumber;
    }

    boolean isUnique(int[] randomNumber, int number){
        for(int i=0;i<NUM_COUNT;i++){
            if(randomNumber[i]==number){
                return false;
            }
        }
        return true;
    }
}