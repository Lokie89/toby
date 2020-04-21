# 스프링
## 1. 오브젝트와 의존관계
#### 스프링 컨테이너
    스프링은 스프링 컨테이너 또는 애플리케이션 컨텍스트라고 불리는 스프링 런터임 엔진을 제공
    스프링 컨테이너는 설정정보를 참고로 해서 애플리케이션을 구성하는 오브젝트를 생성하고 관리

#### 스프링 프로그래밍 모델
    IoC / DI, 추상화, AOP
    
#### 스프링 추구
    단순함, 유연성
    
### DAO
    Data Acceess Object 는 DB를 사용해 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 오브젝트
###### 자바빈
    비주얼 툴에서 조작 가능 한 컴포넌트 였지만 "웹 기반의 엔터프라이즈 방식으로 바뀌면서 ?" 
    비주얼 컴포넌트라기보다는 다음 두 가지 관례를 따라 만들어진 오브젝트를 가리킨다.
    디폴트 생성자, 프로퍼티
    
### 관심사의 분리
    관심이 같은 것끼리는 하나의 객체 안으로 또는 친한 객체로 모이게 하고,
    관심이 다른 것은 가능한 따로 떨어져서 서로 영향을 주지 않도록 분리하는 것

###### 템플릿 메소드 패턴
    슈퍼클래스의 기본적인 로직의 흐름을 만들고, 그 기능의 일부를 추상 메소드나 오버라이딩이
    가능한 protected 메소드 등으로 만든 뒤 서브클래스에서 이런 메소드를 필요에 맞게
    구현해서 사용하도록 하는 방법을 "템플릿 메소드 패턴" 이라고 한다.
    
###### 팩토리 메소드 패턴
    오브젝트를 생성하는 메소드를 정의해놓고 서브클래스에서 해당 메소드를 구현하여
    어떤 오브젝트를 어떻게 생성할 것인지리를 결정하는 방법을 "팩토리 메소드 패턴" 이라고 한다.
    
### 객체지향 기술의 이론

###### 개방 폐쇄 원칙
    OCP, Open-Closed Principle
    클래스나 모듈은 확장에는 열려 있어야 하고 변경에는 닫혀있어야 한다.
###### 높은 응집도와 낮은 결합도
    응집도가 높다는 건 하나의 모듈, 클래스가 하나의 책임 또는 관심사에만 집중되어 있다는 뜻
    응집도가 높다는 건 변화가 일어날 때 해당 모듈에서 변하는 부분이 크다는 것
    만약 모듈의 일부분에만 변경이 일어나도 된다면, 모듈 전체에서 어떤 부분이 바뀌어야 하는지 파악
    
    결합도가 낮다는 건 하나의 오브젝트가 변경이 일어날 때 관계를 맺고있는 다른 오브젝트에게
    적은 변화를 요구한다는 것
    
###### 전략 패턴
    자신의 기능 맥락에서 필요에 따라 변경이 필요한 알고리즘을 인터페이스를 통해 
    통째로 외부로 분리시키고 이를 구현한 구체적인 알고리즘 클래스를 필요에 따라
    바꿔서 사용할 수 있게 하는 디자인 패턴

###### 팩토리
    객체의 생성 방법을 결정하고 그렇게 만들어진 오브젝트를 돌려주는 클래스
    
### 제어의 역전
    IoC, Inversion of Control
    프로그램의 제어 흐름 구조가 뒤바뀌는 것
    오브젝트가 자신이 사용할 오브젝트를 스스로 선택하지 않는다.
    ★ 제어의 역전이라는 말로 많이 헷갈렸음.
        결국 생성자로 던져주는 ConnectionMaker 의 DConnectionMaker는 내가 선택하는 것이 아닌가
        라고 생각했음. 그런데 선택(나는 제어라고 생각함) 여부가 아닌 어떤 객체가 그 주도권을 행사할것인가
        라는 의미로 받아들여야 한다고 생각.
        
       내 정의로 주도권의 역전 이라고 생각. 어떤 객체가 컨트롤 할 것이냐를 제어로 표현
       제어는 강제적인 느낌, 주도권은 더 우위? 더 영향력이 큰 느낌,
       
###### 스프링 IoC
    스프링에서 제어권을 가지고 직접 만들고 관계를 부여하는 오브젝트를 빈 bean 이라 함
    빈의 생성과 제어를 담당하는 IoC 오브젝트를 빈 팩토리 bean factory 라고 함
    애플리케이션 전반에 걸쳐 모든 구성요소의 제어 작업을 담당하는 Ioc 엔진을 애플리케이션 컨텍스트라 함
    
#### 애플리케이션 컨텍스트
    Application Context
    
    클라이언트는 구체적인 팩토리 클래스를 알 필요가 없다.
        어플리케이션 컨텍스트를 이용하면 오브젝트 팩토리가 아무리 많아져도 이를 알아야 하거나 직접 사용할 필요가 없다.
        일관된 방식으로 원하는 오브젝트를 가져올 수 있다. 또 XML처럼 단순한 방법을 이용해 IoC 설정정보를 만들 수도 있다.
    
    애플리케이션 컨텍스트는 종합 IoC 서비스를 제공해준다.
        애플리케이션 컨텍스트는 오브젝트가 만들어지는 방식, 시점과 전략을 다르게 가져갈 수도 있고,
        부가적으로 자동생성, 오브젝트에 대한 후처리, 정보의 조합, 설정방식의 다변화, 인터셉팅 등 
        다양한 기능을 제공
        
    애플리케이션 컨텍스트는 빈을 검색하는 다양한 방법을 제공한다.
        getBean() 메소드는 빈의 이름을 이용해 빈을 찾아준다.
        

###### 싱글톤 레지스트리
    어플리케이션 컨텍스트에서 빈을 추출하여 확인해보면 모두 같은 객체임을 알 수 있음.
    
    싱글톤 패턴의 한계
        1. private 생성자를 갖고 있기 때문에 상속할 수 없다.
        2. 싱글톤은 테스트하기가 힘들다.
        3. 서버환경에서는 싱글톤이 하나만 만들어지는 것을 보장하지 못한다.
        4. 싱글톤의 사용은 전역 상태를 만들 수 있기 때문에 바람직하지 못하다.
    
    싱글톤 레지스트리는 이러한 싱글톤 패턴의 한계 때문에 
    직접 싱글톤 형태의 오브젝트를 만들고 관리하는 기능을 제공한다.
    
###### 스프링 빈의 스코프
    스프링이 관리하는 빈이 생성되고, 존재하고, 적용되는 범위를 빈의 스코프라 함
    대부분 스프링에서 만들어지는 빈은 싱글톤 스코프를 갖는다.
    싱글톤 외의 스코프에는 
    프로토타입 스코프 - 빈을 요청할 때마다 새로운 오브젝트르 만들어줌 (<-> 싱글톤)
    요청 스코프 - 새로운 HTTP 요청이 생길때마다 생성되는,
    세션 스코프 - 웹의 세션과 스코프가 유사한
    등등 이 있음.
    
#### DI
    Dependency Injection
    의존관계 주입 조건
    1. 클래스 모델이나 코드에는 런타임 시점의 의존관계가 드러나지 않는다.
       그러기 위해서는 인터페이스에만 의존하고 있어야 한다.
    2. 런타임 시점의 의존관계는 컨테이너나 팩토리 같은 제 3의 존재가 결정한다.
    3. 의존관계는 사용할 오브젝트에 대한 레퍼런스를 외부에서 제공(주입) 해줌으로써 만들어진다.

###### 의존관계 검색
    자신이 필요로 하는 의존 오브젝트를 능동적으로 찾는다.
    물론 자신이 사용할 클래스의 오브젝트를 이용할지 결정하지는 않는다.
    
    의존관계 검색과 의존관계 주입을 적용할 때 차이점은 의존관계 검색 방식에서는
    검색하는 오브젝트 자신이 빈일 필요는 없다는 것
    
    보통 main 함수 내에서 의존관계 주입을 사용할 수 없어, 의존관계 검색을 사용함 (test 등)
    
###### XML 을 이용한 DI 설정
    빈의 이름 : @Bean 메소드 이름
    빈의 클래스 : Bean 오브젝트를 어떤 클래스르 이용해서 만들지를 정의
    빈의 의존 오브젝트 : Bean 의 생성자나 수정자 메소드를 통해 의존 오브젝트를 넣어준다.
        의존 오브젝트도 하나의 Bean 이므로 이름이 있고, 그 이름에 해당하는 메소드를 호출
        
```java
public class DaoFactory {
    @Bean // <bean
    public ConnectionMaker connectionMaker() { // id="connectionMaker"
        return new CountingConnectionMaker(new DConnectionMaker()); // class="toby/src../CountingConnectionMaker" />
    }
}
```

    XML 작성
    <beans> // @Configuration 과 동일
        <bean id="JAVA메소드명" class="빈오브젝트를 구현할 클래스">
            <property name="set메소드이름(set제외하고사용)" ref="의존빈id" />
        </bean>
    </beans>
    
    XML 사용
    ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
    로 사용한다.
    실제 xml 파일은 현 프로젝트에서 resources로 명시되어있는 path에 넣지 않으면 파일을 못찾아냄
    이유가뭐지
    
    bean 의 property 중 value 값 대입 시, String 값이 아닌 Class 이름이 들어갈 때가 있음
    스프링에서 set 메소드의 파라미터 타입을 확인 하고 해당 오브젝트로 자동 형변환 시킴
    
#### 정리
    관심사의 분리
    인터페이스 구현 인터페이스로만 접근가능( 전략 패턴 )
    개방 폐쇄 원칙
    낮은 결합도와 높은 응집도
    IoC
    싱글톤 레지스트리
    DI
    생성자 주입과 수정자 주입
    XML 설정
    

## 2. 테스트
    
    @Test 어노테이션이 왜 java 패키지에서는 작동안하는지 확인

#### @Test( expected = 예외클래스명 )
    테스트 메소드 실행 중에 발생하리라 기대하는 예외 클래스를 넣어줌
    보통의 테스트와는 반대로, 정상적으로 테스트 메소드를 마치면 테스트 실패
    expected 에서 지정한 예외가 던져지면 테스트 성공
    
    테스트 할 메소드에서 예외발생시 throw 되는 혹은 throw 시키는 예외 클래스명 을 넣어줌
    
#### 포괄적인 테스트
    테스트 코드 작성시 성공 케이스를 예상하고 테스트 코드를 작성하기 보다는
    예외적인 상황까지 고려하며 테스트 코드를 작성해야 한다.
    "항상 네거티브 테스트를 먼저 만들라"
    
#### TDD
    만들고자 하는 기능의 내용을 담고 있으면서 만들어진 코드를 검증도 해줄 수 있도록
    테스트 코드를 먼저 만들고, 테스트를 성공하게 해주는 코드를 작성하는 방식의 개발 방법
    "실패한 테스트를 성공시키기 위한 목적이 아닌 코드는 만들지 않는다."
    
