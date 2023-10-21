package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class ComputerNumber {

    private String computerNumber;

    public ComputerNumber() {
        SetComputerNumber();
    }

    public void SetComputerNumber(){
        this.computerNumber = String.join("", generateNumber());
    }

    public Set<String> generateNumber(){
        Set<String> number = new HashSet<String>();
        while (number.size() < 3){
            number.add(String.valueOf(Randoms.pickNumberInRange(1,9)));
        }
        return number;
    }

    public String getComputerNumber(){
        return computerNumber;
    }
}