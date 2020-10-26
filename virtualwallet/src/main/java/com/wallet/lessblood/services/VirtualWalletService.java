package com.wallet.lessblood.services;

import com.wallet.lessblood.bo.VirtualWalletBo;
import com.wallet.lessblood.entity.Status;
import com.wallet.lessblood.entity.VirtualWalletEntity;
import com.wallet.lessblood.entity.VirtualWalletTansferEntity;
import com.wallet.lessblood.repository.VirtualWalletReposity;
import com.wallet.lessblood.repository.VirtualWalletTansferReposity;

import java.math.BigDecimal;

public class VirtualWalletService { //业务层代码
// 钱包持久层
    private VirtualWalletReposity walletReposity;

    private VirtualWalletTansferReposity walletTansferReposity;

    public VirtualWalletBo getVirtualWallet(Long walletId){      //获取虚拟钱包数据记录
        VirtualWalletEntity walletEntity = walletReposity.getWalletEntity(walletId);
        VirtualWalletBo walletBo = convert(walletEntity);         //数据库映射到字段操作
        return walletBo;
    }
//映射操作
    private VirtualWalletBo convert(VirtualWalletEntity walletEntity) {
        return new VirtualWalletBo(walletEntity.getId(),walletEntity.getCreated_at(),walletEntity.getBalance());
    }
//获取余额
    public BigDecimal getBalance(Long walletId){
        return walletReposity.getBalance(walletId);
    }

    public void debit(Long walletId,BigDecimal amount) throws Exception {
        VirtualWalletEntity walletEntity = walletReposity.getWalletEntity(walletId);  //获取数据库记录
        BigDecimal balance = walletEntity.getBalance();
        if(balance.compareTo(amount)<0){
            throw new Exception("转出金额大于余额");
        }
        walletReposity.upodateBalance(walletId,balance.subtract(amount));

    }


    public void credit(Long walletId,BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletReposity.getWalletEntity(walletId);  //获取数据库记录
        BigDecimal balance = walletEntity.getBalance();
        walletReposity.upodateBalance(walletId,balance.add(amount));

    }

    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        VirtualWalletTansferEntity walletTansferEntity = new VirtualWalletTansferEntity();
        walletTansferEntity.setAmount(amount);
        walletTansferEntity.setCreateTime(System.currentTimeMillis());
        walletTansferEntity.setFromWalletId(fromWalletId);
        walletTansferEntity.setToWalletId(toWalletId);
        walletTansferEntity.setStatus((long) Status.TO_BE_EXECUTED);

        int transactionId = walletTansferReposity.saveTransaction(walletTansferEntity);

        try { debit(fromWalletId, amount);
            credit(toWalletId, amount);
        }
        catch (Exception e)
        {
            walletTansferReposity.updateStatus(transactionId, Status.CLOSED);
//        ...rethrow exception e...
        }
        walletTansferReposity.updateStatus(transactionId,Status.EXECUTED);
    }



}
