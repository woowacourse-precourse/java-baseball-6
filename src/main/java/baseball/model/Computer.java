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

}
