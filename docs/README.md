start() 메소드는 게임을 시작하는 파트입니다. playing()메소드를 반복수행 하다가 
3strike가 나오면 게임을 종료하고 재시작 및 종료를 묻습니다. 


playing() 메소드는 computer의 List를 받아 사용자가 입력한 값과 비교해 결과를 출력해줍니다.


createNumber() 메소드는 start() 실행시 computer List를 난수 발생으로 초기화합니다.


notNumber() 메소드는 입력한 문자열의 구성이 하나라도 숫자가 아닐경우를 체크합니다. 
