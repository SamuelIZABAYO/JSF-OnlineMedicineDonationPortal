
package Model.Domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Builder;

/**
 *
 * @author eddy
 */
@Entity
public class Donor extends User{
   
    @OneToMany(mappedBy = "donor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Medicine> medecines;
     
    @Builder
     public Donor(String userName, String password, String name, String location, String contactNo) {
        super(userName, password, name, location, contactNo);
    }

    public Donor() {
    }

    public List<Medicine> getMedicines() {
        return medecines;
    }

    public void setMedicines(List<Medicine> medecines) {
        this.medecines = medecines;
    }
    
}
