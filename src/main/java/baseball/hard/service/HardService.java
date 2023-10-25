package baseball.hard.service;

import baseball.common.service.CommonNumberService;

public class HardService extends CommonNumberService {

    private static final int COUNT_LIMIT = 7;
    private static final int TIME_LIMIT = 10*1000;
    private long inputStartTime;

    //카운트 제한을 넘었는지 체크
    public boolean isCountOver(int count){
        return count > COUNT_LIMIT;
    }
    //timeover 체크
    public boolean isTimeOver(long time){
        return time - inputStartTime <= TIME_LIMIT;
    }

    public void setInputStartTime(long inputStartTime){this.inputStartTime = inputStartTime;}


    //카운트 캡슐화
    public int getCountLimit(){return COUNT_LIMIT;}

    public int getTimeLimit(){return TIME_LIMIT;}
}
