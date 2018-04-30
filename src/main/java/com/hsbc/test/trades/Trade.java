package com.hsbc.test.trades;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trade {
    private String tradeId;
    private String tradeDateTime = "";
    private String instrumentID;
    private String quantity;
    private String price;
    private String amount;
    private String trader;

    public Trade(String tradeId,
            String tradeDateTime,
            String instrumentID,
            String quantity,
            String price,
            String amount,
            String trader) {

        this.tradeId = tradeId;
        this.tradeDateTime = tradeDateTime;
        this.instrumentID = instrumentID;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
        this.trader = trader;
    }

    public String getInstrumentId() {
        return instrumentID;
    }

    public String getTradeId() {
        return tradeId;
    }

    public Date getTradeDateInDateFormat() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date tradeDateInDateFormat = null;
        try {
            tradeDateInDateFormat = dateFormat.parse(tradeDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tradeDateInDateFormat;
    }

    public String toString() {
        return tradeId;
    }
}
