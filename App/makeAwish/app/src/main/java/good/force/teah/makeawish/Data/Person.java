package good.force.teah.makeawish.Data;

/**
 * Created by Anurag on 7/30/2017.
 */

public class Person {
    String aadhar_id, password;
    int typeDoctor, typeDonor, volunteer;

    public Person(String aadhar_id, String password, int typeDoctor, int typeDonor, int volunteer) {
        this.aadhar_id = aadhar_id;
        this.password = password;
        this.typeDoctor = typeDoctor;
        this.typeDonor = typeDonor;
        this.volunteer = volunteer;
    }

    public String getAadhar_id() {
        return aadhar_id;
    }

    public void setAadhar_id(String aadhar_id) {
        this.aadhar_id = aadhar_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTypeDoctor() {
        return typeDoctor;
    }

    public void setTypeDoctor(int typeDoctor) {
        this.typeDoctor = typeDoctor;
    }

    public int getTypeDonor() {
        return typeDonor;
    }

    public void setTypeDonor(int typeDonor) {
        this.typeDonor = typeDonor;
    }

    public int getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(int volunteer) {
        this.volunteer = volunteer;
    }
}
