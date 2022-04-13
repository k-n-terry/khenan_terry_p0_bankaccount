package dev.terry.services;

import dev.terry.entities.Checking;
import dev.terry.utilities.List;

public interface CheckingService{
    Checking registerChecking(Checking checking);
    Checking depositToChecking(Checking checking);
    Checking withdrawFromChecking(Checking checking);
    List<Checking> allCheckingAccountsList();
}
