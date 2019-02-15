/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberdoc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import persistente.*;

/**
 *
 * @author leo
 */
public class HiberDoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory instancia = HibernateUtil.buildSessionFactory();
        try (Session ses = instancia.openSession()) {
        Person person1 = new Person( "ABC-123" );
        Person person2 = new Person( "DEF-456" );

        Address address1 = new Address( "12th Avenue", "12A", "4005A" );
        Address address2 = new Address( "18th Avenue", "18B", "4007B" );

        person1.addAddress( address1 );
        person1.addAddress( address2 );

        person2.addAddress( address1 );

        ses.persist( person1 );
        ses.persist( person2 );

        ses.flush();

        person1.removeAddress( address1 );
            ses.close();
        } 

    }
    
}
