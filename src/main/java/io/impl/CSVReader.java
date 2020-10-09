package io.impl;

import io.Reader;
import model.Transaction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CSVReader implements Reader<Transaction> {

    @Override
    public Map<String, Transaction> read(String path) {
        Map<String, Transaction> transactions = new HashMap<>();
        ArrayList<String> transactionsToRemove = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                Transaction transaction = new Transaction(line.split(","));
                if(transaction.getType().equals("REVERSAL")){
                    transactionsToRemove.add(transaction.getRelatedTransaction());
                }
                transactions.put(transaction.getId(), transaction);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Something went wrong while processing file");
        }
        for (String s : transactionsToRemove) {
            transactions.remove(s);
        }
        return transactions;
    }

}
