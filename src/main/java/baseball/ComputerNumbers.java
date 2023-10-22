package baseball;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers {

    private List<Integer> computerNumbers = new ArrayList<Integer>();

    public ComputerNumbers(List<Integer> computerNumbers){
        this.computerNumbers = computerNumbers;
    }

    public List<Integer> getList(){
        return this.computerNumbers;
    }

}
