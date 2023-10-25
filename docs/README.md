## 🚀 기능 구현 목록

1. **Computer Class**: 1부터 9까지 서로 다른 수로 이루어진 세 자리 수 생성.
    - 난수 생성: camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용.
    - 조건: 각 자리 수가 모두 다른 숫자인지 중복 확인하며 생성.
        1. generateNumber(): 각 자리 숫자가 모두 다른 세 자리 난수를 생성.
        2. result(userNumber): 사용자가 유추한 수와 비교해 "볼, 스트라이크, 낫싱"을 판별.
        3. countStrike(userNumber): 같은 수가 같은 자리에 있는 "스트라이크" 판별.
        4. countBall(userNumber): 같은 수가 다른 자리에 있는 "볼" 판별.
        5. countNothing(userNumber): 같은 수가 전혀 없는 "낫싱" 판별.
        6. isCorrect(userNumber): 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임을 종료.
---
2. **User Class**: 세 자리 수를 입력 받음.
    - 예외처리: 세자리 수가 아닌 잘못된 값은 IllegalArgumentException
    - 난수 생성: camp.nextstep.edu.missionutils.Console의 readLine()을 활용.
    - 조건: 각 자리 수가 모두 다른 숫자인지 중복 확인하며 생성.
        1. enterNumber(): 각 자리 숫자가 모두 다른 세 자리 난수를 입력. 만약 잘못된 값을 입력할 경우 IllegalArgumentException 예외처리.
        2. checkValid(): 올바른 입력 값인지 확인.
---
3. **Main Logic**: Computer 가 생성한 세 자리 수와 사용자가 유추한 수를 비교.
    - 스트라이크, 볼 판별 함수(countStrike, countBall)로 "x볼 y스트라이크" or "낫싱" 출력.
    - 3스트라이크(컴퓨터가 선택한 3개의 숫자를 사용자가 모두 맞히면) 판별 함수(isCorrect)로 게임 종료 여부 판단.
        1. gameStart(): 새로운 게임을 시작. 3스트라이크 일때까지 진행.
        2. 사용자 입력:
            1. "1"일 경우 - 새로운 게임을 다시 시작.
            2. "2"일 경우 - 게임 종료.