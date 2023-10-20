package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag = true; //게임이 종료되었을 때 재시작과 종료를 확인할 수 있는 flag
        while(flag) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {  // 컴퓨터의 숫자 선택
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
                System.out.println("computer number = " + computer);
            }
            List<Integer> user = new ArrayList<>();
            String userInput = sc.next(); // 사용자 입력
            for(String i:userInput.split("")){
                int bit = Integer.parseInt(i);
                if (!user.contains(bit)){
                    user.add(bit);
                }
            }

            if (user.size()!=3 || userInput.length()!=3) {
                throw new IllegalArgumentException("올바르지 않은 입력입니다. 3자리의 서로 다른 수를 입력해주세요."); // 사용자가 올바르지 않은 입력을 넣었을 때
            }
            int ballCount = 0;
            int strikeCount = 0;
            for(int i=0;i<3;i++){
                if (computer.contains(user.get(i))){
                    ballCount++;
                }
                if(user.get(i) == computer.get(i)){
                    strikeCount++;
                    ballCount--;
                }
            }
            System.out.println("ball = " + ballCount + "strike =" + strikeCount);

            if (strikeCount==3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
                try {
                    int gameRestart = sc.nextInt();
                    if (gameRestart!=1 && gameRestart!=2){
                        throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
                    }
                    if (gameRestart==2){
                        flag=false;
                    }
                }catch (InputMismatchException e){
                    throw new IllegalArgumentException("숫자 1 또는 2를 입력해주세요.");
                }
            }
        }
    }
}
