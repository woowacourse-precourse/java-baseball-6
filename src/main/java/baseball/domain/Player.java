package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> number;

    public void callNumber(String number){
        this.number = new ArrayList<>();

        for(int i=0; i<number.length(); i++){
            int numEach = Character.getNumericValue(number.charAt(i));
            this.number.add(numEach);
        }
    }

    public List<Integer> getNumber(){
        return this.number;
    }
}
