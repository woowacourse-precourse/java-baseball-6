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

}
