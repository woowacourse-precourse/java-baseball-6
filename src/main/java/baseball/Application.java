package baseball;
import java.util.Vector;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {		
		
		int iGameStare = 1;
		int iFistType = 0;
		Vector<Integer> VecComNum = new Vector<Integer>(3);		
		Vector<Integer> VecPlayerNum = new Vector<Integer>(3);	
							
		while(iGameStare==1)
		{				
			while(VecComNum.size()<3)
			{
				int iCreateNum = Randoms.pickNumberInRange(1, 9);
				if(!VecComNum.contains(iCreateNum))
				{
					VecComNum.add(iCreateNum);					
				}
			}			
			if(VecPlayerNum.size()<3)
			{
				if(iFistType ==0)
				{
					System.out.println("숫자 야구 게임을 시작합니다.");
					++iFistType;
				}	
				System.out.print("숫자를 입력해주세요 : ");	
				String sInput = Console.readLine();
				String[] sInputAyy = sInput.split("");	
				if(sInputAyy.length!=3)
				{					
					throw new IllegalArgumentException("사용자가 잘못된 값을 입력하였습니다.");
				}
				else 
				{								
					for(int i=0;i<sInputAyy.length;i++)
					{
						VecPlayerNum.add(Integer.parseInt(sInputAyy[i]));							
					}	
				}				
			}
			else if(VecComNum.size()==3)
			{
				int iBall = 0;
				int iStrike = 0;
				
				for(int i=0; i<VecPlayerNum.size();i++)
				{						
					if(VecComNum.get(i)==VecPlayerNum.get(i))
					{
						++iStrike;
					}
					else if(VecPlayerNum.contains(VecComNum.get(i)))
					{
						++iBall;
					}	
				}	
				
				if(iStrike==3)
				{
					System.out.println("3스트라이크");	
					System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
					VecPlayerNum.clear();
					System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");					
					String sInputData = Console.readLine();
					int iInputNum = Integer.parseInt(sInputData);
					if(iInputNum!=1 && iInputNum!=2)
					{						
						throw new IllegalArgumentException("사용자가 잘못된 값을 입력하였습니다.");
					}
					else if(iInputNum==1)
					{	
						iFistType=0;
						VecComNum.clear();						
						continue;
					}
					else if(iInputNum==2)
					{
						iGameStare =2;					
						break;
					}					
				}
				else if(iBall==0 && iStrike==0)
				{
					System.out.println("낫싱");	
					VecPlayerNum.clear();					
				}					
				else if(iBall!=0 || iStrike!=0)
				{
					System.out.println(iBall+"볼 "+iStrike+"스트라이크");	
					VecPlayerNum.clear();
				}
			}
		}	
    }
}