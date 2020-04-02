package zoo.animal;

import zoo.employee.Employee;

import java.time.LocalDate;
import java.util.*;

public class Animal {

    /** Название животного */
    private String name;
    /** Дата рождения */
    private LocalDate dateOfBirth;
    /** Опекуны */
    private Set<Employee> employees;
    /** Журнал болезней */
    private List<DiseaseNote> diseaseDiary;


    /**
     * Животное
     * @param name название
     * @param dateOfBirth дата рождения
     */
    public Animal(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.employees = new HashSet<>();
        this.diseaseDiary = new ArrayList<>();
    }

    /**
     * Добавление записи о болезни
     * @param diseaseNote запись о болезни
     */
    public void add(DiseaseNote diseaseNote) {
        diseaseDiary.add(diseaseNote);
    }

    /**
     * Добавление опекуна
     * @param employee опекун
     */
    public void add(Employee employee) {
        employees.add(employee);
    }

    /**
     * Снятие опекуна
     * @param employee опекун
     */
    public void remove(Employee employee) {
        employees.remove(employee);
    }

    public String getName() {
        return name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public Set<Employee> getEmployees() {
        return employees;
    }
    public List<DiseaseNote> getDiseaseDiary() {
        return diseaseDiary;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", employees=" + employees +
                ", diseaseDiary=" + diseaseDiary +
                '}';
    }
}
