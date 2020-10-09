package model;

import lombok.Data;
import utils.TimeUtils;

import java.util.Date;

@Data
public class Args {

    private String path;

    private Date fromDate;

    private Date toDate;

    private String merchant;

    public Args(String path, String fromDate, String toDate, String merchant) {
        this.path = path;
        this.fromDate = TimeUtils.parse(fromDate);
        this.toDate = TimeUtils.parse(toDate);
        this.merchant = merchant;
    }
}
