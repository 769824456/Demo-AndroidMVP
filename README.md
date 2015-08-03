# Demo-AndroidMVP

>参考
http://blog.csdn.net/lmj623565791/article/details/46596109
---
#MVP--->“代码很清晰，不过增加了很多类”。

####MVC：
```
View：对应于布局文件
Model：业务逻辑和实体模型
Controllor：对应于Activity
```
####MVP
```
View 对应于Activity，负责View的绘制以及与用户交互
Model 依然是业务逻辑和实体模型
Presenter 负责完成View于Model间的交互
```
####小结
Presenter的出现，将Actvity视为View层，Presenter负责完成View层与Model层的交互。
也就是说，之所以让人觉得耳目一新，是因为这次的跳跃是从并不标准的MVC到MVP的一个转变，减少了Activity的职责，简化了Activity中的代码，将复杂的逻辑代码提取到了Presenter中进行处理。与之对应的好处就是，耦合度更低，更方便的进行测试。


