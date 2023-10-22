package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	
	
    public static void main(String[] args) {
    	
        // TODO: 프로그램 구현
    	do {
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	Game();
    	} while (Restart());
    }
    
    
    public static void Game() {
      	Calc(SwingBat(), Ballin());
    }
    
    
    public static int[] SwingBat(){
    	System.out.print("숫자를 입력해주세요 : ");
    	String Keyin = Console.readLine();
    	Integer intKey = null;
    	int[] Ballin = new int[3];
    	try {
    		intKey = Integer.parseInt(Keyin);
    	} catch (Exception e1){
    		System.out.println("숫자를 입력하시오");
    	}
    	if(intKey> 1000 || intKey < 100) {
    		throw new IllegalArgumentException("공을 3번 던지시오");

    	}
    	Ballin[0]=intKey/100;
    	Ballin[1]=intKey%100/10;
    	Ballin[2]=intKey%100%10;
    	Arrays.sort(Ballin);
    	if(Ballin[0]==Ballin[1] || Ballin[1]==Ballin[2]) {
    		throw new IllegalArgumentException("중복된 값이 없도록 다시 제시하시오");

    	}
    	return Ballin;
     	}
    	
    public static List<Integer> Ballin() {
    	List<Integer> Randball = new ArrayList<>();
    	while(Randball.size()<3) {
    		int a = Randoms.pickNumberInRange(1, 9);
    		if (!Randball.contains(a)) {
    			Randball.add(a);
    		}
    		
    	}
    	
    	return Randball;
    	
    }
   
    
    public static void Calc(int[] a, List<Integer> b) {
    	int[] Result = new int[] {0,0};
        System.out.println(Arrays.toString(a));
    	System.out.println(b);		
    	for(int i=0; i<3;i++) {
    		if(b.contains(a[i])){
    			Result[0]++;
    		}
    		if(!b.contains(a[i])) {
    			Result[1]++;
    		}
    	}
    	//if(a[0]==9) {
    	//	Result = {3,0};
    	//}
    	if(Result[0]==3) {//스트라이크
    		System.out.println("3스트라이크");
    		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    		Restart();
    	}
    	if(Result[0]==0) {//낫싱
    		System.out.println("낫싱");
    		Game();
    	}
    	if(Result[0]!=0 && Result[0]!=3) {//볼스트라이
    		System.out.printf("%d볼 %d스트라이크\n",Result[1],Result[0]);
    		Game();
    	}
    }
   
    
    public static boolean Restart() {
    	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    
    	String Game = Console.readLine();
    	if(Game.equals("1")) {
    		System.out.println("게임을 재시작합니다");

    		return true;
    	}
    	if(Game.equals("2")) {
    		System.out.println("게임을 완전히 종료합니다");
    		return false;

    	}
    	//if(!Game.equals("1")&&!Game.equals("2")) {
    	throw new IllegalArgumentException("잘못된 값으로 종료합니다");
    	//}
    }    
}
