package dev.terry.services;

import dev.terry.data.SavingsDAO;
import dev.terry.entities.Savings;
import dev.terry.utilities.List;

public class SavingsService_impl implements SavingsService{
    private SavingsDAO savingsDAO;

    public SavingsService_impl(SavingsDAO savingsDAO){
        this.savingsDAO = savingsDAO;
    }

    @Override
    public Savings registerSavings(Savings savings){
        return this.savingsDAO.createSavings(savings);
    }

    @Override
    public Savings depositToSavings(Savings savings){
        savings.setSavingsBalance(0);
        this.savingsDAO.updateSavings(savings,"savings_balance");

        return savings;
    }

    @Override
    public Savings withdrawFromSavings(Savings savings){
        savings.setSavingsBalance(0);
        this.savingsDAO.updateSavings(savings,"savings_balance");

        return savings;
    }
    @Override
    public List<Savings> allSavingsAccountsList(){
        return this.savingsDAO.getAllSavings();
    }
}
