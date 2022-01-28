package groupId.nutritec.model;

import java.util.List;

public class Nutritionist {
    private String id;
    private Long registration;
    private String name;
    private int age;
    private String speciality;
    private List<String> healthPlan;

    public Nutritionist(String id, Long registration, String name, int age, String speciality, List<String> healthPlan) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.speciality = speciality;
        this.registration = registration;
        this.healthPlan = healthPlan;
    }

    public Nutritionist() {
    }

    public List<String> getHealthPlan() {
        return healthPlan;
    }

    public void setHealthPlan(List<String> healthPlan) {
        this.healthPlan = healthPlan;
    }

    public Long getRegistration() {
        return registration;
    }

    public void setRegistration(Long registration) {
        this.registration = registration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
