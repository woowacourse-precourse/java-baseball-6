package baseball;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Referee {

    private Printer pr;
    private int length;
    private List<Integer> answer;

    Referee(int length){
        this.length = length;
        this.pr = new Printer();
    }

    private Referee() {

    }
}
