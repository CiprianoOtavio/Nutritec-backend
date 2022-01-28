package groupId.nutritec.model;

public class Consulta {

    private String id;
    private String nutritionistId;
    private String patientId;
    private Long date;

//    public String formatDate(LocalDateTime localDateTime){
//        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
//    }


    public Consulta(String id, String nutritionistId, String patientId, Long date) {
        this.id = id;
        this.nutritionistId = nutritionistId;
        this.patientId = patientId;
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

    public String getNutritionistId() {
        return nutritionistId;
    }

    public void setNutritionistId(String nutritionistId) {
        this.nutritionistId = nutritionistId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
