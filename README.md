# 23designpattern_java
23种常用的设计模式Java版（本项目为自己对设计模式对总结，为编程提供方法论，包含源码项目和使用心得）
tip: 
软件设计中，用户需求变化（用户输入数据）或软件业务需求造成了代码的变化，变化意味着不稳定性，不稳定性使得软件不易拓展，隔离变化提高软件模块的稳定性就是我们软件设计目标。设计模式指导我们如何写出更高效、更易于拓展的代码，给我们带来遍便利同时使得系统更加稳定！

#### JVM中类的加载机制
当程序主动使用某个类时，如果该类并未被加载到内存中，则系统会通过：加载、连接、初始化来对该类进行出生化，这个三个步骤
我们通常称之为类的加载，此时JVM会将class文件读入到内存中并为之创建一个对应的java.lang.Class对象

#### 面向接口编程
+ 接口的定义：对一系列标准（协议）的声明。准确说是对实现类中要实现的成员方法及变量的预定义，接口变量定义默认为：public static final 定义(全局常量)，方法默认为public
+ 接口是对一类事物的最高层次的抽象，并且遵从开闭原则的设计思想：对修改关闭，对扩展开放。所以接口类只定义标准，不做实现
+ 关于面向对象编程的多态：子类对象可以直接赋值给父类变量，但是依然表现出子类的行为特征，这意味着同一个类型的对象在执行同一个方法时候，可能表现出多种行为特征，如果编译时和运行时类型不一致就会体现出多态性。
  里氏替换的设计原则和多态特性中,继承是基础,但是二者阐述的重点不一致,所以多态特性的设计并非遵循了该原则，概念容易被混淆。
  1.LSP
  --里氏替换原则：子类可以替换父类的位置，并且不影响程序。
  --父类有的功能子类都有，但是子类可以在子类的基础上，添加功能。
  
  2.父类变量指向一个子类对象的时候，只能通过这个父类的成员，子类独有的成员无法调用。
  
  3.类型转化
  --必须有继承关系，才能使用强制转换。
  --如果一个父类对象，指向的就是一个父类对象，将这个父类对象转化成子类对象的会报异常。
  --如果一个父类变量指向了一个子类对象，那么可以将这个父类对象转换为子类对象。
  
  4.is关键字
  --判断变量是否是指定的类型。
  --如果没有继承关系，返回值永远都是false。
  
  5.as关键字
  --as转换如果转换成功，引用指向指定变量，如果转换失败，不报异常，返回null。
  
  6.虚方法
  --被virtual修饰的方法就叫虚方法。
  --虚方法可在子类中重写。
  --子类中被override修饰的、与父类同名的方法将会替换父类的虚方法，实现方法的重写。
  --通过父类变量来调用虚方法，若子类重写，则调用子类，否则还是父类的虚方法。
  
  7.多态:核心思想是将"相同行为"和"不同事物如何执行该行为"分离开，也就是将"不变"和"可能改变的分离开"，将不变部分隔离或作为父类，将可变的部分独立封装。具体指:子类对象可以赋予父类变量，但是运行时候仍然表现出子类行为特征，这也就意味着同一个对象在执行同一个方法时候可能表现为多种行为特征。由此可见多态是一种机制，当父类的某个方法被子类重写后，将子类对象赋值给父类对象的引用，可以产生不同的功能，这个就是多态的体现；另外将实现接口的类创建对象赋值给接口对象的引用，以实现不同类的功能，也是多态的表现！
  --同一种行为，对于不同的事物，有不同的表现形式。
  --多态的表现形式之一：将父类类型作为方法的参数。
  --多态的表现形式之二：将父类类型作为返回值。
  --屏蔽多个子类的不同，将多个子类当成父类来处理。
  --继承是为了多态、拓展、开闭原则。
  --多态基于继承。
  如java编译时候变量可以有一种类型，运行的时候可以是另一种类型(如子类向父类转型-向上转型)，从而保障了多态特性。JavaScript的变量类型在运行期是可变的，这意味着JavaScript对象的多态性是与生俱来的。不同语言有不同保障多态特性的方式。
  
#### IoC控制反转
+ 控制权转移，应用本身不负责依赖对象对创建，而是由外部容器负责创建和维护

