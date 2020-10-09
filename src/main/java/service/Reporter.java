package service;

import model.Args;
import model.Report;
import model.Transaction;
import utils.TimeUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reporter {

    public Report report(Map<String, Transaction> transactions, Args args) {
        BigDecimal averageTransactionValue = BigDecimal.ZERO;
        List<Transaction> filteredTransactions = transactions.values().stream().filter(transaction -> {
                    if(!transaction.getMerchant().equals(args.getMerchant())){
                        return false;
                    }
                    boolean isValidDate = TimeUtils.isDateToFrom(transaction.getDate(), args.getToDate(), args.getFromDate());
                    if (isValidDate) {
                        boolean isReversal = transaction.getType().equals("REVERSAL");
                        if (isReversal) {
                            Transaction relatedTransaction = transactions.get(transaction.getRelatedTransaction());
                            return TimeUtils.isDateToFrom(relatedTransaction.getDate(), args.getToDate(), args.getFromDate());
                        }
                        return isValidDate;
                    }
                    return isValidDate;
                }
        ).collect(Collectors.toList());
        for (Transaction filteredTransaction : filteredTransactions) {
            averageTransactionValue = averageTransactionValue.add(filteredTransaction.getAmount());
        }

        return new Report(String.valueOf(filteredTransactions.size()), averageTransactionValue.toString());
    }

}
