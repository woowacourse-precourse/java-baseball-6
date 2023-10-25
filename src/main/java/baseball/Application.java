package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
    	Random random = new Random();
    	int rn[] = new int[3];
    	int n[] = new int[3];
    	int i, j, strike, ball, answer = 1;
    	
    	while(answer == 1){
    		for(i = 0; i < 3; i++) {
    			rn[i] = random.nextInt(10);
    			System.out.print(rn[i]);
    		}
    		System.out.println();
    		System.out.println("숫자 야구 게임을 시작합니다.");
    		
    		while(true){
    			System.out.print("숫자를 입력해주세요 : ");
    			int x = sc.nextInt();
    			
    			n[0] = x/100;
    			x %= 100;
    			n[1] = x/10;
    			x %= 10;
    			n[2] = x;
		    	
    			strike = 0; ball = 0;
    			for(i = 0; i < 3; i++)
    				for(j = 0; j < 3; j++)
    					if(rn[i]== n[j]){
    						if(i == j)
    							strike++;
    						else
    							ball++;
    					}
    	
    			if(strike == 3)
    				break;
    			else if(strike ==0 && ball == 0)
    				System.out.println("낫싱");
    			else if(ball > 0 && strike == 0)
    				System.out.println(ball + "볼");
    			else if(strike > 0&& ball == 0)
    				System.out.println(strike + "스트라이크");
    			else
    				System.out.println(ball + "볼 " + strike + "스트라이크");
    		}
    		
    		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    			answer = sc.nextInt();
    		}
    }
}
