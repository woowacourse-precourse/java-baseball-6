## 구현할 기능 목록
- 입력
  - [x] camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  - [x] 게임이 끝난 경우 재시작/종료를 구분하는 1과 2중 하나의 수 입력받기
  - [x] 잘못 된 값 입력하면 IllegalArgumentException 예외 발생시키고 어플리케이션 종료하기
    - [x] 입력한 값이 숫자인지 판별
    - [x] 입력한 값의 길이가 3인지 판별
    - [x] 3자리의 숫자가 중복있는지 판별
- 출력 
  - [x] 시작, 입력 프롬프트 출력
  - [x] 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
  - [x] 게임 종료 출력
- 컴퓨터 클래스 생성하기
  - [x] 생성하면 서로 다른 3자리의 수 입력받기
    - [x] camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하기
  - [x] 입력 값과 생각한 숫자 같은지 확인하는 메서드 만들기
- main 함수
  - [x] 로직 작성

