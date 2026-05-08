/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.security.admin;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rizal
 */
@Entity
@Table(catalog = "voting", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findById", query = "SELECT m FROM Menu m WHERE m.id = :id"),
    @NamedQuery(name = "Menu.getMaxLevel", query = "SELECT max(m.mnuLevel) FROM Menu m"),
    @NamedQuery(name = "Menu.findByMnuLevel", query = "SELECT m FROM Menu m WHERE m.mnuLevel = :mnuLevel"),
    @NamedQuery(name = "Menu.findByMnuClass", query = "SELECT m FROM Menu m WHERE m.mnuClass = :mnuClass"),
    @NamedQuery(name = "Menu.findBySort", query = "SELECT m FROM Menu m WHERE m.sort = :sort")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String id;
    @Basic(optional = false)
    @Column(name = "mnu_level", nullable = false)
    private Integer mnuLevel;
    @Column(name = "mnu_class", length = 100)
    private String mnuClass;
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer sort;
    @ManyToMany(mappedBy = "menuList")
    private List<Acc> accList;
    @OneToMany(mappedBy = "parent")
    private List<Menu> mnuList;
    @JoinColumn(name = "parent", referencedColumnName = "id")
    @ManyToOne
    private Menu parent;

    private transient Set<Menu> childs;

    public void addChild(Menu m) {
        if(childs==null){
            childs = new TreeSet<Menu>((Menu o1, Menu o2) -> o1.getSort().compareTo(o2.getSort()));
        }
        childs.add(m);
    }

    public void removeChild(Menu m){
        if(childs!=null && !childs.isEmpty()){
            childs.remove(m);
        }
    }

    public Set<Menu> getChilds() {
        return childs;
    }

    public Menu() {
    }

    public Menu(String id) {
        this.id = id;
    }

    public Menu(String id, Integer mnuLevel, Integer sort) {
        this.id = id;
        this.mnuLevel = mnuLevel;
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMnuLevel() {
        return mnuLevel;
    }

    public void setMnuLevel(Integer mnuLevel) {
        this.mnuLevel = mnuLevel;
    }

    public String getMnuClass() {
        return mnuClass;
    }

    public void setMnuClass(String mnuClass) {
        this.mnuClass = mnuClass;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @XmlTransient
    public List<Acc> getAccList() {
        return accList;
    }

    public void setAccList(List<Acc> accList) {
        this.accList = accList;
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return mnuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.mnuList = menuList;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return id;
    }
    
}
