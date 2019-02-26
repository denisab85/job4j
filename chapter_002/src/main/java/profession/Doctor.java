package profession;

public class Doctor extends Profession {

    public Doctor(String profession) {
        super(profession);
    }

    public Diagnose heal(Patient patient) {
        return new Diagnose();
    }

}
