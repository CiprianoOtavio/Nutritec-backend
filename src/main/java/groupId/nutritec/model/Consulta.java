package groupId.nutritec.model;

public class Consulta {

    private String id;
    private String nutritionistRegistration;
    private String patientCPF;
    private String date;

    public Consulta(String id, String nutritionistId, String patientCPF, String date) {
        this.id = id;
        this.nutritionistRegistration = nutritionistId;
        this.patientCPF = patientCPF;
        this.date = date;
    }

    public Consulta() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNutritionistRegistration() {
        return nutritionistRegistration;
    }

    public void setNutritionistRegistration(String nutritionistId) {
        this.nutritionistRegistration = nutritionistId;
    }

    public String getPatientCPF() {
        return patientCPF;
    }

    public void setPatientCPF(String patientCPF) {
        this.patientCPF = patientCPF;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}