#### JUnit 테스트 클래스 수행 순서
    1. 테스트 클래스에서 @Test가 붙은 public, void 형의 파라미터가 없는 테스트 메소드를 찾는다.
    2. 테스트 클래스의 오브젝트를 만든다.
    3. @Before가 붙은 메소드 실행
    4. @Test 붙은 메소드를 호출하고 테스트 결과를 저장
    5. @After가 붙은 메소드 실행
    6. 나머지 테스트 메소드에 대해 2-5 까지 반복
    7. 모든 테스트 결과를 종합
    
    테스트 메소드를 실행할 때마다 새로운 오브젝트를 만듬
    각 테스트가 서로 영향을 주지 않고 독립적으로 실행함을 보장해주기 위해
    
#### 픽스처
    fixture
    테스트를 수행하는 데 필요한 정보나 오브젝트
    일반적으로 @Before 메소드를 이용해 생성
    
#### @BeforeClass
    테스트 클래스 전체에 걸쳐 한 번만 실행되는 스태틱 메소드
#### @ContextConfiguration
    테스트 컨텍스트 프레임워크
    여러개의 클래스 내에서 어플리케이션 컨텍스트를 공유
#### @Autowired
    변수타입과 일치하는 컨텍스트 내의 빈을 찾아서 주입해준다.
    같은 타입의 빈이 두 개 이상 있는 경우에는 타입만으로는 어떤 빈을 가져올지 결정할 수 없다.
    빈 하나를 선택할 수 없는 경우에는 "변수의 이름과 같은 이름의 빈"이 있는지 확인
    
#### @DirtiesContext
    스프링의 테스트 컨텍스트 프레임워크에게 해당 클래스의 테스트에서 
    애플리케이션 컨텍스트의 상태를 변경한다는 것을 알려줌.
    이 어노테이션이 붙은 테스트 클래스에는 애플리케이션 컨텍스트 공유를 허용하지 않음.

#### 테스트 방법 선택
    스프링 컨테이너 없이 테스트할 수 있는 방법
    
#### 정리
    테스트는 자동화
    JUnit 프레임워크를 이용하면 편리
    일관성이 있어야함
    포괄적으로 작성, 충분한 검증
    간격이 짧을수록 좋다
    테스트를 먼저 만들고 테스트를 성공시키는 코드를 만들기
    @Before, @After 사용
    동일한 설정파일은 하나의 애플리케이션 컨텍스트 공유
    @Autowired 이용 
    학습 테스트
    버그 테스트
    
## 3. 템플릿
    
#### 분리와 재사용을 위한 디자인 패턴 적용
    변하는 성격이 다른 것을 찾아냄. ( 관심사의분리? )
#### 익명 내부 클래스
    상속할 클래스나 구현할 인터페이스를 생성자 대신 사용해서 다음과 같은 형태로 만들어 사용
    클래스를 재사용할 필요가 없고, 구현한 인터페이스 타입으로만 사용할 경우에 유용
    new 인터페이스이름(){ 클래스 본문 };
    
#### 스프링 빈으로 DI를 적용
    의존 관계 주입(DI)시 클래스 레벨에서 구체적인 의존과계가 만들어지지 않도록 인터페이스를 사용
    그러나 스프링 빈으로 DI 를 적용할 경우( 클래스 레벨 )의 이유 
    1. 스프링 컨테이너의 싱글톤 레지스트리 사용
        사용하는 인스턴스 변수가 읽기 전용( 여기선 DataSource ) 
    2. DI를 통해 다른 빈에 의존하고 있기 때문
        DI 를 적용할 클래스가 이미 다른 빈을 통해 DI를 사용하고 있을 경우
    3. 강한 결합이 필요한 경우
    
```diff
그저 인터페이스를 만들기가 귀찮으니까 그냥 클래스를 사용하자는 것은 잘못된 생각이다! 
```

#### 템플릿과 콜백
    템플릿은 고정된 작업 흐름을 가진 코드를 재사용한다는 의미
    콜백은 템플릿 안에서 호출되는 것을 목적으로 만들어진 오브젝트
    
#### 템플릿 / 콜백 패턴
    일반적인 DI 방식의 전략 패턴 구조 인데
    일반적인 DI는 템플릿에 인스턴스 변수를 만들어두고 사용할 의존 오브젝트를 수정자 메소드로 받지만
    템플릿 / 콜백 방식에서는 매번 메소드 단위로 사용할 오브젝트를 새롭게 전달받는다.
    전략 패턴과 DI의 장점을 익명 내부클래스 사용 전략과 결합한 활용법
    
    템플릿( 메소드 )에 사용할 콜백 인터페이스를 전달받아 실행

#### JdbcTemplate
    스프링이 제공하는 JDBC 코드용 기본 템플릿

###### update()
```java
public class UserDao {
    // PreparedStatementCreator 를 매개변수로 받음
    public void deleteAll() throws SQLException{
        this.jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        return con.prepareStatement("delete from users");
                    }
                }
        );
    }
    // SQL 문을 매개변수로 받음
    public void deleteAll() {
        this.jdbcTemplate.update("delete from users");
    }

}
```
###### queryForObject()
```java
public class UserDao {
    public int getCount(){
        // 첫째 매개변수로 PreparedStatementCreator
        // 두번째 매개변수로 ResultSetExtractor
        return this.jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                return con.prepareStatement("select count(id) from users");
            }
        }, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                rs.next();
                // 리턴값을 넘겨줌
                return rs.getInt(1);
            }
        });
    }
}
```
```java
public class UserDao {
    public User get(String id) {
        // queryForObject는 호출 시 한개의 오브젝트만 리턴 받을 것으로 예상함
        // ? 에 바인딩할 값들을 두번째 매개변수에 Object[] 형태로 넣어줌
        // 세번째 매개변수인 RowMapper 구현체가 리턴한 User 가 실제 queryForObject 의 리턴값으로 반환됨
        // 반환할 값이 없을 경우 EmptyResultDataAccessException 반환
        return this.jdbcTemplate.queryForObject("select * from users where id = ? ",
                new Object[]{id},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setName(rs.getString("name"));
                        user.setPassword(rs.getString("password"));
                        return user;
                    }
                });
    }
}
```
```java
public class UserDao {
    public List<User> getAll() {
        // 여러개의 로우 값이 반환 될 경우 query() 메소드 사용
        return this.jdbcTemplate.query("select * from users order by id", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });

    }
}
```
```diff
언제나 네거티브 테스트를 먼저 작성할 것!
```
## 4. 예외

#### 잘못된 예외처리
    예외 블랙홀
        try {
            ...
        } catch(SQLException e){
        }
        - 예외를 잡고는 아무것도 하지 않는다. 예외 발생을 무시한다.
        실제 예외가 발생하면 무시하고 진행하기 때문에, 나중에 예외를 찾는 것도 힘들다.
    
        try {
            ...
        } catch(SQLException e){
            e.printStackTrace();
        }
        - 예외를 잡고 메시지를 출력한다. 계속 로그화면을 볼때면 모르겠지만 실제 운영서버에서
          다른 로그나 메시지에 금방 묻혀버리게 됨.
          출력은 예외처리가 아니다!
    
    무책임한 throws
        public void method1() throws Exception {
            method2();
            ...        
        }
        public void method2() throws Exception {
            method3();
            ...        
        }
        public void method3() throws Exception {
            ...        
        }
        
        - 기계적으로 예외를 throws 함
    
#### 예외의 종류
    Error
        java.lang.Error 클래스의 서브클래스
        에러는 시스템에 뭔가 비정상적인 상황이 발생했을 경우에 사용
        OutOfMemoryError 나 ThreadDeath 같은 에러는 어플리케이션 코드에서
        catch 블록으로 잡아도 대응 방법이 없음
        따라서 시스템 레벨에서 특별한 작업을 하는 게아니라면 에러에 대한 처리는
        신경 쓰지 않아도 됨.
    Checked Exception
        RuntimeException( Unchecked Exception ) 을 상속하지 않은 것을 말함
        사용한 메소드가 체크 예외를 던진다면 ( throws ...Exception )
        catch 구문을 통해 예외 처리를 해주던지, throws 를 통해 메소드 밖으로 던져야 함
    Unchecked Exception ( RuntimeException )
        java.lang.RuntimeException 클래스를 상속한 예외
        따로 catch 문이나 throws 를 통하여 예외 처리를 하지 않아도 됨. ( 강제가 아니라는 뜻 )
        
#### 예외 처리 방법
###### 예외 복구
    catch 구문을 통하여 정해진 로직을 수행
###### 예외 회피
    throws 를 통하여 예외를 메소드 밖으로 던짐
    ( 기계적 throws 를 발생시키지 않기 위해선
      다른 오브젝트에게 예외처리 책임을 분명히 지게 하거나,
      자신이 사용하는 쪽에서 예외를 다루는게 최선의 방법이라는 
      확신이 있어야 한다. )
###### 예외 전환
    첫번째 경우는
    
    예외 발생 시 더 적절한 의미 부여를 위해 다른 Exception 으로 전환하여 throws
    예외 전환 때에는 중첩 예외로 만드는 것이 좋다
    
    catch(SQLException e){
        if(...){
            throws DuplicateUserIdException(e);
        }
    }
    
    catch(SQLException e){
        if(...){
            throws DuplicateUserIdException().initCause(e);
        }
    } 
    
    두번째 경우는
    
    예외를 처리하기 쉽고 단순하게 만들기 위해 "포장"하는 것
    중첩 예외를 이용해 새로운 예외를 만들고 원인이 되는 내부에 담아서 던짐
    
    catch(NamingException ne) {
        throw new EJBException(ne);
    } catch(SQLException se) {
        throw new EJBException(se);
    } catch(RemoteException re) {
        throw new EJBException(re);
    }

###### 예외 처리 전략
    
    런타임 예외의 보편화
        체크 예외를 애플리케이션 차원에서 미리 파악하고 차단
        대응이 불가능한 체크 예외를 런타임 예외로 전환
        
```java
public class UserDao {
    public void add(User user) throws DuplicateUserIdException {
        try {
            this.jdbcContext.executeSql(user, "insert into users(id, name, password) values(?, ?, ?)");
        } catch (SQLException e) {
            if (e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY) {
                throw new DuplicateUserIdException(e); // 예외 전환
            } else {
                throw new RuntimeException(e); // 예외 포장
            }
        }
    }
}
```
    애플리케이션 예외
        시스템 또는 외부의 예외상황이 원인이 아니라 
        애플리케이션 자체의 로직에 의해 의도적으로 발생시키고,
        반드시 catch 해서 무엇인가 조치를 취하도록 요구하는 예외
    
#### JDBC 의 한계

###### 비표준 SQL
    SQL 은 어느정도 표준화된 언어이고 규약이 있지만,
    대부분 DB는 표준을 따르지 않는 비표준 문법과 기능도 제공한다.
    비표준 SQL을 사용 할 경우 DB 가 바뀔 때마다 DAO 를 생성해야 한다.
    
