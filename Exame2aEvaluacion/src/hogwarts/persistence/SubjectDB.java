package hogwarts.persistence;

import hogwarts.model.Subject;
import java.util.ArrayList;

/**
 * Manexa a persistencia das asignaturas
 *
 * @author xaquin.alvesgonzalez
 */
public class SubjectDB {

    /**
     * Lista das materias gardadas
     */
    private static ArrayList<Subject> subjects = new ArrayList<>();

    /**
     * Obten a lista das materias gardadas
     *
     * @return Lista das materias gardadas
     */
    public static ArrayList<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Busca unha asignatura por codigo, devolvendoa se a atopa, se non
     * devolvendo null
     *
     * @param subjectCode codigo da asignatura
     * @return a asginatura se existe, se non null
     */
    public static Subject finByCode(String subjectCode) {
        Subject foundSubject = null;

        for (Subject subject : subjects) {
            if (subject.getSubjectCode().equals(subjectCode)) {
                foundSubject = subject;
            }
        }

        return foundSubject;
    }
}
