package model;

import lombok.Data;
import utils.TimeUtils;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Transaction {

    private String id;

    private Date date;

    private BigDecimal amount;

    private String merchant;

    private String type;

    private String relatedTransaction;

    public Transaction(String[] values) {
        this.id = values[0].trim();
        this.date = TimeUtils.parse(values[1].trim());
        this.amount = new BigDecimal(values[2].trim());
        this.merchant = values[3].trim();
        this.type = values[4].trim();
        if(values.length>5)
            this.relatedTransaction = values[5].trim();
    }
}
