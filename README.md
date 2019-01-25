# Learn_Java
Java学习

## 18-12-5

JDK是Java开发所需要的环境，就跟我们想玩某个网游一样，玩之前一定是需要先安装相应的程序包的，那这个JDK就是我们准备登陆Java大陆前需要安装的一个程序包  
* javac -- 编译器，将源程序转换成字节码
* java  -- 运行编译后的.class文件

IDE是集成开发环境，一般集成开发环境都会带有JDK，可以使用自带的JDK也可以使用我们下载的JDK，不同的IDE配置不同。Java常用的IDE有Eclipse、MyEclipse、IntelliJ IDEA。IDE具备代码分析、补全、变异、调试等常用功能，可以大大的提高开发人员的编程效率  

JVM -- java虚拟机  

JRE -- java运行时环境包括JVM、JAVA核心类库和支持文件，若要运行java环境，下载安装JRE即可；若要开发就得使用JDK，JDK包含JRE  

### java命令行运行

命令行运行需要添加jdk下的bin目录路径到系统环境变量  

```
javac HelloWorld.java             # 生成.class文件 
java HelloWorld                   # 执行程序

```

### 构造方法

构造方法与类名相同，且没有返回值 


### 封装

```
        以 private 修饰的成员只能在本类中访问，外部需要调用get、set 方法才可访问修改

        (1)隐藏实现细节，提供公共的访问方式
	(2)好处：
		A:隐藏实现细节，提供公共的访问方式
		B:提高了代码的复用性
		C:提高了代码的安全性
	(3)使用原则
		A:把成员变量隐藏
		B:给出该成员变量对应的公共访问方式

```

### 继承

```
    1:Override和Overload的区别?Overload能改变返回值类型吗?
	Override:重写
	Overload:重载

	方法重写：子类中出现和父类中一模一样的方法声明的现象。
	方法重载：同一个类中出现的方法名相同，参数列表不同的现象。

	Overload能改变返回值类型，因为它和返回值类型无关。

    2:this关键字和super关键字分别代表什么?以及他们各自的使用场景和作用。
	this:本类对象的引用
	super:父类存储空间的标识。(可以理解为父类对象的引用)

	使用场景：
		成员变量：
			this.变量 本类的成员变量
			super.变量 父类的成员变量
		构造方法：
			this(...) 本类的构造方法
			super(...) 父类的构造方法
		成员方法：
			this.方法名(...) 本类的成员方法
			super.方法名(...) 父类的成员方法
```

### 多态

```
        多态：同一个对象在不同时刻表现出现的不同状态。

	举例：
		A:水(水，冰，水蒸气)

		B:猫和动物。
			把右边的值赋值给左边，如果能读通过，就说明可以。
			动物 d = new 动物();
			动物 dd = new 猫();
			猫 m = new 猫();
			猫 mm = new 动物();  错误

			动物 dd = new 猫();

	代码如何体现呢?
		A:有继承关系	
		B:有方法重写	
		C:有父类引用指向子类对象
```

### 抽象

```
        抽象类的特点：
		A:抽象类和抽象方法必须用abstract关键字修饰
		B:抽象类的子类
			a:要么是抽象类
			b:要么重写抽象类中的所有抽象方法
		C:抽象类不一定有抽象方法，有抽象方法的类一定是抽象类
		D:抽象类不能实例化
			那么如何使用抽象类的功能呢?
			按照多态的方式使用。抽象类多态。
```

### 权限修饰符

```
+ private: Java语言中对访问权限限制的最窄的修饰符，一般称之为“私有的”。被其修饰的属性以及方法只能被该类的对象访问，其子类不能访问，更不能允许跨包访问。
+ default：即不加任何访问修饰符，通常称为“默认访问权限“或者“包访问权限”。该模式下，只允许在同一个包中进行访问。
+ protected: 介于public 和 private 之间的一种访问修饰符，一般称之为“保护访问权限”。被其修饰的属性以及方法只能被类本身的方法及子类访问，即使子类在不同的包中也可以访问。
+ public： Java语言中访问限制最宽的修饰符，一般称之为“公共的”。被其修饰的类、属性以及方法不仅可以跨类访问，而且允许跨包访问。

```

### Tomcat 控制台打印 log 中文乱码解决办法
在 IDEA 安装文件的 bin 目录下的 idea.exe.vmoptions 和 idea64.exe.vmoptions 分别都添加 **-Dfile.encoding=UTF-8** 即可  
若是在控制台 server 中打印的中文为乱码 则要在 run -> edit configurations 中 VM options 添加 -Dfile.encoding=UTF-8

### SLF4J 冲突

```
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/C:/Program%20Files/maven/lib/maven-slf4j-provider-3.5.4.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/C:/Program%20Files/maven/repo/org/slf4j/slf4j-log4j12/1.7.23/slf4j-log4j12-1.7.23.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
SLF4J: Actual binding is of type [org.slf4j.impl.MavenSimpleLoggerFactory]
```

解决途径：删除 pom.xml 中的
```
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.23</version>
        </dependency>
```

