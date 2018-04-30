package com.hsbc.test.trades;

public class TradeBuilder {

    private String tradeId;
    private String tradeDateTime;
    private String instrumentID;
    private String quantity;
    private String price;
    private String amount;
    private String trader;

    public TradeBuilder withTradeId(String tradeId) {
        this.tradeId = tradeId;
        return this;
    }

    public TradeBuilder withTradeDateId(String tradeDateTime) {
        this.tradeDateTime = tradeDateTime;
        return this;
    }

    public TradeBuilder withInstrumentId(String instrumentID) {
        this.instrumentID = instrumentID;
        return this;
    }

    public TradeBuilder withQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    public TradeBuilder withPrice(String price) {
        this.price = price;
        return this;
    }

    public TradeBuilder withAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public TradeBuilder withTrader(String trader) {
        this.trader = trader;
        return this;
    }

    public Trade build() {
        return new Trade(tradeId,
                tradeDateTime,
                instrumentID,
                quantity,
                price,
                amount,
                trader);
    }


}
