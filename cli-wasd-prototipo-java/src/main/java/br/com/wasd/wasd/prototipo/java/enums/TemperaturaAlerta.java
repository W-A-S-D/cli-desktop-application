package br.com.wasd.wasd.prototipo.java.enums;

public enum TemperaturaAlerta {

    NORMAL("Normal", 0.0, 44.9),
    ALERTA("Alerta", 45.0, 79.9),
    ATENCAO("Atenção", 80.0, Double.MAX_VALUE);

    private String status;
    private Double minimo;
    private Double maximo;

    
    private TemperaturaAlerta(String status, Double minimo, Double maximo) {
        this.status = status;
        this.minimo = minimo;
        this.maximo = maximo;
    }

    public static String fromTemperatura(Double temperatura){
        for (TemperaturaAlerta statusTemp : values()) {
            if(temperatura < statusTemp.maximo && temperatura >= statusTemp.minimo){
                return statusTemp.getStatus();
            }
        }
        return null;
    }

    public String getStatus() {
        return status;
    }

    public Double getMinimo() {
        return minimo;
    }

    public Double getMaximo() {
        return maximo;
    }

    /*
    TemperaturaAlerta.values()  -> obtem todos so valores de uma Enum
    
    Exemplo:
    for (TemperaturaAlerta statusType : TemperaturaAlerta.values()) {
            System.out.println(statusType);
        }
    */
    
    //-------------------------------------------------------------------------
    
    /*
    TemperaturaAlerta.fromTemperatura(*value*)
    Chamar o method fromTemperatura na main
    
    Exemplo:
    TemperaturaAlerta maquinaStatus = TemperaturaAlerta.fromTemperatura(objeto.getValue()); 
    
    */
    
    //-------------------------------------------------------------------------

    /*
    Foreach enum na main.
    Exemplo:
        for (TemperaturaAlerta maquinaStatus : TemperaturaAlerta.values()) {
        System.out.println(maquinaStatus);
        }
    */
    //-------------------------------------------------------------------------
}
