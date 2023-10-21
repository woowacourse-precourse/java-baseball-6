package utility;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private Input(){}
    public static List<Integer> sliceToThree(final int[] input, final int count) throws IllegalArgumentException{
        List<Integer> chunk = new ArrayList<>();
        int currentNumber = 0;
        if(input.length % 3 != 0)
            throw new IllegalArgumentException();
        for(int index = count*3; index < count*3+3; index++){
            currentNumber = input[index];
            chunk.add(currentNumber);
        }
        return chunk;
    }
}
