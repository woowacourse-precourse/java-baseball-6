- class Computer
  컴퓨터 숫자 Random 값 생성
  생성자 Computer()로 computer 값 저장
  camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 이용
  static void compare(int userNumber)

  - class UserNumber
  userNumber 생성
  camp.nextstep.edu.missionutils.Console의 readLine() 사용자 입력값
  사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 예외 처리    

- class Compare
  입력한 수와 컴퓨터의 숫자 비교
    1. strike 
    2. ball
    3. nothing 하나도 없는 경우

- class Application
  숫자 야구 게임을 시작합니다.
    1. compare()
       /* Compare class에서 정의된 method받아옴
       method 입력값 과 상대방 값 비교
       3스트라이크 종료 */
    2. 2. 3개의 숫자를 모두 맞히셨습니다! 게임 종료
          게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
       1 or 2 값 받아서 1인경우 반복 / 2인경우 종료
          (입력된 값이 1, 2가 아닌 경우 IllegalArgumentException 예외 처리)
    