package com.springapp.mvc.domain;

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
@Entity
@Table(name = "staff_project")
@XmlRootElement
public class StaffProject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_staff_project")
    private Integer idStaffProject;
    @JoinColumn(name = "id_staff", referencedColumnName = "id_staff")
    @ManyToOne(optional = false)
    private Staff idStaff;
    @JoinColumn(name = "id_project", referencedColumnName = "id_project")
    @ManyToOne(optional = false)
    private Project idProject;

    public StaffProject() {
    }

    public StaffProject(Integer idStaffProject) {
        this.idStaffProject = idStaffProject;
    }

    public Integer getIdStaffProject() {
        return idStaffProject;
    }

    public void setIdStaffProject(Integer idStaffProject) {
        this.idStaffProject = idStaffProject;
    }

    public Staff getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Staff idStaff) {
        this.idStaff = idStaff;
    }

    public Project getIdProject() {
        return idProject;
    }

    public void setIdProject(Project idProject) {
        this.idProject = idProject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStaffProject != null ? idStaffProject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffProject)) {
            return false;
        }
        StaffProject other = (StaffProject) object;
        if ((this.idStaffProject == null && other.idStaffProject != null) || (this.idStaffProject != null && !this.idStaffProject.equals(other.idStaffProject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StaffProject[ idStaffProject=" + idStaffProject + " ]";
    }

}

