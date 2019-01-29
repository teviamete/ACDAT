
package test;
import java.util.*;
import org.hibernate.*;
import conexion.*;
import persistente.Criaturita;
import javax.persistence.TypedQuery;
/**
 *
 * @author Leo
 */
public class ManejadorCriaturitas {
    public void crearCriaturita (String nombre, byte id){
        Transaction tran;
        SessionFactory instancia = HibernateUtil.buildSessionFactory();
        Session ses = instancia.openSession();
//        Session ses = HibernateUtil.buildSessionFactory();
        tran = ses.beginTransaction();
        Criaturita nene = new Criaturita();
        nene.setNombre(nombre);
        nene.setId(id);
		// Al ejecutar el método save el objeto se convierte en persistente
        ses.save(nene);
        tran.commit();
        ses.close();
    }
    public void cambiarNombre (String nombre, byte id){
        Criaturita nene;
        Transaction tran;
        SessionFactory instancia = HibernateUtil.buildSessionFactory();
        Session ses = instancia.openSession();
        tran = ses.beginTransaction();
        nene = new Criaturita ();
        nene.setNombre (nombre);
        ses.update (nene);
        tran.commit();
        ses.close();
    }
    public void borrar (byte id){
        Criaturita nene;
        Transaction tran;
        SessionFactory instancia = HibernateUtil.buildSessionFactory();
        Session ses = instancia.openSession();
        tran = ses.beginTransaction();
        nene = new Criaturita ();
        ses.delete (nene);
        tran.commit();
        ses.close();
    }
    public Criaturita recuperar (byte id){
        Criaturita nene;
        SessionFactory instancia = HibernateUtil.buildSessionFactory();
        Session ses = instancia.openSession();
        nene = (Criaturita)ses.get(Criaturita.class, id);
        ses.close();
        return nene;
    }

    public void listaCriaturitas (){
        Criaturita actual;
        SessionFactory instancia = HibernateUtil.buildSessionFactory();
        Session ses = instancia.openSession();

        for (Object unObjeto : ses.createQuery("FROM Criaturita").getResultList()){
            actual = (Criaturita)unObjeto;
            System.out.println(cadenaCriaturita(actual));
        }
        ses.close();
    }
    public String cadenaCriaturita (Criaturita c){
        String cad;
        cad = "ID: "+c.getId() + "  Nombre: " + c.getNombre();
        return cad;
    }

}
