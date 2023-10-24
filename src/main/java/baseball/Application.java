package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	boolean errInput = false;
    	while(true) {
    		List<Integer> computer = new ArrayList();
    		while(computer.size()<3) {
    			int randomNumber = Randoms.pickNumberInRange(1, 9);
    			if(!computer.contains(randomNumber)) {
    				computer.add(randomNumber);
    			}
    		}
    		
    		while(true) {
    			
				System.out.print("숫자를 입력해주세요 : ");
				String a = Console.readLine();
				System.out.println(a);
				Set<Character>set = new HashSet<Character>();
				boolean outrange = false;
				for(int i = 0;i<a.length();i++) {
					if(a.charAt(i)<'0' || a.charAt(i)>'9') {
						outrange = true;
						break;
					}
					set.add(a.charAt(i));
				}
				
				if (a.length() != 3) {
					throw new IllegalArgumentException("3자리 이상 입력하였습니다.");
				}else if(set.size()!=3) {
					throw new IllegalArgumentException("중복되는 것이 있습니다.");
				}else if(outrange) {
					throw new IllegalArgumentException("");
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
    		System.out.println(num);
    		if(num==1) {
    			continue;
    		}else {
    			break;
    		}
    	}
       
    }
}
