package zoo.animal;

import java.time.LocalDateTime;

public class DiseaseNote {

    /** Болезнь */
    private String disease;
    /** Когда заболел */
    private LocalDateTime time;
    /** Дополнения */
    private final String comment;

    /**
     * Запись о болезни
     * @param disease болезнь
     * @param time когда заболел
     * @param comment дополнения
     */
    public DiseaseNote(String disease, LocalDateTime time, String comment) {
        this.disease = disease;
        this.time = time;
        this.comment = comment;
    }

    public String getDisease() {
        return disease;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "DiseaseNote{" +
                "disease='" + disease + '\'' +
                ", time=" + time +
                ", comment='" + comment + '\'' +
                '}';
    }
}
