package com.hsbc.test.instrument;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InstrumentsList {
    private List<Instrument> instrumentList;

    public void readAndProcess(String inputFile) {

        try {

            instrumentList = Files.lines(Paths.get("src", "test", "resources", inputFile)).skip(1).map(mapToInstrument).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Function<String, Instrument> mapToInstrument = (line) -> {
        String[] fieldsArray = line.split(",");
        Instrument instrument = new InstrumentBuilder()
                .withInstrumentId(fieldsArray[0])
                .withInstrumentName(fieldsArray[1])
                .build();

        return instrument;
    };

    public List<Instrument> getInstrumentList() {
        return instrumentList;
    }

    public List<Instrument> getOtherInstrumentsInList(List<String> instrumentsToExclude) {
        List<Instrument> otherInstruments =
                instrumentList.stream()
                        .filter(instrument -> !instrumentsToExclude.contains(instrument.getInstrumentID()))
                        .collect(Collectors.toList());

        return otherInstruments;
    }
}
