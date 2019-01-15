
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
    public void crearCriaturita (String nombre, long id){
        Transaction tran;
        Session ses = HibernateUtil.getSessionFactory().openSession();
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
        Session ses = HibernateUtil.getSessionFactory().openSession();
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
        Session ses = HibernateUtil.getSessionFactory().openSession();
        tran = ses.beginTransaction();
        nene = new Criaturita ();
        ses.delete (nene);
        tran.commit();
        ses.close();
    }
    public Criaturita recuperar (byte id){
        Criaturita nene;
        Session ses = HibernateUtil.getSessionFactory().openSession();
        nene = (Criaturita)ses.get(Criaturita.class, id);
        ses.close();
        return nene;
    }

    public void listaEmpleados (List<Criaturita> lista){
        Session ses = HibernateUtil.getSessionFactory().openSession();
        for (Criaturita actual:lista){
            // El objeto es detached y con esto pasa a persistent
            ses.update(actual);
            System.out.println(cadenaEmpleado(actual));
        }
        ses.close();
    }
    public String cadenaEmpleado (Criaturita c){
        String cad;
        cad = "ID: "+c.getId() + "  Nombre: " + c.getNombre();
        return cad;
    }

}
