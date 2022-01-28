package groupId.nutritec.model;

public class ConsultaData {

    private int patientAge, consultaCount;

    public ConsultaData(int patientAge, int consultaCount) {
        this.patientAge = patientAge;
        this.consultaCount = consultaCount;
    }

    public ConsultaData() {
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public int getConsultaCount() {
        return consultaCount;
    }

    public void setConsultaCount(int consultaCount) {
        this.consultaCount = consultaCount;
    }
}
