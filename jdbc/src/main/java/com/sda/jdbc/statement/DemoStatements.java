package com.sda.jdbc.statement;

public class DemoStatements {

    public static void main(String[] args) {
        Statements statements = new Statements();
        //statements.insert("Ionut","jurca_b@yahoo.com", "Romania");
        //statements.findAllUsers();
        //statements.updateOperation( 1,"Alex", "alex@gmail.com", "westeros");
        statements.deleteOperation(2);
    }
}
