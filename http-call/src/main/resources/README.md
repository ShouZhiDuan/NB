# HOW TO USE

```text
当前组件用于https/http调用。
```

## 1、引入工程
```xml
<dependency>
    <groupId>com.nb</groupId>
    <artifactId>http-call</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 2、核心类
- com.nb.protocolcall.util.HttpClientUtil


## 3、使用案例

```java

import com.alibaba.fastjson.JSONObject;
import com.nb.protocolcall.util.HttpClientUtil;

@Service
public class TestService {
    // 发送一个Post请求
    public void test() {
        JSONObject jsonObject = HttpClientUtil.doPostJson("url", "JsonData");
    }
}
```
