package com.hsbc.test.instrument;

public class Instrument {
    private String instrumentID;
    private String instrumentName;

    public Instrument(String instrumentID, String instrumentName) {
        this.instrumentID = instrumentID;
        this.instrumentName = instrumentName;
    }

    public String getInstrumentID() {
        return instrumentID;
    }

    public String getInstrumentName() {
        return instrumentName;
    }
}
