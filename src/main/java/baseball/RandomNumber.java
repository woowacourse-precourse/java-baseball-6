package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    public List<Integer> mainMakeRnadomNumber(){ //컴퓨터 랜덤 숫자 생성
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) { //총 3개 숫자 생성
            int randomNumber = Randoms.pickNumberInRange(1, 9); //범위는 1~9까지
            if (!computer.contains(randomNumber)) { //중복방지를 위해 들어가있지 않은 값을 넣음
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}