package baseball;

public class Guess extends Balls {
    int strike, ball, nothing;

    Guess(String new_balls) {
        this.strike = 0;
        this.ball = 0;
        int locate = 0;

        while (locate < new_balls.length()) {
            char new_ball = new_balls.charAt(locate);
            this.add_ball(new_ball - '0');
            locate++;
        }
        this.nothing = this.size;
    }

    public int get_ball(int locate) {
        return this.balls.get(locate);
    }

    public int add_strike() {
        return this.strike++;
    }

    public int add_ball() {
        return this.ball++;
    }

    public int there_noting() {
        return this.nothing--;
    }

    public boolean is_nothing(){
        if(this.nothing==0){
            return true;
        } else return false;
    }

    public boolean is_zero_ball(){
        if(this.ball==0){
            return true;
        }else return false;
    }

    public boolean is_zero_strike(){
        if(this.strike==0){
            return true;
        }else return false;
    }
}
