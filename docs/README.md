# 우아한테크코스 2024 Pre-course 과정 (1주차)

## 기능 목록

- **Application**
	- 메인 클래스
	
<br>

- **Game**
	- 메인 게임 클래스
	- gameStart() : 초기 게임을 실행하고 사용자 입력에 따라 재시작하는 메소드
	- playGame() : 정답을 생성하고, 사용자로부터 입력을 받아 맞출 때까지 반복하는 메소드
	- showResult() : 볼/스트라이크 개수에 따라 String을 출력하는 메소드
	- checkNumbers() : 볼/스트라이크 개수를 판정하는 메소드
	- continueGame() : 게임 재시작 메소드
	
	
- **RandomGenerator**
	- 숫자 생성 클래스
	- generate() : 입력받은 숫자만큼 서로 다른 세 자리 숫자를 뽑는 메소드
	
- **User**
	- 유저 입력값 클래스
	- input() : 유저로부터 입력을 받고 유효값을 검증한 뒤 List로 리턴하는 메소드