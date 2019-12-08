////////////////////////////////////////////////////////////////////
// SIMONE FEDERICO BERGAMIN 1144724
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

import java.util.List;

public interface TakeAwayBill {
    double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException;
}