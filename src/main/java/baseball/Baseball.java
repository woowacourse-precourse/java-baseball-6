package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Baseball {
    private List<Integer> target = new ArrayList<>();
    private List<Integer> userInput;

    private List<Integer> result = new ArrayList<>(Arrays.asList(0, 0));

    public void play(){
        initGame();
        while(result.get(0) != 3) {
            inputNumber();
            result = referee();
            printResult();
        }
    }

    private void inputNumber() throws IllegalArgumentException{
        System.out.print(Messages.USER_INPUT_NUMBER);
        try {
            String inputString = Console.readLine();
            List<Integer> converted = convert(inputString);

            //유효성 검사
            //1. 문자 포함 여부 체크
            for(Integer i : converted){
                if(i < 1 || i > 9)
                    throw new IllegalArgumentException(Messages.INVALID_NUMBER_FORMAT);
            }
            //2. 자릿수 체크
            if(converted.size() != 3)
                throw new IllegalArgumentException(Messages.NOT_THREE_DIGIT);
            //3. 중복 체크
            Map<Integer, Integer> check = new HashMap<>();
            for(Integer i : converted){
                if(check.containsKey(i))
                    throw new IllegalArgumentException(Messages.INVALID_NUMBER_INPUT);
                check.put(i, 1);
            }
            userInput = converted;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(Messages.INVALID_NUMBER_FORMAT);
        }
    }

    private boolean isValidNumber(int number){
        if(number < 123 || number > 987)
            return false;

        int num100 = number / 100;
        int num10 = number / 10 % 10;
        int num1 = number % 10;

        return num100 != num10 && num100 != num1 && num10 != num1;
    }

    private void initGame(){
        while(target.size() < 3){
            int rand = Randoms.pickNumberInRange(1, 9);
            if(!target.contains(rand))
                target.add(rand);
        }
    }

    private List<Integer> referee(){
        int strike = 0, ball = 0;

        if(userInput.get(0) == target.get(0)) strike++;
        else if (userInput.get(0) == target.get(1) || userInput.get(0) == target.get(2)) ball++;

        if(userInput.get(1) == target.get(1)) strike++;
        else if (userInput.get(1) == target.get(0) || userInput.get(1) == target.get(2)) ball++;

        if(userInput.get(2) == target.get(2)) strike++;
        else if (userInput.get(2) == target.get(1) || userInput.get(2) == target.get(0)) ball++;

        return Arrays.asList(strike, ball);
    }

    private void printResult(){
        if(result.get(0) == 3)
            System.out.println(Messages.SUCCESS);
        else if (result.get(0) + result.get(1) == 0)
            System.out.println(Messages.FAIL);
        else
            System.out.println(Messages.STRIKE_AND_BALL(result));
    }

    private List<Integer> convert(String str){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            list.add(str.charAt(i) - '0');
        }
        return list;
    }
}
