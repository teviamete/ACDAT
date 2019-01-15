
package persistente;

/**
 *
 * @author leo
 */
 
import javax.persistence.*;
 
/**
 *
 * @author Leo
 */
@Entity
@Table(name = "Criaturitas")
public class Criaturita {
 
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
 
    public Criaturita() {
    }
 
    public Criaturita(String nombre) {
        this.nombre = nombre;
 
    }
 
    public Long getId() {
        return id;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
}