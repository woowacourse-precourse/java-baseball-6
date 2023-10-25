/**
* @Package_name   : gamer 
* @Class_name     : JudgeGamer 
*
* Create Date : 2023-10-21 
* Create User : 정은채 
*/
package gamer;

import java.util.ArrayList;
import display.ConsoleDisplay;
import utility.Const;

public class JudgeGamer implements Gamer{

	// 야구게임 정답 여부
	public boolean correct;
	// 기본생성자
	public JudgeGamer() {	
		correct = false;
	} 
	
	/**
	* Description : JudgeGamer의 게임 플레이
	*
    * @Method : play
    */ 
	@Override
	public void play() {
		String result = judgeNum();
		ConsoleDisplay display = new ConsoleDisplay();
		display.output(result);
	}
	
	// 컴퓨터의 정답 숫자리스트, 사용자의 예상 숫자리스트
	private ArrayList<Integer> comNumberArr;
	private ArrayList<Integer> userNumberArr;
	/**
	* Description :  컴퓨터의 정답 숫자리스트와 사용자의 예상 숫자리스트 세팅
	*
    * @Method : setNumberArr
	*/ 
	public void setNumberArr(ArrayList<Integer> _comNumArr, ArrayList<Integer> _userNumArr) {
		this.comNumberArr = _comNumArr;
		this.userNumberArr = _userNumArr;
	}
		
	/**
	* Description : 컴퓨터의 정답 숫자리스트와 사용자의 예상 숫자리스트 비교 후 결과값 반환
	*
    * @Method : judgeNum
    * @return : String
    */ 
	private String judgeNum() {
		StringBuilder sb = new StringBuilder();
		int ballResult = getBall();
		int strikeResult = getStrike();
		
		//정답여부 저장
		if (strikeResult == 3) {
			correct = true;
		}
		
		if (ballResult == 0 && strikeResult == 0) {
			sb.append(Const.NOTHIING).append("\n");
		}else if(ballResult == 0) {
			sb.append(strikeResult).append(Const.STRIKE).append("\n");
		}else if(strikeResult == 0) {
			sb.append(ballResult).append(Const.BALL).append("\n");
		}else {
			sb.append(ballResult).append(Const.BALL).append(" ").append(strikeResult).append(Const.STRIKE).append("\n");
		}
		
		return sb.toString();
	}
	
	/**
	* Description : 볼 개수 반환
	*
    * @Method : ball
    * @return : Integer
    */ 
	private Integer getBall() {
		int ballNum = 0;
		for (int i = 0 ; i <3 ; i++) {
			for (int j = 0 ; j <3 ; j++) {
				if (i != j && this.comNumberArr.get(i) == this.userNumberArr.get(j)) {
					ballNum += 1;
				}
			}
		}
		return ballNum;
	}
	
	/**
	* Description : 스트라이크 개수 반환
	*
    * @Method : strike
    * @return : Integer
    */ 
	private Integer getStrike() {
		int strikeNum = 0;
		for (int i = 0 ; i <3 ; i++) {
			if (this.comNumberArr.get(i) == this.userNumberArr.get(i)) {
				strikeNum += 1;
			}
		}
		return strikeNum;
	}   

}