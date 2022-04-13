package dev.terry.data;

import dev.terry.entities.Ledger;
import dev.terry.utilities.List;

import java.sql.Connection;

public class LedgerDAO_impl implements LedgerDAO{
    @Override
    public Ledger createLedgerEntry(Ledger ledger, Connection conn) {
        return null;
    }

    @Override
    public Ledger getLedgerEntryBySharedId(String sharedId) {
        return null;
    }

    @Override
    public List<Ledger> getAllLedgerEntries() {
        return null;
    }

    @Override
    public Ledger updateLedgerEntry(Ledger ledger) {
        return null;
    }

    @Override
    public boolean deleteLedgerEntryBySharedId(String sharedId) {
        return false;
    }
}
