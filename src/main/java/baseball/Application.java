package baseball;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	
	
    public static void main(String[] args) {
    	Boolean On = true;
        // TODO: 프로그램 구현
    	do {
    	System.out.println("숫자 야구 게임을 시작합니다.");
    	On = Game();
    	} while (On);
    }
    
    
    public static Boolean Game() {
    	Boolean On = true;
    	ArrayList<Integer> Ballin = Ballin();
    	do {
      	On=Calc(SwingBat(), Ballin);
    	} while(On);
    	return Restart();
    }
    
    
    public static ArrayList<Integer> SwingBat(){
    	System.out.print("숫자를 입력해주세요 : ");
    	String Keyin = Console.readLine();
    	Integer intKey = null;
    	Boolean error = false;
    	ArrayList<Integer> Ballin = new ArrayList<>();
    	//int[] Ballin = new int[3];
    	try {
    		intKey = Integer.parseInt(Keyin);
    	} catch (Exception e1){
    		error = true;
    		//System.out.println("게임종료");
    	}
    	if(intKey> 1000 || intKey < 100) {
    		error = true;
    		throw new IllegalArgumentException("게임종료");

    	}
    	Ballin.add(intKey/100);
    	Ballin.add(intKey%100/10);
    	Ballin.add(intKey%100%10);
    	
    	//Ballin[0]=intKey/100;
    	//Ballin[1]=intKey%100/10;
    	//Ballin[2]=intKey%100%10;
    	//Arrays.sort(Ballin);
    	if(Ballin.get(0)==Ballin.get(1) || Ballin.get(1)==Ballin.get(2) || Ballin.get(0)==Ballin.get(2)) {
    		error = true;
    		throw new IllegalArgumentException("게임종료");
    	}
    	if(error){
    		Ballin=SwingBat();
    	}
    	
    	return Ballin;
    	
     	}
    	
    public static ArrayList<Integer> Ballin() {
    	ArrayList<Integer> Randball = new ArrayList<>();
    	while(Randball.size()<3) {
    		int a = Randoms.pickNumberInRange(1, 9);
    		if (!Randball.contains(a)) {
    			Randball.add(a);
    		}
    		
    	}
    	
    	return Randball;
    	
    }
   
    
    public static Boolean Calc(List<Integer> swing, List<Integer> ball) {
    	int[] Result = new int[] {0,0};
        System.out.println(swing);
    	System.out.println(ball);		
    	for(int i=0; i<3;i++) {
    		if(ball.get(i)==(swing.get(i))){
    			Result[0]++;
    		}
    		if(ball.contains(swing.get(i))&&ball.get(i)!=(swing.get(i))) {
    			Result[1]++;
    			
    		}
    	}
    	//if(a[0]==9) {
    	//	Result = {3,0};
    	//}
    	//System.out.println(b);
    	//System.out.println(a);
    	if(Result[0]==3) {//스트라이크
    		System.out.println("3스트라이크");
    		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    		return false;//Restart();
    	}
    	if(Result[0]==0) {//낫싱
    		System.out.println("낫싱");
    		
    	}
    	if(Result[0]!=0 && Result[0]!=3) {//볼스트라이
    		System.out.printf("%d볼 %d스트라이크\n",Result[1],Result[0]);
    		
    	}
    	return true;
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
