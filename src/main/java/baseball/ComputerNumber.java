package baseball;
/*
    클래스 명 : ComputerNumber
    설명      : 컴퓨터가 사용할 랜덤 수를 생성
    작성자	  : 김준태
	날짜	  : 2023. 10. 23.
 */
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    public List<Integer> randomNumber() {
        List<Integer> computerNumberList = new ArrayList<>();
        //랜덤한 난수 3개를 생성하여 리스트에 담음
        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
        return computerNumberList;
    }
}