###### 호환성 없는 SQLException 의 에러정보
    DB 를 사용하다가 발생된 예외의 원인은 매우 다양한데,
    이 모든 오류는 SQLEception 한가지만 던지도록 설계되어 있다.
    그래서 getErrorCode() 로 분류하여 예외 처리를 하는데
    이 ErrorCode 는 DB 별로 다르다.
    
    그래서 SQLException 은 예외가 발생했을 때의 DB 상태를 담은
    SQL 상태정보를 부가적으로 제공
    getSQLState() 메소드로 예외 상황에 대한 상태 정보를 가져올 수 있다.
    
    하지만 DB의 JDBC 드라이버에서는 상태 코드를 정확하게 만들어 주지 않는다???
    
#### SQLException 에러 코드 매핑을 통한 전환
    결국 상태 코드는 정확하지 않다는 걸 알았음.
    차라리 DB 업체별로 만들어 유지해오고 있는 DB 전용 에러 코드를 사용하자
    스프링은 DB별 에러 코드를 분류해서 스프링이 정의한 예외 클래스와 매핑해놓은
    에러 코드 매핑정보 테이블을 만들어 두고 이를 이용하고 있음.
    
#### DAO 인터페이스
    자바에서는 JDBC 이외에도 데이터 엑세스를 위한 표준 기술이 존재
    JDO, JPA 와 같은 표준 퍼시스턴스 기술, TopLink, Hibernate 같은 ORM 기술,
    JDBC 와 비슷한 iBatis ( MyBatis ) 등이 있다.
    
    DataAccessException 은 데이터 엑세스 기술의 종류와 상관없이 예외를 발생하도록 만들어준다.

#### DataAccessException 계층 구조
    데이터 엑세스 기술에 상관없이 데이터 기술을 부정확하게 사용했을 때는
    InvalidDataAccessResourceUsageException 예외가 던져짐
    이를 세분화 하면 BadSqlGrammarException, HibernateQueryException,
    TypeMismatchDataAccessException 등으로 구분된다.
    
    또는 낙관적인 라킹 ( optimistic locking, 같은 정보를 두 명 이상의 사용자가 동시에 접속할 때
    뒤늦게 업데이트한 것이 먼저 업데이트한 것을 덮어쓰지 않도록 막아주는 기능 ) 이 발생할 수 있다.
    이 또한 데이터 엑세스 기술에 상관 없이 ObjectOptimisticLockingFailureException 을 발생시킨다.
    
    etc...
    
#### DataAccessException 활용 시 주의사항
    스프링을 활용하면 DB 종류나 데이터 엑세스 기술에 상관없이 
    키 값이 중복이 되는 상황에서는 동일한 예외가 발생하리라고 기대할 것이다.
    그러나 DUplicateKeyException은 아직까지 JDBC를 이용하는 경우에만 발생한다.
    데이터 엑세스 기술은 Hibernate나 JAP를 사용했을 때는 다른 예외가 던져진다.
    그 이유는 SQLException 에 담긴 DB의 에러 코드를 바로 해석하는 JDBC의 경우와 달리
    Hibernate, JPA, JDO 등에서는 각 기술이 재정의한 예외를 가져와 최종적으로 DataAccessException으로
    변환하는데 DB의 에러 코드와 달리 이런 예외들은 세분화 되어 있지 않기 때문
    
    한마디로 예외 전환을 하는데 실제 발생하는 에러 코드가 다 달라서 최종 DataAccessException 으로는
    넘어오지만 까보면 서로 다른 예외들로 이루어져 있다는 뜻?
    
#### 스프링에서 SQLException 을 DataAccessException 으로 전환하는 방법
###### DB 에러 코드 이용
```java
public class DaoTest{
    public void sqlExceptionTranslate() {
        dao.deleteAll();
        try {
            User user1 = new User("gyumee", "박성철", "springno1");
            dao.add(user1);
            dao.add(user1);
        } catch (DuplicateKeyException ex) {
            SQLException sqlException = (SQLException) ex.getRootCause();
            SQLExceptionTranslator set =
                    new SQLErrorCodeSQLExceptionTranslator(this.dataSource);
            Assert.assertEquals(set.translate(null, null, sqlException), DuplicateKeyException.class);
        }
    }
}
```    
## 5. 서비스 추상화
    서비스 추상화 할때는 필요한 기능을 관심사별로 묶고 그에 따른 클래스 작성
    전략 패턴 방식 적용 하면 좋음
    Test 코드 작성 시 오류날 상황 고려
    등등 위에서 했던 방법이랑 같음
    
    프로그램 로직 진행 시 어떤 내용이 필요할 지 미리 예상
    
#### 트랜잭션 서비스 추상화

    DB는 완벽한 트랜잭션 서비스를 지원함
    SQL을 이용해 다중 로우의 수정이나 삭제를 위한 요청을 했을 경우 일부만 삭제 또는 수정되는 경우는 없다.
    그러나 여러 개의 SQL이 사용되는 작업을 하나의 트랜잭션으로 취급해야 하는 경우엔 트랜잭션 서비스 구현
    
    첫번째 SQL 성공 후 두번째 SQL이 실패했을 경우 처리한 SQL 작업을 취소시키는 것을 트랜잭션 롤백
    여러가지 SQL 이 성공적으로 마무리 됐을 경우 DB에 알려줘 작업을 확정시키는 것을 트랜잭션 커밋
    
    JDBC 의 트랜잭션은 하나의 Connection 을 가져와 사용하다가 닫는 사이에 일어난다.
    트랜잭션이 한 번 시작되면 commit() 또는 rollback() 메소드가 호출될 때까지의 작업이
    하나의 트랜잭션으로 묶인다.
    
    setAutoCommit(false) 으로 트랜잭션의 시작을 선언하고
    commit() 또는 rollback() 으로 트랜잭션을 종료하는 작업을 트랜잭션의 경계설정 이라고 한다.
    
    하나의 DB 커넥션 안에서 만들어지는 트랜잭션을 로컬 트랜잭션 이라고 한다.
    
    트랜잭션 동기화
        트랜잭션을 시작하기 위해 만든 Connection 오브젝트를 특별한 저장소에 보관해두고
        호출되는 DAO 의 메소드에서 저장된 Connection을 가져다가 사용하게 하는 것
        
###### 스프링이 제공하는 트랜잭션 동기화
    트랜잭션 동기화 작업 초기화
    TransactionSynchronizationManager.initSynchronization();
    
    DataSourceUtils.getConnection(dataSource); 를 통해
    DB Connection 생성
    DataSource에서 직접 가져오지 않고 DataSourceUtils 를 이용 하는 이유는
    Connection 오브젝트 뿐만 아니라 트랜잭션 동기화에 사용하도록 저장소에 바인딩 ??
    
    예외가 발생하지 않으면 c.commit();
    예외 발생 시 c.rollback(); throw e;
    
    마지막으로 커넥션을 닫고 동기화 작업 중단 
    DataSourceUtils.releaseConnection(c, dataSource);
    TransactionSynchronizationManager.unbindResource(this.dataSource);
    TransactionSynchronizationManager.clearSynchronization();
    
```java
public class Transaction{
    public void upgradeLevels() throws Exception {
            TransactionSynchronizationManager.initSynchronization();
            Connection c = DataSourceUtils.getConnection(dataSource);
            c.setAutoCommit(false);
    
            try {
                List<User> userList = userDao.getAll();
                for (User user : userList) {
                    if (canUpgradeLevel(user)) {
                        upgradeLevel(user);
                    }
                }
                c.commit();
            } catch (Exception e) {
                c.rollback();
                throw e;
            } finally {
                DataSourceUtils.releaseConnection(c, dataSource);
                TransactionSynchronizationManager.unbindResource(this.dataSource);
                TransactionSynchronizationManager.clearSynchronization();
            }
        }
}
```

###### 글로벌 트랜잭션
    한 Connection 만 컨트롤 하는 로컬 트랜잭션으로는
    한 트랜잭션에서 여러 DB ( Connection ) 을 사용하는 로직에서는 사용할 수가 없다.
    자바는 JDBC 외에 글로벌 트랜잭션을 지원하는 JTA 를 제공하고 있다 
    그러나 사용할 DB에 따른 트랜잭션 관리 코드가 다를 수 있다는 점이다. // ★ 3.1 5장 369p
    
    그래서 스프링에서는 트랜잭션의 경계 설정을 담당하는 코드의 패턴을 추상화 시킨
    FlatformTransactionManager 를 구현한 DataSourceTransactionManager 사용
    
```java
public class Transaction {
    public void upgradeLevels() throws Exception {
        PlatformTransactionManager transactionManager =
                new DataSourceTransactionManager(dataSource);

        TransactionStatus status =
                transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            List<User> userList = userDao.getAll();
            for (User user : userList) {
                if (canUpgradeLevel(user)) {
                    upgradeLevel(user);
                }
            }
            transactionManager.commit(status);
        } catch (RuntimeException e) {
            transactionManager.rollback(status);
            throw e;
        }

    }
}
```
    만약 JTA를 이용하는 글로벌 트랜잭션으로 변경한다면
    PlatformTransactionManager 를 JTATransactionManager로 구현
    Hibernate를 이용한다면 HibernateTransactionManager
    JPA를 이용한다면 JPATransactionManager 로 구현하면 된다.
    
#### 단일 책임 원칙
    Single Responsibility Principle
    하나의 모듈은 한 가지 책임을 가져야 한다.
    
    단일 책임 원칙을 잘 지키고 있다면, 어떤 변경이 필요할 때 수정 대상이 명확해진다.
    기술이 바뀌면 기술계층과의 연동을 담당하는 기술 추상화 계층의 설정만 바꿔주면 된다.
    
#### 테스트 대역의 종류와 특징
    테스트 대역 ( test double )
        테스트 환경을 만들어주기 위해 테스트 대상이 되는 오브젝트의 기능에만 충실하게
        수행하면서 빠르게, 자주 테스트를 실행할 수 있도록 사용하는 오브젝트
    테스트 스텁 ( test stub )
        테스트 대상 오브젝트의 의존객체로서 존재하면서 테스트 동안에 코드가 
        정상적으로 수행할 수 있도록 돕는 것
    목 오브젝트 ( mock object )
        스텁처럼 테스트 오브젝트가 정상적으로 실행되도록 도와주면서, 
        테스트 오브젝트와 자신의 사이에서 일어나는 커뮤니케이션 내용을 저장해뒀다가
        테스트 결과를 검증하는 데 활용
    목 오브젝트 테스트
        보통의 테스트 방법으로는 검증하기 까다로운 테스트 대상 오브젝트의 내부에서
        일어나는 일이나 다른 오브젝트 사이에서 주고받는 정보까지 검증하는 일이 손쉬움
    
## 6. AOP
    Aspect Oriented Programming
    관점 지향 프로그래밍
    
