# DI 依赖注入

## Autowired 

依赖注入有三种方法

1. 属性注入
   ```java
   @RestController
   public class UserController {

        //方式一: 属性注入
        @Autowired
        private UserService userService;

   }
   ```
   
2. 构造函数注入
   
   ```java
   @RestController
   public class UserController {
   
       //方式二: 构造器注入
       private final UserService userService;
       
       @Autowired //如果当前类中只存在一个构造函数, @Autowired可以省略
       public UserController(UserService userService) {
           this.userService = userService;
       }
       
    }   
   ```

3. setter注入

   ```java
   /**
    * 用户信息Controller
    */
   @RestController
   public class UserController {
       
       //方式三: setter注入
       private UserService userService;
       
       @Autowired
       public void setUserService(UserService userService) {
           this.userService = userService;
       }
       
   }    
   ```
   
项目开发中一般选第一种和第二种，官方推荐选第二种

## 注意事项

如果ioc容器中有多个相同类型的bean对象，比如在Dao层中现在有两个实现了UserDao接口的对象。
