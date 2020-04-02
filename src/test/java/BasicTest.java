import org.junit.jupiter.api.*;
import zoo.Zoo;
import zoo.animal.Animal;
import zoo.animal.DiseaseNote;
import zoo.employee.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@DisplayName("Зоопарк: проверка основы")
public class BasicTest {

    private Employee Jack;
    private Employee John;
    private Animal lion;
    private Animal wolf;
    private Zoo zoo;

    @BeforeEach
    public void Init() {
        zoo = new Zoo("Сан-Диего");

        Jack = new Employee("Джек", LocalDate.of(1960,5,3));
        John  = new Employee("Джон", LocalDate.of(1975,8,1));

        lion = new Animal("лев", LocalDate.now());
        wolf = new Animal("волк", LocalDate.now());
    }

    @DisplayName("Приём на работу и увольнение сотрудников")
    @Test
    public void HiringAndFiringTest() {

        zoo.add(Jack, John);
        Assertions.assertEquals(Arrays.asList(Jack,John), zoo.getEmployees());

        zoo.remove(Jack, John);
        Assertions.assertEquals(new ArrayList<>(), zoo.getEmployees());
    }

    @DisplayName("Появление и исчезновение животных")
    @Test
    public void AnimalActionTest() {

        zoo.add(Jack, John);
        zoo.add(lion, Jack);
        zoo.add(wolf, John);
        Assertions.assertEquals(Arrays.asList(lion, wolf), zoo.getAnimals());

        zoo.remove(lion, wolf);
        Assertions.assertEquals(new ArrayList<>(), zoo.getAnimals());
    }

    @DisplayName("Добавление записей о болезнях")
    @Test
    public void DiseaseDiaryTest() {

        zoo.add(John);
        zoo.add(lion, John);

        DiseaseNote plague = new DiseaseNote("чума", LocalDateTime.now(), "");
        DiseaseNote flu = new DiseaseNote("грипп", LocalDateTime.now(), "тяжелый случай");

        lion.add(plague);
        lion.add(flu);
        Assertions.assertEquals(Arrays.asList(plague, flu), lion.getDiseaseDiary());
    }

    @DisplayName("Увольнение сотрудников, имеющих подопечных")
    @Test
    public void GuardHiring() {
        zoo.add(John);
        zoo.add(lion, John);
        zoo.remove(John);
        /* Перед увольнением Джона снимается ответственность за льва */
        Assertions.assertEquals(new HashSet<>(), lion.getEmployees());
        /* Затем происходит увольнение */
        Assertions.assertEquals(new ArrayList<>(), zoo.getEmployees());
    }
}
