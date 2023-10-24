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

        List<Integer> nums = new ArrayList<>();
        String input = Console.readLine();
        if(input.length()!=3){
            //System.out.println("there must be only 3 numbers");
            throw new IllegalArgumentException("there must be only 3 numbers");
        }

        for(int i=0;i<3;i++){
            int number = input.charAt(i) - '0';
            nums.add(number);
        }

        //System.out.println("player ===  " + nums);

        validateNumber(nums);

        return nums;
    }

    public static void validateNumber(List<Integer> numbers){
        if (numbers.isEmpty()) {
            //System.out.println("numbers cannot be empty.");
            throw new IllegalArgumentException("numbers cannot be empty.");
        }
        if(numbers.size() != numbers.stream().distinct().count()) {
            //System.out.println("numbers shouldn't be same");
            throw new IllegalArgumentException("numbers must not be same");
        }
        if(numbers.contains(0)){
            //System.out.println("number cannot be 0.");
            throw new IllegalArgumentException("input cannot contain 0.");
        }
    }


}
