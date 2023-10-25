package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserNumber {
    private List<Integer> numberList;
    private static int size;

    public UserNumber(){
        numberList = new ArrayList<>();
        size = 3;
    }

    public void setNumberList() {
        System.out.print("숫자를 입력해주세요 : ");
        String[] input;
        try{
            input = readLine().split("");
            if(input.length!=size) {
                throw new IllegalArgumentException();
            }
            for(int i=0; i<size; i++) {
                int newInput = Integer.parseInt(input[i]);
                if(numberList.contains(newInput) || newInput==0)
                    throw new IllegalArgumentException();
                numberList.add(Integer.parseInt(input[i]));
            }

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }

    public static void setSize(int newSize) {
        size = newSize;
    }
    public List<Integer> getNumberList(){
        return numberList;
    }
}
