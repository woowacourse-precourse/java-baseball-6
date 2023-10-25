/**
* @Package_name   : gamer
* @Class_name     : ComGamer 
*
* Create Date : 2023-10-21 
* Create User : 정은채
*/
package gamer;

import java.util.ArrayList;

import utility.Utility;

public class ComGamer implements Gamer{
	//생성자 
	public ComGamer() {
		this.comNumberArr = new ArrayList<>();
	}
	
	
	/**
	* description : ComGamer의 게임 플레이
	*
    * @Method : play
    */ 
	@Override
	public void play() {
		makeComNumber();
	}
	

	// 컴퓨터의 랜덤 숫자리스트
	private ArrayList<Integer> comNumberArr;
	
	/**
	* description :  컴퓨터의 랜덤 숫자리스트 반환
	*
    * @Method : comNumGetter
    * @return : ArrayList
    */ 
	public ArrayList<Integer> getComNumberArr() {
		return this.comNumberArr;
	}
	
	/**
	* description : 컴퓨터의 랜덤 숫자리스트 생성 
	*
    * @Method : numMaking
    */ 
	public void makeComNumber() {
		comNumberArr.clear(); 
		while(comNumberArr.size() < 3) { 
		    int randomNumber = Utility.campPickNumberInRange();
		    if (!comNumberArr.contains(randomNumber)) { // 중복방지
		    	comNumberArr.add(randomNumber);
		    }
		}
		
	}


}