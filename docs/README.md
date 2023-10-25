## 기능
### 컨트롤러
- BaseballGame
  - ball 
  - strike 
  - admin 

  - BaseballGame()
    - 게임 생성 시 참여할 플레이어 선택(약한 결합)
  - init()
    - 새로운 게임이 진행 될 때 마다 진행되는 초기화
  - run()
    1. 초기화 (init 함수 사용)
    2. 실행
       1. 플레이어 숫자 제시 
       2. admin과 player의 숫자 비교
       3. 결과 출력 (print 함수 사용)
  - print()
    - 결과 출력
  - playerInput()
  - countStrikeBall()

### 모델
- Player
    - answer
      - player의 입력 값
    - Player()
      - 초기 answer 000으로 초기화
    - getAnswer()
    - setAnswer()
      - 입력값 3개 이외의 값일시 예외처리 
      - 숫자 이외의 값 입력 시 예외 처리 
      - 밑의 검사 함수에 대한 부분 예외처리 
    - isDif()
      - 동일 숫자 입력 값 검사 
    - isZero()
      - 0 숫자 입력 값 검사
- Admin
    - answer 
      - 숫자 야구 게임의 정답
    - Admin()
      - 객체 생성 시 정답 값 생성(게임 진행 중 변화 x)
    - getAnswer()
