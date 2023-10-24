package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        int opt;
        String randomNumber;

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {

            boolean checkAgain = false;

            randomNumber = generateRandomNumber();
            System.out.println(randomNumber);

            while(!checkAgain){

                System.out.println("숫자를 입력해주세요 : ");
                String inputNumber = Console.readLine();
                checkValidInputNumber(inputNumber);

                checkAgain = checkResult(randomNumber, inputNumber);
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            opt = Integer.parseInt(Console.readLine());
            checkValidOption(opt);

        } while (opt == 1);

    }

    //주요 로직
    private static boolean checkResult(String correctNumber,String inputNumber){

        int countOfBall = 0;
        int countOfStrike = 0;

        for (int i = 0; i < 3; i++) {
            if(correctNumber.charAt(i)==inputNumber.charAt(i)){
                countOfStrike += 1;
            }
            else{
                if(inputNumber.contains(Character.toString(correctNumber.charAt(i)))){
                    countOfBall += 1;
                }
            }
        }
        if (countOfBall == 0 && countOfStrike == 0) {
            System.out.print("낫싱");
        }
        if(countOfBall!=0){
            System.out.print(countOfBall + "볼 ");
        }
        if(countOfStrike!=0){
            System.out.print(countOfStrike + "스트라이크");
        }
        System.out.println();
        if(countOfStrike==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static void checkValidInputNumber(String input){

        Set<Character> inputSet = new HashSet<>();
        for(int i =0;i<input.length();i++){
            inputSet.add(input.charAt(i));
        }

        // 숫자로 바꿀 수 있는 문자열인지 확인
        if(!isInteger(input)){
            throw new IllegalArgumentException();
        }

        // 세자리 숫자인지 확인
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        //0이 포함되는지 확인
        if(input.contains("0")){
            throw new IllegalArgumentException();
        }

        //서로다른 숫자인지 확인
        if(inputSet.size()!=input.length()){
            throw new IllegalArgumentException();
        }
    }

    private static String generateRandomNumber(){

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer.toString().replaceAll("[^0-9]","");
    }

    private static void checkValidOption(int option){
        if(option!=1 && option!=2){
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInteger(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

}
