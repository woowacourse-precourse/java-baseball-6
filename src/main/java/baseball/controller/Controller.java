package baseball.controller;

import baseball.view.View;
import baseball.model.Model;

import java.util.List;

public class Controller {
    public Controller(){
        View view = new View();
        Model model = new Model();

        boolean finish = false;

        while (finish == false) {
            List<Integer> randomList = model.getRandomList(3);
            boolean isCorrect = false;

            view.printStart();

            while(isCorrect == false) {
                String stringOfNum = view.getStringOfNum();
                isCorrect = model.printAndGetResult(stringOfNum, randomList);
            }

            finish = view.getBooleanOfFinish();
        }
    }
}
