package baseball.service;

import java.util.ArrayList;
import java.util.List;

import baseball.model.Constant;
import baseball.model.StrikeBallCount;
import baseball.model.ThreeDigits;
import baseball.random.NumberGenerator;
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
        System.out.println(String.format("%c%c%c 정답", answer.getFirst(),answer.getSecond(),answer.getThird()));
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            try {
                    validateInput(input);
                } catch (IllegalArgumentException e) {
                    System.exit(0);
                }

            ThreeDigits inputThreeDigits = ThreeDigits.toThreeDigits(input);
            List<StrikeBallCount> strikeBallCounts = new ArrayList<>();
                for(int i = 0; i<Constant.DIGIT_LENGTH; i++){
                    StrikeBallCount stCntBallCnt = ThreeDigits.compare(i, answer, inputThreeDigits);
                    strikeBallCounts.add(stCntBallCnt);
                }

                int totalStrike = 0;
                int totalBall = 0;
                // stcheck
                for(int i = 0; i<Constant.DIGIT_LENGTH; i++){
                    totalStrike += strikeBallCounts.get(i).getStrikeCount();
                    totalBall+= strikeBallCounts.get(i).getBallCount();
                }

            if (totalStrike == Constant.DIGIT_LENGTH) {
                System.out.println(String.format("%d스트라이크", totalStrike));
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if (totalStrike != Constant.NOT_STRIKE && totalBall == Constant.NOT_BALL) {
                System.out.println(String.format("%d스트라이크", totalStrike));
            } else if (totalStrike == Constant.NOT_STRIKE && totalBall != Constant.NOT_BALL) {
                System.out.println(String.format("%d볼", totalBall));
            } else if (totalStrike != Constant.NOT_STRIKE && totalBall != Constant.NOT_BALL) {
                System.out.println(String.format("%d볼 %d스트라이크", totalBall, totalStrike));
            }else {
                System.out.println("낫싱");
            }
        }
    }

    private void validateInput(final String input) throws RuntimeException{
        if (input.length() != Constant.DIGIT_LENGTH) {
            throw new IllegalArgumentException("입력값은 3개의 숫자여야 합니다.");
            // 종료 메서드
        }
    }
}
