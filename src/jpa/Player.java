/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author villafan
 */
@Entity
@Table(name = "player")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findById", query = "SELECT p FROM Player p WHERE p.id = :id"),
    @NamedQuery(name = "Player.findByName", query = "SELECT p FROM Player p WHERE p.name = :name"),
    @NamedQuery(name = "Player.findByHealth", query = "SELECT p FROM Player p WHERE p.health = :health"),
    @NamedQuery(name = "Player.findBySkillLevel", query = "SELECT p FROM Player p WHERE p.skillLevel = :skillLevel"),
    @NamedQuery(name = "Player.findByBirthDate", query = "SELECT p FROM Player p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "Player.findByPosX", query = "SELECT p FROM Player p WHERE p.posX = :posX"),
    @NamedQuery(name = "Player.findByPosY", query = "SELECT p FROM Player p WHERE p.posY = :posY"),
    @NamedQuery(name = "Player.findByLoginName", query = "SELECT p FROM Player p WHERE p.loginName = :loginName"),
    @NamedQuery(name = "Player.findByLoginPassword", query = "SELECT p FROM Player p WHERE p.loginPassword = :loginPassword")})
public class Player implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
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
    @Column(name = "health")
    private float health;
    @Basic(optional = false)
    @Column(name = "skill_level")
    private float skillLevel;
    @Basic(optional = false)
    @Column(name = "birth_date")
    private int birthDate;
    @Basic(optional = false)
    @Column(name = "pos_x")
    private int posX;
    @Basic(optional = false)
    @Column(name = "pos_y")
    private int posY;
    @Basic(optional = false)
    @Column(name = "login_name")
    private String loginName;
    @Basic(optional = false)
    @Column(name = "login_password")
    private String loginPassword;
    @Basic(optional = false)
    @Column(name = "region_id")
    private int regionId;
    @Basic(optional = false)
    @Column(name = "admin")
    private int admin;

    public Player() {
    }

    public Player(Integer id) {
        this.id = id;
    }

    public Player(Integer id, String name, float health, float skillLevel, int birthDate, int posX, int posY, String loginName, String loginPassword, int regionId, int admin) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.skillLevel = skillLevel;
        this.birthDate = birthDate;
        this.posX = posX;
        this.posY = posY;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.regionId = regionId;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        float oldHealth = this.health;
        this.health = health;
        changeSupport.firePropertyChange("health", oldHealth, health);
    }

    public float getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(float skillLevel) {
        float oldSkillLevel = this.skillLevel;
        this.skillLevel = skillLevel;
        changeSupport.firePropertyChange("skillLevel", oldSkillLevel, skillLevel);
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        int oldBirthDate = this.birthDate;
        this.birthDate = birthDate;
        changeSupport.firePropertyChange("birthDate", oldBirthDate, birthDate);
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        int oldPosX = this.posX;
        this.posX = posX;
        changeSupport.firePropertyChange("posX", oldPosX, posX);
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        int oldPosY = this.posY;
        this.posY = posY;
        changeSupport.firePropertyChange("posY", oldPosY, posY);
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        String oldLoginName = this.loginName;
        this.loginName = loginName;
        changeSupport.firePropertyChange("loginName", oldLoginName, loginName);
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        String oldLoginPassword = this.loginPassword;
        this.loginPassword = loginPassword;
        changeSupport.firePropertyChange("loginPassword", oldLoginPassword, loginPassword);
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        int oldRegionId = this.regionId;
        this.regionId = regionId;
        changeSupport.firePropertyChange("regionId", oldRegionId, regionId);
    }

     public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        Integer oldAdmin = this.admin;
        this.admin = admin;
        changeSupport.firePropertyChange("admin", oldAdmin, admin);
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
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Player[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
