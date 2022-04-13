package dev.terry.services;

import dev.terry.data.CheckingDAO;
import dev.terry.entities.Checking;
import dev.terry.utilities.List;

public class CheckingService_impl implements CheckingService{
    private CheckingDAO checkingDAO;

    public CheckingService_impl(CheckingDAO checkingDAO){
        this.checkingDAO = checkingDAO;
    }

    @Override
    public Checking registerChecking(Checking checking){
        return this.checkingDAO.createChecking(checking);
    }

    @Override
    public Checking depositToChecking(Checking checking){
        checking.setCheckingBalance(0);
        this.checkingDAO.updateChecking(checking,"checking_balance");

        return checking;
    }

    @Override
    public Checking withdrawFromChecking(Checking checking){
        checking.setCheckingBalance(0);
        this.checkingDAO.updateChecking(checking,"checking_balance");

        return checking;
    }
    @Override
    public List<Checking> allCheckingAccountsList(){
        return this.checkingDAO.getAllChecking();
    }
}
