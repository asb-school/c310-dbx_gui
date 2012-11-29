/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author villafan
 */
@Entity
@Table(name = "npc_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NpcType.findAll", query = "SELECT n FROM NpcType n"),
    @NamedQuery(name = "NpcType.findById", query = "SELECT n FROM NpcType n WHERE n.id = :id"),
    @NamedQuery(name = "NpcType.findByName", query = "SELECT n FROM NpcType n WHERE n.name = :name"),
    @NamedQuery(name = "NpcType.findByAggressiveness", query = "SELECT n FROM NpcType n WHERE n.aggressiveness = :aggressiveness"),
    @NamedQuery(name = "NpcType.findByBenevolence", query = "SELECT n FROM NpcType n WHERE n.benevolence = :benevolence")})
public class NpcType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "aggressiveness")
    private float aggressiveness;
    @Basic(optional = false)
    @Column(name = "benevolence")
    private float benevolence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "npcTypeId")
    private Collection<Npc> npcCollection;

    public NpcType() {
    }

    public NpcType(Integer id) {
        this.id = id;
    }

    public NpcType(Integer id, String name, float aggressiveness, float benevolence) {
        this.id = id;
        this.name = name;
        this.aggressiveness = aggressiveness;
        this.benevolence = benevolence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(float aggressiveness) {
        this.aggressiveness = aggressiveness;
    }

    public float getBenevolence() {
        return benevolence;
    }

    public void setBenevolence(float benevolence) {
        this.benevolence = benevolence;
    }

    @XmlTransient
    public Collection<Npc> getNpcCollection() {
        return npcCollection;
    }

    public void setNpcCollection(Collection<Npc> npcCollection) {
        this.npcCollection = npcCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NpcType)) {
            return false;
        }
        NpcType other = (NpcType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.NpcType[ id=" + id + " ]";
    }
    
}
