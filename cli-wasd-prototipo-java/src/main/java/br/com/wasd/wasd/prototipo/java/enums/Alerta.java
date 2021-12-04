package br.com.wasd.wasd.prototipo.java.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Alerta {

    ATENCAO("Atenção",
            new Double[] { 80.0, 95.0 },
            new Double[] { 80.0, 95.0 },
            new Double[] { 70.0, 80.0 },
            new Double[] { 90.0, 100.0 });

    private Alerta(String status, Double[] paramDisco, Double[] paramCpu, Double[] paramTemperatura,
            Double[] paramRam) {
        this.status = status;
        this.paramDisco = paramDisco;
        this.paramCpu = paramCpu;
        this.paramTemperatura = paramTemperatura;
        this.paramRam = paramRam;
    }

    private String status;
    private Double paramDisco[];
    private Double paramCpu[];
    private Double paramTemperatura[];
    private Double paramRam[];

    public static String fromLog(HashMap<String, Object> logHash) {
        List<Double> usoDiscos = new ArrayList<>();
        Double usoCpu = (Double) logHash.get("usoCpu");
        Double usoRam = (Double) logHash.get("usoRam");
        Double temperatura = (Double) logHash.get("temperatura");
        String result = "";
        for (Map.Entry logElement : logHash.entrySet()) {
            String key = (String) logElement.getKey();
            if (key.startsWith("usoDisco")) {
                usoDiscos.add((Double) logElement.getValue());
            }
        }

        for (Alerta alerta : values()) {
            for (Double usoDisco : usoDiscos) {
                if (isAttentionDisk(usoDisco, alerta.paramDisco[0], alerta.paramDisco[1])
                        || isAttentionCpu(usoCpu, alerta.paramCpu[0], alerta.paramCpu[1])
                        || isAttentionTemperature(temperatura, alerta.paramTemperatura[0], alerta.paramTemperatura[1])
                        || isAttentionRam(usoRam, alerta.paramRam[0], alerta.paramRam[1])) {
                    result = alerta.status;
                } else if (usoCpu > alerta.paramDisco[1] || usoCpu > alerta.paramCpu[1]
                        || temperatura > alerta.paramTemperatura[1] || usoRam > alerta.paramRam[1]) {
                    result = "Alerta";
                } else {
                    result = "Normal";
                }
            }
        }

        return result;
    }

    private static Boolean isAttentionDisk(Double usoDisco, Double min, Double max) {
        if (usoDisco >= min && usoDisco <= max) {
            return true;
        } else {
            return false;
        }
    }

    private static Boolean isAttentionCpu(Double usoCpu, Double min, Double max) {
        if (usoCpu >= min && usoCpu <= max) {
            return true;
        } else {
            return false;
        }
    }

    private static Boolean isAttentionTemperature(Double temperature, Double min, Double max) {
        if (temperature >= min && temperature <= max) {
            return true;
        } else {
            return false;
        }
    }

    private static Boolean isAttentionRam(Double usoRam, Double min, Double max) {
        if (usoRam >= min && usoRam <= max) {
            return true;
        } else {
            return false;
        }
    }

}
