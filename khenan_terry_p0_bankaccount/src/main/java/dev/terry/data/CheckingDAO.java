package dev.terry.data;

import dev.terry.entities.Checking;
import dev.terry.utilities.*;
import java.sql.*;

public interface CheckingDAO{
    // CREATE
    Checking createChecking(Checking checking);
    Checking createChecking(Checking checking, Connection conn);
    // READ
    Checking getCheckingBySharedId(String sharedId);
    List<Checking> getAllChecking();
    // UPDATE
    Checking updateChecking(Checking checking, String columnName);
    // DELETE
    boolean deleteCheckingBySharedId(String sharedId);
}
