package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean flag = true; //게임이 종료되었을 때 재시작과 종료를 확인할 수 있는 flag
        while(flag) {
            int ballCount = 0;
            int strikeCount = 0;
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {  // 컴퓨터의 숫자 선택
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
                System.out.println("computer number = " + computer);
            }
            while (strikeCount<3) { // 사용자가 맞출 때까지
                strikeCount=0;
                ballCount=0;
                List<Integer> user = new ArrayList<>();
                System.out.println("숫자를 입력해주세요 : ");
                String userInput = sc.next(); // 사용자 입력
                try {
                    for (String i : userInput.split("")) {
                        int bit = Integer.parseInt(i);
                        if (!user.contains(bit)) {
                            user.add(bit);
                        }
                    }
                }catch (NumberFormatException e){
                    throw new IllegalArgumentException("3자리의 숫자를 입력해주세요"); // 사용자가 올바르지 않은 입력을 넣었을 때
                }
                if (user.size() != 3 || userInput.length() != 3) {
                    throw new IllegalArgumentException("올바르지 않은 입력입니다. 3자리의 서로 다른 수를 입력해주세요."); // 사용자가 올바르지 않은 입력을 넣었을 때
                }
                for (int i = 0; i < 3; i++) {
                    if (computer.contains(user.get(i))) {
                        ballCount++;
                    }
                    if (user.get(i) == computer.get(i)) {
                        strikeCount++;
                        ballCount--;
                    }
                }
                if (ballCount>0 && strikeCount>0){
                    System.out.println(ballCount+"볼 " + strikeCount+ "스트라이크" );
                }
                else if(ballCount>0){
                    System.out.println(ballCount+"볼");

                } else if (strikeCount > 0) {
                    System.out.println(strikeCount+ "스트라이크" );
                } else if (strikeCount == 0 && ballCount == 0) {
                    System.out.println("낫싱" );
                }

                if (strikeCount == 3) {
                    System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
                    System.out.println("게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    try {
                        int gameRestart = sc.nextInt();
                        if (gameRestart != 1 && gameRestart != 2) { // 입력이 1,2가 아닐 때
                            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
                        }
                        if (gameRestart == 2) {
                            flag = false;
                        }
                    } catch (InputMismatchException e) { // 입력을 문자로 입력했을 때
                        throw new IllegalArgumentException("숫자 1 또는 2를 입력해주세요.");
                    }
                }

            }
        }
    }
}
