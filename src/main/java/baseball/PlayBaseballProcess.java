/**
* @Package_name   : baseball 
* @Class_name     : FacadeProcess 
*
* Create Date : 2023-10-21 
* Create User : 정은채 
*/
package baseball;
import java.util.ArrayList;

import gamer.ComGamer;
import gamer.JudgeGamer;
import gamer.ManageGamer;
import gamer.UserGamer;


public class PlayBaseballProcess {

	// 컴퓨터의 정답 숫자리스트, 사용자의 예상 숫자리스트
	private ArrayList<Integer> comNumberArr;
	private ArrayList<Integer> userNumberArr;
	
	/**
	* Description : facade 패턴 : baseball 게임 주 로직
	*
	* @Method : mainProcess()
	*/ 
	public void mainProcess() {
		
		//플레이어 입장
		ComGamer comGamer = new ComGamer();
		UserGamer userGamer = new UserGamer();
		JudgeGamer judgeGamer = new JudgeGamer();
		ManageGamer manageGamer = new ManageGamer();
		
		
		//<관리자>플레이어에 의해 게임 시작 
		manageGamer.play();
		
		//<관리자>플레이어에 의해 게임 지속 여부 결정
		boolean gaming = true;
		while (gaming) {
			// <컴퓨터>플레이어 정답 숫자 생성 
			comGamer.play();
			this.comNumberArr = comGamer.getComNumberArr();
			
			while(true) {
				//<사용자>플레이어 값 입력받기
				userGamer.play();
				// 입력받은 값이 적절한지 <관리자>플레이어에게 값 넘기고 검사받기
				manageGamer.errorGame(userGamer.userNumbers); // 적절하지 않을 시 IllegalArgumentException 발생
				// 검사통과 시 <사용자>플레이어 값 확정
				userGamer.setUserNumberArr();
				this.userNumberArr = userGamer.getUserNumberArr();
				
				//<심판자>플레이어에게 값 넘기고 결과 받기
				judgeGamer.setNumberArr(this.comNumberArr,this.userNumberArr);
				judgeGamer.play();
				
				//<심판자>플레이어 정답 판정
				if (judgeGamer.correct) { 
					//<관리자>플레이어 게임 종료
					gaming = manageGamer.endGame();
					break;
				}
			}
		}
	}
}