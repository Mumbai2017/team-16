package good.force.teah.makeawish.Data;

/**
 * Created by Anurag on 7/29/2017.
 */

public class Doctor {
    int aadharID;
    String name;
    String address;
    String hospital;
    String specialization;
    int type;
    String gender;

    public int getAadhar_id() {
        return aadharID;
    }

    public void setAadhar_id(int aadhar_id) {
        this.aadharID = aadhar_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
