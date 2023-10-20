package baseball;

public class Guess extends Balls{
    int strike, ball, nothing;

    Guess(){
        this.strike=0;
        this.ball=0;
    }

    Guess(String new_balls){
        this.strike=0;
        this.ball=0;
        int locate=0;

        while(locate < new_balls.length()){
            char new_ball = new_balls.charAt(locate);
            this.add_ball(new_ball - '0');
            locate++;
        }
        this.nothing=this.size;
    }

    public int get_ball(int locate){
        return this.balls.get(locate);
    }

    public int get_result(){
        if(nothing==0) {
            System.out.println("낫싱");
            return 0;
        }
        if (ball == 0) {
            System.out.println(strike + "스트라이크");
            if(strike ==3){
                return 3;
            }
            return 0;
        }
        if (strike == 0) {
            System.out.println(ball + "볼");
            return 0;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
        return 0;
    }
}
