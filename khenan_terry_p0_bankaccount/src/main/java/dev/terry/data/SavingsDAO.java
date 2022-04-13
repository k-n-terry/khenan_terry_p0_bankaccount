package dev.terry.data;

import dev.terry.entities.Savings;
import dev.terry.utilities.List;
import java.sql.Connection;

public interface SavingsDAO{
    // CREATE
    Savings createSavings(Savings savings);
    Savings createSavings(Savings savings, Connection conn);
    // READ
    Savings getSavingsBySharedId(String sharedId);
    List<Savings> getAllSavings();
    // UPDATE
    Savings updateSavings(Savings savings, String columnName);
    // DELETE
    boolean deleteSavingsBySharedId(String sharedId);
}