### DI依赖注入
+ 是IoC控制反转的一种实现方式，使获得依赖对象的过程被反转了，获得依赖过程由自身管理变为由IoC容器主动注入

#### 关于反射
+ Java反射是指在程序运行时获取已知名称的类或已有对象的相关信息（包括类的方法、属性、父类等信息）的一种机制
+ 在JKD中主要由java.lang.reflect包来实现反射机制，所以应用反射必须导入该包。因为
+ Java设计中根据一切皆为对象的原则，对于定义类变量本身而言，类本身即为Class对象
+ 获取类对象对方式有三种:
  (1)Class.forName(String.clazzName); //入参为某个类对全限定类名
  (2)Person.class;  //某个类如Person的class属性返回Class对象
  (3)person.getClass(); //某个类Person 创建的实例person = new Person(),通过对象的getClass方法
案例 com.reflectiondemo

#### 对于贫血模型和充血模型、DDD（驱动领域设计）的理解
MVC三层架构一般是基于贫血模型去做系统开发，其实整体框架而言更多是面向结构化编程。如在MVC的逻辑层(也就是控制层中),UserBo和UserService组成业务逻层。
大多数时候UserBo只是单纯的数据结构，只包含数据，不包含任何业务逻辑。业务操作集中在UserService中，我们通过UserServcie操作UserBo，像UserBo这样，只
包含数据结构没有业务操作逻辑，就叫做贫血模型。其他展示层、数据层都是类似贫血模型。这类方式破坏了面向对象都封装性，除了数据或操作的对象定义整体结构是一种
面向过程都编程风格。
充血模型将数据结构和业务逻辑放到同一个类中，充血模型满足面向对象的封装特性。
DDD,领域驱动设计（概念新但是是新瓶装旧酒），主要指导结构业务系统，划分业务模块，前提的对业务熟练，DDD提供方法论指导拆分业务层功能。在基于充血模型的DDD系统架构中
Service层包含Service类和Domain类，其中Domain类相当于贫血模型中的Bo类，区别在于Domain不仅仅包含数据结构也包含业务逻辑，领域模型类相当于可复用业务中间层。
案例 钱包系统(账单管理)

#### 设计模式必须遵守的6大原则
关于模式的使用目的：为了是让结构松耦合，让功能高内聚少修改且易于拓展
+ 单一原则：一个类应当只有一个职责
+ 里氏替换原则：一个类型为S的对象object1,都有类型T的对象object2,使得以S定义的所有程序P在所有对象object1都替换为object2，程序P没有发生任何变化，那么类型T就是类型S的自类型。如：子类继承父亲的特性
+ 依赖倒置原则：高层和实现都依赖抽象层
+ 迪米特法则：一个对象应该对其他对象尽少的了解产生关联
+ 开闭原则：对拓展开放，对修改关闭（Open-Closed Principle）；尽量保持控制代码的稳定，控制代码决定了代码的稳定性

1 利用interface统一方法调用(但是无法统一实例化)。面向对象主要完成两个动作：(1)实例化(2)方法调用(完成业务逻辑)

2 一段代码要保持稳定就不要直接负责对象的实例化，实例化是造成不稳定的本质问题。即保持某段代码中没有new来实例化,该代码往往比较稳定易于拓展。解决方法：将实例化转移到其他代码块中（如工厂模式、容器）

3 易于拓展是相对的，我们将需要修改的部分隔离出到独立到代码块中。修改是必须存在，只需要合理隔离是不违背开闭原则的。
案例1 对应base模块中的 com.openclosedprinciple.hero.Diana

### 23种经典类型分为三类：创建型（解决对象创建问题,即实例化的问题）、结构型（解决类或对象的组合或组装）、行为型（类或对象之间的交互）

##### 创建模式(create模块)
* 单例模式
* 工厂模式
主要解耦对象的创建和使用
案例1 简单工厂 com.com.simplefactory
案例2 工厂方法 com.factorymethod
案例3 抽象工厂 com.abstractfactory

##### 结构模式(struct模块)
* 代理模式（包含3个角色：抽象主题角色、实现主题角色、代理主题角色）
为其他对象提供一种代理以控制对这个对象访问。在代理主题角色中注入实现对象，对对象业务流程及逻辑重新构建。
案例1 静态代理 com.structpattern.staticproxy
案例2 com.structpattern.proxygame

