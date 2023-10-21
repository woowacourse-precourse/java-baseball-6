package baseball.domain;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ClientNumbers implements Numbers {

    private final List<Integer> numbers;

    public ClientNumbers() {
        numbers = new ArrayList<>(SIZE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Info compareWithComputerNumbers(ComputerNumbers computerNumbers) {
        Info info = new Info();

        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {

                int cl = numbers.get(i);
                int co = computerNumbers.getNumbers().get(j);

                if(cl == co && i != j) {
                    info.ball++;
                }
                if(cl == co && i == j) {
                    info.strike++;
                }
            }
        }

        if(info.strike == 3) {
            info.ongoing = false;
        }

        return info;
    }
}
