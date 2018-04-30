package com.hsbc.test.trades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TradeTransactions {

    private List<Trade> tradesList;

    public void readAndProcess(String inputFile) {

        try {
            tradesList = Files.lines(Paths.get("src", "test", "resources",inputFile)).skip(1).map(mapToTrade).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Function<String, Trade> mapToTrade = (line) -> {
        String[] fieldsArray = line.split(",");
        Trade trade = new TradeBuilder()
                .withTradeId(fieldsArray[0])
                .withTradeDateId(fieldsArray[1])
                .withInstrumentId(fieldsArray[2])
                .withQuantity(fieldsArray[3])
                .withPrice(fieldsArray[4])
                .withAmount(fieldsArray[5])
                .withTrader(fieldsArray[6])
                .build();

        return trade;
    };

    public Map<String, List<Trade>> getInstrumentWiseTradedVolumeInDataRange(Date fromDate, Date toDate) {

        Map<String, List<Trade>> result =
                tradesList
                        .stream()
                        .filter(trade -> (!trade.getTradeDateInDateFormat().before(fromDate) && !trade.getTradeDateInDateFormat().after(toDate)))
                        .collect(Collectors.groupingBy(Trade::getInstrumentId));

        return result;
    }
}
