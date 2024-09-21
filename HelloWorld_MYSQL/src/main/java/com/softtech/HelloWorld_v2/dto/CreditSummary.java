package com.softtech.HelloWorld_v2.dto;

import java.math.BigDecimal;

public class CreditSummary {
    private String creditType;
    private long count;
    private BigDecimal totalBalance;

    // Constructor
    public CreditSummary(String creditType, long count, BigDecimal totalBalance) {
        this.creditType = creditType;
        this.count = count;
        this.totalBalance = totalBalance;
    }

    // Getter ve Setter metodları
    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    // toString metodu
    @Override
    public String toString() {
        return "CreditSummary{" +
                "creditType='" + creditType + '\'' +
                ", count=" + count +
                ", totalBalance=" + totalBalance +
                '}';
    }
}
