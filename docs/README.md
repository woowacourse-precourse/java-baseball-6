## 0. 개발 전
### - JDK 17 설정 
### - 작동 흐름 
- MC : "숫자 야구 게임을 시작합니다."
- computer : 1~9까지 서로 다른 임의수 3개 선택

- MC : "숫자를 입력해주세요 :"
- player : 서로 다른 3개 숫자 입력 > 값 잘못 입력시 IllegalArgumentException 발생 후 Application 종료
- computer : 결과 출력(볼, 스트라이크, 낫싱)

- MC : (3스트라이크 인 경우) "3개의 숫자를 모두 맞히셨습니다! 게임종료"
- MC : "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

- 반복 > computer의 숫자 맞출시 종료 > 다시 시작/완전 종료 (입력인 1과 2를 통해 구분)

### - 구현 목표 
- while문을 통한 반복
- MC의 말을 출력
- computer의 임의 값 3개 설정
- player의 값 받기
- 결과 함수 구축 및 return 값으로 볼,스트라이크,낫싱여부 도출
- while문 빠져 나오기


## 1. 1차 개발.
- 코드 리펙토링 필요
- 입력값 예외처리는 아직 안함
- './gradlew.bat clean test' 코드 실행시 오류 2개 발생
  - ApplicationTest > 게임종료_후_재시작() FAILED
    java.lang.ArrayIndexOutOfBoundsException at ApplicationTest.java:33

  - ApplicationTest > 예외_테스트() FAILED
  java.lang.AssertionError at ApplicationTest.java:27

## 2. 2차 개발. > 최종
- 1차 개발 코드는 흐름을 쉽게 판별할 수 있지만 큰 규모의 프로젝트에 알맞지 않는 코딩 방식이기 때문에 변경
- 각 class로 기능을 세분화 하고 한개의 메소드에 한개의 기능만 동작을 목표로 구현

---
# < 최종 코드 리뷰 >

##  Main
- UserNum, ComputerNum, ResScore을 생성하여 사용
- 첫번째 while문
  - ComputerNum의 랜덤값 초기화
  - 두번째 while문
    - 사용자의 값 받고 제대로 된 값인지 확인
    - ResScore 초기화
    - check를 통한 결과를 ResScore에 저장
    - resScore.printScore 결과 출력
    - 3스트라이크 인 경우 break
  - 새로 시작/종료 값을 받음
- check()
  - input : ComputerNum, UserNum,ResScore / return : void
  - 위치값을 서로 확인 후 ResScore의 값 변화하여 ball, strike, nothing 계산

## (Class) UserNum
- int형의 n1,n2,n3로 구분
- set, get을 통해 다른 class에서 사용 가능하도록 하였음
- getUserNum()
  - input : null / return : void
  - 사용자 입력 받는 기능 작동
  - 입력값이 제대로 된 값인지 확인하는 checkInput을 통해 이상값일 시 IllegalArgumentException발생
  - 문자열 형태의 입력값을 숫자로 변경 하여 n1,n2,n3에 값 대입
- checkInput()
  - input : string / return : boolean
  - 파라미터의 string 값이 알맞은 값인지 확인
  - 1~9 사이의 값인가? 서로 겹치지 않는 값인가? 를 판단
  - 알맞는 값이면 true, 아니면 false return
  
## (Class) ComputerNum
- int형의 c1,c2,c3로 구분
- set, get을 통해 다른 class에서 사용 가능하도록 하였음
- makeComputerNum()
  - input : null / return : void
  - Randoms.pickNumberInRange()를 통해 랜덤한 3개의 값 선택
  - c1,c2,c3에 값 대입
- testComputerNum()
  - input : int / return : void
  - 기능이 잘 작동 하는지 확인 하기 위해 임의의 값을 지정할 수 있도록 함
  - 실제 동작에서는 사용되지 않지만 개발 과정에서 사용

## (Class) ResScore
- int형의 ball,strike,nothing 으로 구분
- set, get을 통해 다른 class에서 사용 가능하도록 하였음
- initScore()
  - input : null / return : void
  - ball, strike, nothing의 값을 0으로 초기화
- printScore()
  - input : null / return : void
  - ball, strike 값이 존재하면 해당 값을 출력하고 두개의 값이 0일시에는 nothing으로 출력

