package baseball;
import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    private Numbers computerNumbers;
    public Numbers initComputerNumbers(){
        computerNumbers = new Numbers();
        return computerNumbers;
    }
    public Judgement getJudgement(Numbers userNumbers){
        return new Judgement(userNumbers, computerNumbers);
    }
}
