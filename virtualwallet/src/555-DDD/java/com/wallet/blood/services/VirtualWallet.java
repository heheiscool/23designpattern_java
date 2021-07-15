package com.wallet.blood.services;

import java.math.BigDecimal;

public class VirtualWallet {  // Domain领域模型(充血模型)
    private Long id;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;

    public VirtualWallet(Long preAllocatedId) {
        this.id = preAllocatedId;
    }

    public BigDecimal balance() {
        return this.balance;
    }
    public void debit(BigDecimal amount) throws Exception {
        if (this.balance.compareTo(amount) < 0) {
            throw new Exception();
        }
        this.balance.subtract(amount);
    }
    public void credit(BigDecimal amount) throws Exception {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new Exception();
        }
        this.balance.add(amount);
    }
//如果虚拟钱包系统需要支持更复杂的业务逻辑，那充血模型的优势就显现出来了。比如，我们要支持透支一定额度和冻结部分余额的功能。
//这个时候，我们重新来看一下 VirtualWallet 类的实现代码。
    public void freeze(BigDecimal amount) {
        //...
    }
    public void unfreeze(BigDecimal amount) {
       // ...
    }
    public void increaseOverdraftAmount(BigDecimal amount) {
        //...
    }
    public void decreaseOverdraftAmount(BigDecimal amount) {
        //...
    }
    public void closeOverdraft() {
        //...
    }
    public void openOverdraft() {
        //...
    }
//领域模型 VirtualWallet 类添加了简单的冻结和透支逻辑之后，功能看起来就丰富了很多，代码也没那么单薄了。
// 如果功能继续演进，我们可以增加更加细化的冻结策略、透支策略、支持钱包账号（VirtualWallet id 字段）自动生成的逻辑（不是通过构造函数经外部传入 ID，而是通过分布式 ID 生成算法来自动生成 ID）等等。
// VirtualWallet 类的业务逻辑会变得越来越复杂，也就很值得设计成充血模型了。
//注意这里没有去掉service类，是因为我们需要跟持久层交互，领域模型之专注于业务，利于代码都解耦
}
