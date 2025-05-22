public class CalculadoraMain {
    
    public static void main(String[] args){
        Calculadora calcu = new Calculadora();
        System.out.println("Suma: "+ calcu.suma("34", "8"));
        calcu.add();
        System.out.println("Resta: " + calcu.resta("34", "4"));
        calcu.add();
        System.out.println("Multiplicacion: " + calcu.multiplicacion("34", "4"));
        calcu.add();
        System.out.println("Division: " + calcu.division("34", "4"));
        calcu.add();
        System.out.println("Potencia: " + calcu.potencia("34", "4"));
        calcu.add();
        System.out.println("Historial: " + calcu.toString());
    
    }
}