#### 테스트 메소드 작성
    테스트 메소드 작성시 의존관계가 깊은, 많은 오브젝트들을 제외하는 것이 좋다.
    왜냐 간단한 테스트 실행시에도 필요한 모든 의존도를 설정해야 하니까
    예를들어 DB에서 데이터 하나 가져오는 동안
    DataSource, JDBCTemplate, Dao 등 여러가지의 의존관계를 설정해줘야함
    그리고 테스트 시간 자체도 더 오래걸림
    그래서 고립된 테스트가 가능하도록 Mock 오브젝트를 만듬
    
    이때 의존관계 설정을 해놓은 interface 의 메소드를 구현하고
    Mock 필드 메소드를 작성 ( 테스트에 사용하지 않을 메소드는 throw Exception 시킴 )
    
    가이드라인
        - 항상 단위 테스트를 먼저 고려한다.
        - 테스트 대역을 이용하여 테스트를 만든다.
        - 외부 리소스를 사용해야만 가능한 테스트는 통합 테스트로 만든다.
        - DAO 테스트는 DB라는 외부 리소스를 사용하기 때문에 통합 테스트로 분류
        - 여러 개의 단위가 의존관계를 가지고 동작할 때를 위한 통합 테스트가 필요
        - 스프링 테스트 컨텍스트 프레임워크를 이용하는 것도 통합 테스트
      
    Mock 프레임워크
        목 오브젝트를 편리하게 작성하도록 도와주는 프레임워크
        
    Mockito
        1. 인터페이스를 이용해 목 오브젝트를 만든다.
        2. 목 오브젝트가 리턴할 값이 있으면 이를 지정해준다.
           메소드가 호출되면 예외를 강제로 던지게 만들 수도 있다.
        3. 테스트 대상 오브젝트에 DI 해서목 오브젝트가 테스트 중에 사용되도록 만든다.
        4. 테스트 대상 오브젝트를 사용한 후에 목 오브젝트의 특정 메소드가 호출 됐는지
           어떤 값을 가지고 몇 번 호출됐는지를 검증한다.
           
```java

import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Test
    public void mockUpgradeLevels() throws Exception {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        // 다이나믹한 목 오브젝트 생성과 메소드의 리턴 값, DI 설정
        UserDao mockUserDao = mock(UserDao.class);
        when(mockUserDao.getAll()).thenReturn(this.userList);
        userServiceImpl.setUserDao(mockUserDao);
        
        // 리턴 값이 없는 메소드를 가진 목 오브젝트는 더욱 간단함
        MailSender mockMailSender = mock(MailSender.class);
        userServiceImpl.setMailSender(mockMailSender);

        userServiceImpl.upgradeLevels();

        // times() : 메소드 호출 횟수 검증
        // any() : 파라미터 무시 호출 횟수만 확인
        verify(mockUserDao, times(2)).update(any(User.class));
        verify(mockUserDao, times(2)).update(any(User.class));
        verify(mockUserDao).update(userList.get(1));
        Assert.assertEquals(userList.get(1).getLevel(),Level.SILVER);
        verify(mockUserDao).update(userList.get(3));
        Assert.assertEquals(userList.get(3).getLevel(),Level.GOLD);

        // ArgumentCaptor 는 오브젝트에 전달된 파라미터를 가져와 내용을 검증할때 유용 
        ArgumentCaptor<SimpleMailMessage> mailMessageArg =
                ArgumentCaptor.forClass(SimpleMailMessage.class);

        verify(mockMailSender,times(2)).send(mailMessageArg.capture());
        List<SimpleMailMessage> mailMessages = mailMessageArg.getAllValues();
        Assert.assertEquals(mailMessages.get(0).getTo()[0],userList.get(1).getEmail());
        Assert.assertEquals(mailMessages.get(1).getTo()[0],userList.get(3).getEmail());
    }
}
```
#### 다이나믹 프록시와 팩토리 빈

###### 프록시
    확장성을 고려해서 한 가지 기능을 분리한다면 전략패턴을 사용하면 된다.
    
    부가적인 기능을 위임을 통해 외부로 분리했을 때
    구체적인 구현 코드는 제거했을지라도 위임을 통해 
    기능을 사용하는 코드는 핵심 코드와 함께 남아있다.
    
    이렇게 분리된 부가기능을 담은 클래스는 중요한 특징이 있다.
    부가기능 외의 나머지 모든 기능은 원래 핵심기능을 가진 클래스로 위임해줘야 한다.
    핵심기능은 부가기능을 가진 클래스의 존재 자체를 모른다.
    따라서 부가기능이 핵심기능을 사용하는 구조가 되는 것이다.
    
    부가기능 코드에서는 핵심기능으로 요처을 위임해주는 과정에서 자신이 가진
    부가적인 기능을 적용해줄 수 있다.
    
    이렇게 마치 자신이 클라이언트가 사용하려고 하는 실제 대상인 것처럼 위장해서
    클라이언트의 요청을 받아주는 것을 대리자, 대리인 역할을 하는 프록시 라고 한다.
    
    프록시는 사용목적에 따라 두 가지로 구분할 수 있다.
    1. 클라이언트가 타깃에 접근하는 방법을 제어하기 위함.
    2. 타깃에 부가적인 기능을 부여해주기 위함

###### 데코레이터 패턴
    타깃에 부가적인 기능을 런타임 시 다이나믹하게 부여해주기 위해 프록시를 사용하는 패턴
    
    데코레이터라 불리는 이유는 마치 제품이나 케익 등을 여러 겹으로 포장하고
    그 위에 장식을 붙이는 것처럼 실제 내용물은 동일하지만
    부가적인 효과를 부여해줄 수 있기 때문이다.
    
    데코레이터 패턴은 인터페이스를 통해 위임하는 방식이기 때문에
    어느 데코레이터에서 타깃으로 연결될지 코드 레벨에선 미리 알 수 없다.

```java
public class HelloTarget implements Hello {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String sayHi(String name) {
        return "Hi " + name;
    }

    @Override
    public String sayThankYou(String name) {
        return "Thank You " + name;
    }
}
```
###### 프록시 패턴
    타깃에 대한 접근 방법을 제어하려는 목적으로 사용하는 패턴
    
    클라이언트에게 타깃에 대한 레퍼런스를 넘겨야 할때, 
    실제 타깃 오브젝트를 만드는 것 대신 프록시를 넘겨준다.
    그리고 프록시의 메소드를 통해 타깃을 사용하려고 시도할때, 
    프록시가 타깃 오브젝트를 생성하고 요청을 위임해준다.
    
    또는 특정 상황에서 타깃에 대한 접근권한을 제어하기 위해 사용하기도 한다.
    특정 메소드를 사용하려고 하면 접근이 불가능하다는 예외를 발생시킨다.

```java
public class HelloUppercase implements Hello {

    Hello hello;

    public HelloUppercase(Hello hello) {
        this.hello = hello;
    }

    @Override
    public String sayHello(String name) {
        return hello.sayHello(name).toUpperCase();
    }

    @Override
    public String sayHi(String name) {
        return hello.sayHi(name).toUpperCase();
    }

    @Override
    public String sayThankYou(String name) {
        return hello.sayThankYou(name).toUpperCase();
    }
}
```
###### 다이나믹 프록시

    프록시를 만들기 번거로운 이유
    1. 타깃의 인터페이스를 구현하고 위임하는 코드를 작성하는 것
       메소드가 많고 다양해지면 부담스러워 지기도 하며, 타깃 인터페이스의 메소드가
       변경되었을 시 모두 수정해줘야 함
    2. 부가기능 코드가 중복될 가능성이 많다는 점
    
    프록시 패턴의 단점은 매번 프록시를 만드는 것이 번거롭다는 점
    기능 확장, 접근 방법 제어를 위해 매번 클래스를 정의해야 하고, 
    인터페이스의 구현해야 할 메소드는 일일히 구현해서 위임하는 코드를 넣어줘야 하기 때문
    
    그래서 자바는 java.lang.reflect 패키지 안에 
    프록시를 손쉽게 만들 수 있도록 하는 클래스를 지원해준다.
    
```java
public class Proxy {
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
        Objects.requireNonNull(h);
        Class<?> caller = System.getSecurityManager() == null ? null : Reflection.getCallerClass();
        Constructor<?> cons = getProxyConstructor(caller, loader, interfaces);
        return newProxyInstance(caller, cons, h);
    }
}

public class HelloTargetTest {
    public void dynamicProxyPattern() {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(), // 클래스 로더 제공 다이나믹 프록시가 정의되는 클래스 로더 지정
                new Class[]{Hello.class}, // 다이나믹 프록시가 구현해야 할 인터페이스
                new UppercaseHandler(new HelloTarget()) // 부가기능과 위임관련 코드를 담고있는 InvocationHandler 구현 오브젝트
        );
    }
}
```
       
###### 리플렉션
    자바의 코드 자체를 추상화해서 접근하도록 만든것
    
    자바의 모든 클래스는 그 클래스 자체의 구성정보를 담은 Class 타입의 오브젝트를 갖고 있다.
    클래스이름.class 또는 오브젝트.getClass() 를 통하여 Class 타입의 오브젝트를 가져올 수 있다.
    이 오브젝트를 통해 클래스의 이름, 필드, 이름, 상속, 인터페이스 등 메타정보를 가져올 수 있다.
    e.g) 메소드 정보 추출
    Method lengthMethod = String.class.getMethod("length");
    메소드 사용 ( invoke() )
    int length = lengthMethod.invoke(name);
    
###### 다이나믹 프록시 확장
```java
public class UppercaseHandler implements InvocationHandler {

//    Hello target;
    Object target;

    public UppercaseHandler(/*Hello target*/Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        String ret = (String) method.invoke(target, args); // 타깃으로 위임, 인터페이스의 모든 메소드 호출에 적용
//        return ret.toUpperCase(); // 부가기능

        Object ret = method.invoke(target, args);
        // String 일 경우에만 대문자로 변환 ( return 타입이 Integer 인 인터페이스 메소드가 추가 되더라도 영향이 없도록
        // method 의 이름이 say 시작할 경우에만
        if (ret instanceof String && method.getName().startsWith("say")) {
            return ((String) ret).toUpperCase();
        } else {
            return ret;
        }
    }
}
```
###### 다이나믹 프록시 팩토리 빈 적용
    스프링의 빈은 기본적으로 클래스 이름과 프로퍼티로 정의됨
    스프링은 지정된 클래스 이름을 가지고 리플렉션을 이용해서 해당 클래스의 오브젝트를 만듬
    그러나 다이나믹 프록시 오브젝트의 클래스가 어떤 것인지 알 수 없다.
    따라서 사전에 프록시 오브젝트의 크래스 정보를 미리 알아내서 스프링의 빈에 정의할 방법이 없다는 뜻이다.
    
    팩토리 빈
        스프링을 대신해서 오브젝트의 생성로직은 담당하도록 만들어진 특별한 빈
        FactoryBean 인터페이스를 구현

