package dev.terry.services;

import dev.terry.entities.Ledger;
import dev.terry.utilities.List;

public interface LedgerService{
    Ledger registerLedgerEntry(Ledger ledger);
    List<Ledger> allLedgerEntriesList();
}
