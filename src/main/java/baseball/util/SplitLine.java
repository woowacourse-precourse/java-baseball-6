package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class SplitLine {
    public List<Integer> splitLine(String line) {
        List<Integer> splitLine = new ArrayList<>();

        for (int l = 0; l < line.length(); l++) {
            splitLine.add(Integer.parseInt(String.valueOf(line.charAt(l))));
        }

        return splitLine;
    }
}
