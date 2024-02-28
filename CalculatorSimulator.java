package lab7;






//TaxCalculator class
class TaxCalculator {
 public double calculateTax(String empName, boolean isIndian, double empSal)
         throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException {
     if (!isIndian) {
         throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax");
     }

     if (empName == null || empName.trim().isEmpty()) {
         throw new EmployeeNameInvalidException("The employee name cannot be empty");
     }

     double taxAmount;

     if (empSal > 100000) {
         taxAmount = empSal * 8 / 100;
     } else if (empSal >= 50000 && empSal <= 100000) {
         taxAmount = empSal * 6 / 100;
     } else if (empSal >= 30000 && empSal < 50000) {
         taxAmount = empSal * 5 / 100;
     } else if (empSal >= 10000 && empSal < 30000) {
         taxAmount = empSal * 4 / 100;
     } else {
         throw new TaxNotEligibleException("The employee does not need to pay tax");
     }

     return taxAmount;
 }
}

//CalculatorSimulator class
public class CalculatorSimulator {
 public static void main(String[] args) {
     TaxCalculator taxCalculator = new TaxCalculator();

     try {
         // Test case 1: Valid scenario
         double taxAmount = taxCalculator.calculateTax("John Doe", true, 120000);
         System.out.println("Tax amount is: " + taxAmount);

         // Test case 2: Employee from a non-Indian country
         taxCalculator.calculateTax("Alice", false, 50000);

     } catch (CountryNotValidException e) {
         System.out.println("Country not valid: " + e.getMessage());
         e.printStackTrace();
     } catch (EmployeeNameInvalidException e) {
         System.out.println("Employee name not valid: " + e.getMessage());
         e.printStackTrace();
     } catch (TaxNotEligibleException e) {
         System.out.println("Not eligible for Tax calculation: " + e.getMessage());
         e.printStackTrace();
     }
 }
}
