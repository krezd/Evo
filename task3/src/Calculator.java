public class Calculator {
    private Operation operation;

    public Calculator(Operation operation) {
        this.operation = operation;
    }

    public double calc(double a, double b){
        return operation.result(a,b);
    }

}
