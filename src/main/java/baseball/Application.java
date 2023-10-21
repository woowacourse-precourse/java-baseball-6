package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	while(true) {
    		List<Integer> computer = new ArrayList();
    		while(computer.size()<3) {
    			int randomNumber = Randoms.pickNumberInRange(1, 9);
    			if(!computer.contains(randomNumber)) {
    				computer.add(randomNumber);
    			}
    		}
    		
    		while(true) {
    			
				System.out.print("숫자를 입력해 주세요 : ");
				String a = Console.readLine();
				try {
					if (a.length() != 3) {
						throw new IllegalAccessException("세자리 수보다 크거나 작음");
					}
				} catch (IllegalAccessException e) {
					System.out.println(e.getMessage());
					break;
				}
    			
    			String[]aa = a.split("");
    			
    			int[]aaa = new int[aa.length];
    			for(int i = 0;i<aa.length;i++) {
    				aaa[i] = Integer.parseInt(aa[i]);
    			}
    			int strike = 0;
    			int ball = 0;
    			for(int i = 0;i<3;i++) {
    				if(computer.contains(aaa[i])) {
    					if(computer.get(i)==aaa[i]) {
    						strike++;
    					}else {
    						ball++;
    					}
    				}
    			}
    			if(strike==3) {
    				System.out.println("3스트라이크");
    				System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    				break;
    			}
    			if(strike==0 && ball==0) {
    				System.out.println("낫싱");
    			}else if(strike==0 && ball!=0) {
    				System.out.println(ball+"볼");
    			}else if(strike!=0&& ball==0) {
    				System.out.println(strike+"스트라이크");
    			}else {
    				System.out.println(ball+"볼 "+strike +"스트라이크");
    			}
    		}
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    		int num = Integer.parseInt(Console.readLine());
    		if(num==1) {
    			continue;
    		}else {
    			break;
    		}
    	}
       
    }
}
