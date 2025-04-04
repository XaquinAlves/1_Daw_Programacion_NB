package hogwarts.model;

import java.util.ArrayList;

/**
 * Esta clase represeenta unha materua que se imparte na academia
 *
 * @author xaquin.alvesgonzalez
 */
public class Subject {

    /**
     * Codigo da materia
     */
    private String subjectCode;
    /**
     * Nome da materia
     */
    private String name;
    /**
     * Curso no que se imparte a materia
     */
    private int curso;
    /**
     * Profesor que imparte a materia
     */
    private Teacher teacher;
    /**
     * Lista de alumnos que cursan a materia
     */
    private ArrayList<Student> students;

    /**
     * Para instanciar unha materia
     *
     * @param subject_code Codigo da materia
     * @param name Nome da materia
     * @param curso Curso no que se imparte a materia
     * @param teacher Profesor que imparte a materia
     */
    public Subject(String subject_code, String name, int curso, Teacher teacher) {
        this.subjectCode = subject_code;
        this.name = name;
        this.curso = curso;
        this.teacher = teacher;
        students = new ArrayList<>();
    }

    /**
     *
     * @return Codigo da materia
     */
    public String getSubjectCode() {
        return subjectCode;
    }

    /**
     * Establece o Codigo da materia
     *
     * @param subjectCode Codigo da materia
     */
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    /**
     *
     * @return Nome da materia
     */
    public String getName() {
        return name;
    }

    /**
     * Establece o Nome da materia
     *
     * @param name Nome da materia
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Curso no que se imparte a materia
     */
    public int getCurso() {
        return curso;
    }

    /**
     * Establece o Curso no que se imparte a materia
     *
     * @param curso Curso no que se imparte a materia
     */
    public void setCurso(int curso) {
        this.curso = curso;
    }

    /**
     *
     * @return Profesor que imparte a materia
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Establece o Profesor que imparte a materia
     *
     * @param teacher Profesor que imparte a materia
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     *
     * @return Lista de alumnos que cursan a materia
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Establece a Lista de alumnos que cursan a materia
     *
     * @param
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

}
