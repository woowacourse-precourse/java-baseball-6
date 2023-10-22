package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        int inputNum = 0; //사용자가 입력하는 숫자
        List<Integer> user = new ArrayList<>();// 사용자가 입력하는 숫자를 담을 리스트

        List<Integer> computer = makeRandomNumber(); //랜덤 숫자 생성

        int strikeCount = 0; // 스트라이크 카운팅
        int ballCount = 0; // 볼 카운팅

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumberStr = Console.readLine();
            if(inputNumberStr.length() != 3) {  //입력받은 수가 3자리가 아니라면 예외 발생
                throw new IllegalArgumentException();
            }

            inputNum = Integer.parseInt(inputNumberStr);

            user.add(inputNum / 100);
            user.add((inputNum % 100) / 10);
            user.add(inputNum % 10);

            //사용자가 입력한 숫자와 랜덤 숫자를 비교해 볼 수와 스트라이크 수를 구한다.
            if(!computer.equals(user)) {
                for (int i = 0; i < computer.size(); i++) {
                    if(computer.get(i).equals(user.get(i))) {
                        ++strikeCount;
                    }
                    for (int j = 0; j < user.size(); j++) {
                        if(computer.get(i).equals(user.get(j))) {
                            ++ballCount;
                            if(computer.get(i).equals(user.get(i))) {
                                --ballCount;
                            }
                        }
                    }
                }
                //볼 수와 스트라이크 수를 출력한다.
                if(ballCount > 0 && strikeCount > 0) {
                    System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                    ballCount = 0;
                    strikeCount = 0;
                } else if(strikeCount > 0) {
                    System.out.println(strikeCount + "스트라이크");
                    strikeCount = 0;
                } else if(ballCount > 0) {
                    System.out.println(ballCount + "볼");
                    ballCount = 0;
                } else {
                    System.out.println("낫싱");
                }
            } else {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int start = Integer.parseInt(Console.readLine());
                if(start == 1) {
                    computer = makeRandomNumber();
                } else if(start == 2) {
                    System.out.println("게임 종료");
                    break;
                }
            }
            user.clear();
        }
    }

    //랜덤 숫자를 만드는 메서드
    private static List<Integer> makeRandomNumber() {
        List<Integer> randomList = new ArrayList<>();
        while (randomList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }
        return randomList;
    }
}
