package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    List<Integer> balls = new ArrayList<>();
    int size;
    int limit_size;

    Balls(){
        this.limit_size=3;
    }

    public void add_ball(int new_ball){
        if(!balls.contains(new_ball)){
            this.balls.add(new_ball);
            this.size = this.balls.size();
        }
    }

    public void remove_balls(){
        while(balls.size()>0){
            balls.remove(balls.size()-1);
        }
        this.size=0;
    }
// get_index 로 대체 가능할 듯
//    public boolean is_contain(Integer ball){
//        if(balls.contains(ball)){
//            return true;
//        } else return false;
//    }

    public int get_index(int target){
        if(balls.contains(target)){
            return balls.indexOf(target);
        } else return -1;
    }
}
