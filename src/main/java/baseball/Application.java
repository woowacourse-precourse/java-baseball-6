package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final int NUM_DIGITS = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true){
            playGame();
            if(shouldRestartGame()==false){//종료
                break;
            }
        }

    }

    private static void playGame() {
        displayGameStartMessage();
        List<Integer> computer = generateComputerRandomThreeDigitNumber();

        while(true){
            List<Integer> userNumber = getUserGuessThreeDigitNumber();
            if(checkForGameEnd(computer,userNumber)){//3스트라이크인 경우,
                break;
            }
        }
    }

    public static void displayGameStartMessage()  {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static List<Integer> generateComputerRandomThreeDigitNumber(){

        List<Integer> computer = new ArrayList<>();
        while(computer.size() <NUM_DIGITS ){
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
        for(char c: userThreeNumbers.toCharArray()){
            user.add(Character.getNumericValue(c));
        }
        return user;
    }

    public static boolean checkForGameEnd(List<Integer> user,List<Integer> computer){//1이면, 게임 종료하기 위한 단계로 간다.

        int numStrikes=0;
        int numBalls =0;
        for(int i=0;i<NUM_DIGITS;i++){
            if(user.get(i)==computer.get(i)){
                numStrikes++;
            } else if(user.get(i)!=computer.get(i) && computer.contains(user.get(i))){
                numBalls++;
            }
        }

        return evaluateGuess(numStrikes,numBalls);
    }

    public static boolean shouldRestartGame(){//반환값이 1이면 restart
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        return validateRestartOrExitChoice(choice);
    }

    public static void validateUserThreeNumbers(String userThreeNumbers){
        List<Integer> user = new ArrayList<>();

        if(userThreeNumbers.length()!=NUM_DIGITS)//3개 미만, 또는 초과해서 입력된 경우에 대한 예외처리
            throw new IllegalArgumentException("3개의 수를 입력하지 않았습니다.");

        for(int i=0;i<NUM_DIGITS;i++){
            char char_num = userThreeNumbers.charAt(i);

            if(user.contains(char_num-'0'))//중복 된 값에 대한 예외처리
                throw new IllegalArgumentException("중복된 수를 입력하였습니다.");
            if(char_num<'1' || char_num>'9'){//1~9가 아닌 값에 대한 예외처리
                throw new IllegalArgumentException("1~9사이 수가 아닌 값을 입력하였습니다.");
            }
            user.add(char_num-'0');
        }
    }

    public static boolean validateRestartOrExitChoice(String choice){//재시작, 종료 외의 예외처리

        if(choice.equals("1"))
            return true;
        else if(choice.equals("2"))
            return false;
        throw new IllegalArgumentException("1 또는 2를 입력하지 않았습니다.");
    }

    private static boolean evaluateGuess(int numStrikes,int numBalls){

        String message = "";
        if(numStrikes == NUM_DIGITS){
            message = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다.! 게임 종료";
        }
        if(numBalls>0){
            message = numBalls+"볼";
        }
        if(numStrikes>0 && numStrikes <NUM_DIGITS){
            message = (message.isEmpty() ? "" : message + " ") +numStrikes+"스트라이크";
        }
        if (message.isEmpty()) {
            message="낫싱";
        }
        System.out.println(message);
        return numStrikes ==NUM_DIGITS;
    }

}
