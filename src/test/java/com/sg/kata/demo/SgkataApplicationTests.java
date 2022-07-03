package com.sg.kata.demo;

import com.sg.kata.demo.models.BankAccount;
import com.sg.kata.demo.models.OperationHistory;
import com.sg.kata.demo.models.Operation;
import com.sg.kata.demo.models.OperationType;
import java.time.LocalDate;
import java.util.Vector;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SgkataApplicationTests {

    private SgKataApplication sgKataApplication;
    private BankAccount bankAccount;
    private OperationHistory operationHistory;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        sgKataApplication = new SgKataApplication();
        bankAccount = new BankAccount(50.0);
        Operation operation = new Operation(-10, LocalDate.now(), bankAccount, OperationType.DEPOSIT);
        Vector<Operation> operations = new Vector<>();
        operations.add(operation);
        operationHistory = new OperationHistory(operations);
    }

    @Test
    public void deposit_should_not_pass_with_negative_amount() throws Exception {
        assertEquals(sgKataApplication.deposit(new Operation(-10, LocalDate.now(), bankAccount, OperationType.DEPOSIT)), false);
    }

    @Test
    public void deposit_should_pass_with_postive_amount() throws Exception {
        assertEquals(sgKataApplication.deposit(new Operation(4, LocalDate.now(), bankAccount, OperationType.DEPOSIT)), true);
    }

    @Test
    public void withdrawal_should_not_pass_with_more_than_balance() throws Exception {
        assertEquals(sgKataApplication.withdrawal(new Operation(100, LocalDate.now(), bankAccount, OperationType.WITHDRAWAL)), false);
    }

    @Test
    public void withdrawal_should__pass_with_less_than_balance() throws Exception {
        assertEquals(sgKataApplication.withdrawal(new Operation(20, LocalDate.now(), bankAccount, OperationType.WITHDRAWAL)), true);
    }

    @Test
    public void history_should_not_pass_if_empty1() throws Exception {
        assertEquals(sgKataApplication.checkHistory(null), false);
    }

    @Test
    public void history_should_not_pass_if_empty2() throws Exception {
        operationHistory.setOperations(null);
        assertEquals(sgKataApplication.checkHistory(operationHistory), false);
    }

    @Test
    public void history_should_print_one_transaction_in_one_line_for_one_operation() throws Exception {
        assertEquals(sgKataApplication.checkHistory(operationHistory), operationHistory.getOperations());
    }

}
