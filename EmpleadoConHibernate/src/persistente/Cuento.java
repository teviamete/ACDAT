
package persistente;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

/**
 *
 * @author leo
 */
@Entity
@Table(name="Cuentos")
public class Cuento implements Serializable{
    @Id
    @Column(name="Id")
    private int id;
    @Column(name="Titulo")
    private String titulo;
    @Column(name="Autor")
    private String autor;
    @Column(name="Tema")
    private String tema;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Lecturas", joinColumns={@JoinColumn(name="IdCuento")}, inverseJoinColumns={@JoinColumn(name="Id")})
    private List<Criaturita> listaLectores=new ArrayList();

    public Cuento() {
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getTema() {
        return tema;
    }

    public List<Criaturita> getListaLectores() {
        return listaLectores;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setListaLectores(List<Criaturita> listaLectores) {
        this.listaLectores = listaLectores;
    }
    
    
}
