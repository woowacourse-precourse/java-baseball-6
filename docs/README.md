# 숫자 야구 게임

*************

### 실행 순서 (기본 : 1 -> 2 -> 3 -> 4 -> 5 -> 6)

#### 1. 게임 시작
* 출력 : "숫자 야구 게임을 시작합니다."

#### 2. computer : 3자리 수 뽑기 
* 조건 1 : Randoms.pickNumberInRange() 사용
* 조건 2 : 1부터 9까지 중복된 숫자 없는 세자리 수

#### 3. user : 3자리 수 입력 받기
* 출력 : "숫자를 입력해주세요 : "
  * 조건 1 : Console.readLine() 사용
  * 조건 2 : 1부터 9까지 중복된 숫자 없는 세자리 수

#### 4. strike, ball 판별 후 출력
* 4-1. strike, ball 개수 세기
* 4-2. strike, ball 출력
  * 출력 예시 : 낫싱, 1볼, 2스트라이크, 1볼 1스트라이크
  
#### 5. 게임 종료 판별
* 3스트라이크 아닐 시 : 과정 3으로 이동
* 3스트라이크 시 : 게임 종료
  * 출력 : "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

#### 6. 게임 종료 시 새로 시작/종료
* 출력 : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
* "1" 입력 시 : 게임 새로 시작 (과정 2로 이동)
* "2" 입력 시 : 시스템 종료

*************
### 구현할 기능 목록

#### - baseball
#### - ball, strike : 인스턴스 변수

#### - sayStart() : "숫자 야구 게임을 시작합니다." 출력

#### - getRandomThreeNum() : 중복되지 않은 랜덤 3자리 수를 리턴

#### - getThreeNum()
* input값이 3자리인지 판별 / 아니면 에러(IllegalArgumentException) 발생
* isNumeric(String str) : 숫자로 바뀔 수 있는 문자열인지 판별 / 아니면 에러(IllegalArgumentException) 발생
* 중복된 값이 존재하면 에러(IllegalArgumentException) 발생

#### - calculateBallStrike(List<Integer>user, List<Integer>computer)
* user 와 computer 배열에서 같은 숫자가 있으면
  * 같은 인덱스면 : strike += 1
  * 다른 인덱스면 : ball += 1

#### - sayBallStrike()
* strike가 0이고, ball이 0이면 : "낫싱" 출력
* strike가 0이고, ball이 0이 아니면 : "X볼" 출력
* strike가 0이 아니고, ball이 0이면 : "X스트라이크" 출력
* strike가 0이 아니고, ball이 0이 아니면 : "X볼 X스트라이크" 출력

#### - sayEnd() : "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력

#### - determineRestart()
* 출력 : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
* "1" 입력 시 : 게임 새로 시작 (과정 2로 이동)
* "2" 입력 시 : 시스템 종료
