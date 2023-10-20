package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class ComputerNumber {

    private String computerNumber;

    public ComputerNumber() {
        SetNumber();
    }

    public void SetNumber(){
        Set number = new HashSet();
        while (number.size() < 3){
            number.add(String.valueOf(Randoms.pickNumberInRange(1,9)));
        }
        this.computerNumber = String.join("", number);
    }

    public String getComputerNumber(){
        return computerNumber;
    }
}