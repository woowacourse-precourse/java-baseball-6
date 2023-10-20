package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true){
            displayGameStartMessage();
            List<Integer> computer = generateComputerRandomThreeDigitNumber();

            while(true){
                List<Integer> userNumber = getUserGuessThreeDigitNumber();
                if(evaluateGuessAndCheckForGameEnd(computer,userNumber)){//3스트라이크인 경우,
                    break;
                }
            }
            if(restartOrExit()==false){//종료
                break;
            }
        }

    }

    public static void displayGameStartMessage()  {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> generateComputerRandomThreeDigitNumber(){

        List<Integer> computer = new ArrayList<>();
        while(computer.size() <3 ){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> getUserGuessThreeDigitNumber(){

        List<Integer> user = new ArrayList<>();
        String userThreeNumbers = Console.readLine();
        validateUserThreeNumbers(userThreeNumbers);
        for(int i=0;i<userThreeNumbers.length();i++){
            user.add(userThreeNumbers.charAt(i)-'0');
        }
        return user;
    }

    public static boolean evaluateGuessAndCheckForGameEnd(List<Integer> user,List<Integer> computer){

        int strike=0;
        int ball =0;
        for(int i=0;i<3;i++){
            if(user.get(i)==computer.get(i)){
                strike++;
            }
            else if(user.get(i)!=computer.get(i) && computer.contains(user.get(i))){
                ball++;
            }
        }


        if(ball ==0 &&strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다.! 게임 종료");
            return true;
        }
        else if(ball>0 && strike >0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }  else if (ball == 0 && strike > 0 &&strike <3) {
            System.out.println(strike+"스트라이크");
        }else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }

        return false;
    }

    public static boolean restartOrExit(){//반환값이 1이면 restart
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int input = Integer.parseInt(Console.readLine());
        return input == 1 ? true: false;
    }

    public static void validateUserThreeNumbers(String userThreeNumbers){
        List<Integer> user = new ArrayList<>();

        if(userThreeNumbers.length()!=3)//3개 미만, 또는 초과해서 입력된 경우에 대한 예외처리
            throw new IllegalArgumentException("3개의 수를 입력하지 않았습니다.");

        for(int i=0;i<userThreeNumbers.length();i++){
            char char_num = userThreeNumbers.charAt(i);

            if(user.contains(char_num-'0'))//중복 된 값에 대한 예외처리
                throw new IllegalArgumentException("중복된 수를 입력하였습니다.");
            if(char_num<'1' || char_num>'9'){//1~9가 아닌 값에 대한 예외처리
                throw new IllegalArgumentException("1~9사이 수가 아닌 값을 입력하였습니다.");
            }
            user.add(char_num-'0');
        }
    }
}
