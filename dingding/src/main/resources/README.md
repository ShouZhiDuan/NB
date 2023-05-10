# HOW TO USE

```text
当前组件用于推送钉钉群消息。
```

## 1、引入工程
```xml
<dependency>
    <groupId>com.nb</groupId>
    <artifactId>dingding</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 2、核心类
- com.nb.dingding.DingDingUtil
```text
推送功能：com.nb.dingding.DingDingUtil.postWithJson(String message);
```

## 3、使用案例

### 配置相关平台参数(appliction.properties)
```properties
dingding.baseurl=testUrl
dingding.token=testToken
dingding.secret=testSecret
```

```java
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TestService {

    @Autowired
    private DingDingUtil dingDingUtil;
    
    // 测试发送钉钉消息
    public void test() {
        dingDingUtil.postWithJson("待推送的消息");
    }
}
```
