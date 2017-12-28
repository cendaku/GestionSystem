/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author administrador
 */
@Embeddable
public class DocumentoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clase_documento")
    private boolean claseDocumento;

    public DocumentoPK() {
    }

    public DocumentoPK(int id, boolean claseDocumento) {
        this.id = id;
        this.claseDocumento = claseDocumento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getClaseDocumento() {
        return claseDocumento;
    }

    public void setClaseDocumento(boolean claseDocumento) {
        this.claseDocumento = claseDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (claseDocumento ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoPK)) {
            return false;
        }
        DocumentoPK other = (DocumentoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.claseDocumento != other.claseDocumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DocumentoPK[ id=" + id + ", claseDocumento=" + claseDocumento + " ]";
    }
    
}
