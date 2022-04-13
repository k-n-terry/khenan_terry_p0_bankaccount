package dev.terry.data;

import dev.terry.entities.Ledger;
import dev.terry.utilities.List;
import java.sql.Connection;

public interface LedgerDAO{
    // CREATE
    Ledger createLedgerEntry(Ledger ledger, Connection conn);
    // READ
    Ledger getLedgerEntryBySharedId(String sharedId);
    List<Ledger> getAllLedgerEntries();
    // UPDATE
    Ledger updateLedgerEntry(Ledger ledger);
    // DELETE
    boolean deleteLedgerEntryBySharedId(String sharedId);
}
