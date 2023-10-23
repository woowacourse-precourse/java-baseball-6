package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.*;

public class Application {
    public static boolean hasDuplicate(ArrayList<Integer> temp){ // 동일한 숫자가 있는지 확인하는 hasDuplicate 메서드
        if(temp.size() != 3)
            return true;
        if(temp.contains(0))
            return true;

        for(int i=0; i < temp.size(); i++){
            for(int j=i+1; j < temp.size(); j++){
                if(temp.get(i) == temp.get(j)) // 동알한 숫자가 있다면 true
                    return true;
            }
        }
        return false; // 동일한 숫자가 없으면 false
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Scanner scanner = new Scanner(System.in); // Scanner를 통해 숫자를 입력
        List<Integer> computer = new ArrayList<>(); // 랜덤의 3자리 숫자를 생성
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
        while(true){ // 3스트라이크이면서 종료 뒤 2를 누르면 반복문이 종료됨
            System.out.print("숫자를 입력해주세요 : ");
            ArrayList<Integer> mynumber = new ArrayList<>(); // 사용자가 입력한 3자리 숫자를 저장하는 mynumber
            String tmp = scanner.next(); // String 타입으로 3자리 수를 입력받는 tmp

            for(int i=0; i < tmp.length(); i++){ // tmp의 3자리 수를 한 자리씩 끊어 mynumber에 int타입으로 삽입
                char digitChar = tmp.charAt(i);
                int digit = Character.getNumericValue(digitChar);
                mynumber.add(digit);
            }

            if(hasDuplicate(mynumber)) // 동일한 숫자가 존재하거나, mynumber의 개수가 3이 아니거나, 0이 존재한다면 예외 발생
                throw new IllegalArgumentException();

            int[] temp = new int[2]; // 볼과 스트라이크의 개수를 담는 temp 배열
            for(int i=0; i < computer.size(); i++){
                int computerDigitNumber = computer.get(i); // computer 배열의 i번째 원소를 담는 computerDigitNumber
                for(int j=0; j < mynumber.size(); j++){
                    int myDigitNumber = mynumber.get(j); // mynumber 배열의 j번째 원소를 담는 myDigitNumber
                    if(computerDigitNumber == myDigitNumber){ // 동일하면서
                        if(i == j) // 같은 위치에 존재한다면
                            temp[1]++; // 스트라이크 +1
                        else // 다른 위치에 존재한다면
                            temp[0]++; // 볼 +1
                    }
                }
            }
            if(temp[0] + temp[1] == 0) // 볼과 스트라이크가 없다면 낫싱을 출력
                System.out.println("낫싱");
            else if(temp[0] > 0 && temp[1] > 0) // 볼과 스트라이크 모두 존재한다면 둘 다 출력
                System.out.println(temp[0] + "볼 " + temp[1] + "스트라이크");
            else if(temp[0] > 0) // 볼만 존재한다면 볼의 개수를 출력
                System.out.println(temp[0] + "볼");
            else if(temp[1] > 0) // 스트라이크만 존재한다면 스트라이크의 개수를 출력
                System.out.println(temp[1] + "스트라이크");

            if(temp[1] == 3){ // 스트라이크의 개수가 3이면
                System.out.println("세 개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int reStart = scanner.nextInt(); // 재시작 여부를 확인하기 위해 1 또는 2를 입력받는 reStart
                if(reStart == 1){ // 1을 입력했다면 게임을 새로 시작하므로 새로운 랜덤 3자리의 수를 computer에 담는다
                    computer = new ArrayList<>();
                    while(computer.size() < 3){
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if(!computer.contains(randomNumber))
                            computer.add(randomNumber);
                    }
                }
                else if(reStart == 2) // 2를 입력했다면 게임 종료
                    break;
                else // 1 또는 2를 입력하지 않았다면 예외 발생
                    throw new IllegalArgumentException();
            }
        }
    }
}
