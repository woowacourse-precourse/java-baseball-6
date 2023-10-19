package baseball.controller;

import baseball.domain.Computer;
import baseball.service.BaseballService;

import java.util.List;

public class BaseballController {
    static BaseballService baseballService;



    private static void run(){
        start();
    }
    private static void start(){
        Computer computer = new Computer(createRandomNumber());
    }

    //컴퓨터가 생각하고 있는 3개의 수 생성
    private static List<Integer> createRandomNumber() {
        return baseballService.createRandomNumber();
    }
}
