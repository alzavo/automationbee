package com.ipfdigital.bee.automation.test.mx.generator;

import static com.ipfdigital.bee.automation.test.mx.generator.DataField.*;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import com.ipfdigital.bee.automation.test.global.generator.ScorecardVariable;
import com.ipfdigital.bee.automation.test.mx.engine.Field;
import com.ipfdigital.bee.automation.test.mx.util.ScorecardTypes;

public class AppScorecardDictionaryMX extends ScorecardDictionaryMX {
	
	  private static final int CONSTANT = 200;
	  private static final int MIN_SCORE = 160;
	  private static final int MAX_SCORE = 290;
	  private static final String SCORECARD_TYPE = ScorecardTypes.ASC.name();
	  
	  private static Map<Field, List<ScorecardVariable>> staticScores;

	  static {
		    staticScores = new HashMap<>();
		    staticScores.put(RS_09_1, buildRs09());
		    staticScores.put(MF_SCORE, buildMfScore());
		    staticScores.put(NET_INCOME, buildNetIncome());
		    staticScores.put(DATE_OF_BIRTH, buildAgeScorecard());
		    staticScores.put(EDUCATION, buildEducation());
		    staticScores.put(OPERATING_SYSTEM, buildOperatingSystem());
		    staticScores.put(APPS_REGULAR_REJECTED_M_6, buildAppsRegularRejectedM6());
		    staticScores.put(DEPENDENTS_IN_HOUSEHOLD, buildDependentsInHousehold());
		    staticScores.put(OPEN_PERSONAL_LOANS, buildOpenPersonalLoans());
		    staticScores.put(OPEN_CREDIT_CARDS, buildOpenCreditCards());
		    staticScores.put(NUMBER_OF_REVOLVING_ACCOUNTS, buildNumberOfRevolvingAccounts());
		    staticScores.put(RS_04_1, buildNumberOfOverdueAccounts());
		    staticScores.put(RS_13_1, buildDefaultRatio());
		    staticScores.put(TOTAL_AMOUNT_OF_MAXIMUM_CREDITS, buildAmountOfMaximumCredits());
		    staticScores.put(YEARS_SINCE_MOST_RECENT_ACCOUNT, buildYearsSinceMostRecentAccount());
		    staticScores.put(INQUIRIES_IN_60_DAYS, buildInquiriesIn60Days());

		  }


	@Override
	public Stream<Entry<Field, List<ScorecardVariable>>> asStream() {
		Map<Field, List<ScorecardVariable>> scores = new HashMap<>(staticScores);
		return scores.entrySet().stream();
	}

	@Override
	public int getConstant() {
		return CONSTANT;
	}

	@Override
	public int getMinScore() {
		return MIN_SCORE;
	}

	@Override
	public int getMaxScore() {
		return MAX_SCORE;
	}
	
	@Override
	public String getType() {
		return SCORECARD_TYPE;
	}
	
