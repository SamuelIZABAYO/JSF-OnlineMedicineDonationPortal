package Model.Domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Builder;

/**
 *
 * @author eddy
 */
@Entity
public class Ngo extends User {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "request",
            joinColumns = {
                @JoinColumn(name = "NgoId")},
            inverseJoinColumns = {
                @JoinColumn(name = "medecine_id")})
    private List<Medicine> requestedMedicines = new ArrayList<>();

    public Ngo() {
    }

    @Builder
    public Ngo(String userName, String password, String name, String location, String contactNo) {
        super(userName, password, name, location, contactNo);
    }

    public List<Medicine> getRequestedMedicines() {
        return requestedMedicines;
    }

    public void setRequestedMedicines(List<Medicine> requestedMedicines) {
        this.requestedMedicines = requestedMedicines;
    }

    public void requestMedicine(Medicine medecine) {
        requestedMedicines.add(medecine);
    }

}
