package com.ipfdigital.bee.automation.test.mx.generator;

import com.ipfdigital.bee.automation.test.global.generator.ScorecardVariable;
import com.ipfdigital.bee.automation.test.mx.engine.Field;
import com.ipfdigital.bee.automation.test.mx.util.ScorecardTypes;

import java.util.*;
import java.util.stream.Stream;

import static com.ipfdigital.bee.automation.test.mx.generator.DataField.*;

public class BehScorecardDictionaryMX extends ScorecardDictionaryMX {

    private static final int CONSTANT = 200;

    // was 120
    private static final int MIN_SCORE = 119;
    // was 340
    private static final int MAX_SCORE = 348;

    private static final String SCORECARD_TYPE = ScorecardTypes.BSC.name();

    private static final Map<Field, List<ScorecardVariable>> staticScores;

    static {
        staticScores = new HashMap<>();
        staticScores.put(MF_SCORE, buildMfScore());
        staticScores.put(FREE_MONTHLY_INCOME, buildFreeMonthlyIncome());
        staticScores.put(PREV_WITHDRAWAL_AM, buildPrevWithdrawalAm());
        staticScores.put(R_MIN_REALREPAYMENT_MMP_3M, buildMinRepayment3M());
        staticScores.put(INVOICES_PAID_MONTHLY_LATE_M_3, buildInvoicesPaidLate3M());
        staticScores.put(MAX_DAYS_BETWEEN_DRAWS_IN_PERIOD_V1, buildMaxDaysBetweenDraws());
        staticScores.put(OVERDUE_DAYS_SQUARED_12M, buildOverdueDaysSquared());
        staticScores.put(PREV_LATE_LAST_INVOICE_IN_PERIOD_V1, buildPrevLateLastInvoice());
        staticScores.put(TIME_SINCE_FIRST_CUST_IN_PERIOD_V2, buildTimeSinceFirstCust());
        staticScores.put(DAYS_SINCE_LAST_ACCOUNT_OPEN, buildDaysSinceLastAccount());
        staticScores.put(INQUIRIES_IN_60_DAYS, buildInquiriesIn60Days());
        staticScores.put(NUMBER_OF_REVOLVING_ACCOUNTS, buildNumberOfRevolvingAccounts());
        staticScores.put(OVERDUE_BALANCE, buildOverdueBalance());
        staticScores.put(AMOUNT_OF_FIXED_AND_MORTGAGE_PAYMENT, buildTotalPaymentsILMortgage());
    }

    @Override
    public Stream<Map.Entry<Field, List<ScorecardVariable>>> asStream() {
        Map<Field, List<ScorecardVariable>> scores = new HashMap<>(staticScores);
        return scores.entrySet().stream();
    }