```java
public class Message {
    String text;
    
    // 생성자를 접근 불가하게 만들고
    private Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // 스태틱메소드를 사용해서 생성하게 만들어 놨을때 
    public static Message newMessage(String text) {
        return new Message(text);
    }
}
```
    <bean id="m" class="proxy.Message"> // private 생성자를 가진 클래스 직접 사용 금지
    
```java
public class MessageFactoryBean implements FactoryBean<Message> {
    String text;
    
    // 프로퍼티 설정 
    public void setText(String text) {
        this.text = text;
    }
    
    // 실제 빈으로 사용될 오브젝트를 직접 생성 
    @Override
    public Message getObject() throws Exception {
        return Message.newMessage(this.text);
    }

    @Override
    public Class<?> getObjectType() {
        return Message.class;
    }

    // getObject() 메소드가 돌려주는 오브젝트가 싱글톤인지를 알려준다.
    // 이 팩토리 빈은 매번 요청할 때마다 새로운 오브젝트를 만드므로 false 로 설정한다.
    // 이것은 팩토리 빈의 동작방식에 관한 설정이고 만들어진 빈 오브젝트는 싱글톤으로 스프링이 관리해줄 수 있다.
    public boolean isSingleton() {
        return false;
    }
}
```

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration // locations 지정하지 않으면 Class명-context.xml 로 자동 매핑됨
public class FactoryBeanTest {
    @Autowired
    ApplicationContext context;

    @Test
    public void getMessageFromFactoryBean() {
        Object message = context.getBean("message");
        assertThat((Message) message, is(Message.class));
        assertThat(((Message) message).getText(), is("Factory Bean"));
    }

    @Test
    public void getFactoryBean() throws Exception {
        Object factory = context.getBean("&message"); // &을 붙여주면 오브젝트가 아닌 팩토리 빈 자체를 리턴해줌
        assertThat((MessageFactoryBean) factory, is(MessageFactoryBean.class));
    }
}
```
    다이나믹 프록시를 스프링의 빈으로 등록하기 위해 팩토리 빈을 사용한다.
    팩토리 빈의 getObject() 메소드에 다이나믹 프록시 오브젝트를 만들어주는 코드를 삽입

```java
public class TxProxyFactoryBean implements FactoryBean<Object> {
    Object target;
    PlatformTransactionManager transactionManager;
    String pattern;
    Class<?> serviceInterface;

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setServiceInterface(Class<?> serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public Object getObject() throws Exception {
        TransactionHandler txHandler = new TransactionHandler();
        txHandler.setTarget(target);
        txHandler.setPattern(pattern);
        txHandler.setTransactionManager(transactionManager);
        return Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{serviceInterface},
                txHandler
        );
    }

    @Override
    public Class<?> getObjectType() {
        return serviceInterface;
    }
    
    // 싱글톤 빈이 아니라는 뜻 getObject() 가 
    // 매번 같은 오브젝트를 리턴 하지 않는다.
    @Override
    public boolean isSingleton() {
        return false;
    }
}
```
    <bean id="userService" class="proxy.TxProxyFactoryBean">
        <property name="target" ref="userServiceImpl"/>
        <property name="transactionManager" ref="transactionManager"/>
        <property name="pattern" value="upgradeLevels"/>
        <!--Class 타입은 value 를 이용해 클래스 또는 인터페이스의 이름을 넣어주면 됨
            스프링은 수정자 메소드의 파라미터 타입을 확인해서 프로퍼티의 타입이 Class 인 경우
            value로 설정한 이름을 가진 Class 오브젝트로 자동 변환해준다.-->
        <property name="serviceInterface" value="dao.service.UserService"/> 
    </bean>

###### 프록시 팩토리 빈 방식의 장점과 한계
    장점
    프록시 팩토리 빈의 재사용
        TransactionHandler 를 이용하는 다이나믹 프록시를 생성해주는 TxProxyFactoryBean은
        코드의 수정 없이도 다양한 클래스에 적용할 수 있다.
    다이나믹 프록시를 이용하면 타깃 인터페이스를 구현하는 클래스를 일일이 만드는 번거로움 제거
    하나의 핸들러 메소드를 구현하면 수많은 메소드에 부가기능 부여 가능, 중복 코드 사라짐
    한계
        부가기능 제공하는 것은 메소드 단위로 일어나는 일
        하나의 클래스 안에 존재하는 메소드에 부가기능을 제공할 순 있지만
        여러개의 클래스에 부가기능을 적용할 순 없다.
        
###### 타깃이 필요 없는 순수한 부가기능
```java
static class UppercaseAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String ret = (String) invocation.proceed();
        return ret;
    }

}
```
    MethodInterceptor 를 구현한 uppercaseAdvice 에는 타깃 오브젝트가 등장하지 않는다.
    MethodInvocatio 은 타깃 오브젝트의 메소드를 실행할 수 있는 기능이 있기 때문에
    MethodInterceptor 는 부가기능을 제공하는 데만 집중할 수 있다.
    
    MethodInvocation 의 proceed() 메소드를 실행하면 타깃 오브젝트의 메소드를
    내부적으로 실행해주는 기능이 있다.
    그렇다면 MethodInvocation 구현 클래스는 일종의 공유 가능한 템플릿처럼 동작하는 것

```java
public class DynamicProxyTest {
    @Test
    public void proxyFactoryBean() {
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new HelloTarget());
        pfBean.addAdvice(new UppercaseAdvice());

        Hello proxiedHello = (Hello) pfBean.getObject();
        assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
        assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
        assertThat(proxiedHello.sayThankYou("Toby"), is("THANK YOU TOBY"));
    }
}
```
    ProxyFactoryBean 에 MethodInterceptor 를 설정해줄 때는 일반적인 DI처럼
    수정자 메소드를 사용하는 대신 addAdvice() 라는 메소드를 사용한다.
    addAdvice() 메소드를 통해 ProxyFactoryBean 에는 
    여러 개의 MethodInterceptor 를 추가할 수 있다.

###### 부가기능 적용 대상 메소드 선정 방법
    TxProxyFactoryBean 은 pattern 이라는 메소드 이름 비교용 스트링 값을 DI 받아서
    TransactionHandler 를 생성할 때 이를 넘겨주고, TransactionHandler 는 요청이
    들어오는 메소드의 이름과 패턴을 비교해서 부가기능인 트랜잭션 적용 대상을 판별했다.
    
    스프링의 ProxyFactoryBean 과 MethodInterceptor 를 사용하는 방식에서는
    메소드 선정 기능을 사용할 수 없다. 
    MethodInterceptor 오브젝트는 여러 프록시가 공유해서 사용할 수 있기 때문에
    MethodInterceptor 오브젝트는 타깃 정보를 갖고 있지 않도록 만들었다.
    그 덕분에 MethodInterceptor 를 스프링의 싱글톤 빈으로 등록할 수 있었다.
    
    그래서 MethodInterceptor 에는 재사용 가능한 순수한 부가기능 제공 코드만 남겨준다.
    대신 프록시에 부가기능 적용 메소드를 선택하는 기능을 넣는다.
    
    스프링은 부가기능을 제공하는 오브젝트를 어드바이스라고 부르고,
    메소드 선정 알고리즘을 담은 오브젝트를 포인트컷이라고 부른다.
    어드바이스와 포인트컷은 모두 프록시에 DI로 주입돼서 사용된다.
    
    1. 프록시는 클라이언트로부터 요청을 받으면 
    2. 먼저 포인트컷에서 부가기능을 부여할 메소드인지 확인
    3. MethodInterceptor 타입의 어드바이스 호출
    4. 어드바이스가 부가기능을 부여하는 중에 타깃 메소드의 호출이 필요하면
    5. MethodInvocation 타입 콜백 오브젝트의 proceed() 메소드 호출

```java

public class DynamicProxyTest {
    @Test
    public void pointcutAdvisor() {
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new HelloTarget()); // 타겟 등록

        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("sayH*"); // 포인트 컷 등록

        pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice())); // 포인트컷에 대한 어드바이스 추가

        Hello proxiedHello = (Hello) pfBean.getObject();

        assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
        assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
        assertThat(proxiedHello.sayThankYou("Toby"), is("Thank You Toby"));
    }
}
```
    포인트컷이 필요없을 때는 ProxyFactoryBean 의 addAdvice() 메소드를 통하여 어드바이스를 추가함
    포인트컷과 함께 등록할 때는 Advisor 타입으로 묶어 addAdvisor() 메소드를 호출한다.
    여기서 굳이 오브젝트로 ( e.g DefaultPointcutAdvisor ) 묶어서 등록하는 이유는
    ProxyFactoryBean 에는 여러개의 어드바이스와 포인트컷이 추가될 수 있기 때문
    
    이렇게 포인트컷과 어드바이스를 묶은 오브젝트를 어드바이저 라고 부른다.
    어드바이저 = 포인트컷( 메소드 선정 알고리즘 ) + 어드바이스( 부가기능 )
    
###### 어드바이저의 빈 등록
    <bean id="transactionAdvice" class="proxy.TransactionAdvice">
        <property name="transactionManager" ref="transactionManager"/>
    </bean>

    <bean id="transactionPointcut" class="org.springframework.aop.support.NameMatchMethodPointcut">
        <property name="mappedName" value="upgrade*"/>
    </bean>

    <bean id="transactionAdvisor"
          class="org.springframework.aop.support.DefaultPointcutAdvisor">
        <property name="advice" ref="transactionAdvice"/>
        <property name="pointcut" ref="transactionPointcut"/>
    </bean>

    <bean id="userService" class="org.springframework.aop.framework.ProxyFactoryBean">
        <property name="target" ref="userServiceImpl"/>
        <property name="interceptorNames">
            <list>
                <value>transactionAdvisor</value>
            </list>
        </property>
    </bean>
    
#### 스프링 AOP
    
###### 빈 후처리기를 이용한 자동 프록시 생성기
    스프링 빈 오브젝트로 만들어지고 난 후에, 빈 오브젝트를 다시 가공할 수 있게 해준다.
    빈 후처리기 자체를 빈으로 등록하고 빈 오브젝트가 생성될 때마다 빈 후처리기에 보내서 후처리 작업을 요청
    빈 후처리기는 빈 오브젝트의 프로퍼티를 강제로 수정할 수도 있고 별도의 초기화 작업을 수행할 수도 있다.
    
    1. ( e.g) DefaultAdvisorAutoProxyCreator ) 빈 후처리기가 등록되어 있으면
    2. 스플이은 빈 오브젝트를 만들 때마다 후처리기에게 빈을 보낸다.
    3. DefaultAdvisorAutoProxyCreator 는 빈으로 등록된 모든 어드바이저 내의 포인트컷을 이용해
       전달받은 빈이 프록시 적용 대상인지 확인
    4. 적용 대상이면 내장된 프록시 생성기에게 현재 빈에 대한 프록시를 만들게하고
    5. 만들어진 프록시에 어드바이저를 연결해준다.
    6. 빈 후처리기는 프록시가 생성되면 원래 컨테이너가 전달해준 빈 오브젝트 대신
       프록시 오브젝트를 컨테이너에게 돌려준다.
    7. 컨테이너는 최종적으로 빈 후처리기가 돌려준 오브젝트를 빈으로 등록하고 사용한다.
    
    적용할 빈을 선정하는 로직이 추가된 포인컷이 담긴 어드바이저를 등록하고 빈 후처리기를 사용하면
    일일이 ProxyFactoryBean 을 등록하지 않아도 타깃 오브젝트에 자동으로 프록시가 적용되게 할 수 있다.
    
###### 포인트컷
    처음에 포인트컷은 타깃 오브젝트의 어떤 메소드에 부가기능을 적용할지를 선정해주는 역할
    포인트컷은 클래스 필터의 기능을 제공함
    클래스 필터를 이용하여 빈 후처리기를 이용하기 전 프록시를 적용할 클래스인지 판단할 수 있음
    
```java
public class DynamicProxyTest {
    @Test
    public void classNamePointcutAdvisor() {
        NameMatchMethodPointcut classMethodPointcut = new NameMatchMethodPointcut() {
            // getClassFilter Override 하여 ClassFilter 재정의
            public ClassFilter getClassFilter() {
                return new ClassFilter() {
                    @Override
                    public boolean matches(Class<?> clazz) {
                        return clazz.getSimpleName().startsWith("HelloT");
                    }
                };
            }
        };
        classMethodPointcut.setMappedName("sayH*");

        checkAdviced(new HelloTarget(), classMethodPointcut, true);

        class HelloWorld extends HelloTarget {};
        checkAdviced(new HelloWorld(), classMethodPointcut, false);

        class HelloToby extends HelloTarget {};
        checkAdviced(new HelloToby(), classMethodPointcut, true);
    }

