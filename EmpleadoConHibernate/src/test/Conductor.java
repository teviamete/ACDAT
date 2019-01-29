package test;

import conexion.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistente.*;
import test.ManejadorCriaturitas;

/**
 *
 * @author Leo
 */
public class Conductor {
    public static void main(String[] args) {
//        final byte id = 50;
//        final String nombre = "Jessica";
//
//        ManejadorCriaturitas me = new ManejadorCriaturitas();
////        me.crearCriaturita (nombre,id);
//        me.listaCriaturitas();
//        System.out.println("Añadimos a Eutanasio");
//
//        me.crearCriaturita("Eutanasio", (byte)51);
//        me.listaCriaturitas();
        int id = 16;
        Criaturita nene;
        Regalo surprise;
        SessionFactory instancia = HibernateUtil.buildSessionFactory();
        Session ses = instancia.openSession();
        surprise = (Regalo)ses.get(Regalo.class, id);
        System.out.println(surprise.toString());
        ses.close();
    }
}
