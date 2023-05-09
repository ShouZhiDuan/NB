# 使用教程

## 1、引入工程
```xml
<dependency>
    <groupId>com.nb</groupId>
    <artifactId>global-exception</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 2、核心类
- com.nb.global.exception.handler.GlobalExceptionHandler
```text
全局异常处理器
```
- com.nb.global.exception.GlobalException
```text
全局异常
```

## 3、使用案例
```java
@RestController
public class TestController {
    @GetMapping("/test")
    public void test(){
        throw new GlobalException(-1,"测试抛出自定义异常");
    }
}
```
```json

```


