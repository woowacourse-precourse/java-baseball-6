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
        - GenerateRandomComputerNum 랜덤 숫자 지정
        - getComputerNum
    - GameSystem
        - check 컴퓨터와 유저의 수 비교
        - playGame 게임 시작
        - restart 재시작 여부 설정
    - Player
        - SetComputerNum 유저의 인풋을 받아 값을 지정
        - getPlayerNum

3. 게임 플로우
    1. Application - main함수 실행
    2. GameSystem → playGame()
    3. Computer - GenerateRandomComputerNum으로 랜덤숫자를 지정함.
    4. Player → SetPlayerNum (Exception 처리)
    5. GameSystem → check()를 통해서 두 수를 비교한 결과값을 출력.
    6. if check의 result == 3Strike, 게임 종료 안내 출력 후 reStart()
    7. if 사용자가 1을 입력하면 다시 playGame / else 게임 끝!