package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {
    public List<Integer> createNewNumber()//컴퓨터 숫자 생성기
    {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {  // 컴퓨터의 숫자 선택
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}