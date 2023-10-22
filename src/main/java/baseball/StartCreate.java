package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class StartCreate {

    /**
     * 컴퓨터 숫자를 생성해주는 메서드 입니다.
     */
    public List<Integer> computerCreate(){

        List<Integer> computer = new ArrayList<>();

        return checkNumber(computer);
    }

    /**
     * 랜덤한 숫자를 하나를 생성 해주는 메서드 입니다.
     */
    public int randomDigit(){

        return Randoms.pickNumberInRange(1,9);
    }

    /**
     * 컴퓨터 숫자에 동일한 숫자가 있는지 확인 해주는 메서드 입니다..
     */
    private List<Integer> checkNumber(List<Integer> computer){

        while (computer.size() < 3){
            int repoDigit = randomDigit();

            if(!computer.contains(repoDigit)){
                computer.add(repoDigit);
            }
        }

        return computer;
    }
}
