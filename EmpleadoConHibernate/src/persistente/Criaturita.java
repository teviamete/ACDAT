package persistente;
// 

import java.util.*;
import javax.persistence.*;


@Entity
@Table(name="Criaturitas"
)
public class Criaturita  implements java.io.Serializable {

    @Id 

    @Column(name="Id", nullable=false)	
     private byte id;
     
    @Column(name="Nombre")     
     private String nombre;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
     private List<Cuento> listaCuentos=new ArrayList();

    public Criaturita() {
    }

    public Criaturita(byte id) {
        this.id = id;
    }
    public Criaturita(byte id, String nombre) {
       this.id = id;
       this.nombre = nombre;
    }
   
    public byte getId() {
        return this.id;
    }
    
    public void setId(byte id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuento> getListaCuentos() {
        return listaCuentos;
    }

    public void setListaCuentos(List<Cuento> listaCuentos) {
        this.listaCuentos = listaCuentos;
    }

    @Override
    public String toString() {
        return "Criaturita{" + "id=" + id + ", nombre=" + nombre + '}';
    }




}


