package baseball.controller;

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


}
