package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args){
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	List<Integer> computerNum = setComputerNum();
    	while(true) {
    	List<Integer> userNum = inputUserNum();
    	if(computerNum.equals(userNum)) {  //정답일경우
    		System.out.println("3스트라이크");
    		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    		int isReplay = Integer.parseInt(Console.readLine());
    		if(isReplay == 1) {
    			computerNum = setComputerNum(); //리플레이를 위한 computerNum
    			continue;
    		}
    		else break;
    	}
    	checkNum(computerNum,userNum);
    	}
    }
    
    //상대방 슷자 셋팅
    public static List<Integer> setComputerNum(){
    	List<Integer> computerNum = new ArrayList<>();
    	while (computerNum.size() < 3) {
    	    int randomNumber = Randoms.pickNumberInRange(1, 9);
    	    if (!computerNum.contains(randomNumber)) {
    	        computerNum.add(randomNumber);
    	    }
    	}
    	return computerNum;
    }
    
    //사용자 숫자 입력 *중복값 제거(setComputerNum참고)
    public static List<Integer> inputUserNum(){
    	System.out.print("숫자를 입력해주세요 : ");
    	List<Integer> userNum = new ArrayList<>();
    	int[] tmpUserArr = new int[3];
    	int input = Integer.parseInt(Console.readLine());
    	if(input<100||input>999) {
    		System.out.println("잘못된 범위입니다.");
    		throw new IllegalArgumentException();
    	}
    	for(int i=2; i>=0; i--) { //입력된 값을 배열 각 인덱스에 저장
    		tmpUserArr[i] = input % 10;
    		input /= 10;
    	}
    	for(int i=0; i<3; i++) { //tmpUserArr배열의 값을 userNum 리스트로 입력. 동시에 중복값검사 중복시 예외처리
    		if(userNum.contains(tmpUserArr[i])) {
    			System.out.print("중복된 값이 입력되었습니다.");
    			throw new IllegalArgumentException();
    		}else {
    			userNum.add(tmpUserArr[i]);
    		}
    	}
    	return userNum;
    }
    
    //볼,스트라이크 판독
    public static int[] checkNum(List<Integer> computerNum, List<Integer> userNum){ 
    	int countArr[] = new int[2];
    	int ballCount = 0;
    	int strikeCount = 0;
    	if(!computerNum.contains(userNum.get(0))&&!computerNum.contains(userNum.get(1))&&!computerNum.contains(userNum.get(2))){
    		System.out.println("낫싱");
    	}else {
    		for(int i=0; i<3; i++) {
    			if(computerNum.get(i).equals(userNum.get(i))) {
    				strikeCount++;
    			}else if(computerNum.contains(userNum.get(i))){ 
    				ballCount++;
    			}
    		}
    		String output = "";
    		if(ballCount>0) {
    			output += ballCount + "볼 ";
    		}
    		if(strikeCount>0) {
    			output += strikeCount + "스트라이크 ";
    		}
    		output+= "\n";
    		System.out.print(output);
    		countArr[0] = ballCount;
    		countArr[1] = strikeCount;
    	}
    	return countArr;
}
}