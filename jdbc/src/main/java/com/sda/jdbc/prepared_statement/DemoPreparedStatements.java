package com.sda.jdbc.prepared_statement;

public class DemoPreparedStatements {
    public static void main(String[] args) {
        PreparedStatements preparedStatements = new PreparedStatements();
        preparedStatements.insertOperation("Rose", "rose@gmail.com", "England");
        preparedStatements.queryOperation();
        preparedStatements.updateOperation(3, "Bogdan", "jurca_b@hotmail.com", "Romania");
        preparedStatements.queryOperation();
        preparedStatements.deleteOperation(3);
        preparedStatements.queryOperation();
    }


}
