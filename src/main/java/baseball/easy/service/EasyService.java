package baseball.easy.service;

import baseball.common.service.CommonNumberService;

public class EasyService extends CommonNumberService {

    private int hintCount = 0;

    //정답 1개 제공하기
    public Integer hintWithPossibleNumber(){
        return super.getComputer().get(hintCount);
    }

    public int getHintCount(){
        return hintCount;
    }

    public void plusHintCount(){
        hintCount++;
    }

    public void resetHintCount(){
        hintCount = 0;
    }
}
