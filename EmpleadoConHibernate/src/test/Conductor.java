package test;

import conexion.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistente.*;

/**
 *
 * @author Leo
 */
public class Conductor {
    private static void recuperaRegaloConCriaturita(Session s, int id){
 
        Regalo surprise;

        surprise = (Regalo)s.get(Regalo.class, id);
        System.out.println(surprise.toString()+" Propietari-> "+surprise.getPropietario().toString());
    }
    private static void recuperaCriaturitaConRegalos(Session s, byte id){
 
        CriaturitaConRegalos nene;
     
        nene = (CriaturitaConRegalos)s.get(CriaturitaConRegalos.class, id);
        System.out.println();
        System.out.println(nene.toString());
        System.out.println("Regalos");
        int cont = 1;
        for(RegaloParaCriaturitaConRegalos surprise:nene.getRegalitos()){
            System.out.println(cont+" -> "+surprise.toString());
            cont++;
        }
    }
    public static void main(String[] args) {

        SessionFactory instancia = HibernateUtil.buildSessionFactory();
        try (Session ses = instancia.openSession()) {
            int idR = 6;
            byte idC = 3;
//            recuperaRegaloConCriaturita(ses,idR);
            System.out.println("======================================================");
            recuperaCriaturitaConRegalos (ses,idC);
            ses.close();
        }
        
    }
}
