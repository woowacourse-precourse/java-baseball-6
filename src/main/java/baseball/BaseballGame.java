package baseball;

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

           ThreeDigits threeDigits = ThreeDigits.toThreeDigits(input);

           if(isCorrect(answer, threeDigits)){
               System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
               break;
           }
       }
   }

   private boolean isCorrect(final ThreeDigits answer, final ThreeDigits threeDigits){
        //* 스트라이크, 볼 등 유무 판정 메서드 개발 예정 */
        return true;
   }

   private void validateInput(final String input) throws RuntimeException{
    if (input.length() != 3) {
        throw new IllegalArgumentException("입력값은 3개의 숫자여야 합니다.");
        // 종료 메서드
    }
   }
}
