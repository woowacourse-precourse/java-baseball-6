package baseball.model;

import java.util.List;

public class ComputerNumberDto {
    private List<Integer> computerNumber;
    public ComputerNumberDto(){};

    public List<Integer> getComputerNumber(){
        return this.computerNumber;
    }

    public void setComputerNumber(List<Integer> computerNumber){
        this.computerNumber = computerNumber;
    }
}
