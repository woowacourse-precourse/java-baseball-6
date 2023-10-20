package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;
// 자바를 처음 써보는 사람
// 익숙치 않은 관계로 남의 코드와 정보를 보면서 공부중.


public class Application {
    public static void main(String[] args) { // 메인 프로그램.
        // TODO: 프로그램 구현
        boolean again  = true;

        while(again){
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> com = comCreate();
            String result = "";
            while (!result.equals("3스트라이크")){
                result = judgement(com, userNum());
                System.out.println(result);
            }
            again = playagain();
        }
    }
    private static int randomCreate(){ // 1~9사이 랜덤 값을 생성해 리턴함.
        Random Random = new Random(); // Random 클래스의 인스턴스 생성함.
        return Randoms.pickNumberInRange(1,9); // 1~9사이의 랜덤 값을 생성. 우테코 제공.
    }

    private static List<Integer> comCreate(){ //  중복 되지 않는 3개의 랜덤 값을 받아 array로 리턴함.
        List<Integer> comNum = new ArrayList<>();

        while(comNum.size() < 3){
            int randomNum = randomCreate();
            if(comNum.contains(randomNum)){ // contains는  Array 객체에 값이 존재 하는지 확인할 수 있음.
                continue;
            } else{
                comNum.add(randomNum); // add를 통해 랜덤 값을 추가함.
            }
        }
        return comNum;
    }
    private  static int countStrike(List<Integer> com, List<Integer> user){ // 스트라이크 갯수를 확인함.
        int count = 0;

        for(int i = 0; i < user.size(); i++){
            if(com.get(i) == user.get(i)){  // get을 이용해 각 자릿 수의 값이 맞는지 확인.
                count += 1;
            }
        }
        return count;
    }
    private static int countBall(List<Integer> com, List<Integer> user){ // 볼 갯수를 확인함.
        int count = 0;
        int strike = countStrike(com,user); // 스트라이크 값

        for(int i = 0; i < user.size(); i++){ // 숫자가 얼마나 맞는 지 확인.
            if(com.contains(user.get(i))){
                count ++;
            }
        }
        return  count - strike; // 전체 일치 하는 수에서 스트라이크 값을 뺀 값이 볼의 값임.
    }

    private static String judgement(List<Integer> com, List<Integer> user){ // 볼 과 스트라이크로 게임의 결과를 판단함.
        int strike = countStrike(com,user);
        int ball = countBall(com,user);

        if(strike == 0 && ball == 0){ // 맞는게 하나도 존재하지 않음.
            return "낫싱";
        } else if(strike == 0){ // 스트라이크가 없음.
            return ball + "볼";
        } else if(ball == 0){ // 볼이 없음.
            return  strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크"; // 둘다 존재함.
    }

    private static List<Integer> userNum(){ // 유저의 수 3개를 받음.
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNum = new ArrayList<>(); // userNum Array 생성
        String input = Console.readLine(); //data 받기. 우테코 제공.

        if(input.length() != 3) throw new IllegalArgumentException("숫자 3개를 입력하세요."); // 숫자 3개가 아닐시 에러를 던짐.

        // Array 반복해 각 인덱스 데이터를 number 값이 저장함. for문의 새로운 방법.
        for(String number : input.split("")){ //String 타입을 split 통해 분리함.
            userNum.add(Integer.parseInt(number)); //분리된 데이터를 parseInt를 통해 정수로 만들어 userNum에 추가함.
        }
        return userNum;
    }

    private static boolean playagain(){ // 게임의 재시작 여부를 확인함.
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        char answer = Console.readLine().charAt(0); //data 받기. 우테코 제공.
        if(answer == '1'){ // 1일때만 다시 시작함.
            return true;
        }
        return false;
    }
}
