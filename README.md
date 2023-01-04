# UI Automation for Coinmarketcap Application #

This Automation built using the Selenium framework technique

### Official Website of Selenium ###
https://www.selenium.dev/documentation/



### Technique used ###
BDD Page Object Model framework Java

### Package structure ###
1.	Feature Files – This is holding the user understandable BDD scenarios, which is written in gherkin language
2.	Steps – This package is holding the actual glue of the feature files, written in java script 
3.	Page objects – This Java script file has two sections; first part will hold all the selectors for the web elements followed by functions 
4.	Utilities – This package holds the common reusable functions written in java script

### Application used for automation ###
URL - https://coinmarketcap.com/

### Tools used ###
1. Editor – Eclipse
2. Software installed – Java
	
### Available features of automation  in the release v1.0 ###
1.	visit https://coinmarketcap.com 
2.	Show rows by 20 
3.	Capture all page contents - we will let you decide what is the correct information to capture, suggestions e.g. price, name, position 
4.	Filter by Algorith - "PoW" 
5.	followed by "+ Add Filter" 
6.	Toggle "Mineable" 
7.	Then select "All Cryptocurrencies" 
8.	Select "Coins" 
9.	Then select price and set minimum value to 100 and maximum to 10,000 
10.	Compare page content to the content in step 3 


