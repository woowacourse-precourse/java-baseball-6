package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Application{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            List<Integer> computer = generateComputerNumber();
            boolean gameOver=false;

            while(!gameOver){
                List<Integer> userGuess=getUserGuess(scanner);
                List<String> result=calculateResult(computer, userGuess);
                printResult(result);

                if(result.size()==1 && result.get(0).equals("3스트라이크")){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameOver=true;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice= scanner.nextLine();
            if("2".equals(choice)){
                break;
            }

        }

    }
    private static List<Integer> generateComputerNumber(){
        List<Integer> computer=new ArrayList<>();
        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserGuess(Scanner scanner){
        System.out.print("숫자를 입력해주세요 : ");
        String input = scanner.nextLine();
        if(input.length()!=3 || !input.matches("\\d{3}")){
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
        List<Integer> userGuess=new ArrayList<>();
        for(char digit:input.toCharArray()){
            int number=Character.getNumericValue(digit);
            if(number<1||number>9||userGuess.contains(number)){
                throw new IllegalArgumentException("1에서 9사이의 서로 다른 숫자만 입력해야 합니다.");
            }
            userGuess.add(number);
        }
        return userGuess;
    }

    private static List<String> calculateResult(List<Integer> computer,List<Integer> userGuess){
        List<String> result=new ArrayList<>();
        int strikes=0;
        int balls=0;

        for(int i=0;i<3;i++){
            if(computer.get(i).equals(userGuess.get(i))){
                strikes++;
            } else if(computer.contains(userGuess.get(i))){
                balls++;
            }
        }

        if(strikes==0 && balls==0){
            result.add("낫싱");
        }
        else if(strikes==0){
            result.add(balls+"볼");
        }
        else if(balls==0){
            result.add(strikes+"스트라이크");
        }
        else {
            result.add(balls+"볼 "+strikes+"스트라이크");
        }
        return result;
    }

    private static void printResult(List<String> result){
        for(String s: result){
            System.out.println(s+" ");
        }
        System.out.println();
    }
}