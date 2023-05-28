Feature: user searched for Flight
@Flight
Scenario: user books flight ticket
Given user enter "DEL" text into "From"
And user click on "DEL"
And user enter "HYD" text into "To"
And user click on "HYD"
And user click on "Departure-Date"
Then user click on "moveToNext" icon
Then user click on "moveToNext" icon
Then user click on "moveToNext" icon
Then user click on "moveToPrevious" icon
And user click on "moveToPrevious"
Then user select date
And user click on "Search"
Then user click on "fareStripIconNext" icon
Then user click on "fareStripIconNext" icon
Then user click on "fareStripIconNext" icon
Then user click on "fareStripIconPrevious" icon
And user click on "Cheapest"
And user click on "Fastest"
And user click on "Stops"
And user click on "Airlines"
And user click on "Price"
And user click on "Departure"