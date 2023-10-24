## 기능 목록
### 기능목록 전체 VIEW MAP
- 1번 : 변수 선언
- while 루프 (1사이클 = 1게임)
    - 2번 : 한 게임의 정답생성 with 중복방지
    - while 루프(1사이클 = 1번 맞추기 시도)
        - 3번 입력받고 숫자 유효성 검증
        - 4번 입력값 strike/ball/nothing 판단
        - 5번 정답확인 후 break, 정답실패면 다시 시도
    - 6번 재시작 여부 확인
    


    1. 변수 선언
        a. len : n자리수로 숫자 야구 게임을 할 수 있게하는 변수, 일단은 문제요구에 따라 3으로 고정.
        b. restart : 게임을 재시작할때 판단할 변수 1 or 2의 값만 가질 수 있음
        c. s_cnt, b_cnt : strike와 ball을 count할 변수들
        d. answer[len]배열과 input[len]배열 : 정답과 인풋을 할당할 배열

    2. 중복을 방지하여 랜덤한 정답을 생성한다
        a. Randoms.pickNumberInRange(1, 9)를 사용하되, 배열에서 직전까지의 수와 겹치는 것이 있으면 다시 랜덤한 수를 할당하게끔 반복문 구현하기

    3. 입력받고 숫자 유효성 검증하기
        a. 서로다른
        b. 세자리의
        c. 1-9까지의 수로 구성 : 0도 예외발생처리

        a,b,c 만족하지 못할 경우 => IllegalArgumentException 예외발생

        여기서 궁금증? 1~9까지만 정답이 있으니까 0을 입력하는 것도 잘못된 입력으로 봐야할까? 
        => 0도 입력범위를 초과하는 것으로 판단하여 IllegalArgumentException예외발생처리함
    
    4. 입력값 strike/ball/nothing 판단하기
        a. 정답과 입력배열을 비교하여 같은 숫자, 같은 자리는 Strike++
        b. 정답과 입력배열을 비교하여 같은 숫자, 다른자리는 Ball++
        c. Ball과 Strike모두 0이면 Nothing
        d. Ball, Strike 순으로 출력

    5. 정답확인 
        a. strike수가 3이되면(==len) 정답으로 인정 후 break
        b. 정답 실패시 다시 시도(루프 반복)            

    6. 재시작 여부 확인 및 유효성 검증
        a. 1 or 2의 숫자만 용납
        b. 나머지는 IllegalArgumentException 예외발생


