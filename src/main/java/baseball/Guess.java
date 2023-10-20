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

    public int add_score(String value){
        if(value =="strike"){
            return this.strike++;
        }
        if(value=="ball"){
            return this.ball++;
        }
        if(value=="nothing"){
            return this.nothing--;
        }
        else{
            throw new IllegalArgumentException("재판정이 필요합니다.");
        }
    }

    public int the_number_of(String value){
        if(value =="nothing"){
            return this.nothing;
        }
        if(value=="strike"){
            return this.strike;
        }
        if(value=="ball"){
            return this.ball;
        }
        else {
            throw new IllegalArgumentException("해당하는 속성이 없습니다.");
        }
    }
}
