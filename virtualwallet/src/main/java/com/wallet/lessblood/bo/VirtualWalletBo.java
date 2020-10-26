package com.wallet.lessblood.bo;

import java.math.BigDecimal;

public class VirtualWalletBo {   //对应字段
    private Long id;
    private Long created_at;
    private BigDecimal balance;

    public VirtualWalletBo() {
    }

    public VirtualWalletBo(Long id, Long created_at, BigDecimal balance) {
        this.id = id;
        this.created_at = created_at;
        this.balance = balance;
    }

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
