# ✏️ 요구 사항

- 컴퓨터는 1~9까지 서로 다른 임의의 수 3개를 선택한다.
- 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력한다.
- 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 과정을 반복하여 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.



# 📝 기능 설계

- 협력 : 숫자 야구 게임
- 전체 flow 살펴보기

야구 게임 시작(BaseballGame) -> 야구 게임 실행(BaseballProcess) -> 랜덤 값 생성(RandomUtil) 

-> 사용자 입력받기(InputUtil) -> 숫자 검증하기(ValidationNumber)

-> 야구 게임 연산(BaseballUtil) 

-> 3스트라이크가 아니면 계속 진행(BaseballProcess) or 3스트라이크이면 재실행 여부 요청(BaseballProcess) 

-> 사용자가에게 입력받기(InputUtil) -> 숫자 검증하기(ValidationNumber)

-> 사용자가 종료하면 게임 종료(BaseballGame) or 재실행하면 게임 실행(BaseballProcess)



- InputUtil
    - 하는 것
        - 플레이어에게 숫자를 문자열로 입력하기
        - 입력받은 문자열(숫자)를 Integer로 변환하기
        - 변환한 숫자를 리스트에 저장
        - CheckNumber를 객체를 호출하여 유효한 숫자인지 검증(숫자인가?, 3자리 수인가?, 서로 다른 수인가?, 1-9사이의 값인가?)
        - 게임 재시작 여부 문자열로 입력하기(1또는 2)
        - 입력받은 문자열을 Integer로 변환하기(동일) -> 변환하는 과정에서 숫자인지 판별 가능
        - CheckNumber 객체를 호출하여 유효한 숫자인지 검증(1또는 2인가?, 숫자가 맞는가?)

    - 아는 것


- ValidationNumber
    - 하는 것
        - 1 ~ 9 까지의 숫자인지 판별하기
        - 세자리의 숫자인가?
        - 서로다른 숫자인가?
        - 다음 게임을 이어할건지 여부에서 1,2 이외의 값인가?
    
    - 아는 것


- RandomUtil
    - 하는 것
        - 리스트에 랜덤 수 생성하기
        - 랜덤 수가 서로 다른 숫자인가?
        - 랜덤 수가 1-9사의 값인가?
        - 랜덤 수가 3자리 숫자인가?
    
    - 아는 것
        - 생성된 랜덤 수

- BaseballUtil
    - 하는 것
        - ball 여부 확인
        - strike 여부 확인
        - 입력값과 random 값을 비교하여 ball의 갯수 파악
        - 입력값과 random 값을 비교하여 strike의 갯수 파악
        - 결과 출력
  
    - 아는 것
        - ball 갯수
        - strike 갯수
    

- BaseballProcess
    - 하는 것
        - 게임 시작
        - 라운드 게임 실행
        - RandomNumber 객체에서 랜덤 수 요청
        - InputNumber 객체에서 플레이어에게 숫자 입력 요청
        - 정답(3스트라이크)일 경우, 게임 종료 여부 판단
        - InputNumber 객체를 통해 플레이어에게 다음 라운드 실행 여부 요청
        - 재실행 여부에 따른 게임 시작/종료 여부 리턴

    - 아는 것
        - RandomNumber의 접근
        - InputNumber의 접근


- BaseballGame
    - 하는 것
        - 게임 실행
        - 게임 종료

    - 아는 것
        - BaseballProcess 접근



# 👩🏻‍💻 구현 목록 정리

- [x] 모델 설계하기
- [x] 플레이어에게 입력값 받기
- [x] 랜덤 수 생성
- [x] 게임 진행 (ball, strike, nothing)
- [x] 게임 진행 여부(다음 라운드 진행여부)
- [x] 예외처리(입력값, 랜덤 수 값, 라운드 진행여부 입력값 확인)
