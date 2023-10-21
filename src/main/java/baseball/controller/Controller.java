package baseball.controller;

import baseball.entity.Score;
import baseball.service.Service;

import java.util.List;

public class Controller {

    private final Service service = new Service();

    public List<Integer> makeNumber(){
        return service.makeNumber();
    }

    public List<Integer> getNumber(){
        return service.readNumber();
    }

    public boolean countScore(List<Integer> computer, List<Integer> user, Score score, boolean quit){
        return service.countScore(computer, user, score, quit);
    }


}
