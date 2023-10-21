package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerRandomNumberGenerator implements RandomNumberGenerator<List<Integer>, ComputerRandomNumber> {
    @Override
    public ComputerRandomNumber generate(final Integer randomNumberSize) {
        final List<Integer> computer = new ArrayList<>();
        while(computer.size() < randomNumberSize){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return new ComputerRandomNumber(computer);
    }

    @Override
    public Boolean match(final List<Integer> input, final ComputerRandomNumber generatedNumber) {
        final BaseBallScore baseBallScore = calculateBaseBallScore(generatedNumber, input);
        System.out.println(baseBallScore);
        return baseBallScore.verifyingWinGame();
    }

    private BaseBallScore calculateBaseBallScore(final ComputerRandomNumber randomNumber, final List<Integer> input) {
        final BaseBallScore baseBallScore = new BaseBallScore(randomNumber.size());
        for(int i=0;i<input.size();i++){
            final Integer findNumberIndex = randomNumber.indexOf(input.get(i));
            if(findNumberIndex.equals(ComputerRandomNumber.NOT_FOUND)){
                baseBallScore.increaseNothing();
            }else{
                if(findNumberIndex==i) baseBallScore.increaseStrike();
                else baseBallScore.increaseBall();
            }
        }
        return baseBallScore;
    }
}