    private void checkAdviced(Object target, Pointcut pointcut, boolean adviced) {
        ProxyFactoryBean pfBean
                = new ProxyFactoryBean();
        pfBean.setTarget(target);
        pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));
        Hello proxiedHello = (Hello) pfBean.getObject();
        if (adviced) {
            assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
            assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
            assertThat(proxiedHello.sayThankYou("Toby"), is("Thank You Toby"));
        } else {
            assertThat(proxiedHello.sayHello("Toby"), is("Hello Toby"));
            assertThat(proxiedHello.sayHi("Toby"), is("Hi Toby"));
            assertThat(proxiedHello.sayThankYou("Toby"), is("Thank You Toby"));
        }
    }
}
```
    자동 프록시 생성기 등록
    <bean class="org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator"/>
    
    포인트컷 등록
    <bean id="transactionPointcut" class="proxy.NameMatchClassMethodPointcut">
        <property name="mappedName" value="*ServiceImpl"/>
        <property name="mappedNames" value="upgrade*"/>
    </bean>
    
    ProxyFactoryBean 제거
    <bean id="transactionPointcut" class="proxy.NameMatchClassMethodPointcut">
        <property name="mappedClassName" value="*ServiceImpl"/>
        <property name="mappedName" value="upgrade*"/>
    </bean>
    
    Test 용 UserService 등록
    <!--parent 어트리뷰트는 다른 빈 설정의 내용을 상속받기 위함-->
    <bean id="testUserService" class="proxy.UserServiceTest$TestUserServiceImpl" parent="userService"/>
    
###### 자동 생성 프록시 확인
    1. 트랜잭션이 필요한 빈에 트랜잭션 부가기능이 적용 되었는가 ( 일반 테스트 )
    2. 아무 빈에나 트랜잭션 부가기능이 적용되지 않았는가 ( 역 테스트 ) -> mappedClassName 수정하여 테스트
    3. 생성한 객체의 타입이 Proxy 인지 아닌지
    
###### 포인트컷 표현식
    단순히 이름을 비교해서 클래스나 메소드를 선정하지 않고
    이보다 더 복잡하고 세밀한 기준을 이용하기 위해 스프링에서 제공하는 간단하고 효과적인 방법
    
    AspectJExpressionPointcut 클래스 사용
    execution( [ 접근제한자 패턴 ] (리턴)타입패턴 [ (패키지,클래스 이름)타입패턴. ] (메소드)이름패턴 ( (파라미터)타입패턴 | "..", ... ) [ throws 패턴 ] )
    
    bean() 메소드 사용
    e.g ) bean(*Service)
    
    Annotation 사용
    e.g ) @annotation(org.springframework.transaction.annotation.Trasactional)
    
    포인트컷 포현식을 사용하면 로직이 짧은 문자열에 담기기 때문에 클래스나 코드를 추가할 필요가 없어서
    코드와 설정이 모두 단순해진다. 반면에 문자열로 된 표현식이므로 런타임 시점까지 문법의 검증이나 기능
    확인이 되지 않는다는 단점이 있다. 포인트컷 표현식의 사용으로 얻을 수 있는 장점이 많은 만큼 충분한 학습과
    다양한 테스트를 통해 검증하는 과정이 필요하다.
    
###### 타입 패턴과 클래스 이름 패턴
    포인트컷 표현식에서는 클래스의 이름 패턴이 아닌 타입 패턴을 사용함
    따라서 타입 패턴 정의에 따른 클래스들에 모두 적용됨
    어떤 클래스의 슈퍼클래스 또는 구현 인터페이스의 이름을 정의해도 해당 클래스 또한 함께 적용된다.
    
#### AOP란
    트랜잭션 추상화
        인터페이스와 DI를 통해 무엇을 하는지를 남기고, 그것을 "어떻게 하는지를 분리"한 것
        
    프록시와 데코레이터 패턴
        DI를 이용한 데코레이터 패턴은 비즈니스 로직을 담은 클래스의 코드에는 전혀 영향을 주지 않으면서
        트랜잭션이라는 부가기능을 자유롭게 부여할 수 있는 구조를 만들어줌
        
    다이나믹 프록시와 프록시 팩토리 빈
        프록시를 이용하여 비즈니스 로직 코드에서 트랜잭션 코드는 제거했지만
        모든 메소드마다 트랜잭션 기능을 부여하는 코드를 넣어야 했음
        JDK 다이나믹 프록시 기술 적용하여 일부 메소드에만 트랜잭션 코드 적용
        그러나 오브젝트 단위로는 적용이 불가
        스프링 프록시 팩토리 빈을 이용하여 어드바이스와 포인트컷으로 분리 사용 가능
        
    자동 프록시 생성 방법과 포인트컷
        트랜잭션 적용 대상을 빈마다 설정해줘야 했음
        프록시를 정해진 패턴으로 자동 생성하게 함 ( 포인트컷 사용 )
    
    부가기능 모듈화
        관심사가 같은 코드를 객체지향 설계 원칙에 따라 분리하고,
        서로 낮은 결합도를 가진 채로 독립적이고 유연하게 확장할 수 있는 모듈로 만든다.
        
        그러나 트랜잭션 적용 코드의 경계설정 기능은 "다른 모듈의 코드에 부가적으로 부여되는 기능" 이라는
        특징 때문에 클래스를 만들지 않고도 새로운 구현 기능을 가진 오브젝트를 다이나믹하게 만들어야 했다.
        트랜잭션 부가기능은 타깃이 존재하고 각 타깃의 코드 안에 침투하거나 긴밀하게 연결되어 있어야 한다.
        
        개발자들은 이런 여기저기에 흩어져있는 부가기능들을 모듈화 시키기 위해
        DI, 데코레이터 패턴, 다이나믹 프록시, 오브젝트 생성 후처리, 자동 프록시 생성, 포인트컷과 같은 기법을
        사용했다. 그 결과 TransactionAdvice 라는 이름으로 모듈화될 수 있었다.
        
    Aspect Oriented Programming
        Aspect 란 그 자체로 애플리케이션의 핵심기능을 담고 있지는 않지만,
        애플리케이션을 구성하는 중요한 한 가지 요소이고, 핵심기능에 부가되어 의미를 갖는 특별한 모듈
        
        애플리케이션의 핵심적인 기능에서 부가적인 기능을 분리해서 애스팩트라는 독특한 모듈로 만들어서
        설계하고 개발하는 방법을 Aspect Oriented Programming 이라고 부른다.
        
        부가기능이 핵심기능 안으로 침투하면 핵심기능 설계에 객체지향 기술의 가치를 온전하게 부여하기 어렵다.
        부가된 코드로 인해 객체지향적인 설계가 주는 장점을 잃어버리기 쉽다.
        AOP는 애스팩트를 분리함으로써 핵심기능을 설계하고 구현할 때 
        객체지향적인 가치를 지킬 수 있도록 도와주는 것
        AOP는 결국 애플리케이션을 다양한 측면 ( 관점 )에서 독립적으로 모델링, 설계, 개발 할 수 있도록 도와주는 것이다.

#### AOP 적용 기술
    프록시를 이용한 AOP
        스프링 AOP의 부가기능을 담은 어드바이스가 적용되는 대상은 오브젝트의 메소드다.
        프록시 방식을 사용했기 때문에 메소드 호출 과정에 참여해서 부가기능을 제공해주게 되어있다.
        
    바이트코드 생성과 조작을 통한 AOP
        프록시처럼 간접적인 방법이 아니라, 타깃 오브젝트를 뜯어고쳐서 부가기능을 직접 넣어주는 방법을 사용
        컴파일된 타깃의 클래스 파일 자체를 수정하거나, 클래스가 JVM에 로딩되는 시점을 가로채서
        바이트코드를 조작하는 복잡한 방법을 사용
        복잡한데 사용하는 이유
            1. 바이트 코드를 조작하면 DI 컨테이너의 도움을 받아서 자동프록시 생성 방식을 사용하지 않아도 AOP 적용 가능
            2. 프록시 방식보다 훨씬 강력하고 유연한 AOP가 가능
               프록시 방식은 클라이언트가 호출할 때 사용하는 메소드로 제한되지만
               바이트코드 방식은 오브젝트의 생성, 필드값의 조회와 조작, 스태틱 초기화 등 다양한 작업에 부가기능 적용 가능
               
        단점 바이트코드 조작을 위해 JVM 실행 옵션 변경, 별도의 컴파일러, 특별한 클래스 로더를 사용하는 등 부가작업 필요

#### AOP 용어
    타깃 : 부가기능을 부여할 대상
    어드바이스 : 타깃에게 제공할 부가기능을 담은 모듈
    조인포인트 : 어드바이스가 적용될 수 있는 위치
    포인트컷 : 어드바이스를 적용할 조인 포인트를 선별하는 작업 또는 그 기능을 정의한 모듈
    프록시 : 클라이언트와 타깃 사이에 투명하게 존재하면서 부가기능을 제공하는 오브젝트
    어드바이저 : 포인트컷과 어드바이스를 하나씩 갖고 있는 오브젝트
    애스팩트 : 한개 또는 그 이상의 포인트컷과 어드바이스의 조합으로 만들어지며 보통 싱글톤 형태의 오브젝트로 존재
              클래스와 같은 모듈 정의와 오브젝트와 같은 실체의 구분이 특별히 없다.
    
#### 스프링 AOP 적용
    자동 프록시 생성기
        DefaultAdvisorAutoProxyCreator 클래스를 빈으로 등록한다.
        애플리케이션 컨텍스트가 빈 오브젝트를 생성하는 과정에 빈 후처리기로 참여한다.
        빈으로 등록된 어드바이저를 이용하여 프록시를 자동으로 생성하는 기능을 담당한다.
    어드바이스
        부가기능을 구현한 클래스를 빈으로 등록한다. TransactionAdvice 는 유일하게 "직접 구현한 클래스"를 사용한다.
    포인트컷
        스프링의 AspectJExpressionPointcut 을 빈으로 등록 
        expression 프로퍼티에 포인트컷 표현식을 넣어준다
    어드바이저
        스프링의 DefaultPointcutAdvisor 클래스를 빈으로 등록해 사용
        어드바이스와 포인트컷을 프로퍼티로 참조한다.
        
    xml 선언
        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns:aop="http://www.springframework.org/schema/aop" // 추가
               xsi:schemaLocation="http://www.springframework.org/schema/beans
                                   http://www.springframework.org/schema/beans/spring-beans.xsd
                                   http://www.springframework.org/schema/aop // 추가
                                   http://www.springframework.org/schema/aop/spring-aop-3.0.xsd"> //추가
                                   
        <aop:config>
            <aop:pointcut id="transactionPointcut" expression="execution(* *..*ServiceImpl.upgrade*(..))"/>
            <aop:advisor advice-ref="transactionAdvice" pointcut-ref="transactionPointcut"/>
        </aop:config>
        
        <aop:config>
        <!--<aop:pointcut id="transactionPointcut" expression="execution(* *..*ServiceImpl.upgrade*(..))"/>-->
        <!--<aop:advisor advice-ref="transactionAdvice" pointcut-ref="transactionPointcut"/>-->
            <aop:advisor advice-ref="transactionAdvice" pointcut="execution(* *..*ServiceImpl.upgrade*(..))"/>
        </aop:config>
#### 트랜잭션 속성
    DefaultTransactionDefinition 
```java
public class TransactionAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        TransactionStatus status =
                this.transactionManager.getTransaction(new DefaultTransactionAttribute()); // 트랜잭션 정의
        try {
            Object ret = invocation.proceed();
            this.transactionManager.commit(status); // 트랜잭션 종료
            return ret;
        } catch (RuntimeException e) {
            this.transactionManager.rollback(status); // 트랜잭션 종료
            throw e;
        }
    }
}
```
###### 트랜잭션 정의
    TransactionDefinition 인터페이스의 속성
    
    트랜잭션 전파
        트랜잭션의 경계에서 이미 진행 중인 트랜잭션이 있을 때 또는 없을 때 
        어떻게 동작할 것인가를 결정하는 방식
        
        PROPAGATION_REQUIRED
            가장 많이 사용되는 전파 속성
            진행 중인 트랜잭션이 없으면 새로 시작하고, 이미 시작된 트랜잭션이 있으면 이에 참여한다.
        PROPAGATION_REQUIRES_NEW
            항상 새로운 트랜잭션을 시작한다.
            앞에서 시작된 트랜잭션이 있든 없든 상관없이 새로운 트랜잭션을 만들어서 독자적으로 동작하게 한다.
        PROPAGATION_NOT_SUPPORTED
            진행 중인 트랜잭션이 있어도 무시한다.
            트랜잭션 없이 동작 가능
            전체 포인트컷에는 트랜잭션을 적용하지만 특정 트랜잭션을 "제외"할 때 사용
            
    격리수준
        모든 db 트랜잭션은 격리수준( isolation level )을 갖고 있어야 한다.
        가능하다면 모든 트랜잭션이 순차적으로 진행돼서 다른 트랜잭션의 작업에 독립되는 것이 좋겠지만,
        성능이 크게 떨어질 수 있다.
        따라서 적절하게 격리수준을 조정해서 가능한 많은 트랜잭션을 동시에 진행시키며, 
        문제가 발생하지 않게 하는 제어가 필요하다.
        
        격리수준은 기본적으로 DB에 설정되어 있지만 JDBC 드라이버나 DataSource 등에서 재설정이 가능하고,
        트랜잭션 단위로도 격리수준을 조정할 수 있다.
        
        ISOLATION_DEFAULT
            DataSource에 설정되어 있는 디폴트 격리수준을 그대로 따른다.
    
    제한시간
        트랜잭션을 수행하는 제한시간을 설정할 수 있다.
        DefaultTransactionDefinition 의 기본 설정은 제한시간이 없다.
    
    읽기전용
        읽기전용으로 설정해두면 트랜잭션 내에서 데이터를 조작하는 시도를 막아줄 수 있다.
        또한 데이터 엑세스 기술에 따라서 성능이 향상될 수도 있다.

###### 트랜잭션 인터셉터와 트랜잭션 속성
    메소드별로 다른 트랜잭션 정의를 적용하려면 어드바이스 기능을 확장해야 한다.
    초기의 Transactionhandler에서 메소드 이름을 이용해 트랝개션 적용 여부를 판단했던 것과 비슷한 방식을 사용한다.
    
    TransactionInterceptor
        TransactionInterceptor 어드바이스의 동작방식은 기존의 TransactionAdvice와 다르지 않다.
        그러나 트랜잭션 정의를 메소드 이름 패턴을 이용해서 다르게 지정할 수 있는 방법을 추가로 제공해준다.
        TransactionInterceptor 는 PlatformTransactionManager 와 Properties 타입의 두가지 프로퍼티가 있다.
        Properties 타입은 transactionAttributes로 트랜잭션 속성을 정의한 프로퍼티다.
        트랜잭션 속성은 TransactionDefinition 의 네가지 기본 항목에 rollbanckOn() 이라는 메소드를 하나 더 가지고 있는
        TransactionAttribute 인터페이스로 정의된다.
        rollbackOn() 메소드는 어떤 예외가 발생하면 롤백을 할 것인가를 결정하는 메소드다.
        
```java
public class TransactionAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        TransactionStatus status =
                this.transactionManager.getTransaction(new DefaultTransactionAttribute()); // 트랜잭션 정의
        try {
            Object ret = invocation.proceed();
            this.transactionManager.commit(status); // 트랜잭션 종료
            return ret;
        } catch (RuntimeException e) {
            this.transactionManager.rollback(status); // 트랜잭션 종료
            throw e;
        }
    }
}
```
    에서 TransactionAdvice는 RuntimeException 이 발생하는 경우에만 트랜잭션을 롤백시킨다.
    런타임 예외가 아닌 경우에는 트랜잭션이 제대로 처리되지 않고 메소드를 빠져나가게 되어 있다.
    
    스프링이 제공하는 TransactionInterceptor에는 기본적으로 두가지 종류의 예외처리 방식이 있다.
    1. 런타임 예외가 발생하면 트랜잭션은 롤백된다.
    2. 타깃 메소드가 런타임 예외가 아닌 체크 예외를 던지는 경우에는 예외상황으로 해석하지 않고
       일종의 비즈니스 로직에 따른, 의미가 있는 리턴 방식의 한 가지로 인식해서 트랜잭션을 커밋한다.
    
    그런데 TransactionInterceptor의 이러한 예외처리 기본 원칙을 따르지 않는 경우가 있을 수 있다.
    그래서 TransactionAttribute는 rollbackOn()이라는 속성을 둬서 기본 원칙과 다른 예외처리가 가능하게 해준다.
    이를 활용하면 특정 체크 예외의 경우는 트랜잭션을 롤백시키고, 특정 런타임 예외에 대해서는 트랜잭션을 커밋시킬 수도 있다.
    
###### 메소드 이름 패턴을 이용한 트랜잭션 속성 지정
    Propeties 타입의 transactionAttributes 프로퍼티는 메소드 패턴과 트랜잭션 속성을 키와 값으로 갖는 컬렉션이다.
    
    PROPAGATION_NAME ( 트랜잭션 전파 방식, 필수 항목, PROPAGATION_ 으로 시작함 ),
    ISOLATION_NAME ( 격리 수준, ISONLATION_ 으로 시작, 생략 가능 ),
    readOnly ( 읽기전용 항목, 생략 가능, default 값은 읽기전용이 아님 ),
    timeout_NNNN ( 제한시간, timeout_ 으로 시작, 초 단위 시간을 붙임, 생략 가능 ),
    -Exception1 ( 체크 예외 중에서 롤백 대상으로 추가할 것을 넣음, 한개 이상 등록 가능 ),
    +Exception2 ( 런타임 예외, 롤백시키지 않은 예외를 넣음, 한개 이상 등록 가능 )
    
    모든 런타임 예외는 롤백돼야 하지만, +XXXRuntimeException 이라고 해주면 커밋 가능
    반대로 체크 예외는 모두 커밋이 기본이지만, -를 붙여주면 롤백 대상이 됨.
    
    트랜잭션 속성 정의 예
    
    <bean id="transactionAdvice" class="org.springframework.transaction.interceptor.TransactionInterceptor">
        <property name="transactionManager" ref="transactionManager"/>
        <property name="transactionAttributes">
            <props>
                <prop key="get*">PROPAGATION_REQUIRED,readOnly,timeout_30</prop>
                <prop key="upgrade*">PROPAGATION_REQUIRES_NEW,ISOLATION_SERIALIZABLE</prop>
                <prop key="*">PROPAGATION_REQUIRED</prop>
            </props>
        </property>
    </bean>
    
    첫번째는 get으로 시작하는 모든 메소드에 대한 속성
        PROPAGATION_REQUIRED 이면서, 읽기전용, 시간제한은 30초
    두번째는 upgrade로 시작하는 메소드에 대한 속성
        PROPAGATION_REQUIRES_NEW 항상 독립적인 트랜잭션으로 동작, 
        ISOLATION_SERIALIZABLE 다른 동시작업에 영향을 받지 않도록 고립된 상태에서 트랜잭션 동작
    세번째는 *만 사용하여 두가지 조건에 해당하지 않는 나머지 모든 메소드에 사용될 속성을 지정
        PROPAGATION_REQUIRED 만 지정 나머지는 디폴트 설정
        
###### tx 네임스페이스를 이용한 설정 방법
    TransactionInterceptor 타입의 어드바이스 빈과 TransactionAttribute 타입의 속성 정보도
    tx 스키마의 전용 태그를 이용해 정의할 수 있다.
    
    xmlns:tx="http://www.springframework.org/schema/tx"
    
    http://www.springframework.org/schema/tx
    http://www.springframework.org/schema/tx/spring-tx-2.5.xsd
    
    <tx:advice id="transactionAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="get*" propagation="REQUIRED" read-only="true" timeout="30"/>
            <tx:method name="upgrade*" propagation="REQUIRES_NEW" isolation="SERIALIZABLE"/>
            <tx:method name="*" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>
    
    트랜잭션 속성이 개별 어트리뷰트를 통해 지정될 수 있으므로 설정 내용을 읽기가 더 쉽고
    XML 에디터의 자동완성 기능을 통해 편하게 작성할 수 있다.
    문자열로 입력할 때 자주 발생하는 오타 문제도 해결할 수 있다.
    
#### 포인트컷과 트랜잭션 속성의 적용 전략
    트랜잭션 포인트컷 표현식은 타입 패턴이나 빈 이름을 이용한다.
    
    공통된 메소드 이름 규칙을 통해 최소한의 트랜잭션 어드바이스와 속성을 정의한다.
    
    프록시 방식 AOP는 같은 타깃 오브젝트 내의 메소드를 호출할 때는 적용되지 않는다.
    
#### 트랜잭션 속성 적용
    트랜잭션 경계설정의 일원화
        일반적으로 특정 계층의 경계를 트랜잭션 경계와 일치시키는 것이 바람직하다.
        비즈니스 로직을 담고 있는 서비스 계층 오브젝트의 메소드가 
        트랜잭션 경계를 부여하기에 가장 적절한 대상이다.
    서비스 빈에 적용되는 포인트컷 표현식 등록
        포인트컷 표현식을 모든 비즈니스 로직의 서비스 빈에 적용되도록 수정한다.
        
    트랜잭션 속성을 가진 트랜잭션 어드바이스 등록
        
    트랜잭션 속성 테스트
    
#### 애너테이션 트랜잭션 속성과 포인트컷
    세밀한 트랜잭션 속성의 제어가 필요한 경우를 위해 스프링이 제공하는 다른 방법이 있다.
    설정 파일에서 패턴으로 분류 가능한 그룹을 만들어서 일괄적으로 속성을 부여하는 대신에
    직접 타깃에 트랜잭션 속성정보를 가진 애너테이션을 지정하는 방법이다.
    
###### 트랜잭션 어노테이션
    @Transactional
        애너테이션을 트랜잭션 속성정보로 사용하도록 지정하면 스프링은 
        @Transactional 이 부여된 모든 오브젝트를 자동으로 타깃 오브젝트로 인식한다.
        이때 사용되는 포인트컷은 TransactionAttributeSourcePointcut 이다.
        @Transactional 은 기본적으로 트랜잭션 속성을 정의하는 것이지만,
        동시에 포인트컷의 자동등록에도 사용된다.
    
    트랜잭션 속성을 이용하는 포인트컷
        포인트컷과 트랜잭션 속성을 애너테이션 하나로 지정할 수 있다.
        트랜잭션 속성은 타입 레벨에 일괄적으로 부여할 수도 있지만,
        메소드 단위로 세분화해서 트랜잭션 속성을 다르게 지정할 수도 있기 때문에
        매우 세밀한 트랜잭션 속성 제어가 가능해진다.
        
    대체 정책
        스프링은 @Transactional 을 적용할 때 4단계의 대체 정책을 이용하게 해준다.
        메소드의 속성을 확인할 때 타깃메소드, 타깃클래스, 선언메소드, 선언타입의 순서에 따라서
        @Transactional 이 적용됐는지 차례로 확인하고, 가장 먼저 발견되는 속성 정보를 사용
        
        e.g )
        [1]
        public interface Service {
           [2]
           void method1();
           [3]
           void method2();
        }
        [4]
        public class ServiceImpl implements Service {
            [5]
            public void method1(){}
            [6]
            public void method2(){}
        }
    
        일 때, ServiceImpl 이 빈으로 등록됐고 두 메소드가 트랜잭션 적용 대상이 된다면
        @Transactional 을 부여할 수 있는 위치는 총 6개 이다.
        
        순서는 [5] [6] ( 타깃메소드 ), [4] ( 타깃클래스 ), [2] [3] ( 선언메소드 ), [1] ( 선언타입 ) 순으로 확인한다.
        
        기본적으로 @Transactional 적용 대상은 클라이언트가 사용하는 인터페이스가 정의한 메소드이므로
        @Transactional 도 타깃 클래스 보다는 인터페이스에 두는 게 바람직하다.
        하지만 인터페이스를 사용하는 프록시 방식의 AOP가 아닌 방식으로 트랜잭션을 적용하면 인터페이스에 정의한 
        @Transactional 은 무시되기 때문에 안전하게 타깃 클래스에 @Transactional 을 두는 방법을 권장한다.
        인터페이스에 @Transactional 을 두면 구현 클래스가 바뀌더라도 트랜잭션 속성을 유지할 수 있다는 장점이 있다.
    
    트랜잭션 어노테이션 사용을 위한 설정
        <tx:annotation-driven/>
        
###### 트랜잭션 애너테이션 적용
    @Transactional 을 이용하는 트랜잭션 설정이 직관적이고 간단하다고 생각해서 사용하는 경우도 많다.
    클래스, 빈, 메소드의 이름에 일관된 패턴을 만들어 적용하고 이를 활용해 포인트컷과 트랜잭션 속성을
    지정하는 것보다는 단순하게 트랜잭션이 필요한 타입 또는 메소드에 직접 애너테이션을 부여하는 것이
    훨씬 편리하고 코드를 이해하기도 좋다.
    
    다만 트랜잭션 적용 대상을 손쉽게 파악할 수 없고, 사용 정책을 잘 만들어두지 않으면 무분별하게
    사용되거나 자칫 빼먹을 위험도 있다. 
    
```java
@Transactional
public interface UserService {

