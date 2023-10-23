1. 필요한 기능
    - 컴퓨터의 랜덤 숫자를 지정하기
        - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현.
        - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    - 사용자에게 숫자를 입력받기
        - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
        - 사용자의 숫자에 중복된 숫자가 있는지 확인
        - 사용자가 숫자가 아닌 문자나 공백을 입력하지 않았는지 예외처리

          만약 잘못된 값을 입력한다면 예외처리 후 애플리케이션 종료 (IllegalArgumentException)

    - 입력받은 숫자로 컴퓨터와 사용자의 숫자를 비교하기
    - 비교된 결과를 출력하고 게임을 계속 진행하기
    - 3스트라이크가 나오면 게임이 종료되고 다시 시작하냐는 문구 출력하기

2. 필요한 객체
    - Computer
        - RandomNum 랜덤 숫자 지정
    - GameSystem
        - CheckNum 컴퓨터와 유저의 수 비교
        - GameStart 게임 시작
        - Restart 재시작 여부 설정
    - Player
        - SetNum 유저의 인풋을 받아 값을 지정
        - Exception 입력받은 숫자 예외처리

3. 상호작용 플로우
    1. Application - main함수 실행
    2. GameSystem → GameStart
    3. Computer - RandomNum
    4. Player → SetNum (Exception)
    5. GameSystem → CheckNum …
    6. if CheckNum == 3Strike, Restart
    7. if Restart == Y, GameStart / else 게임 끝!