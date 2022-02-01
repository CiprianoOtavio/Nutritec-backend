package groupId.nutritec.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Nutritionist {
    @Id
    private String registration;
    private String name;
    private int age;
    private String speciality;
    private List<String> healthPlan;

    public Nutritionist(String registration, String name, int age, String speciality, List<String> healthPlan) {
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

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
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
