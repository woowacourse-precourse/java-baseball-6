package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
            boolean playAgain = true;
            while (playAgain) {
                    try{
                            playGame();
                            // 기능8. 게임 종료 후에는 재시작 할 것인지 종료할 것인지 1 또는 2를 입력하게 하여 선택하게 함
                            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
                            String choice = Console.readLine();
                            if (!choice.equals("1")) {
                                    if (choice.equals("2")){
                                            System.out.println("게임 종료!");
                                            return;
                                    }
                            }
                    } catch(IllegalArgumentException e){
                            throw e;
                    }
            }
    }
    public static void playGame(){
            // 기능1. 컴퓨터가 1~9까지 서로 다른 임의의 수 3개를 선택하도록 함
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                    }
                }
            // 기능2. 게임 플레이어가 서로 다른 3개의 숫자를 입력하게 함
            System.out.println("숫자 야구 게임을 시작합니다.");
            boolean condition = true;
            while(condition) {
                    System.out.print("숫자를 입력해주세요 : ");
                    String input = Console.readLine();
                    
                    // 기능3. 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킴
                    if (input.length() != 3 || !input.matches("\\d+")) {
                            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
                    }
                    
                    int number = Integer.parseInt(input);
                    int unitDigit = number % 10; // 일의 자리 숫자
                    int tensDigit = (number / 10) % 10; // 십의 자리 숫자
                    int hundredsDigit = (number / 100) % 10; // 백의 자리 숫자

                    int ball = 0;
                    int strike = 0;
                    // 기능4. 같은 수가 같은 자리에 있으면 스트라이크를 출력하게 함
                    if(computer.get(0) == hundredsDigit){
                            strike += 1;
                    } if(computer.get(1) == tensDigit){
                            strike += 1;
                    } if(computer.get(2) == unitDigit){
                            strike += 1;
                    }
                    // 기능5. 같은 수가 다른 자리에 있으면 볼을 출력하게 함
                    if(computer.get(0) == unitDigit || computer.get(0) == tensDigit){
                            ball += 1;
                    } if(computer.get(1) == unitDigit || computer.get(1) == hundredsDigit){
                            ball += 1;
                    } if(computer.get(2) == tensDigit || computer.get(2) == hundredsDigit){
                            ball += 1;
                    }
                    
                    if(ball != 0 && strike != 0){
                            System.out.println(ball + "볼 " + strike + "스트라이크");
                    }
                    else if(ball != 0 && strike == 0){
                            System.out.println(ball + "볼");
                    }
                    else if(ball == 0 && strike != 0){
                            System.out.println(strike + "스트라이크");
                            // 기능7. 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임을 종료함
                            if(strike == 3){
                                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                                    condition = false;
                            }
                    }
                    // 기능6. 같은 수가 전혀 없으면 낫싱을 출력하게 함
                    else{
                            System.out.println("낫싱");
                    }

                    // 기능3. 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킴
                    if (unitDigit == tensDigit || tensDigit == hundredsDigit || hundredsDigit == unitDigit) {
                            throw new IllegalArgumentException();
                    }
            }   
    }
}
