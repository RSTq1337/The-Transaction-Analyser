package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Report {

    private String numberOfTransactions;

    private String averageTransactionValue;

    @Override
    public String toString() {
        return "Number of transactions = " + numberOfTransactions + "\n" +
               "Average Transaction Value = " + averageTransactionValue;
    }
}
