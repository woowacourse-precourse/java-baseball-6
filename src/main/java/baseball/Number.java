package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Number {

    private final int NUM_COUNT=3;
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

    public static int[] getUserInput(){
        String string=Console.readLine();
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