	  private static List<ScorecardVariable> buildRs09() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("100", 0));
		    return list;
		  }

		  private static List<ScorecardVariable> buildAgeScorecard() {
		    final List<ScorecardVariable> age = new LinkedList<>();
		    age.add(new ScorecardVariable("970130", -4));
		    age.add(new ScorecardVariable("880130", 0));
		    age.add(new ScorecardVariable("780130", 2));
		    age.add(new ScorecardVariable("680130", 7));
		    return age;
		  }

		  private static List<ScorecardVariable> buildEducation() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("POLYTECHNIC", -6));
		    list.add(new ScorecardVariable("POST_GRADUATE", 7));
		    list.add(new ScorecardVariable("PRIMARY", -11));
		    list.add(new ScorecardVariable("UNIVERSITY", 4));
		    return list;
		  }

		  private static List<ScorecardVariable> buildDefaultRatio() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("0", 6));
		    list.add(new ScorecardVariable("5", 1));
		    list.add(new ScorecardVariable("10", -3));
		    list.add(new ScorecardVariable("16", -3));
		    list.add(new ScorecardVariable("24", -5));
		    list.add(new ScorecardVariable("40", -12));
		    return list;
		  }

		  private static List<ScorecardVariable> buildNetIncome() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("0", -1, true));
		    list.add(new ScorecardVariable("499990", -1, true));
		    list.add(new ScorecardVariable("900001", 0));
		    list.add(new ScorecardVariable("990000", 0));
		    list.add(new ScorecardVariable("999999", 0));
		    list.add(new ScorecardVariable("1000000", 0));
		    list.add(new ScorecardVariable("1000010", 0));
		    list.add(new ScorecardVariable("1130001", 1));
		    list.add(new ScorecardVariable("1800001", 3));
		    list.add(new ScorecardVariable("1999980", 3));
		    list.add(new ScorecardVariable("1999990", 3));
		    list.add(new ScorecardVariable("1999999", 3));
		    list.add(new ScorecardVariable("2000010", 3));
		    list.add(new ScorecardVariable("2000000", 3));
		    list.add(new ScorecardVariable("2000020", 3));
		    list.add(new ScorecardVariable("2780001", 5));
		    list.add(new ScorecardVariable("2999990", 5));
		    list.add(new ScorecardVariable("3000000", 5));
		    list.add(new ScorecardVariable("3000020", 5));
		    list.add(new ScorecardVariable("3000030", 5));
		    list.add(new ScorecardVariable("3999980", 5));
		    list.add(new ScorecardVariable("3999990", 5));
		    list.add(new ScorecardVariable("4000000", 5));
		    list.add(new ScorecardVariable("4000020", 5));
		    list.add(new ScorecardVariable("4000030", 5));
		    list.add(new ScorecardVariable("4000040", 5));
		    list.add(new ScorecardVariable("4666897", 5));
		    list.add(new ScorecardVariable("4666900", 5));
		    list.add(new ScorecardVariable("4999990", 5));
		    list.add(new ScorecardVariable("5000000", 5));
		    list.add(new ScorecardVariable("5000040", 5));
		    list.add(new ScorecardVariable("5000050", 5));
		    list.add(new ScorecardVariable("5000060", 5));
		    list.add(new ScorecardVariable("5999980", 5));
		    list.add(new ScorecardVariable("5999990", 5));
		    list.add(new ScorecardVariable("6000000", 5));
		    list.add(new ScorecardVariable("6000040", 5));
		    list.add(new ScorecardVariable("6000050", 5));
		    list.add(new ScorecardVariable("6000060", 5));
		    list.add(new ScorecardVariable("6999990", 5));
		    list.add(new ScorecardVariable("7000000", 5));
		    list.add(new ScorecardVariable("7000060", 5));
		    list.add(new ScorecardVariable("7000070", 5));
		    list.add(new ScorecardVariable("7999980", 5));
		    list.add(new ScorecardVariable("7999990", 5));
		    list.add(new ScorecardVariable("8000000", 5));
		    list.add(new ScorecardVariable("8000060", 5));
		    list.add(new ScorecardVariable("8000070", 5));
		    list.add(new ScorecardVariable("8000080", 5));
		    list.add(new ScorecardVariable("8000090", 5));
		    list.add(new ScorecardVariable("8999990", 5));
		    list.add(new ScorecardVariable("9000000", 5));
		    list.add(new ScorecardVariable("9000080", 5));
		    list.add(new ScorecardVariable("9000090", 5));
		    list.add(new ScorecardVariable("9999980", 5));
		    list.add(new ScorecardVariable("9999990", 5));
		    list.add(new ScorecardVariable("10000000", 5));
		    list.add(new ScorecardVariable("10000080", 5));
		    list.add(new ScorecardVariable("10000090", 5));
		    list.add(new ScorecardVariable("10000100", 5));
		    list.add(new ScorecardVariable("10999990", 5));
		    list.add(new ScorecardVariable("11000000", 5));
		    list.add(new ScorecardVariable("11000100", 5));
		    list.add(new ScorecardVariable("11000110", 5));
		    list.add(new ScorecardVariable("11999980", 5));
		    list.add(new ScorecardVariable("11999990", 5));
		    list.add(new ScorecardVariable("11999999", 5));
		    list.add(new ScorecardVariable("12000000", 5));
		    list.add(new ScorecardVariable("12000100", 5));
		    list.add(new ScorecardVariable("12000110", 5));
		    list.add(new ScorecardVariable("12000120", 5));
		    list.add(new ScorecardVariable("12999990", 5));
		    list.add(new ScorecardVariable("13000000", 5));
		    list.add(new ScorecardVariable("13000120", 5));
		    list.add(new ScorecardVariable("13000130", 5));
		    list.add(new ScorecardVariable("13000140", 5));
		    list.add(new ScorecardVariable("13999980", 5));
		    list.add(new ScorecardVariable("13999990", 5));
		    list.add(new ScorecardVariable("14000000", 5));
		    list.add(new ScorecardVariable("14000120", 5));
		    list.add(new ScorecardVariable("14000130", 5));
		    list.add(new ScorecardVariable("14000140", 5));
		    list.add(new ScorecardVariable("14999990", 5));
		    list.add(new ScorecardVariable("15000000", 5));
		    list.add(new ScorecardVariable("15000140", 5));
		    list.add(new ScorecardVariable("15000150", 5));
		    list.add(new ScorecardVariable("15999980", 5));
		    list.add(new ScorecardVariable("15999990", 5));
		    list.add(new ScorecardVariable("16000000", 5));
		    list.add(new ScorecardVariable("16000140", 5));
		    list.add(new ScorecardVariable("16000150", 5));
		    list.add(new ScorecardVariable("16000160", 5));
		    list.add(new ScorecardVariable("16999990", 5));
		    list.add(new ScorecardVariable("17000160", 5));
		    list.add(new ScorecardVariable("17000000", 5));
		    list.add(new ScorecardVariable("17000170", 5));
		    list.add(new ScorecardVariable("17999980", 5));
		    list.add(new ScorecardVariable("17999990", 5));
		    list.add(new ScorecardVariable("18000000", 5));
		    list.add(new ScorecardVariable("18000160", 5));
		    list.add(new ScorecardVariable("18000170", 5));
		    list.add(new ScorecardVariable("18000180", 5));
		    list.add(new ScorecardVariable("18999990", 5));
		    list.add(new ScorecardVariable("19000000", 5));
		    list.add(new ScorecardVariable("19000180", 5));
		    list.add(new ScorecardVariable("19000190", 5));
		    list.add(new ScorecardVariable("19999980", 5));
		    list.add(new ScorecardVariable("19999990", 5));
		    list.add(new ScorecardVariable("20000000", 5));
		    list.add(new ScorecardVariable("20000180", 5));
		    list.add(new ScorecardVariable("20000190", 5));
		    list.add(new ScorecardVariable("20000200", 5));
		    list.add(new ScorecardVariable("20000210", 5));
		    list.add(new ScorecardVariable("20999990", 5));
		    list.add(new ScorecardVariable("21000000", 5));
		    list.add(new ScorecardVariable("21000200", 5));
		    list.add(new ScorecardVariable("21000210", 5));
		    list.add(new ScorecardVariable("21999980", 5));
		    list.add(new ScorecardVariable("21999990", 5));
		    list.add(new ScorecardVariable("22000000", 5));
		    list.add(new ScorecardVariable("22000200", 5));
		    list.add(new ScorecardVariable("22000210", 5));
		    list.add(new ScorecardVariable("22000220", 5));
		    list.add(new ScorecardVariable("22999990", 5));
		    list.add(new ScorecardVariable("23000000", 5));
		    list.add(new ScorecardVariable("23000220", 5));
		    list.add(new ScorecardVariable("23000230", 5));
		    list.add(new ScorecardVariable("23999980", 5));
		    list.add(new ScorecardVariable("23999990", 5));
		    list.add(new ScorecardVariable("24000000", 5));
		    list.add(new ScorecardVariable("24000220", 5));
		    list.add(new ScorecardVariable("24000230", 5));
		    list.add(new ScorecardVariable("24000240", 5));
		    list.add(new ScorecardVariable("24999980", 5));
		    list.add(new ScorecardVariable("24999990", 5));
		    list.add(new ScorecardVariable("25000000", 5));
		    list.add(new ScorecardVariable("25000240", 5));
		    list.add(new ScorecardVariable("25000250", 5));
		    list.add(new ScorecardVariable("25999980", 5));
		    list.add(new ScorecardVariable("25999990", 5));
		    list.add(new ScorecardVariable("26000000", 5));
		    list.add(new ScorecardVariable("26000240", 5));
		    list.add(new ScorecardVariable("26000250", 5));
		    list.add(new ScorecardVariable("26000260", 5));
		    list.add(new ScorecardVariable("26999980", 5));
		    list.add(new ScorecardVariable("26999990", 5));
		    list.add(new ScorecardVariable("27000000", 5));
		    list.add(new ScorecardVariable("27000260", 5));
		    list.add(new ScorecardVariable("27000270", 5));
		    list.add(new ScorecardVariable("27999980", 5));
		    list.add(new ScorecardVariable("27999990", 5));
		    list.add(new ScorecardVariable("28000000", 5));
		    list.add(new ScorecardVariable("28000260", 5));
		    list.add(new ScorecardVariable("28000270", 5));
		    list.add(new ScorecardVariable("28000280", 5));
		    list.add(new ScorecardVariable("28999980", 5));
		    list.add(new ScorecardVariable("28999990", 5));
		    list.add(new ScorecardVariable("29000000", 5));
		    list.add(new ScorecardVariable("29000280", 5));
		    list.add(new ScorecardVariable("29000290", 5));
		    list.add(new ScorecardVariable("29999980", 5));
		    list.add(new ScorecardVariable("29999990", 5));
		    list.add(new ScorecardVariable("30000000", 5));
		    list.add(new ScorecardVariable("30000280", 5));
		    list.add(new ScorecardVariable("30000290", 5));
		    list.add(new ScorecardVariable("30000300", 5));
		    list.add(new ScorecardVariable("30999990", 5));
		    list.add(new ScorecardVariable("31000000", 5));
		    list.add(new ScorecardVariable("31000300", 5));
		    list.add(new ScorecardVariable("31000310", 5));
		    list.add(new ScorecardVariable("31999980", 5));
		    list.add(new ScorecardVariable("31999990", 5));
		    list.add(new ScorecardVariable("32000000", 5));
		    list.add(new ScorecardVariable("32000300", 5));
		    list.add(new ScorecardVariable("32000310", 5));
		    list.add(new ScorecardVariable("32000320", 5));
		    list.add(new ScorecardVariable("32999990", 5));
		    list.add(new ScorecardVariable("33000000", 5));
		    list.add(new ScorecardVariable("33000320", 5));
		    list.add(new ScorecardVariable("33000330", 5));
		    list.add(new ScorecardVariable("33999980", 5));
		    list.add(new ScorecardVariable("33999990", 5));
		    list.add(new ScorecardVariable("34000000", 5));
		    list.add(new ScorecardVariable("34000320", 5));
		    list.add(new ScorecardVariable("34000330", 5));
		    list.add(new ScorecardVariable("34000340", 5));
		    list.add(new ScorecardVariable("34999990", 5));
		    list.add(new ScorecardVariable("35000000", 5));
		    list.add(new ScorecardVariable("35000340", 5));
		    list.add(new ScorecardVariable("35000350", 5));
		    list.add(new ScorecardVariable("35999980", 5));
		    list.add(new ScorecardVariable("35999990", 5));
		    list.add(new ScorecardVariable("36000000", 5));
		    list.add(new ScorecardVariable("36000340", 5));
		    list.add(new ScorecardVariable("36000350", 5));
		    list.add(new ScorecardVariable("36000360", 5));
		    list.add(new ScorecardVariable("36999990", 5));
		    list.add(new ScorecardVariable("37000000", 5));
		    list.add(new ScorecardVariable("37000360", 5));
		    list.add(new ScorecardVariable("37000370", 5));
		    list.add(new ScorecardVariable("37999980", 5));
		    list.add(new ScorecardVariable("37999990", 5));
		    list.add(new ScorecardVariable("38000000", 5));
		    list.add(new ScorecardVariable("38000360", 5));
		    list.add(new ScorecardVariable("38000370", 5));
		    list.add(new ScorecardVariable("38000380", 5));
		    list.add(new ScorecardVariable("38999990", 5));
		    list.add(new ScorecardVariable("39000000", 5));
		    list.add(new ScorecardVariable("39000380", 5));
		    list.add(new ScorecardVariable("39000390", 5));
		    list.add(new ScorecardVariable("39999980", 5));
		    list.add(new ScorecardVariable("39999990", 5));
		    list.add(new ScorecardVariable("40000000", 5));
		    list.add(new ScorecardVariable("40000380", 5));
		    list.add(new ScorecardVariable("40000390", 5));
		    list.add(new ScorecardVariable("40000400", 5));
		    list.add(new ScorecardVariable("40000410", 5));
		    list.add(new ScorecardVariable("40000400", 5));
		    list.add(new ScorecardVariable("40999990", 5));
		    list.add(new ScorecardVariable("41000000", 5));
		    list.add(new ScorecardVariable("41000410", 5));
		    list.add(new ScorecardVariable("41999980", 5));
		    list.add(new ScorecardVariable("41999990", 5));
		    list.add(new ScorecardVariable("42000000", 5));
		    list.add(new ScorecardVariable("42000410", 5));
		    list.add(new ScorecardVariable("42000420", 5));
		    list.add(new ScorecardVariable("42999990", 5));
		    list.add(new ScorecardVariable("43000000", 5));
		    list.add(new ScorecardVariable("43000420", 5));
		    list.add(new ScorecardVariable("43000430", 5));
		    list.add(new ScorecardVariable("43999980", 5));
		    list.add(new ScorecardVariable("43999990", 5));
		    list.add(new ScorecardVariable("44000000", 5));
		    list.add(new ScorecardVariable("44000430", 5));
		    list.add(new ScorecardVariable("44000440", 5));
		    list.add(new ScorecardVariable("44999990", 5));
		    list.add(new ScorecardVariable("45000000", 5));
		    list.add(new ScorecardVariable("45000440", 5));
		    list.add(new ScorecardVariable("45000450", 5));
		    list.add(new ScorecardVariable("45999980", 5));
		    list.add(new ScorecardVariable("45999990", 5));
		    list.add(new ScorecardVariable("46000000", 5));
		    list.add(new ScorecardVariable("46000450", 5));
		    list.add(new ScorecardVariable("46000460", 5));
		    list.add(new ScorecardVariable("46000460", 5));
		    list.add(new ScorecardVariable("46999990", 5));
		    list.add(new ScorecardVariable("47000000", 5));
		    list.add(new ScorecardVariable("47000460", 5));
		    list.add(new ScorecardVariable("47000470", 5));
		    list.add(new ScorecardVariable("47999980", 5));
		    list.add(new ScorecardVariable("47999990", 5));
		    list.add(new ScorecardVariable("48000000", 5));
		    list.add(new ScorecardVariable("48000470", 5));
		    list.add(new ScorecardVariable("48000480", 5));
		    list.add(new ScorecardVariable("48999990", 5));
		    list.add(new ScorecardVariable("49000000", 5));
		    list.add(new ScorecardVariable("49000480", 5));
		    list.add(new ScorecardVariable("49000490", 5));
		    list.add(new ScorecardVariable("49999980", 5));
		    list.add(new ScorecardVariable("49999990", 5));
		    list.add(new ScorecardVariable("50000000", 5));
		    list.add(new ScorecardVariable("50000480", 5));
		    list.add(new ScorecardVariable("50000490", 5));
		    list.add(new ScorecardVariable("50000500", 5));
		    list.add(new ScorecardVariable("50999990", 5));
		    list.add(new ScorecardVariable("51000000", 5));
		    list.add(new ScorecardVariable("51000500", 5));
		    list.add(new ScorecardVariable("51000510", 5));
		    list.add(new ScorecardVariable("51999980", 5));
		    list.add(new ScorecardVariable("51999990", 5));
		    list.add(new ScorecardVariable("52000000", 5));
		    list.add(new ScorecardVariable("52000510", 5));
		    list.add(new ScorecardVariable("52000520", 5));
		    list.add(new ScorecardVariable("52999990", 5));
		    list.add(new ScorecardVariable("53000000", 5));
		    list.add(new ScorecardVariable("53000520", 5));
		    list.add(new ScorecardVariable("53000530", 5));
		    list.add(new ScorecardVariable("53999980", 5));
		    list.add(new ScorecardVariable("53999990", 5));
		    list.add(new ScorecardVariable("54000000", 5));
		    list.add(new ScorecardVariable("54000530", 5));
		    list.add(new ScorecardVariable("54000540", 5));
		    list.add(new ScorecardVariable("54999990", 5));
		    list.add(new ScorecardVariable("55000000", 5));
		    list.add(new ScorecardVariable("55000540", 5));
		    list.add(new ScorecardVariable("55000550", 5));
		    list.add(new ScorecardVariable("55999980", 5));
		    list.add(new ScorecardVariable("55999990", 5));
		    list.add(new ScorecardVariable("56000000", 5));
		    list.add(new ScorecardVariable("56000550", 5));
		    list.add(new ScorecardVariable("56000560", 5));
		    list.add(new ScorecardVariable("56999990", 5));
		    list.add(new ScorecardVariable("57000000", 5));
		    list.add(new ScorecardVariable("57000560", 5));
		    list.add(new ScorecardVariable("57000570", 5));
		    list.add(new ScorecardVariable("57999980", 5));
		    list.add(new ScorecardVariable("57999990", 5));
		    list.add(new ScorecardVariable("58000000", 5));
		    list.add(new ScorecardVariable("58000570", 5));
		    list.add(new ScorecardVariable("58000580", 5));
		    list.add(new ScorecardVariable("58999990", 5));
		    list.add(new ScorecardVariable("59000000", 5));
		    list.add(new ScorecardVariable("59000580", 5));
		    list.add(new ScorecardVariable("59000590", 5));
		    list.add(new ScorecardVariable("59999980", 5));
		    list.add(new ScorecardVariable("59999990", 5));
		    list.add(new ScorecardVariable("60000000", 5));
		    list.add(new ScorecardVariable("60000580", 5));
		    list.add(new ScorecardVariable("60000590", 5));
		    list.add(new ScorecardVariable("60000600", 5));
		    list.add(new ScorecardVariable("60999990", 5));
		    list.add(new ScorecardVariable("61000000", 5));
		    list.add(new ScorecardVariable("61000600", 5));
		    list.add(new ScorecardVariable("61000610", 5));
		    list.add(new ScorecardVariable("61999980", 5));
		    list.add(new ScorecardVariable("61999990", 5));
		    list.add(new ScorecardVariable("62000000", 5));
		    list.add(new ScorecardVariable("62000610", 5));
		    list.add(new ScorecardVariable("62000620", 5));
		    list.add(new ScorecardVariable("62999990", 5));
		    list.add(new ScorecardVariable("63000000", 5));
		    list.add(new ScorecardVariable("63000620", 5));
		    list.add(new ScorecardVariable("63000630", 5));
		    list.add(new ScorecardVariable("63999980", 5));
		    list.add(new ScorecardVariable("63999990", 5));
		    list.add(new ScorecardVariable("64000000", 5));
		    list.add(new ScorecardVariable("64000630", 5));
		    list.add(new ScorecardVariable("64000640", 5));
		    list.add(new ScorecardVariable("64999990", 5));
		    list.add(new ScorecardVariable("65000000", 5));
		    list.add(new ScorecardVariable("65000640", 5));
		    list.add(new ScorecardVariable("65000650", 5));
		    list.add(new ScorecardVariable("65999980", 5));
		    list.add(new ScorecardVariable("65999990", 5));
		    list.add(new ScorecardVariable("66000000", 5));
		    list.add(new ScorecardVariable("66000650", 5));
		    list.add(new ScorecardVariable("66000660", 5));
		    list.add(new ScorecardVariable("66999990", 5));
		    list.add(new ScorecardVariable("67000000", 5));
		    list.add(new ScorecardVariable("67000660", 5));
		    list.add(new ScorecardVariable("67000670", 5));
		    list.add(new ScorecardVariable("67999980", 5));
		    list.add(new ScorecardVariable("67999990", 5));
		    list.add(new ScorecardVariable("68000000", 5));
		    list.add(new ScorecardVariable("68000670", 5));
		    list.add(new ScorecardVariable("68000680", 5));
		    list.add(new ScorecardVariable("68999990", 5));
		    list.add(new ScorecardVariable("69000000", 5));
		    list.add(new ScorecardVariable("69000680", 5));
		    list.add(new ScorecardVariable("69000690", 5));
		    list.add(new ScorecardVariable("69999980", 5));
		    list.add(new ScorecardVariable("69999990", 5));
		    list.add(new ScorecardVariable("70000000", 5));
		    list.add(new ScorecardVariable("70000680", 5));
		    list.add(new ScorecardVariable("70000690", 5));
		    list.add(new ScorecardVariable("70000700", 5));
		    list.add(new ScorecardVariable("70000800", 5));
		    list.add(new ScorecardVariable("70999990", 5));
		    list.add(new ScorecardVariable("71000000", 5));
		    list.add(new ScorecardVariable("71999980", 5));
		    list.add(new ScorecardVariable("71999990", 5));
		    list.add(new ScorecardVariable("72000000", 5));
		    list.add(new ScorecardVariable("72999990", 5));
		    list.add(new ScorecardVariable("73999980", 5));
		    list.add(new ScorecardVariable("73000000", 5));
		    list.add(new ScorecardVariable("73999990", 5));
		    list.add(new ScorecardVariable("74000000", 5));
		    list.add(new ScorecardVariable("74999990", 5));
		    list.add(new ScorecardVariable("75999980", 5));
		    list.add(new ScorecardVariable("76000000", 5));
		    list.add(new ScorecardVariable("77999980", 5));
		    list.add(new ScorecardVariable("79999980", 5));
		    list.add(new ScorecardVariable("78000000", 5));
		    list.add(new ScorecardVariable("80000000", 5));
		    list.add(new ScorecardVariable("80000780", 5));
		    list.add(new ScorecardVariable("80000800", 5));
		    list.add(new ScorecardVariable("81999980", 5));
		    list.add(new ScorecardVariable("82000000", 5));
		    list.add(new ScorecardVariable("83999980", 5));
		    list.add(new ScorecardVariable("84000000", 5));
		    list.add(new ScorecardVariable("85999980", 5));
		    list.add(new ScorecardVariable("86000000", 5));
		    list.add(new ScorecardVariable("87999980", 5));
		    list.add(new ScorecardVariable("88000000", 5));
		    list.add(new ScorecardVariable("89999980", 5));
		    list.add(new ScorecardVariable("90000000", 5));
		    list.add(new ScorecardVariable("90000880", 5));
		    list.add(new ScorecardVariable("90000900", 5));
		    list.add(new ScorecardVariable("91999980", 5));
		    list.add(new ScorecardVariable("92000000", 5));
		    list.add(new ScorecardVariable("93999980", 5));
		    list.add(new ScorecardVariable("94000000", 5));
		    list.add(new ScorecardVariable("95999980", 5));
		    list.add(new ScorecardVariable("96000000", 5));
		    list.add(new ScorecardVariable("97999980", 5));
		    list.add(new ScorecardVariable("98000000", 5));
		    list.add(new ScorecardVariable("99999980", 5));
		    list.add(new ScorecardVariable("100000000", 5));
		    list.add(new ScorecardVariable("100000980", 5));
		    list.add(new ScorecardVariable("100001000", 5));
		    list.add(new ScorecardVariable("101999980", 5));
		    list.add(new ScorecardVariable("102000000", 5));
		    list.add(new ScorecardVariable("103999980", 5));
		    list.add(new ScorecardVariable("104000000", 5));
		    list.add(new ScorecardVariable("105999980", 5));
		    list.add(new ScorecardVariable("106000000", 5));
		    list.add(new ScorecardVariable("107999980", 5));
		    list.add(new ScorecardVariable("108000000", 5));
		    list.add(new ScorecardVariable("109999980", 5));
		    list.add(new ScorecardVariable("110000000", 5));
		    list.add(new ScorecardVariable("110001080", 5));
		    list.add(new ScorecardVariable("110001100", 5));
		    list.add(new ScorecardVariable("111999980", 5));
		    list.add(new ScorecardVariable("112000000", 5));
		    list.add(new ScorecardVariable("113999980", 5));
		    list.add(new ScorecardVariable("114000000", 5));
		    list.add(new ScorecardVariable("115999980", 5));
		    list.add(new ScorecardVariable("116000000", 5));
		    list.add(new ScorecardVariable("117999980", 5));
		    list.add(new ScorecardVariable("118000000", 5));
		    list.add(new ScorecardVariable("119000000", 5));
		    list.add(new ScorecardVariable("119999980", 5));
		    list.add(new ScorecardVariable("120000000", 5));
		    list.add(new ScorecardVariable("120001180", 5));
		    list.add(new ScorecardVariable("120001200", 5));
		    list.add(new ScorecardVariable("121999980", 5));
		    list.add(new ScorecardVariable("122000000", 5));
		    list.add(new ScorecardVariable("123999980", 5));
		    list.add(new ScorecardVariable("124000000", 5));
		    list.add(new ScorecardVariable("125999980", 5));
		    list.add(new ScorecardVariable("126000000", 5));
		    list.add(new ScorecardVariable("127999980", 5));
		    list.add(new ScorecardVariable("128000000", 5));
		    list.add(new ScorecardVariable("129999980", 5));
		    list.add(new ScorecardVariable("130000000", 5));
		    list.add(new ScorecardVariable("130001280", 5));
		    list.add(new ScorecardVariable("130001300", 5));
		    list.add(new ScorecardVariable("131999980", 5));
		    list.add(new ScorecardVariable("132000000", 5));
		    list.add(new ScorecardVariable("133999980", 5));
		    list.add(new ScorecardVariable("134000000", 5));
		    list.add(new ScorecardVariable("135999980", 5));
		    list.add(new ScorecardVariable("136000000", 5));
		    list.add(new ScorecardVariable("137999980", 5));
		    list.add(new ScorecardVariable("138000000", 5));
		    list.add(new ScorecardVariable("139999980", 5));
		    list.add(new ScorecardVariable("140001380", 5));
		    list.add(new ScorecardVariable("140000000", 5));
		    list.add(new ScorecardVariable("140001400", 5));
		    list.add(new ScorecardVariable("140001600", 5));
		    list.add(new ScorecardVariable("141999980", 5));

		    return list;
		  }

		  private static List<ScorecardVariable> buildOperatingSystem() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("Android 6.0", -9));
		    list.add(new ScorecardVariable("Linux", -4));
		    list.add(new ScorecardVariable("Android 9.0", 0));
		    list.add(new ScorecardVariable("iOS 12.0.0", 3));
		    list.add(new ScorecardVariable("iOS 13.0.0", 6));
		    list.add(new ScorecardVariable("Mac", 13));
		    list.add(new ScorecardVariable("Windows XP", 5));
		    list.add(new ScorecardVariable("Windows 10", 9));
		    list.add(new ScorecardVariable("SunOS", 1));
		    return list;
		  }

		  private static List<ScorecardVariable> buildNumberOfRevolvingAccounts() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("0", -5));
		    list.add(new ScorecardVariable("1", -5));
		    list.add(new ScorecardVariable("2", -3));
		    list.add(new ScorecardVariable("4", -1));
		    list.add(new ScorecardVariable("7", 3));
		    list.add(new ScorecardVariable("10", 5));
		    list.add(new ScorecardVariable("15", 8));
		    return list;
		  }

		  private static List<ScorecardVariable> buildMfScore() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("-008", -8, true));
		    list.add(new ScorecardVariable("-009", -8, true));
		    list.add(new ScorecardVariable("-9", -8, true));
		    list.add(new ScorecardVariable("-5", -8, true));
		    list.add(new ScorecardVariable("-3", -8, true));
		    list.add(new ScorecardVariable("-1", -8, true));
		    list.add(new ScorecardVariable("0", -8, true));
		    list.add(new ScorecardVariable("1", -10, true));
		    list.add(new ScorecardVariable("584", -10, true));
		    list.add(new ScorecardVariable("585", -8, true));
		    list.add(new ScorecardVariable("619", -8, true));
		    list.add(new ScorecardVariable("620", -8, true));
		    list.add(new ScorecardVariable("621", -8));
		    list.add(new ScorecardVariable("627", -4));
		    list.add(new ScorecardVariable("642", -1));
		    list.add(new ScorecardVariable("656", 2));
		    list.add(new ScorecardVariable("674", 4));
		    list.add(new ScorecardVariable("694", 8));
		    return list;
		  }

		  private static List<ScorecardVariable> buildOpenCreditCards() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("0", -4));
		    list.add(new ScorecardVariable("1", -2));
		    list.add(new ScorecardVariable("2", 2));
		    list.add(new ScorecardVariable("3", 6));
		    list.add(new ScorecardVariable("6", 9));
		    return list;
		  }

		  private static List<ScorecardVariable> buildInquiriesIn60Days() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("0", 9));
		    list.add(new ScorecardVariable("2", 5));
		    list.add(new ScorecardVariable("3", 1));
		    list.add(new ScorecardVariable("5", -5));
		    list.add(new ScorecardVariable("6", -7));
		    list.add(new ScorecardVariable("11", -15));
		    return list;
		  }

		  private static List<ScorecardVariable> buildAppsRegularRejectedM6() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("0", 2));
		    list.add(new ScorecardVariable("1", -3));
		    list.add(new ScorecardVariable("2", -6));
		    list.add(new ScorecardVariable("3", -9));
		    return list;
		  }

		  private static List<ScorecardVariable> buildYearsSinceMostRecentAccount() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("30102017", -1));
		    list.add(new ScorecardVariable("30082017", 1));
		    list.add(new ScorecardVariable("30072017", 3));
		    list.add(new ScorecardVariable("31012017", 4));
		    return list;
		  }

		  private static List<ScorecardVariable> buildDependentsInHousehold() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("0", 3));
		    list.add(new ScorecardVariable("1", -1));
		    list.add(new ScorecardVariable("2", -4));
		    return list;
		  }

		  private static List<ScorecardVariable> buildOpenPersonalLoans() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("0", 4));
		    list.add(new ScorecardVariable("1", 3));
		    list.add(new ScorecardVariable("2", -1));
		    list.add(new ScorecardVariable("4", -5));
		    return list;
		  }

		  private static List<ScorecardVariable> buildNumberOfOverdueAccounts() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("0", 2));
		    list.add(new ScorecardVariable("1", -2));
		    list.add(new ScorecardVariable("2", -10));
		    list.add(new ScorecardVariable("3", -10));
		    return list;
		  }

		  private static List<ScorecardVariable> buildAmountOfMaximumCredits() {
		    final List<ScorecardVariable> list = new LinkedList<>();
		    list.add(new ScorecardVariable("0", -2));
		    list.add(new ScorecardVariable("1", -1));
		    list.add(new ScorecardVariable("26301", 0));
		    list.add(new ScorecardVariable("46001", 1));
		    list.add(new ScorecardVariable("95001", 3));
		    list.add(new ScorecardVariable("170001", 6));
		    return list;
		  }

}
