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
    //这里要注意数据强一致性（不论何时都保持一致）和弱一致（某个时刻可能不一致，通过某个机制使最终结果保持一致）的概念
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
            //为了保证转账操作的数据一致性，添加了一些跟 transaction 相关的记录和状态更新的代码
            walletTansferReposity.updateStatus(transactionId, Status.CLOSED);
//        ...rethrow exception e...
        }
        walletTansferReposity.updateStatus(transactionId,Status.EXECUTED);
    }



}
