////////////////////////////////////////////////////////////////////
// SIMONE FEDERICO BERGAMIN 1144724
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class TakeAwayBillException extends RuntimeException {
    public TakeAwayBillException() {
        super("Hai superato il limite di ordini!");
    }
}
