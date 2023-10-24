숫자야구

컴퓨터가 생성한 숫자를 '나'가 맞추는 게임


**컴퓨터(Computer)**
상대방(컴퓨터)의 세자리 수 임의로 생성(중복 x),random라이브러리

**나(Player)**
['나'의 입력조건]
규칙1.세자리 수 생성 ,하지만 중복되는 수 금지
규칙2.컴퓨터의 수를 맞출때까지 반복
['나'의 종료조건]
규칙3.게임을 맞추면 종료->다시 시작하거나 완전히 종료할 수 있음
    >다시 시작할 경우 '1' 입력후 재시작
    >완전히 종료할 경우 '2'입력후 종료 
    >(1,2)잘못 입력하면 IllegalArgumentException ->예외처리후 종료

**힌트(Hint)**
규칙1.같은 수가 같은 자리에 있으면 스트라이크
규칙2.같은 수가 다른 자리에 있으면 볼
규칙3.다른 수가 다른 자리에 있으면 낫싱

**출력(Print)**
규칙1.볼, 스트라이크 카운트 후 순서대로 출력
    > ?볼, ?스트라이크
규칙2.3스트라이크 달성시 게임종료
규칙3.게임 재실행, 종료 여부 묻기

**라이브러리 사용**
camp.nextstep.edu.missionutils에서 제공하는
Randoms 및 Console API를 사용하여 구현해야 한다.

______________________________________________________

mvc

**model**
Computer
    >computerNumber(상대방)
    API사용_pickNumberInRange,readLine
     범위정하기
     1-9제한
    
Player
    >PlayerNumber(나)
     세자리 수 제한
     중복값x(HashSet)
Replay
    >ReplayNumber
     1 or 2


**View**
Input
    >Player
    >Replay
    와 연결
Output
    >볼, 스트라이크 , 낫싱, 카운트

**Util**
NumberUtility
    >ball
    >strike
     초기화카운트
     볼카운트
     스트라이크카운트
     
ValidatioUtility
    >numberUtility 

**Controller**
    
**Application**
    >게임시작
    >개임재실행 or 종료여부 묻기

     