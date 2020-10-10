#The Transaction Analyser
 
The goal of the system is to display statistic information about processed financial transactions.
#####A transaction record will contain the following fields:
- ID - A string representing the transaction id<br>
- Date - The date and time when the transaction took place (format "DD/MM/YYYY hh:mm:ss")<br>
- Amount - The value of the transaction (dollars and cents)<br>
- Merchant - The name of the merchant this transaction belongs to<br>
- Type - The type of the transaction, which could be either PAYMENT or REVERSAL<br>
- Related Transaction - (Optional) - In the case a REVERSAL transaction, this field will contain the ID of the transaction it is reversing.<br>
#####The Problem
The system will be Initialised with an input file in CSV format containing a list of transaction records.
Once initialised, the system should report the total number of transactions and the average transaction value for a specific merchant in a specific date range.
An additional requirement is that, if a transaction record has a REVERSAL transaction, then it should not be included in the computed statistics, even if the reversing transaction is outside of the requested date range.

##Example
#####Input CSV Example:<br>
ID, Date, Amount, Merchant, Type, Related Transaction<br>
WLMFRDGD, 20/08/2018 12:45:33, 59.99, Kwik-E-Mart, PAYMENT,<br>
YGXKOEIA, 20/08/2018 12:46:17, 10.95, Kwik-E-Mart, PAYMENT,<br>
LFVCTEYM, 20/08/2018 12:50:02, 5.00, MacLaren, PAYMENT,<br>
SUOVOISP, 20/08/2018 13:12:22, 5.00, Kwik-E-Mart, PAYMENT,<br>
AKNBVHMN, 20/08/2018 13:14:11, 10.95, Kwik-E-Mart, REVERSAL, YGXKOEIA<br>
JYAPKZFZ, 20/08/2018 14:07:10, 99.50, MacLaren, PAYMENT,<br><br>
#####Given the above CSV file and the following input arguments:
fromDate: 20/08/2018 12:00:00<br>
toDate: 20/08/2018 13:00:00<br>
merchant: Kwik-E-Mart<br>
#####The output will be:
Number of transactions = 1<br>
Average Transaction Value = 59.99

##How to change input
1. To change the input, you need to enter the **src/main/resources/** and add the new csv file.
2. Then you go to **src/main/java/Main** and change first parameter of Args constructor(***this is the path to your csv file***).
3. The second and third parameters are responsible for the time period of the analysts.
4. The last one is Merchant.

##Dependencies
- lombok


