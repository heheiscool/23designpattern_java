package com.wallet.blood.entity;

import java.math.BigDecimal;

public class VirtualWalletEntity {  //持久层对应的数据库列名
    private Long id;
    private Long created_at;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Long created_at) {
        this.created_at = created_at;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "VirtualWalletBo{" +
                "id=" + id +
                ", created_at=" + created_at +
                ", balance=" + balance +
                '}';
    }

}
