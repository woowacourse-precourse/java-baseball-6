package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //게임시작 문구 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            //임의의 세자리 숫자 생성
            //임의의 정수 세개를 어레이 리스트에 저장한다.
            ArrayList<Integer> threeNumber = new ArrayList<>();
            while(threeNumber.size() < 3){
                int randNumber = Randoms.pickNumberInRange(1,9);
                if(!threeNumber.contains(randNumber)){
                    threeNumber.add(randNumber);
                }
            }

            Boolean inplayCheck = true; // 3스트라이크가 나올때까지 사용자 입력을 받는 단계를 반복시킨다.
            while (inplayCheck) {
                int strikeCount = 0;
                int ballCount = 0;
                //사용자에게 숫자를 입력받기
                System.out.print("숫자를 입력해주세요 : ");
                String playerS = Console.readLine();
                //사용자 입력이 적절한지 판단하기
                // - 세자리가 아닌 수를 입력하면 예외를 발생한다.
                if(playerS.length() != 3){
                    throw new IllegalArgumentException("올바른 입력이 아닙니다.");
                }
                // - 세자리 수는 서로 다른 수여야 한다.
                if(playerS.substring(0,1).equals(playerS.substring(1,2)) || playerS.substring(0,1).equals(playerS.substring(2,3))){
                    throw new IllegalArgumentException("올바른 입력이 아닙니다");
                }
                if(playerS.substring(1,2).equals(playerS.substring(2,3))){
                    throw new IllegalArgumentException("올바른 입력이 아닙니다");
                }
                ArrayList<Integer> playerI = new ArrayList<>(3);
                for (int i = 0; i < 3; i++) {
                    playerI.add(Integer.parseInt(playerS.substring(i, i + 1)));
                    if(playerI.get(i) == 0){
                        throw new IllegalArgumentException("올바른 입력이 아닙니다.");
                    }
                }

                //판정
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (threeNumber.get(i) == playerI.get(j)) {
                            if (i == j) {
                                strikeCount += 1;
                            } else {
                                ballCount += 1;
                            }
                        }
                    }
                }
                //판정결과출력
                if(strikeCount == 0){
                    if(ballCount == 0){
                        System.out.println("낫싱");
                    }
                    else{
                        System.out.println(ballCount + "볼");
                    }
                }
                else {
                    if(ballCount == 0){
                        System.out.println(strikeCount + "스트라이크");
                    }
                    else{
                        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                    }
                }
                //3스트라면 종료
                if(strikeCount == 3){
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    inplayCheck = false;
                }
            }
            //다시하기 묻기
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            String replay = Console.readLine();
            if(replay.equals("1")){
                continue;
            }
            else if(replay.equals("2")){
                break;
            }
            else{
                throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
        }
    }
}