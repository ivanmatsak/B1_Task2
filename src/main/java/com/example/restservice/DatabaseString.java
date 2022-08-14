package com.example.restservice;

import java.math.BigDecimal;

public class DatabaseString {//Класс, который представляет из себя строку из таблицы бд
    private int id;
    private String number;
    //Используем тип BigDecimal, потому что числа в бд большие, но при этом имеют знаки после запятой
    private BigDecimal incomingSaldoActive;
    private BigDecimal incomingSaldoPassive;
    private BigDecimal turnoverDebet;
    private BigDecimal turnoverCredit;
    private BigDecimal outgoingSaldoActive;
    private BigDecimal outgoingSaldoPassive;

    @Override
    public String toString() {
        return "DatabaseString{" +
                "id=" + id +
                ", number=" + number +
                ", IncomingSaldoActive=" + incomingSaldoActive +
                ", IncomingSaldoPassive=" + incomingSaldoPassive +
                ", TurnoverDebet=" + turnoverDebet +
                ", TurnoverCredit=" + turnoverCredit +
                ", OutgoingSaldoActive=" + outgoingSaldoActive +
                ", OutgoingSaldoPassive=" + outgoingSaldoPassive +
                '}';
    }
    //Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getIncomingSaldoActive() {
        return incomingSaldoActive;
    }

    public void setIncomingSaldoActive(BigDecimal incomingSaldoActive) {
        this.incomingSaldoActive = incomingSaldoActive;
    }

    public BigDecimal getIncomingSaldoPassive() {
        return incomingSaldoPassive;
    }

    public void setIncomingSaldoPassive(BigDecimal incomingSaldoPassive) {
        this.incomingSaldoPassive = incomingSaldoPassive;
    }

    public BigDecimal getTurnoverDebet() {
        return turnoverDebet;
    }

    public void setTurnoverDebet(BigDecimal turnoverDebet) {
        this.turnoverDebet = turnoverDebet;
    }

    public BigDecimal getTurnoverCredit() {
        return turnoverCredit;
    }

    public void setTurnoverCredit(BigDecimal turnoverCredit) {
        this.turnoverCredit = turnoverCredit;
    }

    public BigDecimal getOutgoingSaldoActive() {
        return outgoingSaldoActive;
    }

    public void setOutgoingSaldoActive(BigDecimal outgoingSaldoActive) {
        this.outgoingSaldoActive = outgoingSaldoActive;
    }

    public BigDecimal getOutgoingSaldoPassive() {
        return outgoingSaldoPassive;
    }

    public void setOutgoingSaldoPassive(BigDecimal outgoingSaldoPassive) {
        this.outgoingSaldoPassive = outgoingSaldoPassive;
    }
}
