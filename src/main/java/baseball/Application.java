package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        List<Integer> randomNum = new ArrayList<>();
        List<Integer> inputNum = new ArrayList<>();
        int strike = 0;		//입렵한 숫자에서 스트라이크 개수
        int ball = 0;		//볼 개수
        int total = 0;		//볼+스트라이크
        int playagain = 1;	//게임 재시작 할지 종료할지 선택
        
        System.out.println("숫자 야구 게임을 시작합니다.");
        
        while (playagain == 1){	
            total = 0;
            strike = 0;
            ball = 0;
         
            while (randomNum.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!randomNum.contains(randomNumber)) {
                            randomNum.add(randomNumber);
                     }   

                    while(strike != 3){
                        try {
                            System.out.println("숫자를 입력해주세요 : ");
                            

                            if(inputNum.size() != 3 || inputNum.contains(0)) {
                                throw new IllegalArgumentException("잘못된 값을 입력했습니다."); 
                           
                            }

                            int checkNum;
                            List<Integer> inputArray = inputNum;
                            for(int i = 0; i < inputNum.size(); i++){
                                checkNum = inputArray.get(i);
                                inputArray.remove(i);
                                if(inputArray.contains(checkNum)){
                                    throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
                                }
                            }

                        }catch (IllegalArgumentException e) {
                            playagain = 2;
                            break;
                            }
                    
                        
                            for(int i = 0; i < inputNum.size(); i++){
                                if(randomNum.contains(inputNum.get(i))){
                                total += 1;
                                }
                                if(randomNum.get(i) == inputNum.get(i)){
                                strike += 1;
                                }
                            }
                        ball = total - strike;
                
                                if(total == 0){
                                        System.out.println("낫싱");
                                }else if(strike == 0){
                                        System.out.println(ball + "볼");
                                }else if(ball == 0){
                                        System.out.println(strike + "스트라이크");
                                }else{
                                        System.out.println(ball + "볼 " + strike + "스트라이크");
                                }
                        }
                        if(strike == 3){
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        }
            }
                
        }
    }
}

