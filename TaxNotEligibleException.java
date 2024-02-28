package lab7;


//Custom exception for not eligible for tax calculation
class TaxNotEligibleException extends Exception {
 public TaxNotEligibleException(String message) {
     super(message);
 }
}