/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wasd.wasd.prototipo.java;

/**
 *
 * @author bianc
 */
public class ConversorDouble {

    private static final long KIBI = 1L << 10;
    private static final long MEBI = 1L << 20;
    private static final long GIBI = 1L << 30;
    private static final long TEBI = 1L << 40;
    private static final long PEBI = 1L << 50;
    private static final long EXBI = 1L << 60;

    public static Double formatarBytes(long bytes) {
        if (bytes == 1L) { // bytes
            return (double) bytes;
        } else if (bytes < KIBI) { // bytes
            return (double) bytes;
        } else if (bytes < MEBI) { // KiB
            return formatarUnidades(bytes, KIBI, "KiB");
        } else if (bytes < GIBI) { // MiB
            return formatarUnidades(bytes, MEBI, "MiB");
        } else if (bytes < TEBI) { // GiB
            return formatarUnidades(bytes, GIBI, "GiB");
        } else if (bytes < PEBI) { // TiB
            return formatarUnidades(bytes, TEBI, "TiB");
        } else if (bytes < EXBI) { // PiB
            return formatarUnidades(bytes, PEBI, "PiB");
        } else { // EiB
            return formatarUnidades(bytes, EXBI, "EiB");
        }
    }
    
    private static Double formatarUnidades(long valor, long prefixo, String unidade) {
        return (double) valor / prefixo;
    }
}
