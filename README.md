[![](https://jitpack.io/v/guting50/PayLibrary.svg)](https://jitpack.io/#guting50/PayLibrary)
[![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16) 
[![作者](https://img.shields.io/badge/%E4%BD%9C%E8%80%85-guting50-brightgreen.svg)](https://github.com/guting50)

#### 依赖
将其添加到根build.gradle文件（而不是模块build.gradle文件）中：

```Xml
    allprojects {
        repositories {
            maven { url "https://jitpack.io" }
        }
    }
```
然后，将库添加到模块中 build.gradle
```Xml
    dependencies {
        implementation 'com.github.guting50:PayLibrary:Tag'
    }
```

#### 实现微信支付回调activity
```java
package com.gt.pay.wxapi;

import common.pay.sdk.PayEntryActivity;

/**
 * DESC: 微信那撕必须要该类名的Activity
 * 在自己的APP内的wxapi包名下写一个继承CommonPaySdk的PayEntryActivity的WxPayEntryActivity即可
 */
public class WXPayEntryActivity extends PayEntryActivity {
}
```

#### 清单文件中注册
```xml
<activity
            android:name=".wxapi.WXPayEntryActivity"
            android:exported="true"
            android:launchMode="singleTop"
            android:theme="@style/PayTransparent" />
```

#### 代码中调用
```java
  PrePayOrderInfo wxOrderInfo = new Gson().fromJson("服务端返回的支付信息", PrePayOrderInfo.class);
  PayEntryActivity.startPayActivity(MainActivity.this, wxOrderInfo, 200, WXPayEntryActivity.class);
```
