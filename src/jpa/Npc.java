/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author villafan
 */
@Entity
@Table(name = "npc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Npc.findAll", query = "SELECT n FROM Npc n"),
    @NamedQuery(name = "Npc.findById", query = "SELECT n FROM Npc n WHERE n.id = :id"),
    @NamedQuery(name = "Npc.findByPosX", query = "SELECT n FROM Npc n WHERE n.posX = :posX"),
    @NamedQuery(name = "Npc.findByPosY", query = "SELECT n FROM Npc n WHERE n.posY = :posY")})
public class Npc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "pos_x")
    private int posX;
    @Basic(optional = false)
    @Column(name = "pos_y")
    private int posY;
    @JoinColumn(name = "npc_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NpcType npcTypeId;
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Region regionId;

    public Npc() {
    }

    public Npc(Integer id) {
        this.id = id;
    }

    public Npc(Integer id, int posX, int posY) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public NpcType getNpcTypeId() {
        return npcTypeId;
    }

    public void setNpcTypeId(NpcType npcTypeId) {
        this.npcTypeId = npcTypeId;
    }

    public Region getRegionId() {
        return regionId;
    }

    public void setRegionId(Region regionId) {
        this.regionId = regionId;
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
        if (!(object instanceof Npc)) {
            return false;
        }
        Npc other = (Npc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Npc[ id=" + id + " ]";
    }
    
}
