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
    TxProxyfactoryBean 은 pattern 이라는 메소드 이름 비교용 스트링 값을 DI 받아서
    TransactionHandler 를 생성할 때 이를 넘겨주고, TransactionHandler 는 요청이
    들어오는 메소드의 이름과 패턴을 비교해서 부가기능인 트랜잭션 적용 대상을 판별했다.
    
    스프링의 ProxyFactoryBean 과 MethodInterceptor 를 사용하는 방식에서는
    메소드 선정 기능을 사용할 수 없다. 
    MethodInterceptor 오브젝트는 여러 프록시가 공유해서 사용할 수 있기 때문에
    MethodInterceptor 오브젝트는 타깃 정보를 갖고 있지 않도록 만들었다.
    그 덕분에 MethodInterceptor 를 스프링의 싱글톤 빈으로 등록할 수 있었다.
     
## 7. 스프링 핵심 기술의 응용
## 8. 스프링이란 무엇인가?
## 9. 스프링 프로젝트 시작하기