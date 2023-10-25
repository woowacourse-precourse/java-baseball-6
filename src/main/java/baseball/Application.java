package baseball;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    	
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	ArrayList<Integer> computer = new ArrayList<Integer>();
        // 컴퓨터가 랜덤한 값 추출
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        while(true) {
        	//사용자가 값을 입력
        	System.out.println("숫자를 입력해주세요 :");
        	int Strike = 0 ; int Ball = 0 ;
        	String Input = Console.readLine() ;
        	String[] arr = Input.split("") ;
        	//입력값 예외 catch
        	try {
        		for(int i = 0; i<=2; i++) {
        		int num = Integer.parseInt(arr[i]) ;
        		}
        	} catch (NumberFormatException e) {
        	    throw new IllegalArgumentException();
        	}
        	if (arr.length>3) {
        	    throw new IllegalArgumentException();
        	}
        	else if (arr[0]==arr[1] | arr[1]==arr[2] | arr[0]==arr[2]) {
        		throw new IllegalArgumentException();
        	}
        	ArrayList<Integer> user = new ArrayList<Integer>();
        	for(int i = 0; i<=2; i++) {
        		int a = Integer.parseInt(arr[i]) ;
        		user.add(a) ;
        		}
        	//Strike와 Ball 판별
        	for(int j=0 ; j<=2; j++) { 
        		int b = user.get(j) ;
        		if(computer.contains(b)==true){
        			if(computer.get(j)==b) {
        				Strike++ ;        			
        			}
        			else {
        				Ball++ ;
        			}
        		}
        	}
        	//경우에 따라 출력
        	if(Strike==0 & Ball==0) {
        		System.out.println("낫싱") ;
        	}
        	else {
        		if(Ball==0 & Strike>0) {
        			System.out.printf("%d스트라이크\n", Strike);
        		}
        		else if(Strike==0 & Ball>0) {
        			System.out.printf("%d볼\n",Ball);
        		}
        		else {
        			System.out.printf("%d볼 %d스트라이크\n",Ball,Strike);
        		}
        	}
        	//조건 검수 후 게임 종료or재시작
            if(Strike==3) {
            	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료") ;
            	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.") ;
            	String Input2 = Console.readLine() ;
            	int Det = Integer.parseInt(Input2);
            	if (Det==2) {
            		break;
            	}
            	else if(Det==1){
            		computer.clear();
                	while (computer.size() < 3) {
                        int randomNumber = Randoms.pickNumberInRange(1, 9);
                        if (!computer.contains(randomNumber)) {
                            computer.add(randomNumber);
                        }
                	}
            	}
            	else {
            		throw new IllegalArgumentException();
            	}
            }
        }
    }
}
