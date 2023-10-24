# 기능 정리

### 함수 목록
- [점수 판별하는 메소드](#힌트를-계산하는-메소드)
- [힌트를 계산하는 메소드](#힌트를-문자열로-바꿔주는-메소드)
- [입력을 받는 메소드1](#입력을-받는-메소드)
- [입력을 받는 메소드2](#입력을-받는-메소드2)
- [게임을 준비하는 메소드](#정답을-생성하는-메소드)


#### 입력을 받는 메소드
- name : getNumbers
- parameters : 없음
- return : `List<Integer>` 
  - 부호가 없는 정수를 원소로 가지고 크기가 3인 정수 리스트
- error : 다음의 경우 `IllegalArgumentException`를 발생시키고 종료
  - 1 ~ 9의 범위를 벗어난 경우
  - 숫자가 아닌 경우
  - 이미 있는 원소를 중복으로 입력한 경우
  - 원소가 3개를 초과하거나 미만일 경우 
- description :
  - "숫자를 입력하세요 : "를 출력한다. 
  - 게임을 진행하기 위해 `Console`클래스의 `readLine`으로 입력받은 `String`을 각각 하나의 숫자로 변환시켜 `List`에 추가하는 메소드
  - `getBytes()` 메소드로 각각 한 자리씩 변환해 저장한다.


#### 입력을 받는 메소드2
- name : isGameOver
- parameters : 없음
- return : `boolean`값
- error : 1 또는 2가 아닌 문자일 경우 `IllegalArgumentException`발생시키고 종료
- description : 사용자에게 1 또는 2를 입력 받아 게임 진행 여부를 결정하는 함수

#### 정답과 비교하는 메소드
- name : compareWithAnswer
- parameters : 정답인 `List<Integer>` computer와 유저의 입력인 `List<Integer> user`
- return : 크기가 2인 `int[]`, 0번부터 1번까지 각각 스트라이크, 볼의 개수를 가진다.
- description : 입력받은 수들과 컴퓨터가 가지고 있는 수들을 비교한 후 힌트를 계산해주는 메소드

#### 힌트를 문자열로 바꿔주는 메소드
- name : getScoreMessage
- parameter : `compareWithAnswer`에 전달할 정답 `List<Integer>`과 유저 입력인 `List<Integer>`
- return : 볼, 스트라이크, 낫싱 세 문자열을 조합해 힌트를 출력하는 메소드
- description : `compareWithComputer`메소드에서 반환받은 `int` 배열인 score를 활용한다.
  - `StringBuilder` sb를 활용하여 문자열을 구성하고 출력한다. 
  - 만약 0번 인덱스가 0보다 크다면 `score[0]`과 "볼" 그리고 공백문자를 `append`한다.
    - ex) "2볼 "
  - 만약 1번 인덱스가 1보다 크다면 `score[1]`과 "스트라이크" 그리고 공백문자를 `append`한다.
    - ex) "1스트라이크"
  - 만약 `StringBuilder`가 비었다면 "낫싱"을 `append`한다.
  - 이후 `sb.toString`한 후 공백문자를 `trim`으로 잘라준다.

#### 정답을 생성하는 메소드
- name : prepareAnswer
- parameters : 없음
- return : 중복이 없는 3개의 원소를 가진 `List<Integer>`
- description : `Randoms.pickUniqueNumbersInRange`메소드를 사용해 3개의 중복이 없는 원소를 가진 리스트를 반환하는 메소드