    @Override
    public String getType() {
        return SCORECARD_TYPE;
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

    private static List<ScorecardVariable> buildFreeMonthlyIncome() {
        List<ScorecardVariable> freeMonthlyIncome = new LinkedList<>();
        freeMonthlyIncome.add(new ScorecardVariable("0", -3));
        freeMonthlyIncome.add(new ScorecardVariable("1250001", 3));
        freeMonthlyIncome.add(new ScorecardVariable("2500001", 15));
        return freeMonthlyIncome;
    }

    private static List<ScorecardVariable> buildPrevWithdrawalAm() {
        List<ScorecardVariable> prevWithdrawal = new LinkedList<>();
        prevWithdrawal.add(new ScorecardVariable("0", 0));
        prevWithdrawal.add(new ScorecardVariable("801", 4));
        return prevWithdrawal;
    }

    private static List<ScorecardVariable> buildMinRepayment3M() {
        List<ScorecardVariable> minRepayment = new LinkedList<>();
        minRepayment.add(new ScorecardVariable("0", 0));
        minRepayment.add(new ScorecardVariable("1.1", 7));
        minRepayment.add(new ScorecardVariable("1.2", 20));
        return minRepayment;
    }

    private static List<ScorecardVariable> buildInvoicesPaidLate3M() {
        List<ScorecardVariable> invoicesPaidLate = new LinkedList<>();
        invoicesPaidLate.add(new ScorecardVariable("0", 4));
        invoicesPaidLate.add(new ScorecardVariable("1", 2));
        invoicesPaidLate.add(new ScorecardVariable("2", -1));
        return invoicesPaidLate;
    }

    private static List<ScorecardVariable> buildMaxDaysBetweenDraws() {
        List<ScorecardVariable> maxDaysBetweenDraws = new LinkedList<>();
        maxDaysBetweenDraws.add(new ScorecardVariable("0", -6));
        maxDaysBetweenDraws.add(new ScorecardVariable("56", 0));
        maxDaysBetweenDraws.add(new ScorecardVariable("91", 9));
        return maxDaysBetweenDraws;
    }

    private static List<ScorecardVariable> buildOverdueDaysSquared() {
        List<ScorecardVariable> overdueDaysSquared = new LinkedList<>();
        overdueDaysSquared.add(new ScorecardVariable("0", 11));
        overdueDaysSquared.add(new ScorecardVariable("1", 0));
        overdueDaysSquared.add(new ScorecardVariable("18", -4));
        overdueDaysSquared.add(new ScorecardVariable("82", -21));
        return overdueDaysSquared;
    }

    private static List<ScorecardVariable> buildPrevLateLastInvoice() {
        List<ScorecardVariable> prevLateLastInvoice = new LinkedList<>();
        prevLateLastInvoice.add(new ScorecardVariable("-2", 10));
        prevLateLastInvoice.add(new ScorecardVariable("-1", 4));
        prevLateLastInvoice.add(new ScorecardVariable("0", 1));
        prevLateLastInvoice.add(new ScorecardVariable("1", -7));
        return prevLateLastInvoice;
    }

    private static List<ScorecardVariable> buildTimeSinceFirstCust() {
        List<ScorecardVariable> invoicesPaidLate = new LinkedList<>();
        invoicesPaidLate.add(new ScorecardVariable("0", -9));
        invoicesPaidLate.add(new ScorecardVariable("146", 3));
        invoicesPaidLate.add(new ScorecardVariable("206", 12));
        return invoicesPaidLate;
    }

    private static List<ScorecardVariable> buildDaysSinceLastAccount() {
        List<ScorecardVariable> daysSinceLastAccount = new LinkedList<>();
        daysSinceLastAccount.add(new ScorecardVariable("0", -3));
        daysSinceLastAccount.add(new ScorecardVariable("29", 1));
        daysSinceLastAccount.add(new ScorecardVariable("46", 5));
        daysSinceLastAccount.add(new ScorecardVariable("121", 10));
        return daysSinceLastAccount;
    }

    private static List<ScorecardVariable> buildInquiriesIn60Days() {
        List<ScorecardVariable> inquiriesIn60Days = new LinkedList<>();
        inquiriesIn60Days.add(new ScorecardVariable("0", 13));
        inquiriesIn60Days.add(new ScorecardVariable("1", 12));
        inquiriesIn60Days.add(new ScorecardVariable("2", 5));
        inquiriesIn60Days.add(new ScorecardVariable("5", -4));
        inquiriesIn60Days.add(new ScorecardVariable("9", -14));
        return inquiriesIn60Days;
    }

    private static List<ScorecardVariable> buildTotalPaymentsILMortgage() {
        List<ScorecardVariable> totalPaymentsILMortgage = new LinkedList<>();
        totalPaymentsILMortgage.add(new ScorecardVariable("0", 12));
        totalPaymentsILMortgage.add(new ScorecardVariable("1501", 5));
        totalPaymentsILMortgage.add(new ScorecardVariable("6001", 2));
        totalPaymentsILMortgage.add(new ScorecardVariable("12001", -3));
        totalPaymentsILMortgage.add(new ScorecardVariable("24001", -4));
        return totalPaymentsILMortgage;
    }

    private static List<ScorecardVariable> buildOverdueBalance() {
        List<ScorecardVariable> overdueBalance = new LinkedList<>();
        overdueBalance.add(new ScorecardVariable("0", 5));
        overdueBalance.add(new ScorecardVariable("601", -2));
        return overdueBalance;
    }

    private static List<ScorecardVariable> buildNumberOfRevolvingAccounts() {
        List<ScorecardVariable> numberOfRevolvingAccounts = new LinkedList<>();
        numberOfRevolvingAccounts.add(new ScorecardVariable("0", -6));
        numberOfRevolvingAccounts.add(new ScorecardVariable("5", 1));
        numberOfRevolvingAccounts.add(new ScorecardVariable("8", 5));
        numberOfRevolvingAccounts.add(new ScorecardVariable("12", 8));
        numberOfRevolvingAccounts.add(new ScorecardVariable("16", 17));
        return numberOfRevolvingAccounts;
    }

    private static List<ScorecardVariable> buildMfScore() {
        List<ScorecardVariable> mfScore = new LinkedList<>();
        mfScore.add(new ScorecardVariable("-10", -5, true));
        mfScore.add(new ScorecardVariable("-9", -5, true));
        mfScore.add(new ScorecardVariable("-8", -5, true));
        mfScore.add(new ScorecardVariable("-7", -5, true));
        mfScore.add(new ScorecardVariable("-6", -5, true));
        mfScore.add(new ScorecardVariable("-5", -5, true));
        mfScore.add(new ScorecardVariable("-4", -5, true));
        mfScore.add(new ScorecardVariable("-3", -5, true));
        mfScore.add(new ScorecardVariable("-2", -5, true));
        mfScore.add(new ScorecardVariable("-1", -5, true));
        mfScore.add(new ScorecardVariable("0", -5, true));
        mfScore.add(new ScorecardVariable("1", -5, true));
        mfScore.add(new ScorecardVariable("629", -5, true));
        mfScore.add(new ScorecardVariable("630", -5, true));
        mfScore.add(new ScorecardVariable("631", -1));
        mfScore.add(new ScorecardVariable("651", 3));
        mfScore.add(new ScorecardVariable("662", 4));
        mfScore.add(new ScorecardVariable("685", 6));
        return mfScore;
    }
}
