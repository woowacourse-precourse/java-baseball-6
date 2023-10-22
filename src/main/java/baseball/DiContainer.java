package baseball;

import java.util.List;

public class DiContainer {

    public ComputerController computerController() {
        return new ComputerController(view(), validation());
    }

    public Validate validation() {
        return new Validation();
    }

    public View view() {
        return new ComputerView();
    }

    public List<Integer> answerList() {
        return new Computer().makeAnswerList();
    }
    
}
