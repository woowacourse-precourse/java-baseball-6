#  ⚾️ 미션 #1 - 숫자 야구
<br>

## 구현 기능 목록

### 1. 컴퓨터가 가진 수 3개 랜덤하게 정하기 (1~9)
   > camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용

### 2. 입력받은 수 확인
   > camp.nextstep.edu.missionutils.Console의 readLine()을 활용<br>
   - 스트라이크 : 같은 위치에 동일 수 존재하는지 확인
   - 볼 : 다른 위치에 동일 수 존재하는지 확인
   - 낫싱 : 어느 위치에도 동일 수가 존재하지 않는지 확인 (3 숫자 다 스트라이크, 볼이 아닌 경우)

### 3. 컴퓨터가 가진 수 3개를 다 맞출 시 : 게임 라운드 종료

### 4. 라운드 종료 후 - 게임 재실행 및 게임 완전히 종료 선택 가능
   - 1 입력: 게임 라운드 재시작
   - 2 입력: 완전히 종료

### 5. 사용자 입력 오류 시 : IllegalArgumentException 오류 발생 시키기
   - 도전 중: 3개의 수 입력이 아닐 시 (2개 이하, 4개 이상일 경우)
   - 게임 성공 후: 1,2가 아닌 수 입력 시
<br>
<br>

## 프로그램 클래스 구성

**Application.java**
: Game class 호출

**Game.java**
: 전체 게임 진행

```
// 함수목록

public void startGame()
public boolean startRoundGame()
public ArrayList<Integer> getComputerNums()
public boolean checkIncluding(int input)
public void checkException(int caseNum, int input)
```

   
