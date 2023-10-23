기능
---

# 주요 기능: 
1. 적절한 컴퓨터 값 만들기
2. 맞는 input 들어왔는지 check
   1. 틀릴 시 IllegalArgumentException
3. 맞는 문장 print
4. 점수 계산
5. 반복문
   1. 3 스트라이크를 만들기 전까지 계속 해야 함
   2. 게임이 끝나고 재 시작을 할 수 있어야 함

------
# 1. 적절한 컴퓨터 값 만들기
- 예시에 제공됨

# 2. 맞는 input 들어왔는지 check
- 3글자 맞는지 확인: str.length 사용
- 숫자가 들어왔는지 확인: 
  - 유저 값 확인: Integer.parseInt() 사용
  - 재 시작 값 확인: 2개 밖에 없으므로 그냥 string으로 처리
- 중복 체크: set 활용
- IllegalArgumentException: try catch문과 throw문 사용
- 설계패턴의 decorator 패턴을 본 따서 만들면 될 듯

# 3. 맞는 문장 print
- logic에 대한 이해 없이 바로 고칠 수 있게 class로 따로 빼는 것이 좋아보임

# 4. 점수계산
- strike를 먼저 판단하고 이후 전체 size -1 만큼 자리를 옮겨 다니면서 ball판단
- score에 해당한는 간단한 구조체를 만들자 -> java에서 구조체에 해당하는 것을 모르겠음: 임시 방편으로 class 사용

# 5. 반복문 계산
- while문으로 묶고 게임을 계속 할 것인지 아닐지는 state로 판단.
- Score가 3일 때 state를 바꿀 수 있는 기회가 주어지고 바꾸면 거기서 상황 종료, 아니라면 computer의 값을 새롭게 설정함

-----
# 감상
- 기능을 먼저 파악한 후 프로그램을 짜기 시작하면 시간적 관점으로 효율이 상당히 좋다는 것을 깨닫게 됨
- check 쪽의 경우 input과 output을 모두 String인 것만 두게 되면 client쪽의 logic과 조금 더 독립적으로 짤 수 있었는데 의미 없는 커플링이 발생한 것 같아 아쉬움
  - 중복 체크 시 순회가 필요한데, String에서 index로 접근 가능하다는 것보다 List가 그런 식으로 접근하기 좋다는 것이 먼저 생각나서 
  check length -> convert to List(숫자인지 확인 작업 포함) -> check dup
  으로 짜게 되다 보니 이런 아쉬운 점이 나온 것 같음
