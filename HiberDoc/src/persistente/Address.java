package persistente;
// Generated 12-feb-2019 10:59:58 by Hibernate Tools 4.3.1


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name="Address"
    ,schema="dbo"
    ,catalog="Ejemplos"
)
public class Address  implements java.io.Serializable {

@Id 

    
   @Column(name="id", unique=true, nullable=false)
     private long id;

   @Column(name="number")
     private String number;
   
   @Column(name="street")
     private String street;
   
  @ManyToMany(mappedBy = "addresses")
    private List<Person> owners = new ArrayList<>(); 

    public Address() {
    }

	
    public Address(long id) {
        this.id = id;
    }
    public Address(long id, String number, String street) {
       this.id = id;
       this.number = number;
       this.street = street;
    }
   
     
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    
 
    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    

    public String getStreet() {
        return this.street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }




}


