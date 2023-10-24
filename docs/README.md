# 우테코 프리코스 1주차 - 숫자야구 구현
## 구현의도
- 실제 야구와 동일하게 홈팀, 어웨이팀, 심판을 생각하며 구현해보았습니다.
- 홈 : Player (사용자), 어웨이 : Computer, 심판 : Referee
## 요구사항 분석
### 기능 요구 사항 분석
#### 비교
1. strike
    - 컴퓨터의 number[index]의 값과 사용자의 number[index] 값이 같을 때
2. ball
   - 컴퓨터의 number와 사용자의  number의 중복되는 값의 개수 - strike 개수
#### 프로그램 종료
1. 사용자가 컴퓨터의 값을 맞췄을 때
    1. 사용자의 입력이 0일 경우 프로그램 종료, 1일 경우 게임 재시작
2. 사용자가 입력이 잘못되어 Exception이 발생했을 때
   1. 사용자의 입력이 1, 3자리 수가 아닐 경우 (게임 중 입력, 게임 재시작 입력)
   2. 사용자의 입력이 숫자가 아닐 경우
   3. 사용자의 입력에 중복이 있을 경우

## 기능목록
### 공통
- 각 클래스가 가지고 있는 멤버 변수는 get, set을 통해서만 접근하기
### Player
- 멤버 변수 : number

| 메소드             | 설명                                     | 반환값    |
|-----------------|----------------------------------------|--------|
| askNumber       | 사용자 입력을 받아 멤버 변수 "number" 에 저장         | void   |
| askRestart      | 게임 재시작 값 입력                            | String |
| isCorrectLength | [Exception 발생] 사용자 입력이 1자리 또는 3자리인지 확인 | void   |
| isDist          | [Exception 발생] 사용자 입력이 숫자인지 확인         | void   |
| isDuplication   | [Exception 발생] 사용자 입력에 중복이 없는지 확인      | void   |
| isCorrectInput  | [Exception 발생] 사용자 입력이 1과 2인지 확인       | void   |

### Computer
- 멤버 변수 : number

| 메소드                | 설명                                         | 반환값    |
|--------------------|--------------------------------------------|--------|
| makeRandomNumber   | 주어진 Randoms을 사용하여 컴퓨터의 랜덤값 생성 후 <br/>변환하여 하여 멤버변수 "number" 에 저장 | void   |
| makeNumberToString | 만들어진 랜덤값을 입력으로 받아 String으로 변환              | String |

### Referee
- 멤버 변수 : strike, ball

| 메소드           | 설명                                                            | 반환값  |
|---------------|---------------------------------------------------------------|------|
| startGame     | 게임스타트 문구와 컴퓨터 랜덤값 요청                                          | void |
| askNumber     | 숫자 입력 문구와 사용자에게 입력값 요청                                        | void |
| askRestart    | 입력 값 요청 후 값을 판단하여 게임 종료 및 재시작                                 | void |
| endGame       | 게임종료 문구와 사용자에게 입력값 요청                                         | void |
| compareNumber | 컴퓨터의 number와 사용자의 number를 비교하여<br/>멤버 변수 "strike"와 "ball"에 저장 | void |
| getResult     | 비교하여 저장된 strike 값과 ball 값을 가져옴                                | void |
