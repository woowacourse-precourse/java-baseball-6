package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import java.util.ArrayList;
import java.util.List;
public class ComputerNumber {
    private String computerNum;
    public ComputerNumber(){
        setNumber();
    }
    public String getComputerNumber(){
        return computerNum;
    }
    public void setNumber() {

        List<String> computerNumber = new ArrayList<>();
        while (computerNumber.size()<3) {
            String num = Integer.toString(pickNumberInRange(1, 9));
            if(!computerNumber.contains(num)){
                computerNumber.add(num);
            }
        }
        this.computerNum = String.join("",computerNumber);
    }
}
