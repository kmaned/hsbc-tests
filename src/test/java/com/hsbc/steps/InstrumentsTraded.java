package com.hsbc.steps;

import com.hsbc.test.app.InstrumentsTradedVolumeApp;
import com.hsbc.test.instrument.Instrument;
import com.hsbc.test.trades.Trade;
import com.hsbc.utils.FormatDate;
import cucumber.api.java8.En;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InstrumentsTraded implements En {

    private String tradeFileName;
    private String instFileName;

    private static InstrumentsTradedVolumeApp instrumentsTradedVolumeApp;
    private static Map<String, List<Trade>> instrumentTradedVolume;
    private static List<Instrument> instrumentNotTraded;


    public InstrumentsTraded() {


        Given("^I have a \"([^\"]*)\" & \"([^\"]*)\" files$", (String trades, String instruments) -> {
            tradeFileName = trades;
            instFileName = instruments;
        });

        And("^I load the app with these files$", () -> {
            instrumentsTradedVolumeApp = new InstrumentsTradedVolumeApp(tradeFileName, instFileName);
            instrumentsTradedVolumeApp.readAndProcess(instFileName, tradeFileName);
        });
        When("^I pass the app with the following (.*) & (.*) dates$", (String from, String to) -> {
            instrumentTradedVolume = instrumentsTradedVolumeApp
                    .getInstrumentWiseTradedVolumeInDataRange(FormatDate.formatDate(from), FormatDate.formatDate(to));

            instrumentNotTraded = instrumentsTradedVolumeApp
                    .getListInstrumentsNotTradedInDataRange(FormatDate.formatDate(from), FormatDate.formatDate(to));


        });
        Then("^I should see the following (.*) & (.*) in the date range$", (String instTraded, String instNotTraded) -> {
            StringJoiner tradedInsts = new StringJoiner(",");
            StringJoiner tradedNotInsts = new StringJoiner(",");

            instrumentTradedVolume.forEach((k,v)->{
                String tradesCommaSeperated = v.stream().map(trade -> trade.getTradeId()).collect(Collectors.joining(","));
                tradedInsts.add(k + "-" + "[" + tradesCommaSeperated + "]");
            });

            System.out.println(tradedInsts);

            instrumentNotTraded.forEach(instrument -> {
                tradedNotInsts.add(instrument.getInstrumentID() + "-" + instrument.getInstrumentName());
            });




            assertThat(tradedInsts.toString(), is(instTraded));
            assertThat(tradedNotInsts.toString(), is(instNotTraded));

        });


    }
}
