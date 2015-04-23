package com.lng.stock.quotes.domain;

public enum Field {
	 ASK("ask", 1),
	 AVERAGEDAILYVOLUME("averageDailyVolume",2),
	 BID("bid",3),
	 ASKREALTIME("askRealtime",4),
	 BIDREALTIME("bidRealtime",5),
	 BOOKVALUE("bookValue",6),
	 CHANGEANDPERCENTCHANGE("changeInPercentChange",7),
	 CHANGE("change",8),
	 COMMISSION("commission",9),
	 CURRENCY("currency",10),
	 CHANGEREALTIME("changeRealtime",11),
	 AFTERHOURSCHANGEREALTIME("afterHoursChangeRealtime",12),
	 DIVIDENDSHARE("dividendShare",13),
	 LASTTRADEDATE("lastTradeDate",14),
	 TRADEDATE("tradeDate",15),
	 EARNINGSSHARE("earningsShare",16),
	 ERRORINDICATIONRETURNEDFORSYMBOLCHANGEDINVALID("errorIndicationreturnedforsymbolchangedinvalid",17),
	 EPSESTIMATECURRENTYEAR("ePSEstimateCurrentYear",18),
	 EPSESTIMATENEXTYEAR("ePSEstimateNextYear",19),
	 EPSESTIMATENEXTQUARTER("ePSEstimateNextQuarter",20),
	 DAYSLOW("daysLow",21),
	 DAYSHIGH("daysHigh",22),
	 YEARLOW("yearLow",23),
	 YEARHIGH("yearHigh",24),
	 HOLDINGSGAINPERCENT("holdingsGainPercent",25),
	 ANNUALIZEDGAIN("annualizedGain",26),
	 HOLDINGSGAIN("holdingsGain",27),
	 HOLDINGSGAINPERCENTREALTIME("holdingsGainPercentRealtime",28),
	 HOLDINGSGAINREALTIME("holdingsGainRealtime",29),
	 MOREINFO("moreInfo",30),
	 ORDERBOOKREALTIME("orderBookRealtime",31),
	 MARKETCAPITALIZATION("marketCapitalization",32),
	 MARKETCAPREALTIME("marketCapRealtime",33),
	 EBITDA("eBITDA",34),
	 CHANGEFROMYEARLOW("changeFromYearLow",35),
	 PERCENTCHANGEFROMYEARLOW("percentChangeFromYearLow",36),
	 LASTTRADEREALTIMEWITHTIME("lastTradeRealtimeWithTime",37),
	 CHANGEPERCENTREALTIME("changePercentRealtime",38),
	 CHANGEFROMYEARHIGH("changeFromYearHigh",39),
	 PERCENTCHANGEFROMYEARHIGH("percentChangeFromYearHigh",40),
	 LASTTRADEWITHTIME("lastTradeWithTime",41),
	 LASTTRADEPRICEONLY("lastTradePriceOnly",42),
	 HIGHLIMIT("highLimit",43),
	 LOWLIMIT("lowLimit",44),
	 DAYSRANGE("daysRange",45),
	 DAYSRANGEREALTIME("daysRangeRealtime",46),
	 FIFYDAYMOVINGAVERAGE("fiftydayMovingAverage",47),
	 TWOHUNDREDDAYMOVINGAVERAGE("twoHundreddayMovingAverage",48),
	 CHANGEFROMTWOHUNDEREDDAYMOVINGAVERAGE("changeFromTwoHundreddayMovingAverage",49),
	 PERCENTAGECHANGEFROMTWOHUNDREDDAYMOVINGAVERAGE("percentChangeFromTwoHundreddayMovingAverage",50),
	 CHANGEFROMFIFTYDAYMOVINGAVERAGE("changeFromFiftydayMovingAverage",51),
	 PERCENTCHANGEFROMFIFTYDAYMOVINGAVERAGE("percentChangeFromFiftydayMovingAverage",52),
	 NAME("name",53),
	 NOTES("notes",54),
	 OPEN("open",55),
	 PREVIOUSCLOSE("previousClose",56),
	 PRICEPAID("pricePaid",57),
	 CHANGEINPERCENT("changeinPercent",58),
	 PRICESALES("priceSales",59),
	 PRICEBOOK("priceBook",60),
	 EXDIVIDENDDATE("exDividendDate",61),
	 PERATIO("pERatio",62),
	 DIVIDENDPAYDATE("dividendPayDate",63),
	 PERATIOREALTIME("pERatioRealtime",64),
	 PEGRATIO("pEGRatio",65),
	 PRICEEPSESTIMATECURRENTYEAR("priceEPSEstimateCurrentYear",66),
	 PRICEEPSESTIMATENEXTYEAR("priceEPSEstimateNextYear",67),
	 SYMBOL("symbol",68),
	 SHARESOWNER("sharesOwned",69),
	 SHORTRATIO("shortRatio",70),
	 LASTTRADETIME("lastTradeTime",71),
	 TICKERTREND("tickerTrend",72),
	 ONEYRTARGETPRICE("oneyrTargetPrice",73),
	 VOLUME("volume",74),
	 HOLDINGSVALUE("holdingsValue",75),
	 HOLDINGSVALUEREALTIME("holdingsValueRealtime",76),
	 YEARRANGE("yearRange",77),
	 DAYSVALUECHANGE("daysValueChange",78),
	 DAYSVALUECHANGEREALTIME("daysValueChangeRealtime",79),
	 STOCKEXCHANGE("stockExchange",80),
	 DIVIDENDYEILD("dividendYield",81);
	 
	 private String fieldName;
	 private Integer index;
	 
	 Field(String fieldName, Integer index) {
		 this.fieldName = fieldName;
		 this.index = index;
	 }
	 
	 public String getFieldName(){
		 return fieldName;
	 }
	 
	 public Integer getIndex(){
		 return index;
	 }
	 
	 public static Field getFieldByFieldName(String fieldName) {
		 for(Field field : Field.values()) {
			 if (field.getFieldName().equalsIgnoreCase(fieldName)) {
				 return field;
			 }
		 }
		 return null;
	 }
	 
	 public static Field getFieldByIndex(Integer index) {
		 for(Field field : Field.values()) {
			 if (field.getIndex() == index) {
				 return field;
			 }
		 }
		 return null;
	 }
}
