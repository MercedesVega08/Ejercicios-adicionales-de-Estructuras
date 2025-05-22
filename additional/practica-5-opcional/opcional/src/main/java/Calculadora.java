import list.MyArrayList;
import java.util.Iterator; 

public class Calculadora{
    
    private String operacion;
    private MyArrayList<String> historial;
    private int cantOperation;

    public Calculadora(){
        this.operacion = null;
        historial = new MyArrayList<>();
        cantOperation = 0;
    }

    public int getCantOperation(){
        return cantOperation;
    }

    public void add(String operacion){
        this.operacion = operacion;
        historial.add(operacion);
        cantOperation++;
    }

    public void remove(){
        historial.remove(0);
        cantOperation--;
    }

    private int transformarInt(String number, String number2){
        int number1 = 0;
        char[] charNumber = new char[number.length()];
        char[] charNumber2 = new char[number2.length()];
        
        number.chars();
        return 0;
    }

    public String suma(String operation1, String operation2){
        
        
        return null;
    }
}
