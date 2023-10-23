package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseballGame {
    private static final int INPUT_NUMBERS_SIZE = 3;
    String inputNumbers;
    int strike;
    int ball;
    List<Integer> computer;


    public void start(){
        computer = createComputerNumbers();
        while (true){
            inputNumbersAndValidate();
            compareNumbers();
            if(ball < 1 && strike < 1){
                System.out.println("낫싱");
                continue;
            }
            if(ball>0 && strike<1){
                System.out.println(ball + "볼");
                continue;
            }
            if(ball<1 && strike >0){
                System.out.println(strike + "스트라이크");
                if(strike == 3){
                    System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
                    System.out.println("게임 종료");
                    if(end() == 2){
                        break;
                    }
                }
                continue;
            }
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public int end(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String end = readLine();
        switch(end){
            case "1":
                computer.clear();
                computer = createComputerNumbers();
                return 1;
            case "2":
                return 2;
            default:return 1;
        }
    }

    public void compareNumbers(){
        ball = 0;
        strike = 0;

        ballCount(inputNumbers);
        strikeCount(inputNumbers);
    }

    public void ballCount(String numbers){

        for(String num : numbers.split("")){
            if(computer.contains(Integer.parseInt(num))){
                ball++;
            }
        }

    }

    public void strikeCount(String numbers){

        for(int i=0;i<INPUT_NUMBERS_SIZE;i++){
            if(computer.get(i).equals(Integer.parseInt(numbers.split("")[i]))){
                strike++;
                ball--;
            }
        }
    }

    public void inputNumbersAndValidate(){
        // check point
        // null인지, size가 3인지, 숫자인지, 서로다른 숫자인지, 1~9까지의 숫자인지
        System.out.print("숫자를 입력해주세요 : ");
        String temp = readLine();
        validateSize(temp);
        validateIsDigit(temp);
        validateDuplicate(temp);
        validateRange(temp);
        this.inputNumbers = temp;
    }

    public void validateSize(String numbers){
        // 사이즈예외처리 + null 처리
        if(numbers.length() != INPUT_NUMBERS_SIZE){
            throw new IllegalArgumentException("숫자 3개만 입력 가능합니다.");
        }
    }

    public void validateIsDigit(String numbers){
        //숫자외 입력 예외처리
        for(char num : numbers.toCharArray()){
            if(!Character.isDigit(num)){
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }

    public void validateDuplicate(String numbers){
        //중복예외처리
        Set<Integer> numSet = new HashSet<>();

        for(String num : numbers.split("")){
            numSet.add(Integer.parseInt(num));
        }
        if(numSet.size() != INPUT_NUMBERS_SIZE){
            throw new IllegalArgumentException("서로다른 숫자만 입력 가능합니다.");
        }
    }

    public void validateRange(String numbers){
        // 1~9까지의 숫자가 아니면 예외처리
        // 0일때 예외처리
        for(String num : numbers.split("")){
            if(Integer.parseInt(num)<1){
                throw new IllegalArgumentException("1이상 9이하의 숫자만 입력 가능합니다.");
            }
        }
    }

    public List<Integer> createComputerNumbers(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
