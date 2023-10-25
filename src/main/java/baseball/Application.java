package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) throws IOException {
    	
    	InputStreamReader ir = new InputStreamReader(System.in);
    	BufferedReader br = new BufferedReader(ir);
    	
    	List<String> inputList = new ArrayList<>();

    	System.out.println("숫자 야구 게임을 시작합니다.");

    	while(true) {
        	// 랜덤숫자 	
        	List<String> rdList = new ArrayList<>();
        	while (rdList.size() != 3) {
        	    int rdNum = Randoms.pickNumberInRange(1, 9);
        	    if (!rdList.contains(rdNum)) {
        	    	rdList.add(Integer.toString(rdNum));
        	    }
        	}
        	
    		int strike = 0; 
        	int ball = 0;
        	int nothing = 0;
    		
	    	while(strike < 3) {
	    		strike = 0;
	    		ball = 0;
	    		
	    		System.out.print("숫자를 입력해주세요:");
	    		
	    		// 입력 및 배열 변환
	        	String inputNum = br.readLine();
	        	if(inputNum.length()> 3) {
	        		throw new IllegalArgumentException("3자리를 입력해주세요.");
	        	}
	        	
	        	inputList = Arrays.asList(inputNum.split(""));
	    		
	        	//strike & ball 확인
	    		for(int i=0; i < rdList.size(); i++) {
	        		if(rdList.get(i).equals(inputList.get(i))){ 
	        			strike+=1;
	        		} else {
	        			for(String j : rdList) {
	        				if(inputList.get(i).equals(j)){
	        					ball+=1;
	        				}
	        			}
	        		}
	        	}
	    		
	    		//ment 확인
	    		String ment = "";
	    		if(strike ==0 && ball ==0) {
	    			ment = "낫싱";
	    		}else {
	    			ment += (ball > 0) ? ball+"볼 " : "";
		    		ment += (strike> 0) ? strike+"스트라이크 " : "";
		    	
	    		}
	    		System.out.println(ment);
	    	}
	    	
	    	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	    	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	    	
	    	String restart = br.readLine();
	    	if(restart.equals("2")) {
	    		return;
	    	}
    	}
    }
}
