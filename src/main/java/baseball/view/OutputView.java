package baseball.view;

import java.util.List;

public class OutputView {
    public static boolean outputResult(List<Integer> numberResult){
        boolean correctAnswer = false;
        boolean nothing = true;
        //System.out.println("낫싱");
        for(int i = 1; i >= 0; i--){
            if(numberResult.get(i).equals(0))
                continue;
            nothing = false;
            if(i == 0){
                System.out.print(numberResult.get(i) + "스트라이크");
                if(checkAnswer(numberResult.get(i)))
                    correctAnswer = true;
            }else if(i==1){
                System.out.print(numberResult.get(i) + "볼 ");
            }
        }
        if(nothing)
            System.out.println("낫싱");
        return correctAnswer;
    }

    public static boolean checkAnswer(Integer strike){
        if(strike.equals(3))
            return true;
        return false;
    }
}
