package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Application application = new Application();
        List<Integer> comNumber = application.makeThreeNum();

        System.out.println("숫자 야구 게임을 시작합니다.");
        String onlyNumber = "^[0-9]+$";
        loop : while (true) {
            System.out.print("숫자를 입력해주세요 :");
            String userInput = Console.readLine();

            if(userInput.length() != 3 || !userInput.matches( onlyNumber )){ // 입력값이 숫자가 아니거나 세자리가 아니면 예외 발생
                throw new IllegalArgumentException();
            }else {
                int strikeCount = 0;
                int ballCount = 0;
                List<Integer> userNum = new ArrayList<>();
                for(int i =0; i < comNumber.size(); i++){
                    userNum.add((int) userInput.charAt(i) -48);
                }

                for(int i =0; i<userNum.size(); i++){
                    if(userNum.get(i) == comNumber.get(i)){
                        strikeCount++;
                    }else if(comNumber.contains(userNum.get(i))){
                        ballCount++;
                    }
                }

                if(ballCount !=0 || strikeCount !=0){ // 볼이나 스트라이크가 하나라도 있을때
                    if(strikeCount == 0){
                        System.out.println(ballCount + "볼");
                    }else if(ballCount == 0){
                        System.out.println(strikeCount + "스트라이크");
                    } else {
                        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                    }
                }else {
                    System.out.println("낫싱");
                }

                if(strikeCount == 3){ // 다 맞췄을때
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    String repeat = Console.readLine();
                    switch (repeat){
                        case "1" :
                            comNumber.clear();
                            comNumber = application.makeThreeNum();
                            break;
                        case "2" :
                            System.out.println("게임을 종료합니다.");
                            break loop;
                        default:
                            throw new IllegalArgumentException();
                    }
                }
            }
        }
    }

    public List<Integer> makeThreeNum() {
        List<Integer> comNumber = new ArrayList<>();
        while (comNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber);
                System.out.print(randomNumber);
            }
        }

        return comNumber;
    }
}
