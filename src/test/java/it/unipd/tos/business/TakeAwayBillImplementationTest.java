package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class TakeAwayBillImplementationTest {
	@Test
    public void test() {
        TakeAwayBillImplementation bill = new TakeAwayBillImplementation();
        assertEquals(bill.getOrderPrice(null), 0, 0.001);
    }
}