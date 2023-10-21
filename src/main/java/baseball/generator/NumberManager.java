package baseball.generator;

import baseball.BaseBallNumberCollection;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberManager implements RandomNumberGenerator<BaseBallNumberCollection>, NumberMatcher<BaseBallNumberCollection>{
    @Override
    public BaseBallNumberCollection generate(final Integer randomNumberSize) {
        final List<Integer> computer = new ArrayList<>();
        while(computer.size() < randomNumberSize){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return new BaseBallNumberCollection(computer);
    }

    @Override
    public Boolean match(final BaseBallNumberCollection matchingTargetNumber,
                         final BaseBallNumberCollection generatedNumber) {
        final BaseBallScore baseBallScore = calculateBaseBallScore(matchingTargetNumber,generatedNumber);
        System.out.println(baseBallScore);
        return baseBallScore.verifyingWinGame();
    }

    private BaseBallScore calculateBaseBallScore(final BaseBallNumberCollection matchingTargetNumber,
                                                 final BaseBallNumberCollection randomNumber) {
        final BaseBallScore baseBallScore = new BaseBallScore(randomNumber.size());
        for(int i=0;i<matchingTargetNumber.size();i++){
            final Integer findNumberIndex = randomNumber.indexOf(matchingTargetNumber.get(i));
            if(findNumberIndex.equals(BaseBallNumberCollection.NOT_FOUND)){
                baseBallScore.increaseNothing();
            }else{
                if(findNumberIndex==i) baseBallScore.increaseStrike();
                else baseBallScore.increaseBall();
            }
        }
        return baseBallScore;
    }
}