### Spring 使用 aop 出现的错误
```
1月 25, 2019 10:25:09 上午 org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
信息: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@4b4523f8: startup date [Fri Jan 25 10:25:09 CST 2019]; root of context hierarchy
1月 25, 2019 10:25:09 上午 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
信息: Loading XML bean definitions from class path resource [springaop.xml]
1月 25, 2019 10:25:09 上午 org.springframework.context.support.ClassPathXmlApplicationContext refresh
警告: Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'apple' defined in class path resource [springaop.xml]: BeanPostProcessor before instantiation of bean failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.aop.aspectj.AspectJPointcutAdvisor#0': Cannot create inner bean '(inner bean)#1a6d8329' of type [org.springframework.aop.aspectj.AspectJMethodBeforeAdvice] while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#1a6d8329': Cannot create inner bean '(inner bean)#46cdf8bd' of type [org.springframework.aop.aspectj.AspectJExpressionPointcut] while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#46cdf8bd': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
Exception in thread "main" org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'apple' defined in class path resource [springaop.xml]: BeanPostProcessor before instantiation of bean failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.aop.aspectj.AspectJPointcutAdvisor#0': Cannot create inner bean '(inner bean)#1a6d8329' of type [org.springframework.aop.aspectj.AspectJMethodBeforeAdvice] while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#1a6d8329': Cannot create inner bean '(inner bean)#46cdf8bd' of type [org.springframework.aop.aspectj.AspectJExpressionPointcut] while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#46cdf8bd': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:479)
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:312)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:308)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:761)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:867)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:543)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:139)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:83)
	at aop.AopTest.run1(AopTest.java:13)
	at aop.AopTest.main(AopTest.java:19)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.aop.aspectj.AspectJPointcutAdvisor#0': Cannot create inner bean '(inner bean)#1a6d8329' of type [org.springframework.aop.aspectj.AspectJMethodBeforeAdvice] while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#1a6d8329': Cannot create inner bean '(inner bean)#46cdf8bd' of type [org.springframework.aop.aspectj.AspectJExpressionPointcut] while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#46cdf8bd': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
	at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveInnerBean(BeanDefinitionValueResolver.java:313)
	at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveValueIfNecessary(BeanDefinitionValueResolver.java:129)
	at org.springframework.beans.factory.support.ConstructorResolver.resolveConstructorArguments(ConstructorResolver.java:648)
	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:145)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1201)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1103)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:513)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:312)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:308)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.aop.framework.autoproxy.BeanFactoryAdvisorRetrievalHelper.findAdvisorBeans(BeanFactoryAdvisorRetrievalHelper.java:92)
	at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.findCandidateAdvisors(AbstractAdvisorAutoProxyCreator.java:102)
	at org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator.shouldSkip(AspectJAwareAdvisorAutoProxyCreator.java:103)
	at org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.postProcessBeforeInstantiation(AbstractAutoProxyCreator.java:248)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInstantiation(AbstractAutowireCapableBeanFactory.java:1045)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.resolveBeforeInstantiation(AbstractAutowireCapableBeanFactory.java:1019)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:473)
	... 11 more
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#1a6d8329': Cannot create inner bean '(inner bean)#46cdf8bd' of type [org.springframework.aop.aspectj.AspectJExpressionPointcut] while setting constructor argument; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#46cdf8bd': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
	at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveInnerBean(BeanDefinitionValueResolver.java:313)
	at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveValueIfNecessary(BeanDefinitionValueResolver.java:129)
	at org.springframework.beans.factory.support.ConstructorResolver.resolveConstructorArguments(ConstructorResolver.java:634)
	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:145)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1201)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1103)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:513)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
	at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveInnerBean(BeanDefinitionValueResolver.java:299)
	... 29 more
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name '(inner bean)#46cdf8bd': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1163)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1107)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:513)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
	at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveInnerBean(BeanDefinitionValueResolver.java:299)
	... 37 more
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.aop.aspectj.AspectJExpressionPointcut]: No default constructor found; nested exception is java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:85)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1155)
	... 41 more
Caused by: java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
	at java.base/java.lang.Class.getDeclaredConstructors0(Native Method)
	at java.base/java.lang.Class.privateGetDeclaredConstructors(Class.java:3138)
	at java.base/java.lang.Class.getConstructor0(Class.java:3343)
	at java.base/java.lang.Class.getDeclaredConstructor(Class.java:2554)
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:80)
	... 42 more
Caused by: java.lang.ClassNotFoundException: org.aspectj.weaver.reflect.ReflectionWorld$ReflectionWorldException
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:583)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
	... 47 more
```
原因为缺少名为 aspectjweaver-1.9.2.jar 的jar包  
下载地址：<http://central.maven.org/maven2/org/aspectj/aspectjweaver/1.9.2/>  
导包方式：下载后，移动到项目所在lib目录，点击 Project Structure -> Libraries -> 点击加号添加目录下的jar包 

### Spring JDBC 连接报错
```
Exception in thread "main" org.springframework.jdbc.CannotGetJdbcConnectionException: Could not get JDBC Connection; nested exception is java.sql.SQLException: The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
```

```
这都是因为安装mysql的时候时区设置的不正确 mysql默认的是美国的时区，而我们中国大陆要比他们迟8小时，采用+8:00格式  

使用的数据库是MySQL，从上面图看出SpringBoot2.1在你没有指定MySQL驱动版本的情况下它自动依赖的驱动是8.0.12很高的版本  
这是由于数据库和系统时区差异所造成的，在jdbc连接的url后面加上serverTimezone=GMT即可解决问题，如果需要使用gmt+8时区，需要写成GMT%2B8，否则会被解析为空。  
再一个解决办法就是使用**低版本的MySQL jdbc驱动**，5.1.28不会存在时区的问题。

like : **jdbc:mysql:///springjdbc?serverTimezone=GMT%2B8**

参考 : <https://www.cnblogs.com/smiler/p/9983146.html>
```
