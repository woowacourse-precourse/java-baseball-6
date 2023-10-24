# 미션 - 숫자 야구

## 구현해야하는 기능 목록

### 입력
- length가 3인 숫자
- ```readLine()```을 사용하여 사용자가 입력하는 값 읽기
- Randome 값 추출을 위해 ```pickNumberInRange()``` 활용

### 출력
- 게임 시작 문구
- 숫자를 입력하라는 문구
- 숫자 비교에 따른 볼, 스트라이크 문구
- 게임 종료 안내 문구
- 게임 재시작 또는 종료 선택 문구

### 로직
1. 게임 시작 문구 출력
2. 사용자가 입력한 수를 읽는 기능
3. 사용자가 입력한 수가 올바른 입력 값인지 체크
    - 올바른 값이라면 4번 진행
    - 잘못된 값이라면 ```IllegalArgumentException``` 발생 후 종료
      - 예외 값: 자리수가 적거나 많음, 숫자가 아닌 값
4. 사용자가 입력한 수와 컴퓨터로부터 받은 임의의 수 비교
   - 입력한 값과 해당 숫자의 위치가 동일하다면 스트라이크
   - 입력한 값은 동일하지만 숫자의 위치가 다르다면 볼
   - 맞는 값이 없다면 "낫싱" 출력
5. 3스트라이크라면 게임 종료
6. 게임이 종료되었다면 다시 시작할지(1), 종료할지 묻기(2)
   - 다시 시작한다면 2번 로직부터 시작
   - 아니라면 종료
---
## 구현 클래스 및 메서드
### Application 클래스
  - BaseBallGame 객체 생성 및 초기화

### Array 클래스
  - getStringtoChar(): readLine으로 받은 문자열을 char형으로 변형
  - checkContains(): 숫자끼리 비교(char형, int형)
  - getIndex(): 랜덤 숫자와 입력된 숫자와의 자리 비교
    
### BaseBallGame 클래스
  - init(): 전체적인 게임 시작 관리. 정답 비교, 출력, 새로운 게임 시작의 역할
  - getUserAnswer(): readLine을 사용해 사용자의 입력값 읽어오기
  - checkInput(): 잘못된 값인지 체크
    - checkLen(): 길이가 3인지 체크
    - checkEqual(): 3자리 수에 동일한 숫자가 포함되어 있는지 체크
    - checkNum(): 숫자가 입력받았는지 체크
 - newStart(): 새로운 게임을 시작할지 말지 입력받는 기능
 - getNewStartAnswer(): 입력받은 답을 분류

### GameResult 클래스
  - addBallCount(): ball 개수 증가
  - addStrikeCount(): strike 개수 증가
  - printResult(): 한 게임에 대한 결과값 출력
  - compareAnswer(): 랜덤하게 받은 값과 입력 값 비교