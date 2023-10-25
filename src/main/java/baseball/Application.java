package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
	public void check1(String value)
	   
	   {
	      if(!value.equals("1")||!value.equals("2"))
	      {
	         throw new IllegalArgumentException("1 아니면 2만 선택하시오.");
	      }
	   }
	public void check2(String value)
	   
	   {
	      int len=value.length();
	      if(len!=3)
	      {
	         throw new IllegalArgumentException("세 자리수여야 합니다.");
	      }
	      for(int i=0; i<len; i++)
	      {
	         if(i!=len-1)
	         {
	            if(value.charAt(i)==value.charAt(i+1))
	            {
	               throw new IllegalArgumentException("세 숫자가 같아야합니다.");
	            }
	            
	         }
	      }
	      
	   }
    static int strike=0;
    static int ball=0;
    static int input;
    static int number;
    static int temp;
	public static int Compare_comp_player(int num1, int num2) {
		String computer=Integer.toString(num2);
	    String player=Integer.toString(num1);
	    
	    strike=0;
	    ball=0;
	    
	    for (int i = 0; i < 3; i++) {
            if (player.charAt(i) == computer.charAt(i)) {
                strike++;
            } else if (computer.contains(String.valueOf(player.charAt(i)))) {
                ball++;
            }
        }
		return 0;
    }
	
	
	public static void main(String[] args) {
    int flag=1;
    Application except=new Application();
    System.out.println("숫자 야구 게임을 시작합니다.");//게임 시작
    while (flag==1) {
    	/*
    	Random rand=new Random();
        int number=rand.nextInt(123, 988);//랜덤수 지정
        
        String exception=Integer.toString(number);*/
        int rand=Randoms.pickNumberInRange(123,988);
        String exception=Integer.toString(rand);
        if(exception.contains(String.valueOf('0')))
        {
        	continue;
        }
        if (exception.charAt(0)!=exception.charAt(1) && exception.charAt(0)!=exception.charAt(2) && exception.charAt(1)!=exception.charAt(2) && exception.charAt(0)!=0 && exception.charAt(1)!=0 && exception.charAt(2)!=0) {
        	flag=2;
        }
        
        while (flag==2) {
        	
        	System.out.println("숫자를 입력해주세요 : ");
            String temp=Console.readLine();
            try {
                except.check2(temp);
             }catch(IllegalArgumentException e) {
                System.out.println( e.getMessage());
                break;
                
             }
            int number=Integer.parseInt(temp);
        	//입력값 받기
            
        	Compare_comp_player(input, number);//함수에 입력값과 랜덤수 대입
        	
        	if (ball==0 && strike==3) {
        		flag=3;
        	}
        	if (strike==0 && ball==0) {
            	System.out.println("낫싱");
            }
            else if (ball==0) {
            	System.out.println(strike+"스트라이크");
            }
            else if (strike==0) {
            	System.out.println(ball+"볼");
            }
            else {
            	System.out.println(ball+"볼 "+strike+"스트라이크");
            }
        }
        if (flag==3) {
        	System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        
        	System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        	String choice=Console.readLine();
        	try {
                except.check1(choice);
             }catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
             }
        	int redo=Integer.parseInt(choice);
        
        	if (redo==1) {
        		flag=1;
        		System.out.println("숫자 야구 게임을 시작합니다.");//게임 시작
        	}
        	else {
        		System.exit(0);
        	}
        }
    }
	}}

        
        
        
    