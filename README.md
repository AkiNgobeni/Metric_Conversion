# Metric_Conversion

This API is used  Metric Convertion
===================================

It converts the following :
Temperature: from Celcius to Farenheit
			 from Farenheit to Celcius
			 
Distance:  	from Kilometres to Miles
			from Miles to Kilometres
			
Currency: 	from Rand to US Dollar
			from US Dollar to Rand
			
			
			
Endpoins and Usage:
===================

Temperature:
			localhost:8080/metricContoller/v1/fromTemperatureType/CELCIUS/temperatureValue/20
			localhost:8080/metricContoller/v1/fromTemperatureType/FARENHEIT/temperatureValue/68
			
Distance:	localhost:8080/metricContoller/v1/fromDistanceType/KILOMETRES/distanceValue/10
			localhost:8080/metricContoller/v1/fromDistanceType/MILES/distanceValue/6.21
			
Currency:	localhost:8080/metricContoller/v1/fromCurrencyType/RAND/currencyValue/20
			localhost:8080/metricContoller/v1/fromCurrencyType/DOLLAR/currencyValue/1.29
			

This API can be tested using either Postman/Jmeter or web browser.
 