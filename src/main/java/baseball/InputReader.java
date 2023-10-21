package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputReader {
    public List<Integer> readUserGameInput(){
        String input = Console.readLine();

        validateGameInputSize(input);
        validateGameInputType(input);
        validateGameInputDuplicationOfNumber(input);

        return toIntegerList(input);
    }

    public int readUserGameFinishInput(){
        String input = Console.readLine();

        validateGameFinishInputSize(input);
        validateGameFinishInputType(input);

        return toInt(input);
    }

    private int toInt(String input){
        return Integer.parseInt(input);
    }

    private List<Integer> toIntegerList(String input){
        return Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private void validateGameFinishInputSize(String input){
        if (input.length() != 1) throw new IllegalArgumentException("input's size have to be 1");
    }

    private void validateGameFinishInputType(String input){
        if(!input.matches("[1-2]+")) throw new IllegalArgumentException("input have to type only one or two.");
    }

    private void validateGameInputSize(String input){
        if(input.length() != 3) throw new IllegalArgumentException("input's size have to be 3");
    }

    private void validateGameInputType(String input){
        if(!input.matches("[0-9]+")) throw new IllegalArgumentException("input have to type only number.");
    }

    private void validateGameInputDuplicationOfNumber(String input){
        Set<Character> set = new HashSet<>();

        for(char c : input.toCharArray()){
            set.add(c);
        }

        if(set.size() != input.length()) throw new IllegalArgumentException("input can't be typed duplicated number.");
    }
}
