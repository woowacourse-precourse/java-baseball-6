<h1>클래스 구조와 클래스별 구현해야 할 메소드 목록</h1>
<hr>
<ol>
    <li>
        <h3>Game 인터페이스</h3>
        <ul>
            <li>게임을 시작하는 메소드</li>
            <li>게임을 종료하는 메소드</li>
            <li>게임을 재시작하는 메소드</li>
        </ul>
    </li>
    <li>
        <h3>BaseballGame 클래스(implements Game)</h3>
        <ul>
            <li>게임을 시작하는 메소드</li>
            <li>게임을 종료하는 메소드</li>
            <li>게임을 재시작하는 메소드</li>
            <li>사용자에게 입력을 받아 user의 number를 설장하는 메소드</li>
            <li>사용자의 입력이 유효한지 확인하는 메소드</li>
            <li>컴퓨터의 number를 생성하는 메소드</li>
            <li>스트라이크와 볼의 개수를 세는 메소드</li>
            <li>user가 computer의 숫자를 모두 맞혔는지 확인하는 메소드</li>
            <li>결과를 출력하는 메소드</li>
        </ul>
    </li>
    <li>
        <h3>NumberGenerator 클래스</h3>
        <ul>
            <li>랜덤 숫자를 생성하는 메소드</li>
        </ul>
    </li>
    <li>
        <h3>StringChecker 클래스</h3>
        <ul>
            <li>문자열이 모두 숫자로 이루어져 있는지 확인하는 메소드</li>
            <li>문자열이 숫자로 이루어져 있고, 길이가 numberLength와 같은지 확인하는 메소드</li>
        </ul>
    </li>
    <li>
        <h3>Player 클래스</h3>
        <ul>
            <li>number를 입력받는 메소드</li>
            <li>number를 반환하는 메소드</li>
        </ul>
    </li>
    <li>
        <h3>Computer 클래스 (extends Player)</h3>
        <ul>
            <li>numbers에 해당 숫자가 있는지 확인하는 메소드</li>
        </ul>
    </li>
    <li>
        <h3>User 클래스 (extends Player)</h3>
    </li>
</ol>