package dev.terry.services;

import dev.terry.entities.Savings;
import dev.terry.utilities.List;

public interface SavingsService{
    Savings registerSavings(Savings savings);
    Savings depositToSavings(Savings savings);
    Savings withdrawFromSavings(Savings savings);
    List<Savings> allSavingsAccountsList();
}
