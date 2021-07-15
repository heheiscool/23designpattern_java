package com.wallet.blood.repository;

import com.wallet.lessblood.entity.VirtualWalletEntity;

import java.math.BigDecimal;

public class VirtualWalletReposity {  //持久层，对数据库增删查改----crud操作
    public VirtualWalletEntity getWalletEntity(Long walletId) {
        return new VirtualWalletEntity();
    }

    public BigDecimal getBalance(Long walletId) {
        return new BigDecimal(1000);
    }

    public void upodateBalance(Long walletId, BigDecimal subtract) {
        System.out.println("虚拟钱包余额减去"+subtract);
    }
}
