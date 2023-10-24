package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {
    private static final int MAX_SIZE = 3;
    private static final int START = 1;
    private static final int END = 9;

    private String generatedNumber;
    public NumberGenerator() {
        generatedNumber = setNumber();
    }

    public String getGeneratedNumber() {
        return generatedNumber;
    }

    private String setNumber() {
        StringBuilder generatedNumber = new StringBuilder();
        List<Integer> computer = Randoms.pickUniqueNumbersInRange(START, END, MAX_SIZE);
        for(int element : computer) {
            generatedNumber.append(element);
        }

        return generatedNumber.toString();
    }




}
