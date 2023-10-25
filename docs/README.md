## 구현할 기능

### 1. Application 클래스

#### main()
- IllegalArgumentException 예외 처리하기
- while 루프를 통해 게임 반복하기
### 2. Game 클래스

#### start()
- 게임을 시작하고 숫자 입력받기
- 컴퓨터의 숫자와 입력받은 숫자 비교해 결과 출력하기
- 게임 종료 메세지 출력하기

#### generateComputerNumbers()
- 랜덤으로 3자리 숫자 생성하기

#### convertInput()

- 입력 문자열의 길이가 3인지 확인하기
- 중복된 숫자가 있는지 확인하기
- 오류가 있다면 예외 발생시키기

#### checkNumbers()
- 입력받은 숫자와 컴퓨터의 숫자를 비교해 결과 메시지 출력하기

#### isGameWon()
- 승리했다면 승리 메시지를 출력하기