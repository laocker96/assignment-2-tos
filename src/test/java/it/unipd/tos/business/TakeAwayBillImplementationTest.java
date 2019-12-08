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
	/**
     * itemsOrdered is the base data instance where RestaurantBillImpl.getOrderPrice
     * tests will be built upon
     */
    private List<MenuItem> getItemsOrdered() {
        return Stream.of(
                new MenuItem(ItemType.PANINI, "Primavera", 3.5),
                new MenuItem(ItemType.PANINI, "Vegetariano", 3.5),
                new MenuItem(ItemType.PANINI, "Fantasia", 4),
                new MenuItem(ItemType.FRITTI, "Arancini", 2.5),
                new MenuItem(ItemType.FRITTI, "Olive Ascolane", 9),
                new MenuItem(ItemType.FRITTI, "Corn-dog", 3), 
                new MenuItem(ItemType.BEVANDE, "Coca Cola", 2.5),
                new MenuItem(ItemType.BEVANDE, "Birra Moretti", 3),
                new MenuItem(ItemType.BEVANDE, "Acqua Naturale", 1.5)
                
        ).collect(Collectors.toList());
    }
   
    /**
     * Calculate the itemsOrdered price before any discounts or commissions
     * @param itemsOrdered
     * @return
     */
    private static double getTotalRawPrice(List<MenuItem> itemsOrdered) {
        return itemsOrdered
                .stream()
                .mapToDouble(m -> m.getPrice())
                .sum();
    }
    
    /**
     *Dato un elenco di ordinazioni (Panini e Fritti e Bevande) calcolare il totale
     */
    @Test
    public void testGetOrderPrice() {
    	TakeAwayBillImplementation bill = new TakeAwayBillImplementation();
    	List<MenuItem> itemsOrdered = getItemsOrdered();
    	
    	double totalRawPrice = getTotalRawPrice(itemsOrdered);
    	
        assertEquals(totalRawPrice, bill.getOrderPrice(itemsOrdered), 0.001);
    }
    
    /**
     * Se vengono ordinati più di 5 Panini viene fatto uno sconto del 50% sul prezzo del panino meno
	 * caro
     */
    @Test
    public void testGetOrderPriceCheapestPaninoHas5DiscountIfMoreThan5Panini() {
        TakeAwayBillImplementation bill = new TakeAwayBillImplementation();
        List<MenuItem> itemsOrdered = getItemsOrdered();
        itemsOrdered.add(new MenuItem(ItemType.PANINI, "Panino onto", 4.5));
        itemsOrdered.add(new MenuItem(ItemType.PANINI, "Panino per poveri", 0.5));
        itemsOrdered.add(new MenuItem(ItemType.PANINI, "Panino Primavera", 3));
        
        double totalRawPrice = getTotalRawPrice(itemsOrdered);
        double minPrice = 0.5;
        
        assertEquals(totalRawPrice - minPrice*0.5, bill.getOrderPrice(itemsOrdered), 0.0001);
    }
    
    /**
     * Se l’importo totale delle ordinazioni (Panini, Fritti e Bevande) supera i 50 euro viene fatto un 10% di
     * sconto
     */
    @Test
    public void testGetOrderPrice10PercentDiscountIfMoreThan50Euros() {
        TakeAwayBillImplementation bill = new TakeAwayBillImplementation();
        List<MenuItem> itemsOrdered = getItemsOrdered();
        itemsOrdered.add(new MenuItem(ItemType.PANINI, "Panino per ricchi", 50));
        
        double totalRawPrice = getTotalRawPrice(itemsOrdered);
        double discount = totalRawPrice * 10 / 50;
        assertEquals(totalRawPrice - discount, bill.getOrderPrice(itemsOrdered), 0.001);
    }
}