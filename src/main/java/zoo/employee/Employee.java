package zoo.employee;

import zoo.animal.Animal;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Employee {

    /** Имя сотрудника */
    private String name;
    /** дата рождения */
    private LocalDate dateOfBirth;
    /** Подопечные */
    private Set<Animal> animals;

    /**
     * Сотрудник
     * @param name Имя
     * @param dateOfBirth дата рождения
     */
    public Employee(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        animals = new HashSet<>();
    }

    /**
     * Добавление подопечного
     * @param animal подопечный
     */
    public void add(Animal animal) {
        animals.add(animal);
    }

    /**
     * Снятие ответственности за животное
     * @param animal животное
     */
    public void remove(Animal animal) {
        animals.remove(animal);
    }

    /**
     * Находится ли животное на попечении?
     * @param animal животное
     * @return правда, если находится
     */
    public boolean isCare(Animal animal) {
        return animals.contains(animal);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", animals=" + animals +
                '}';
    }
}
