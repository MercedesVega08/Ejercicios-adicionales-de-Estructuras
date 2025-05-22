import java.util.ArrayList;

import list.MyArrayList;

public class Calculadora{
    
    private String operacion;
    private MyArrayList<String> historial;
    private int cantOperation;
    private static int size;

    public Calculadora(){
        this.operacion = null;
        historial = new MyArrayList<>(15);
        cantOperation = 0;
        size = 0;
    }

    public int getCantOperation(){
        return cantOperation;
    }

    public void add(){
        if(cantOperation == historial.size())
            remove();
        historial.add(operacion);
        cantOperation++;
    }

    public void remove(){
        historial.remove(0);
        cantOperation--;
    }

    private int functionPower(int base, int potencia){
        int result = base;
        if(potencia == 0)
            result = 1;
        if(potencia == 1)
            result *= potencia;
        for(int i = 1; i < potencia; i++)
            result *= base;
       
        return result;
    }

    private int transformarInt(String number){
        int number1 = 0;
        size = number.length();

        for(int i = 0; i < size; i++)
            number1 += ((number.charAt(i)-48)*functionPower(10, size-(i+1)));
        
        return number1;
    }

    private String transformarString(int number){
        String number1 = "";
        number1 += number;
        return number1;
    }

    public String suma(String operation1, String operation2){
        int add = transformarInt(operation1) + transformarInt(operation2);
        operacion = transformarString(add);
        return operacion;
    }

    public String resta(String operation1, String operation2){
        int sub = transformarInt(operation1) - transformarInt(operation2);
        operacion = transformarString(sub);
        return operacion;
    }

    public String division(String operacion1, String operacion2){
        int div = transformarInt(operacion1) / transformarInt(operacion2);
        operacion = transformarString(div);
        return operacion;
    }

    public String multiplicacion(String operacion1, String operacion2){
        int mult = transformarInt(operacion1) * transformarInt(operacion2);
        operacion = transformarString(mult);
        return operacion;
    }

    public String potencia(String base, String potencia){
        int power = functionPower(transformarInt(base), transformarInt(potencia));
        operacion = transformarString(power);
        return operacion;
    }

    public String toString(){
        String history = "[";
        String history2 = "";
        for(int i = 0; i < historial.size(); i++)
            history2 +=  ", ";
        history += history2 + "]";
        return history;
    }
   
}
