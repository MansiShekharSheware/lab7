package lab7;

//Custom exception for invalid employee name
class EmployeeNameInvalidException extends Exception {
public EmployeeNameInvalidException(String message) {
   super(message);
}
}