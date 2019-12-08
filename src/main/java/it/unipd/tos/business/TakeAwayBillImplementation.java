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
    	return -1;
     }
}