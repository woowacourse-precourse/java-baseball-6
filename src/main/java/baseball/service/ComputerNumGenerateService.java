package baseball.service;

import baseball.global.config.BaseballGameConstant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumGenerateService {

    public ComputerNumGenerateService(){}

    //컴퓨터의 랜덤 3자리 숫자를 반환한다
    public List<Integer> computerNumberInit(){
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < BaseballGameConstant.BASEBALL_NUM_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

}
