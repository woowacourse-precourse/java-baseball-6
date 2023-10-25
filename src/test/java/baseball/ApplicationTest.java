package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Scanner;

class ApplicationTest extends NsTest {
	public int menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return input.nextInt();
    }
    public int randNum() {
        int ran = (int)((Math.random()*9)+1);
        return ran;
    }
    public ArrayList<Integer> sol() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0 ; i < 3;i++) {
            int temp = randNum();
            if (arr.contains(temp)) {
                i--;
            } else {
                arr.add(temp);
            }
        }
        return arr;
    }
        
    public void gameStart() {
        
        int count = 0;
        ArrayList<Integer> gameArr = sol();
//        System.out.print("정답 : ");
//        for (int i = 0; i < gameArr.size();i++) {
//            System.out.print(gameArr.get(i));
//        }
//        System.out.println();
        while (true) {
            int strike = 0;
            int ball = 0;
            ArrayList<Integer> myArr = myNumbers();
            
            count++;
            for (int i = 0 ; i < gameArr.size(); i++) {
                for (int j = 0 ; j < myArr.size();j++) {
                    if (gameArr.get(i) == myArr.get(j) && i == j) {
                        strike++;
                    } else if (gameArr.get(i) == myArr.get(j) && i != j) {
                        ball++;
                    }
                }
            }
            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
                return;
            } else {
            	if(strike != 0 && ball != 0) {
            		System.out.print(strike + "스트라이크 ");
            		System.out.println(ball + "볼");
            	} else if(strike != 0) {
            		System.out.println(strike + "스트라이크");
            	} else if(ball != 0) {
            	System.out.println(ball + "볼");
            	} else {
            		System.out.println("낫싱");
            	}
            }
        }
    }
 
    public ArrayList<Integer> myNumbers() {
        Scanner input = new Scanner(System.in);
        
        loop :
            while (true) { 
                ArrayList<Integer> arr = new ArrayList<Integer>();
                System.out.print("숫자를 입력해주세요 : ");
                int num = input.nextInt();
                for (int i = 0;i<3;i++) {
                    arr.add(num % 10);
                    num /= 10;
                }
                int temp1 = arr.get(2);
                arr.set(2, arr.get(0));
                arr.set(0, temp1);
                for (int i = 0 ;i<3;i++) {
                    for (int j = i+1 ;j < 3;j++) {
                        if (arr.get(i) == arr.get(j)) {
                            System.out.println("중복된 숫자를 제외하고 입력해주세요.");
                            continue loop;
                        }
                    }
                }
                return arr;
            }
    }
}
