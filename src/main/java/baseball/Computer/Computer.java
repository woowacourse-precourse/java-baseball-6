package baseball.Computer;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<String> RandomNumber = new ArrayList<>();
    String computer;

    // 컴퓨터가 3자리 숫자를 랜덤으로 생성하는 메서드
    public String CreateNumber() {
        while (RandomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            CheckRepeatNumber(randomNumber);
        }
        //ListToString(RandomNumber);
        computer = String.join("", RandomNumber);
        return computer;
    }

    // 숫자중에 중복이 없으면 add 하는 메서드
    public void CheckRepeatNumber(Integer randomNumber) {
        String randomNumberString = Integer.toString(randomNumber);
        if(!RandomNumber.contains(randomNumberString)) {
            RandomNumber.add(randomNumberString);
        }
    }

}
