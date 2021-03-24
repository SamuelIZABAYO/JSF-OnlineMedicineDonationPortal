package Model.Domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author eddy
 */
@Entity
public class Medicine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int medecineId;
    @Column(name = "NAME")
    private String medicineName;
    @Column(name = "QUATITY")
    private int Qty;
    @Temporal(TemporalType.DATE)
    @Column(name = "MANUFACTURE_DATE")
    private Date MNF_date;
    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRY_DATE")
    private Date EXP_date;
    @Version
    private int version;
    
   @OneToMany(mappedBy = "requestedMedecines")
    private List<Ngo> requestingNgos;
   @ManyToOne()
   @JoinColumn(name = "donorId",referencedColumnName = "userName")
   private Donor donor;
   
    public Medicine() {
    }

    public Medicine(String medicineName, int Qty, Date MNF_date, Date EXP_date,  Donor donor) {
        this.medicineName = medicineName;
        this.Qty = Qty;
        this.MNF_date = MNF_date;
        this.EXP_date = EXP_date;
       
        this.donor = donor;
    }

    public Date getEXP_date() {
        return EXP_date;
    }

    public void setEXP_date(Date EXP_date) {
        this.EXP_date = EXP_date;
    }

    public int getMedecineId() {
        return medecineId;
    }

    public void setMedecineId(int medecineId) {
        this.medecineId = medecineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Date getMNF_date() {
        return MNF_date;
    }

    public void setMNF_date(Date MNF_date) {
        this.MNF_date = MNF_date;
    }

    public List<Ngo> getRequestingNgos() {
        return requestingNgos;
    }
      
    public void setRequestingNgos(List<Ngo> requestingNgos) {
        this.requestingNgos = requestingNgos;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
    
    

}
