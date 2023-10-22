package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final NumberGenerator numberGenerator;
   
   public BaseballGame(final NumberGenerator numberGenerator){
       this.numberGenerator = numberGenerator;
   }

   private ThreeDigits generateAnswer(){
        return ThreeDigits.generateAnswerThreeDigits(
            numberGenerator.generate(),
            numberGenerator.generate(),
            numberGenerator.generate()
        );    
   }

   public void start(){
       ThreeDigits answer = generateAnswer();

       while(true){
           String input = Console.readLine();

           //분리 예정
           try {
            validateInput(input);
            } catch (IllegalArgumentException e) {
                System.exit(1);
            }

           ThreeDigits inputThreeDigits = ThreeDigits.toThreeDigits(input);
           compareControl(answer, inputThreeDigits);
       }
   }

   private void compareControl(final ThreeDigits answer, final ThreeDigits threeDigits){
    List<StrikeBallCount> strikeBallCounts = new ArrayList<>();
    for(int i = 0; i<Constant.DIGIT_LENGTH; i++){
        StrikeBallCount stCntBallCnt = ThreeDigits.compare(i, answer, threeDigits);
        strikeBallCounts.add(stCntBallCnt);
    }

    int totalStrike = 0;
    int totalBall = 0;
    // stcheck
    for(int i = 0; i<Constant.DIGIT_LENGTH; i++){
        totalStrike += strikeBallCounts.get(i).getStrikeCount();
        totalBall+= strikeBallCounts.get(i).getBallCount();
    }

    printResultAndCheckGameEnd(totalStrike, totalBall);
   }

   private void printResultAndCheckGameEnd(int totalStrike, int totalBalls) {
    if (isGameEnd(totalStrike)) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    } else if (isNothing(totalStrike, totalBalls)) {
        System.out.println("낫싱");
    } else {
        System.out.println(String.format("%d볼 %d스트라이크", totalBalls, totalStrike));
        }
    }

    private boolean isGameEnd(int strikes) {
        return strikes == Constant.DIGIT_LENGTH;
    }

    private boolean isNothing(int strikes, int balls) {
        return strikes == Constant.NOT_STRIKE && balls == Constant.NOT_BALL;
    }

   private void validateInput(final String input) throws RuntimeException{
    if (input.length() != Constant.DIGIT_LENGTH) {
        throw new IllegalArgumentException("입력값은 3개의 숫자여야 합니다.");
        // 종료 메서드
        }
    }
}
