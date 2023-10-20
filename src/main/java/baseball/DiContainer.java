package baseball;

import java.util.List;

public class DiContainer {

    public ComputerController ComputerController() {
        return new ComputerController(View(), Validation());
    }

    public Validate Validation() {
        return new ComputerValidation(AnswerList());
    }

    public View View() {
        return new ComputerView();
    }

    public List<Integer> AnswerList() {
        return new Computer().makeAnswerList();
    }


}
