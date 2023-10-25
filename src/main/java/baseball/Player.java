package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> selectedNums = new ArrayList<>();

    public Player(){
        this.selectedNums = getNumber();
    }

    public List<Integer> getSelectedNums() {
        return selectedNums;
    }

    public List<Integer> getNumber(){
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        validateInput(input);

        List<Integer> nums = stringToIntList(input);
        validateNumber(nums);

        return nums;
    }

    public List<Integer> stringToIntList(String str){
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<3;i++){
            int number = str.charAt(i) - '0';
            result.add(number);
        }

        return result;
    }

    public static void validateInput(String str){
        if(str.isEmpty()){
            throw new IllegalArgumentException("numbers cannot be empty.");
        }
        if(str.length()!=3){
            throw new IllegalArgumentException("there must be only 3 numbers.");
        }
    }

    public static void validateNumber(List<Integer> numbers){
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("numbers must not be same.");
        }
        if(numbers.contains(0)){
            throw new IllegalArgumentException("input cannot contain 0.");
        }
    }

}
