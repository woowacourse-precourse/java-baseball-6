package baseball;

import camp.nextstep.edu.missionutils.Randoms; // 랜덤값 추출 pickNumberInRange()

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console; // 사용자 입력값 readLine()

public class Application {

    private static List<Integer> computer;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            // 컴퓨터가 랜덤한 3자리 수 생성, 단 처음 시작하거나 새로 시작할때만!
            if (computer == null) {
                computer = createRandomNumber();
                // System.out.println("랜덤 값 : " + computer);
            }

            // 사용자로부터 3자리 수 받기
            List <Integer> user = getUserInput();
            System.out.println(user);

            String result = calresult(computer, user);
            System.out.println(result);

            // 두 숫자 같은지
            if (result.equals("3스트라이크")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n" + //
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                int answer = Integer.parseInt(Console.readLine());

                if(answer == 1){
                    computer = null;
                    continue;
                } else {
                    break;
                }
            }
        }
        
    }

    private static List<Integer> createRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserInput() {
        List<Integer> userList = new ArrayList<>();
        
        System.out.println("숫자를 입력해주세요 : ");
        String user = Console.readLine();
        
        try {
            if (user.length() != 3) {
                throw new IllegalArgumentException("입력된 숫자가 올바르지 않습니다.");
            }

            for(int i=0; i < user.length(); i++) {
                char digit = user.charAt(i);
                int number = Character.getNumericValue(digit); // (int)digit - '0'
                if (number < 1 || number > 9) {
                    throw new IllegalArgumentException("입력된 숫자가 올바르지 않습니다.");
                }
                userList.add(number);
            }

        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException("입력된 숫자가 올바르지 않습니다.");
        }

        return userList;
        
    }

    private static String calresult(List<Integer> c, List<Integer> u) {
        int strake = 0;
        int ball = 0;

        for (int i=0; i<c.size(); i++) {
            if (c.get(i) == u.get(i)) {
                strake++;
            } else if(c.contains(u.get(i))){
                ball++;
            }
        }

        if (strake == 0 && ball == 0) {
            return "낫싱";
        } else if (strake == 0 && ball != 0) {
            return ball + "볼";
        } else if (strake != 0 && ball == 0) {
            return strake + "스트라이크";
        } else {
            return ball + "볼 "+strake + "스트라이크";
        }
    }
}
