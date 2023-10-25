package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Application {
    public static void main(String[] args)throws IllegalArgumentException {
        // TODO: 프로그램 구현

        while(true){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //System.out.println(Arrays.deepToString(computer.toArray()));
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            int strike = 0;
            int ball = 0;
            System.out.println("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();

            // 예외 처리 0포함할 경우 OR 길이가 3보다 클 경우 OR 같은 숫자를 입력한 경우
            if(userInput.contains("0") || userInput.length() != 3){
                throw new IllegalArgumentException();
            }
            int guessNum = Integer.parseInt(userInput);

            List<Integer> guessArr = new ArrayList<>();

            guessArr.add(guessNum / 100);
            guessArr.add((guessNum % 100) / 10);
            guessArr.add(guessNum % 10);

            for (int i = 0; i < computer.size(); i++) {
                for (int j = 0; j < guessArr.size(); j++) {
                    //if(guessArr.get(i).equals(guessArr.get(j)))
                      //  throw new IllegalArgumentException();
                    if (computer.get(i).equals(guessArr.get(j))) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
                // return;
            }


            if(strike == 0 && ball != 0){
                System.out.printf("%d볼\n", ball);
            }
            if(strike != 0 && ball == 0){
                System.out.printf("%d스트라이크\n", strike);
            }
            if(strike !=0 && ball != 0) {
                System.out.printf("%d볼 %d스트라이크\n", strike, ball);
            }
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
          }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String playInput = Console.readLine();
            int play = Integer.parseInt(playInput);
            if(!(play == 1 || play == 2))
                throw new IllegalArgumentException();

            if(play == 2)
                break;
        }
    }
}
/*
int play = 1;
 while(play==1){
 // 컴퓨터 랜덤값 생성
 // 사용자 입력받고 숫자비교하는 함수 -> 맞출때까지 반복

 if(사용자 입력값 == 2){
    play = 2;
    }
}

 */