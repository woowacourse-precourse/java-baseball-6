package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerNum; //컴퓨터가 생성한 수를 저장할 배열

    //생성자
    private Computer(){
        computerNum = new ArrayList<>();
    }

    //Computer 객체 생성해서 반환
    public static Computer create(){
        return new Computer();
    }

    //1~9까지 서로 다른 임의의 수 3개를 생성한다.
    public void createRandomNums(){

        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            isDuplication(randomNumber);
        }

    }

    // 중복인 수가 없으면 List에 추가
    private void isDuplication(int randomNumber) {

        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber);
        }

    }

    //computerNum 반환
    public List<Integer> getComputerNum(){
        return computerNum;
    }

}
