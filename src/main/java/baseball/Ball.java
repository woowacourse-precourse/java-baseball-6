package baseball;

public class Ball {
    public static final int MIN = 1;
    public static final int MAX = 9;
     private final Integer number;

     public Ball(Integer number){
         this.number = Validator.validateBallNumber(number);
     }

     @Override
    public boolean equals(Object obj){
         Ball ball;
         if(obj instanceof Ball){
             ball = (Ball)obj;
         }
         else {
             throw new RuntimeException("비교하는 대상의 객체가 다릅니다.");
         }
         return ball.number.equals(this.number);
     }
}
