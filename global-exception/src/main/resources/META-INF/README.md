# HOW TO USE

```text
当前组件用于处理全局异常处理。
```

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
全局异常处理器：实现了常见异常处理，自动拦截Respose出固定的数据结构（见下面json格式）。
```
```json
{
   "code": 0,
   "message": "状态码描述",
   "data": null
}
```

- com.nb.global.exception.GlobalException
```text
全局异常：实现了统一异常结构体。使用的时候只要：throw new GlobalException(-1,"测试抛出自定义异常")，
就可以被拦截Response给前端。
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
{
   "code": -1,
   "message": "测试抛出自定义异常",
   "data": null
}
```