    void add(User user);
    void deleteAll();
    void update(User user);
    void upgradeLevels(); 
    // 여기까지는 <tx:method name="*"/> 설정 효과

    @Transactional(readOnly = true)
    User get(String id);

    @Transactional(readOnly = true)
    List<User> getAll(); 
    // 여기까지는 tx:method name="get*" read-only="true"/>를 애너테이션 방식으로 변경한 것
    // 메소드 단위로 부여된 트랜잭션의 속성이 타입 레벨에 부여된 것에 우선해서 적용된다.
    // 같은 속성을 가졌어도 메소드 레벨에 부여될 때는 메소드마다 반복될 수밖에 없다.
}
```

#### 트랜잭션 지원 테스트
###### 트랜잭션 전파속성
    REQUIRED 로 전파 속성을 지정해줄 경우, 앞에서 진행 중인 트랜잭션이 있으면 참여하고
    없으면 자동으로 새로운 트랜잭션을 시작해준다.
    REQUIRED 전파 속성을 가진 메소드를 결합해서 다양한 크기의 트랜잭션 작업을 만들 수 있다.
    트랜잭션 적용 때문에 불필요하게 코드를 중복하는 것도 피할 수 있으며,
    애플리케이션을 작은 기능 단위로 쪼개서 개발할 수 있다.
    
    트랜잭션 전파 방식이 없다면 독자적인 트랜잭션 메소드를 사용하는 다른 트랜잭션 메소드에서
    같은 메소드를 복사하여 사용해함
    
    AOP를 이용해 코드 외부에서 트랜잭션의 기능을 부여해주고 
    속성을 지정할 수 있게 하는 방법을 선언적 트랜잭션이라고한다.
    반대로 TransactionTemplate 이나 개별 데이터 기술의 트랜잭션 API를 사용해 
    직접 코드 안에서 사용하는 방법을 프로그램에 의한 트랜잭션 이라고 한다.
    
## ★ AOP 부분 다시 할것

## 7. 스프링 핵심 기술의 응용
    스프링이 가장 가치를 두고 적극적으로 활용하려고 하는 것은 
    결국 자바언어가 기반을 두고 있는 객체지향 기술이다.
#### DAO SQL 분리
    1. String bean 생성
        <bean id="userDao" class="dao.independent.UserDaoJDBC">
            <property name="dataSource" ref="dataSource"/>
            <property name="sqlAdd" value="insert into users(id, name, password,
                                level, login ,recommend) values(?, ?, ?, ?, ?, ?)"/>
        </bean>
    2. Map bean 생성
        <bean id="userDao" class="dao.independent.UserDaoJDBC">
            <property name="dataSource" ref="dataSource"/>
            <property name="sqlMap">
                <map>
                    <entry key="add" value="insert into users(id, name, password, level, login ,recommend)
                                            values(?, ?, ?, ?, ?, ?)"/>
                    <entry key="get" value="select * from users where id = ?"/>
                    ...
                </map>
            </property>
        </bean>
    3. interface 생성 후 DI
        <bean id="userDao" class="dao.independent.UserDaoJDBC">
            <property name="dataSource" ref="dataSource"/>
            <property name="sqlService" ref="sqlService"/>
        </bean>
        
        <bean id="sqlService" class="dao.independent.SimpleSqlService">
            <property name="sqlMap">
                <map>
                    <entry key="userAdd" value="insert into users(id, name, password, level, login ,recommend)
                                            values(?, ?, ?, ?, ?, ?)"/>
                    <entry key="userGet" value="select * from users where id = ?"/>
                    <entry key="userGetAll" value="select * from users order by id"/>
                    <entry key="userDeleteAll" value="delete from users"/>
                    <entry key="userGetCount" value="select count(id) from users"/>
                    <entry key="userUpdate" value="update users set name = ?, password = ?, level = ?, login = ?, recommend = ? where id = ?"/>
                </map>
            </property>
        </bean>
        
    4. sql xsd
        <?xml version="1.0" encoding="UTF-8"?>
        <schema xmlns="http://www.w3.org/2001/XMLSchema"
                targetNamespace="http://www.epril.com/sqlmap"
               xmlns:tnx="http://www.epril.com/sqlmap" elementFormDefault="qualified">
            <element name="sqlmap">
                <complexType>
                    <sequence>
                        <element name="sql" maxOccurs="unbounded" type="tnx:sqlType"/>
                        // maxOccurs 필요한 개무만큼 sql 을 포함할 수 있게 함
                    </sequence>
                </complexType>
            </element>
        
            <complexType name="sqlType"> // sql 에 대한 정의를 시작
                <simpleContent>
                    <extension base="string"> // sql 문장을 넣을 스트링 타입 정의
                        <attribute name="key" use="required" type="string"/> 
                        // 검색을 위한 key 값은 sql 의 key 애트리뷰트에 넣는다, 필수값
                    </extension>
                </simpleContent>
            </complexType>
        </schema>
        
        셸이나 도스창에서 프로젝트 루트 폴더로 이동한 뒤 명령 사용하여 컴파일
        xjc -p [생성할 클래스의 패키지] [xsd 파일 이름] -d [생성된 파일이 저장될 위치]
        
        두 개의 바인딩용 자바 클래스와 팩토리 클래스 생성
        <sqlmap> 이 바인딩 될 Sqlmap 클래스
        <sql> 태그의 정보를 담을 SqlType 클래스
        
        언마샬링
            JAXB에서 xml 문서를 읽어서 자바의 오브젝트로 변환하는 것
        마샬링
            JAXB에서 바인딩 오브젝트를 xml 문서로 변환하는 것
        
## 8. 스프링이란 무엇인가?
## 9. 스프링 프로젝트 시작하기