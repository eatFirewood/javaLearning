# mybatis持久层框架

## 配置流程

### properties参数设置

在src.main.resources.application.properties文件中加入
spring.datasource.url=jdbc:mariadb://localhost:3306/db01
spring.datasource.username=root
spring.datasource.password=root

必要时还要加上spring.datasource.driver-class-name = org.mariadb.jdbc.Driver

### 编写Mybatis程序：编写Mybatis的持久层接口，定义SQL语句（注解）
在创建出来的springboot工程中，在引导类所在包下，在创建一个包 mapper 。在 mapper 包下创建一个接口 UserMapper ，这是一个持久层接口（Mybatis的持久层接口规范一般都叫 XxxMapper）。
UserMapper接口的内容如下：

```java
import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询全部
     */
    @Select("select * from user")
    public List<User> findAll();
}
```

### 单元测试

在创建出来的SpringBoot工程中，在src下的test目录下，已经自动帮我们创建好了测试类 ，并且在测试类上已经添加了注解 @SpringBootTest，代表该测试类已经与SpringBoot整合。
该测试类在运行时，会自动通过引导类加载Spring的环境（IOC容器）。我们要测试那个bean对象，就可以直接通过@Autowired注解直接将其注入进行，然后就可以测试了。

测试类代码如下：

```java
@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
```

### 删除
1. 固定参数
```java
/**
 * 根据id删除
 */
@Delete("delete from user where id = 5")
public void deleteById();
```

2. 动态传参
```java
/**
 * 根据id删除
 */
@Delete("delete from user where id = #{id}")
public void deleteById(Integer id);
```

### 辅助配置

在***properties***文件中加入mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
在控制台上显示日志