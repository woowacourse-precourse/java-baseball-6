package baseball;

public class Illegal {
	
	public void illegalIntNumber(String num) { // 숫자인지 확인
		try {
			int intNum=Integer.parseInt(num);
		}catch (Exception e) {
			// TODO: handle exception
			throw new IllegalArgumentException();
		}
	}
	
	public void illegalNotThree(int num) { //3자리수보다 작을때
		if(num<100||num>=1000) {
			throw new IllegalArgumentException();
		}
	}
	
	public int[] illegalZeroOrDuplicate(int num) {
		int sepNum[]=new int[3];
		for(int i=0;i<sepNum.length;i++) {
			int div=10;
			sepNum[i]=num%div;
			if(sepNum[i]==0) {
				throw new IllegalArgumentException();
			}
			num/=10;
		}
		for(int i=0;i<sepNum.length-1;i++) {
			for(int j=i+1;j<sepNum.length;j++) {
				if(sepNum[i]==sepNum[j]) {
					throw new IllegalArgumentException();
				}
			}
		}
		return sepNum;
	}
}
