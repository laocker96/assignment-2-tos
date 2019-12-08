////////////////////////////////////////////////////////////////////
// SIMONE FEDERICO BERGAMIN 1144724
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TakeAwayBillImplementation implements TakeAwayBill {
    @Override
    /**
     * Dato un elenco di ordinazioni (Panini e Fritti e Bevande) calcolare il totale
     * Se vengono ordinate più di 5 Panini viene fatto uno sconto del 50% sul prezzo del panino 
     * meno caro
     * 
     * Se l’importo totale delle ordinazioni (Panini e Fritti) supera i 50 euro viene fatto un 10%
     * di sconto
     *
     * Non è possibile avere un’ordinazione con più di 20 elementi (se accade prevedere un
     * messaggio d’errore
     * 
     * Se l’importo totale è inferiore a 10 € viene aggiunta una commissione di 0,50 €
     *
     * @param itemsOrdered
     * @return
     * @throws TakeAwayBillException
     */
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
   
        double totalPrice = getTotalPrice(itemsOrdered);
        
        List<MenuItem> paniniOrdered = filterByItemType(itemsOrdered, ItemType.PANINI);

        if (paniniOrdered.size() > 5) {
            totalPrice -= getCheapestMenuItemPrice(paniniOrdered)*0.5;
        }
        
        return totalPrice;
    }
    
     /**
      * Sums the prices of every item in itemsOrdered
      * @param itemsOrdered
      * @return
      */
     private static double getTotalPrice(List<MenuItem> itemsOrdered) {
         return itemsOrdered.stream()
                 .mapToDouble(item -> item.getPrice())
                 .sum();
     }
     

     /**
      * Returns the cheapest menu item in itemsOrdered.
      * The list itemsOrdered is assumed to have at least an element.
      * @param itemsOrdered
      * @return
      */
     private static double getCheapestMenuItemPrice(List<MenuItem> itemsOrdered) {
         Optional<MenuItem> cheapestMenuItem = itemsOrdered.stream()
                 .min((a, b) -> {
                     // compares MenuItems in ascending order, according to their price
                     if (a.getPrice() < b.getPrice()) {
                         return -1;
                     } else if (a.getPrice() > b.getPrice()) {
                         return 1;
                     }
                     return 0;
                 });

         return cheapestMenuItem.get().getPrice();
     }

     /**
      * Returns the amount of a given itemType in itemsOrdered
      * @param itemsOrdered
      * @param itemType
      * @return
      */
     private static List<MenuItem> filterByItemType(List<MenuItem> itemsOrdered,
                                                    final ItemType itemType) {
         return itemsOrdered.stream()
                 .filter(item -> item.getItemType() == itemType)
                 .collect(Collectors.toList());
     }
     
}