#### 行为模式(action模块)
* 策略模式（三个部分：策略定义、策略创建、策略使用）
* 命令模式（四个角色：命令接口、命令实现接口（发起者）、调用/请求者（invoke）、接收者）
案例 com.command
注意：普通思路，只需要有命令、命令发送者、命令接受者就可以了，为什么还需要请求者，需要解耦调用者和接受者。invoke是一个具体实现，代码是稳定的，不常修改。Receive作为业务逻辑代码是经常需要修改的，即不稳定，一个稳定结构依赖一个不稳定结构肯定是不稳定的，所以invoke中聚合的Command接口是易于拓展的（接口是稳定的/依赖倒置），Command接口实现类依赖于Receive对象，从而解耦了调用者和接受者。
* 观察者模式 (四个角色：被观察对象抽象接口主题、具体主题、抽象观察者、具体观察者)
JDK中有java.util.Observer/Observable类可以直接使用
案例 com.observer
定义了一些列对象之间一对多的关系，精髓在于一个对象(被观察者)状态改变后，其他依赖都会收到通知，从而作出对应的响应。
理解：主要解耦观察者和被观察者，因为观察者是经常添加变换的。从例子可以看出，观察者中的操作与被观察者是完全独立的，观察者会被注入到主题实现类中，只有当发了notifyObservers通知，观察者才会作出相应的执行操作。
网上找到人做了两个案例比较：
不用观察者模式
```
class Video {
 	public function new(){
 		$checkNewVideo = Video::find()->where("xxxxx")->one();
 		if($checkNewVideo){
 			//	通知各位
 			LaoWang::newVideo();
 			XiaoLi::newVideo();
 			ChuanPu::newVideo();
 			.......
 			//	还有很多很多，比如在给某个集体客户群发、短信发等等等等
 		}
 	}
 }
 
 //	具体实现
 $model = new Video();
 $model->new();
 ```
使用观察者模式
```
/**
 * 被观察者接口
 * 定义了一些公用方法声明，使用观察者模式的类都可以继承此接口
 */
interface Observable {
    // 添加/注册观察者
    public function attach(Observer $observer);
    // 删除观察者
    public function detach(Observer $observer);
    // 触发通知
    public function notify();
}

class Video implements Observable {
	public $observers = [];//	订阅者
	
	//	添加观察者
	public function attach(Observer $observer){
		$key = array_search($observer, $this->observers);
		if ($key === false) {
			$this->observers[] = $observer;
		}
	}
	
	//	删除观察者
	public function detach(Observer $observer){
		$key = array_search($observer, $this->observers);
		if ($key !== false) {
			unset($this->observers[$key]);
		}
	}
	
	//	通知所有观察者
	public function notify(){
		foreach ($this->observers as $observer) {
			// 把本类对象传给观察者
			$observer->update($this);
		}
	}
	
	public function  new(){
		$checkNewVideo = Video::find()->where("xxxxx")->one();
		if($checkNewVideo){
			$this->notify();
		}
	}
}

/**
 * 观察者接口
 */
interface Observer
{
    // 接收到通知的处理方法
    public function update(Observable $observable);
}

class LaoWang implements Observer {
	public function update(Observable $observable){
		echo "立刻开始看视频";
	}
}

class XiaoMing implements Observer {
	public function update(Observable $observable){
		echo "收到后忽略通知";
	}
}

class ChuanPu implements Observer {
	public function update(Observable $observable){
		echo "收藏了一下，然后去wc看";
	}
}

class BingBing implements Observer {
	public function update(Observable $observable){
		echo "立刻开始看视频";
	}
}

$model = new Video();
$model->attach(new LaoWang());
$model->attach(new XiaoLi());
$model->attach(new ChuanPu());
$model->attach(new BingBing());
$model->new();
```
然后有人就提出了质疑：很明显第一种代码量更少，更利于维护，第二种观察者模式过于复杂。其实系统小的时候，第一种是适合维护的，当系统复杂到一定程序时候，需要很多人维护的时候，我们需要尽力维持代码的稳定性，少修改功能，多做扩展，符合"开闭原则"；说到稳定，那么这个案例中，被观察者是稳定的，观察者的个体也是稳定的(无非是多于少的问题)，我们扩展的时候只需要增加观察者，在主业务逻辑（往往是需要经常调整变动的）中去增加观察者。
