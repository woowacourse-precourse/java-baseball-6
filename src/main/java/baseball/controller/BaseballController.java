package baseball.controller;

import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.ResultView;
import baseball.view.StartView;
import camp.nextstep.edu.missionutils.Randoms;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

public class BaseballController {


    public BaseballController(List<Integer> computer){
        this.computer = computer;

    }
    private List<Integer> computer;


    private BaseballService service = BaseballService.getInstance();

    public void run(){
        InputView.inputNumber(computer);
    }

    public void check(List<Integer> computer,List<Integer> user){
        int[] result = service.check(computer,user);
        ResultView.printResult(result,computer);
    }
    public void restart(int input){
        if(input ==1){
            StartView sv = new StartView();
            sv.start();
        }
        else if(input ==2){

        }


    }
}
