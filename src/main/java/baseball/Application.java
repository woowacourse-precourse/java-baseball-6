package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            playGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        } while (Console.readLine().equals("1"));
    }

    private static void playGame(){
        List<Integer> computer=generateComputerNumbers();

        while (true){
            System.out.print("숫자를 입력해주세요 : ");
            String userInput=Console.readLine();

            if (!isValidInput(userInput)){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            List<Integer> userNumbers=parseUserInput(userInput);
            int strikes=countStrikes(computer,userNumbers);
            int balls=countBalls(computer,userNumbers);

            if (strikes==3){
                System.out.println("3스트라이크\n"
                        + "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            } else if (strikes>0 || balls>0) {
                System.out.println(balls+"볼"+" "+strikes+"스트라이크");
            } else{
                System.out.println("낫싱");
            }
        }
    }


    private static List<Integer> generateComputerNumbers(){
        List<Integer> computer= new ArrayList<>();

        while (computer.size() < 3){
            int randomNumber=Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
            }
        return computer;
        }

    private  static boolean isValidInput(String input){
        if (!input.matches("^[1-9]{3}$")){
            return false;
        }
        char[] inputChars=input.toCharArray();
        for (int i=0;i<3;i++){
            for (int j=i+1; j<3; j++){
                if (inputChars[i]==inputChars[j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static List<Integer> parseUserInput(String input){
        List<Integer> numbers =new ArrayList<>();
        for(int i=0; i<3; i++) {
            numbers.add(Integer.parseInt(input.substring(i,i+1)));
        }
        return numbers;
    }
    private static int countStrikes(List<Integer> computer, List<Integer> user){
        int strikes=0;
        for (int i=0; i<3; i++){
            if(computer.get(i).equals(user.get(i))){
                strikes++;
            }
        }
        return strikes;
    }
    private static int countBalls(List<Integer> computer, List<Integer> user){
        int balls=0;
        for(int i=0; i<3;i++){
            if (!computer.get(i).equals(user.get(i))&&computer.contains(user.get(i))){
                balls++;
            }
        }
        return balls;
    }
}
