package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.model.Constant;
import baseball.model.StrikeBallCount;
import baseball.model.ThreeDigits;
import baseball.model.random.NumberGenerator;
import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final NumberGenerator numberGenerator;
   
    public BaseballGame(final NumberGenerator numberGenerator){
        this.numberGenerator = numberGenerator;
    }

    private ThreeDigits generateAnswer(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = numberGenerator.generate();
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return ThreeDigits.generateAnswerThreeDigits(
            computer.get(0),
            computer.get(1),
            computer.get(2)
        );    
    }

    public void start(){
        ThreeDigits answer = generateAnswer();
        boolean isGameEnd = false;
        while(!isGameEnd){
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            InputValidator.validateThreeDigitsInput(input);
            
            ThreeDigits inputThreeDigits = ThreeDigits.toThreeDigits(input);
            StrikeBallCount strikeBallCount = calculateStrikeBallCount(answer, inputThreeDigits);

            isGameEnd = checkEnd(strikeBallCount);
        }
    }

    private boolean checkEnd(final StrikeBallCount strikeBallCount){
        int totalStrike = strikeBallCount.getStrikeCount();
        int totalBall = strikeBallCount.getBallCount();

        if (totalStrike == Constant.DIGIT_LENGTH) {
                System.out.println(String.format("%d스트라이크", totalStrike));
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            } else if (totalStrike != Constant.NOT_STRIKE && totalBall == Constant.NOT_BALL) {
                System.out.println(String.format("%d스트라이크", totalStrike));
            } else if (totalStrike == Constant.NOT_STRIKE && totalBall != Constant.NOT_BALL) {
                System.out.println(String.format("%d볼", totalBall));
            } else if (totalStrike != Constant.NOT_STRIKE && totalBall != Constant.NOT_BALL) {
                System.out.println(String.format("%d볼 %d스트라이크", totalBall, totalStrike));
            }else {
                System.out.println("낫싱");
            }
        return false;
    }

    private StrikeBallCount calculateStrikeBallCount(final ThreeDigits answer, final ThreeDigits inputThreeDigits){
        int totalStrike = 0;
        int totalBall = 0;

        for(int i = 0; i<Constant.DIGIT_LENGTH; i++){
            StrikeBallCount stCntBallCnt = ThreeDigits.compare(i, answer, inputThreeDigits);
            totalStrike += stCntBallCnt.getStrikeCount();
            totalBall += stCntBallCnt.getBallCount();
        }

        return new StrikeBallCount(totalStrike, totalBall);
    }
}
