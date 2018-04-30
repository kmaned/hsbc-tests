# HSBC Instrument based Trade volumes extractor
App for HSBC Instruments based trade volume along with BDD based tests

**** 

**Code Structure**
Project is divided into 3 packages:
* app
* instrument
* trades

package app:
This is the main app. Its main functionality is to:
1) read the input files inst.txt and trade.txt and process them
2) provided the date range, get the trade volumes grouped by instruments in the input date range
3) provided the date range, get the instrument list not traded in the input date range
At the moment app just output to screen but can easily be modified to store the output in csv or text file.

package instrument:
consists of
* Instrument - contains the details of instrument
* InstrumentBuilder - Builder to build instrument object
* InstrumentsList - contains the master list of instruments. It provides the following functionality
    * read from input file
    * build instrument object and store it as list
    * provided a list of instruments, it returns list of instruments in the master list that are not present in the input

package trades
* Trade - contains the details of trade
* TradeBuilder - Builder to build trade object
* TradeTransactions - contains the master list of trades. It provides the following functionality
    * read from input file
    * build trade object and store it as list
    * provided a date range, it returns list of trades in the date range grouped by instruments as a map with key as instrument id
    

**App Logic**
1) Instrument wise Trade volume in the date range
    * From the list of trade, filter the trades that are not in the date range.
    * group the result by instrument id
2) List of instruments not traded in the date range
    * Output from 1) gives all the trades traded in the input date range
    * extract the instrument id from that output.
    * pass this list of instrument id that were traded to instruments list and get back the instrument ids that are not in this list.
    
**Tests Covered**
_**Cucumber based BDD tests_**
**Files**
1) Feature file - InstrumentsTraded  
2) Step Def -  Instruments_traded.feature

**Contains a feature that tests both**
 * Instrument traded volumes in a specific date range
 * Instrument not traded volumes in a specific date range

