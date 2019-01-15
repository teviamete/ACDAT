package test;

import java.util.ArrayList;
import persistente.*;
import test.ManejadorCriaturitas;

/**
 *
 * @author Leo
 */
public class Conductor {
    public static void main(String[] args) {
        final long id = 3, otro = 15, idr = 4;
        final String nombre = "Violeta";
        //Empleado r;
        ManejadorCriaturitas me = new ManejadorCriaturitas();
        me.crearCriaturita (nombre,id);
    }
}
