<구현 특이 사항>
1. camp.nextstep.edu.missionutils 라이브러리를 사용해야 한다.
- 유저로부터 숫자를 입력받을 때는 camp.nextstep.edu.missionutils.Randoms.pickNumberInRange를 사용한다.
- 컴퓨터의 숫자를 랜덤으로 생성할 때는 camp.nextstep.edu.missionutils.Console.readLine을 사용한다.
2. 사용자가 잘못된 값을 입력한 경우에는 예외처리를 한다.
- IllegalArgumentException 에러를 발생시킨 후 프로그램을 종료해야 한다.

<구현 상세 정보>
1. Game class 구현
- 필드 : ArrayList인 computer와 user를 생성한다.
- 메서드 :
    - startMessage() : 게임 시작을 알리는 메시지를 출력한다.
    - makeComNum() : computer에 랜덤으로 숫자 3개를 저장한다.
    - getUserNum() : 사용자로부터 숫자를 입력받아 user에 숫자 형태로 저장한다.
    - strike() : 스트라이크 개수를 센다.
    - ball() : 볼 개수를 센다.
    - play() : 스트라이크와 볼 개수에 기반하여 결과를 출력하며, 게임 새로 시작 및 종료를 선택한다.
    - run() : play() 메서드를 실행한다.
2. Application class 구현
- Game 클래스의 객체를 생성하고, 안에 있는 run() 메서드를 실행한다.