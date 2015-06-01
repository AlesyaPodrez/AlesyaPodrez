package com.springapp.mvc.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@Entity
@Table(name = "project")
@XmlRootElement
public class Project {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_project")
    private Integer idProject;
    @Basic(optional = false)
    @Column(name = "year")
    private String year;
    @Basic(optional = false)
    @Column(name = "name_project")
    private String nameProject;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Basic(optional = true)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProject")
    private Collection<Role> roleCollection;
    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
    @ManyToOne(optional = false)
    private myType idType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProject")
    private Collection<StaffProject> staffProjectCollection;

    public Project() {
    }

    public Project(Integer idProject) {
        this.idProject = idProject;
    }

    public Project(Integer idProject, String year, String nameProject, String country, String image) {
        this.idProject = idProject;
        this.year = year;
        this.nameProject = nameProject;
        this.country = country;
        this.image = image;
    }

    public Project(Integer idProject, String year, String nameProject, String country) {
        this.idProject = idProject;
        this.year = year;
        this.nameProject = nameProject;
        this.country = country;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String coutry) {
        this.country = coutry;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    public myType getIdType() {
        return idType;
    }

    public void setIdType(myType idMyType) {
        this.idType = idMyType;
    }

    @XmlTransient
    public Collection<StaffProject> getStaffProjectCollection() {
        return staffProjectCollection;
    }

    public void setStaffProjectCollection(Collection<StaffProject> staffProjectCollection) {
        this.staffProjectCollection = staffProjectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProject != null ? idProject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.idProject == null && other.idProject != null) || (this.idProject != null && !this.idProject.equals(other.idProject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Project[ idProject=" + idProject + " ]";
    }

}

