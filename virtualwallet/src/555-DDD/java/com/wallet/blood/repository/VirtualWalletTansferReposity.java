package com.wallet.blood.repository;

import com.wallet.lessblood.entity.VirtualWalletTansferEntity;

public class VirtualWalletTansferReposity {

    public int saveTransaction(VirtualWalletTansferEntity walletTansferEntity) {
        return 1;
    }

    public int updateStatus(int transactionId, int executed) {
        return 2;
    }
}
