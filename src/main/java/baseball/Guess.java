package baseball;

public class Guess extends Balls{
    int strike, ball, nothing;

    Guess(){
        this.strike=0;
        this.ball=0;
    }

    public void add_ball(String new_balls){
        int locate=0;

        while(locate < this.size){
            char new_ball = new_balls.charAt(locate);
            add_ball(new_ball - '0');
            locate++;
        }
        this.nothing=this.size;
    }
}
