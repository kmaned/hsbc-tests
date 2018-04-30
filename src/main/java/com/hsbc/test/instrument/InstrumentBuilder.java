package com.hsbc.test.instrument;

import com.hsbc.test.trades.Trade;

public class InstrumentBuilder {

    private String instrumentID;
    private String instrumentName;

    public InstrumentBuilder withInstrumentId(String instrumentID) {
        this.instrumentID = instrumentID;
        return this;
    }

    public InstrumentBuilder withInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
        return this;
    }

    public Instrument build() {
        return new Instrument(instrumentID,
                instrumentName);
    }


}
