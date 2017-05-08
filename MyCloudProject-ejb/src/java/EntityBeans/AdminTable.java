/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author code_eagle
 */
@Entity
@Table(name = "admin_table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminTable.findAll", query = "SELECT a FROM AdminTable a")
    , @NamedQuery(name = "AdminTable.findByAdminId", query = "SELECT a FROM AdminTable a WHERE a.adminId = :adminId")
    , @NamedQuery(name = "AdminTable.findByAdminName", query = "SELECT a FROM AdminTable a WHERE a.adminName = :adminName")
    , @NamedQuery(name = "AdminTable.findByAdminPassword", query = "SELECT a FROM AdminTable a WHERE a.adminPassword = :adminPassword")})
public class AdminTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_id")
    private Integer adminId;
    @Size(max = 256)
    @Column(name = "admin_name")
    private String adminName;
    @Size(max = 256)
    @Column(name = "admin_password")
    private String adminPassword;

    public AdminTable() {
    }

    public AdminTable(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminTable)) {
            return false;
        }
        AdminTable other = (AdminTable) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityBeans.AdminTable[ adminId=" + adminId + " ]";
    }
    
}
