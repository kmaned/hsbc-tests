Feature: Instrument traded volumes

Scenario Outline: Check the Instruments traded between different date ranges
  Given I have a "trades.txt" & "inst.txt" files
  And I load the app with these files
  When I pass the app with the following <from> & <to> dates
  Then I should see the following <instrumentsTraded> & <instrumentsNotTraded> in the date range

  Examples:
    | from               | to                  | instrumentsTraded    | instrumentsNotTraded                                                              |
    | 30/10/2017 23:11:01| 12/01/2018 00:11:01 | IN2-[T2,T3],IN1-[T1] |    IN3-Shares XYZ,IN4-Shares XYZ,IN5-Shares XYZ,IN6-Shares XYZ                    |
    | 30/10/2017 23:11:01| 12/01/2018 00:11:01 | IN2-[T2,T3],IN1-[T1] |    IN3-Shares XYZ,IN4-Shares XYZ,IN5-Shares XYZ,IN6-Shares XYZ                    |
    | 01/05/2015 23:11:01| 11/01/2016 00:11:01 | IN2-[T3]             |     IN1-Shares Google,IN3-Shares XYZ,IN4-Shares XYZ,IN5-Shares XYZ,IN6-Shares XYZ |




