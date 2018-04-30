package com.hsbc.test.app;

import com.hsbc.test.instrument.Instrument;
import com.hsbc.test.instrument.InstrumentsList;
import com.hsbc.test.trades.Trade;
import com.hsbc.test.trades.TradeTransactions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class InstrumentsTradedVolumeApp {
    private InstrumentsList instrumentList = new InstrumentsList();

    private TradeTransactions tradeTransactions = new TradeTransactions();

    public InstrumentsTradedVolumeApp(String fromDate, String toDate) {

    }

    public void readAndProcess(String instrumentsFile, String tradesFile) {

        instrumentList.readAndProcess(instrumentsFile);
        tradeTransactions.readAndProcess(tradesFile);
    }

    public Map<String, List<Trade>> getInstrumentWiseTradedVolumeInDataRange(Date fromDate, Date toDate) {
        Map<String, List<Trade>> instrumentWiseTradeVolumeMap = tradeTransactions.getInstrumentWiseTradedVolumeInDataRange(fromDate, toDate);
        return instrumentWiseTradeVolumeMap;
    }

    public List<Instrument> getListInstrumentsNotTradedInDataRange(Date fromDate, Date toDate) {
        Map<String, List<Trade>> instrumentWiseTradeVolumeMap = tradeTransactions.getInstrumentWiseTradedVolumeInDataRange(fromDate, toDate);
        List<String> instrumentIdsTraded = new ArrayList<>(instrumentWiseTradeVolumeMap.keySet());
        List<Instrument> instrumentsNotTraded = instrumentList.getOtherInstrumentsInList(instrumentIdsTraded);
        return instrumentsNotTraded;
    }
}
