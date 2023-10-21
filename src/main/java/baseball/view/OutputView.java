package baseball.view;

import java.util.List;

public class OutputView {
    private static final int STRIKE = 0;
    private static final int BALL = 1;
    private static final int WIN_STRIKES = 3;

    public static boolean outputResult(List<Integer> numberResult){
        // TODO : 리팩토링
        boolean correctAnswer = false;
        boolean nothing = true;
        for(int i = 1; i >= 0; i--){
            if(numberResult.get(i).equals(0))
                continue;
            nothing = false;
            if(i == STRIKE){
                System.out.print(numberResult.get(i) + "스트라이크");
                if(checkAnswer(numberResult.get(i))) {
                    correctAnswer = true;
                    System.out.println();
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                }
            }else if(i==BALL){
                System.out.print(numberResult.get(i) + "볼 ");
            }
        }
        if(nothing)
            System.out.println("낫싱");
        return correctAnswer;
    }

    public static boolean checkAnswer(Integer strike){
        if(strike.equals(WIN_STRIKES))
            return true;
        return false;
    }
}
