/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.edu.um.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import mx.edu.um.model.BaseObject;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;

/**
 *
 * @author lite
 */
@Entity
@Table(name = "paises")
public class Pais extends BaseObject implements Serializable{
    private static final long serialVersionUID = 3832626162173359412L;
    
    private Long id;
    private String nombre;
    //private byte[] icono_bandera;
    private Integer version;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @DocumentId
    public Long getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    @Column(nullable = false,length = 50, unique = true)
    @Field
    public String getNombre() {
        return nombre;
    }
//
//    /**
//     * @return the icono_bandera
//     */
//    @Column(name = "icono_bandera")
//    @Field
//    public byte[] getIcono_bandera() {
//        return icono_bandera;
//    }

    /**
     * @return the version
     */
    @Version
    public Integer getVersion() {
        return version;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    /**
//     * @param icono_bandera the icono_bandera to set
//     */
//    public void setIcono_bandera(byte[] icono_bandera) {
//        this.icono_bandera = icono_bandera;
//    }

    /**
     * @param version the version to set
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.SIMPLE_STYLE)
                .append(this.id)
                .append(this.version)
                .append(this.nombre)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pais)) {
            return false;
        }

        final Pais pais = (Pais) o;

        return !(nombre != null ? !nombre.equals(pais.nombre) : pais.nombre != null);
    }

    @Override
    public int hashCode() {
        return (nombre != null ? nombre.hashCode() : 0);
    }
    
}
