## 기능명세서

Feat 1. 기능 세부 사항 정의<br>
<pre>
Feat 1-1. 숫자 야구는 Computer 와 Player 가 참여하는 게임이다.
Feat 1-2. Computer 의 숫자는 랜덤 3자리로 생성되며 1-9 사이에 중복된 숫자가 없어야 한다.
Feat 1-3. Player 의 입력값은 3자리 숫자이며, 1-9 사이에 중복된 숫자가 없어야 한다.
Feat 1-4. Player 의 입력값과 Computer 숫자를 비교해서 스트라이크, 볼 여부를 출력한다. 불일치하면 게임을 계속 진행한다.
Feat 1-5. Player 의 입력값과 Computer 숫자가 일치하면 게임을 종료 / 재시작을 선택한다.
</pre>
Feat 2. 기능별 객체 생성<br>
<pre>
Feat 2-1. Constants 객체는 게임에 필요한 상수값을 제공한다.
Feat 2-2. Game 객체는 게임을 시작하고 종료/재시작 기능을 제공한다.
Feat 2-3. Number 객체는 숫자와 관련된 연산을 담당한다.
Feat 2-4. OutputHandler 객체는 게임에 필요한 출력 기능을 제공한다.
Feat 2-5. InputHandler 객체는 게임에 필요한 입력 기능을 제공한다.
Feat 2-6. ValidateHandler 객체는 입력값의 유효성을 체크한다.
Feat 2-7. Convertor 객체는 타입 변환 기능을 제공한다.
Feat 2-8. ThrowError 객체는 에러 처리 기능을 제공한다.
</pre>
Feat 3. 기능별 객체 메소드 구현<br>
<pre>
Feat 3-1. Constants 객체
- 출력 텍스트, 에러 메시지, 입력 텍스트, 정규식 추가
Feat 3-2. Game 객체
- 게임시작()
- 재시작 판별()
Feat 3-3. Number 객체
- 숫자 가져오기()
- 컴퓨터 숫자 세팅하기()
- 플레이어 숫자 세팅하기()
- 컴퓨터,플레이어 숫자 비교하기()
- 컴퓨터 랜덤숫자 생성하기()
- 1개 랜덤숫자 생성하기()
- 스트라이크판별하기()
- 볼인지판별하기()
Feat 3-4. OutputHandler 객체
- 게임시작 메세지출력()
- 게임종료/재시작 메세지출력()
- 입력요청 메세지출력()
- 스트라이크/볼 메세지출력()
Feat 3-5. InputHandler 객체
- 플레이어 유추 입력값 가져오기()
- 플레이어 재시작/종료 입력값 가져오기()
Feat 3-6. ValidateHandler 객체
- 플레이어 유추 입력값 유효성 체크하기()
- 플레이어 재시작/종료 입력값 유효성 체크하기()
Feat 3-7. Convertor 객체
- 문자열을 숫자로 변환하기()
- Set을 Array로 변환하기()
Feat 3-8. ThrowError 객체
- 유추 입력값 에러처리하기()
- 재시작/종료 입력값 에러처리하기()
</pre>
