package baseball;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    //컴퓨터의 랜덤 3자리 숫자 생성 함수
    public static ArrayList<Integer> generateRandomNumber(){
        ArrayList<Integer> computerList = new ArrayList<>();
        while (computerList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerList.contains(randomNumber)) {
                computerList.add(randomNumber);
            }
        }
        return computerList;
    }
}
