package com.wallet.lessblood.controller;

import com.wallet.lessblood.services.VirtualWalletService;

import java.math.BigDecimal;

public class VirtualWalletController {
    private VirtualWalletService virtualWalletService;

    public void getBalance(Long walletId){
        System.out.println("虚拟钱包余额: (类型BigDecimal)");
    }

    public void debit(Long walletId,BigDecimal amount){
        System.out.println("虚拟钱出账（借）--");
    }

    public void credit(Long walletId,BigDecimal amount){
        System.out.println("虚拟钱入账（贷）++");
    }

    public void transfer(Long fromWalletId,Long toWalletId,BigDecimal amount){
        System.out.println(fromWalletId + "向" + toWalletId +"转帐 :" + amount);
    }

}
