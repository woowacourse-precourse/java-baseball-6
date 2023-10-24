# 미션 : 숫자야구

## 필요한 기능
    • 컴퓨터 랜덤 숫자 발생기

    • 사용자 숫자 입력기

    • 게임시작

    • 게임종료
---
### 컴퓨터 랜덤 숫자 발생기 (ComputerNumGenerator Class)  메소드 : ComNumGen()
    우선 숫자야구 규칙에 의해 겹치지 않는 3가지 숫자가
    랜덤적으로 발생되는 메소드가 필요로 하다.

    해당 매소드의 가장 큰 핵심은
    • 겹치지 않는 3가지 숫자
    라고 판단이 된다.

    랜덤한 숫자는 프로그래밍 요구사항에 의해 camp.nextstep.edu.missionutils.Randoms 의 pickNumberInRange()를 활용하라고
    명시되어 있다.
    
    따라서 숫자가 겹치는 일이 발생되지 않도록 조건문을 랜덤한 숫자를 비교한다.
---
### 사용자 숫자 입력기 (PlayerNumInput Class)   메소드 : PlayerNumInput(), illegalInput()
    컴퓨터가 임의로 뽑은 숫자를 맞추기 위해 사용자는 숫자를 입력해야 한다.
    입력을 받을 때에는 Scanner 클래스를 사용하는 것이 아니라
    프로그래밍 요구사항에 의해 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
    
    단, 사용자는 숫자만을 입력해야 하고, 그 문장의 길이는 오직 3 이어야 한다.
    위 조건을 위반하는 입력들은 IllegalArgumentException을 통해 예외처리가 된다.
---
### 게임시작 (StartBaseball Class)  메소드 : GameStart()
    앞서 구현한 컴퓨터 랜덤 숫자 발생기와 사용자 숫자 입력기를 사용하여
    각 숫자들을 발생 및 입력 받고, 그 숫자들을 판별하여 볼과 스트라이크를 구분한다.
    이 부분에서는 기능 요구 사항에 명시된 규칙을 따른다.
    
    명시된 규칙에 따라서 3스트라이크가 나오기 전까지 사용자가 숫자를 입력하는 과정을 반복한다.
    게임이 종료된 후 게임을 다시 시작(숫자 1 입력) 혹은 게임을 종료(숫자 2 입력) 할 수 있다.

    3스트라이크가 나오게 되면 EndGame클래스의 EndGame() 메소드를 호출하여 게임종료를 출력하고 재시작 여부를 물어본다.
    
### 게임종료 (EndGame Class)    메소드 : EndGame()
    단순히 게임이 종료되었음을 알려주고 게임 재시작 혹은 종료에 관한 명령을 입력받는다.
    프로그래밍 요구사항에 의해 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.