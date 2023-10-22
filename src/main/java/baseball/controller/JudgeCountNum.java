package baseball.controller;

import baseball.model.CountNum;
import baseball.model.TargetNum;
import baseball.model.UserNum;

public interface JudgeCountNum {

    CountNum getJudgeCountNum(UserNum userNum, TargetNum targetNum);
}
