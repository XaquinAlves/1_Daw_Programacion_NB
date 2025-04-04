package hogwarts.view;

import hogwarts.controller.HogwartsController;
import hogwarts.exceptions.UnderConstructionException;
import hogwarts.model.HogwartsCharacter;
import hogwarts.model.Student;
import hogwarts.model.Subject;
import hogwarts.model.Teacher;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Representa a interface de usuario do programa en modo grafico
 *
 * @author xaquin.alvesgonzalez
 */
public class JFrameHogwarts extends javax.swing.JFrame implements HogwartsView {

    /**
     * Referencia ao obxeto controlador
     */
    private HogwartsController controller;
    /**
     * Lista de personaxes a amosar
     */
    private ArrayList<HogwartsCharacter> shownCharacters;
    /**
     * Lista de materias a amosar
     */
    private ArrayList<Subject> shownSubjects;

    /**
     * Creates new form JFrameHogwarts
     */
    public JFrameHogwarts(HogwartsController controller) {
        initComponents();
        this.controller = controller;

    }

    /**
     * Establece a lista dada como parametro como lista de personaxes a amosar e
     * amosaa
     *
     * @param characters lista de personaxes
     * @throws UnderConstructionException
     */
    @Override
    public void setCharacters(ArrayList<HogwartsCharacter> characters) throws UnderConstructionException {
        this.shownCharacters = characters;
        DefaultListModel charListModel = new DefaultListModel();
        jListCharacters.setModel(charListModel);

        for (HogwartsCharacter character : shownCharacters) {
            charListModel.addElement(character.getName());
            clearCharacterData(true);
        }
    }

    /**
     * Establece a lista de asignaturas a mostrar e amosaas
     *
     * @param subjects lista de asignaturas
     * @throws UnderConstructionException
     */
    @Override
    public void setSubjects(ArrayList<Subject> subjects) throws UnderConstructionException {
        this.shownSubjects = subjects;

        DefaultListModel subjectsListModel = new DefaultListModel();
        jListSubjects.setModel(subjectsListModel);

        for (Subject subject : subjects) {
            subjectsListModel.addElement(subject.getName());
        }
    }

    /**
     * Fai visible a venta
     *
     * @throws UnderConstructionException
     */
    @Override
    public void showMenu() throws UnderConstructionException {
        this.setVisible(true);
    }

    @Override
    public void showCharacterData(HogwartsCharacter character)
            throws UnderConstructionException {
        //Mostramos o nome
        jTextFieldCharName.setText(character.getName());
        //Mostramos o codigo
        jTextFieldCharCode.setText(character.getCharacterCode());
        //Mostramos a descripción
        jTextFieldCharDesc.setText(character.getCharacteristics());
        //Mostramos a casa
        if (character.getHouse().isBlank()) {
            jComboBoxCharCasa.setSelectedItem("Ningunha");
        } else {
            jComboBoxCharCasa.setSelectedItem(character.getHouse());
        }
        //Mostramos a mascota
        if (character.getPet() == null) {
            jTextFieldPetName.setText("");
            jTextFieldPetAge.setText("");
            jTextFieldAnimal.setText("");
        } else {
            jTextFieldPetName.setText(character.getPet().getName());
            jTextFieldPetAge.setText(String.valueOf(character.getPet().getAge()));
            jTextFieldAnimal.setText(character.getPet().getAnimal());
        }
        //Mostramos os datos de alumnos
        if (character instanceof Student) {
            jLabelCurso.setVisible(true);
            jLabelQuidditchCV.setText("Quidditch: ");
            jTextFieldCurso.setVisible(true);
            jTextFieldCurso.setText(String.valueOf(((Student) character).getCurso()));
            jTextFieldCV.setText(((Student) character).getQuidditch());
        } else if (character instanceof Teacher) {//Mostramos os datos do profesor
            jLabelCurso.setVisible(false);
            jLabelQuidditchCV.setText("CV: ");
            jTextFieldCurso.setVisible(false);
            jTextFieldCV.setText(((Teacher) character).getCv());
        }

    }

    /**
     * Sen implementar
     *
     * @param subject
     * @throws UnderConstructionException
     */
    @Override
    public void showSubjectData(Subject subject)
            throws UnderConstructionException {
        throw new UnderConstructionException();
    }

    /**
     * Amosa un candro de dialogo indicando que a opcion non esta dispoñible
     *
     * @param operationName nome da opcion/funcion
     */
    @Override
    public void showUnderConstructionMessage(String operationName) {
        JOptionPane.showMessageDialog(this, "A operación " + operationName
                + "ainda está en construcción");
    }

    private void clearCharacterData(boolean isStudent) {
        //Limpamos os campos comuns
        jTextFieldCharName.setText("");
        jTextFieldCharCode.setText("");
        jTextFieldCharDesc.setText("");
        jComboBoxCharCasa.setSelectedIndex(0);
        //Este campo usase para CV e Quidditch
        jTextFieldCV.setText("");
        //Se vamos a crear un estudante
        if (isStudent) {
            //Amosamos etiqueta e campo curso, e pomos o campo en blanco
            jLabelCurso.setVisible(true);
            jTextFieldCurso.setVisible(true);
            //Na etiqueta Quidditch/CV pomos Quidditch
            jLabelQuidditchCV.setText("Quidditch:");
        } else {//Se vamos a crear un profesor
            //Ocultamos a etiqueta e o campo curso
            jLabelCurso.setVisible(false);
            jTextFieldCurso.setVisible(false);
            //Na etiqueta Quidditch/CV pomos CV
            jLabelQuidditchCV.setText("CV:");
        }
    }

    private void saveCharacter() {

    }

    /**
     * Permite borrar un personaxe dos gardados. Se non hay ningun seleccionado,
     * mostra un cadro de dialogo dicindo que debe estar un personaxe
     * seleccionado, se non mostra un dialogo de confirmación para borrar o
     * personaxe
     */
    private void deleteCharacter() {
        if (jListCharacters.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un personaxe para borrar",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitle = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jTabbedPaneMain = new javax.swing.JTabbedPane();
        jSplitPaneCharacters = new javax.swing.JSplitPane();
        jPanelCharDescription = new javax.swing.JPanel();
        jPanelInfoCharacter = new javax.swing.JPanel();
        jLabelCharName = new javax.swing.JLabel();
        jTextFieldCharName = new javax.swing.JTextField();
        jLabelCharCode = new javax.swing.JLabel();
        jTextFieldCharCode = new javax.swing.JTextField();
        jLabelCharDesc = new javax.swing.JLabel();
        jTextFieldCharDesc = new javax.swing.JTextField();
        jLabelCharCasa = new javax.swing.JLabel();
        jComboBoxCharCasa = new javax.swing.JComboBox<>();
        jLabelCurso = new javax.swing.JLabel();
        jLabelQuidditchCV = new javax.swing.JLabel();
        jTextFieldCurso = new javax.swing.JTextField();
        jTextFieldCV = new javax.swing.JTextField();
        jPanelInfoPet = new javax.swing.JPanel();
        jLabelPetName = new javax.swing.JLabel();
        jLabelAnimal = new javax.swing.JLabel();
        jTextFieldPetName = new javax.swing.JTextField();
        jTextFieldAnimal = new javax.swing.JTextField();
        jLabelPetAge = new javax.swing.JLabel();
        jTextFieldPetAge = new javax.swing.JTextField();
        jButtonCharSave = new javax.swing.JButton();
        jPanelCharList = new javax.swing.JPanel();
        jButtonCharNew = new javax.swing.JButton();
        jButtonCharDelete = new javax.swing.JButton();
        jScrollPaneCharList = new javax.swing.JScrollPane();
        jListCharacters = new javax.swing.JList<>();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelSubjectList = new javax.swing.JPanel();
        jButtonSubjectNew = new javax.swing.JButton();
        jButtonSubjectDelete = new javax.swing.JButton();
        jScrollPaneSubjectList = new javax.swing.JScrollPane();
        jListSubjects = new javax.swing.JList<>();
        jPanelSubjectDescription = new javax.swing.JPanel();
        jPanelInfoSubject = new javax.swing.JPanel();
        jLabelSubjectCode = new javax.swing.JLabel();
        jLabelSubjectName = new javax.swing.JLabel();
        jTextFieldSubjectCode = new javax.swing.JTextField();
        jTextFieldSubjectName = new javax.swing.JTextField();
        jLabelSubjectCurso = new javax.swing.JLabel();
        jLabelSubjectTeacher = new javax.swing.JLabel();
        jComboBoxSubjectTeacher = new javax.swing.JComboBox<>();
        jTextFieldSubjectCurso = new javax.swing.JTextField();
        jPanelInfoStudents = new javax.swing.JPanel();
        jLabelStudentsAvaliable = new javax.swing.JLabel();
        jLabelSubjectStudents = new javax.swing.JLabel();
        jLabelRigthArow = new javax.swing.JLabel();
        jLabelLeftArrow = new javax.swing.JLabel();
        jScrollPaneAvbStudents = new javax.swing.JScrollPane();
        jListAvaliableStudents = new javax.swing.JList<>();
        jScrollPaneSubjectStudents = new javax.swing.JScrollPane();
        jListSubjectStudents = new javax.swing.JList<>();
        jButtonSubjectSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelTitle.setBackground(new java.awt.Color(204, 204, 204));

        jLabelTitle.setFont(new java.awt.Font("Tibetan Machine Uni", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hogwarts-3476786_1280.png"))); // NOI18N
        jLabelTitle.setText("Benvido a Hogwarts");
        jPanelTitle.add(jLabelTitle);

        getContentPane().add(jPanelTitle, java.awt.BorderLayout.PAGE_START);

        jTabbedPaneMain.setBackground(new java.awt.Color(204, 204, 204));

        jPanelCharDescription.setBackground(new java.awt.Color(204, 204, 204));

        jPanelInfoCharacter.setBackground(new java.awt.Color(204, 204, 204));
        jPanelInfoCharacter.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Personaxe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelInfoCharacter.setForeground(new java.awt.Color(0, 0, 0));

        jLabelCharName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCharName.setText("Nome:");

        jTextFieldCharName.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCharName.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldCharName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCharNameActionPerformed(evt);
            }
        });

        jLabelCharCode.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCharCode.setText("Código:");

        jTextFieldCharCode.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCharCode.setForeground(new java.awt.Color(0, 0, 0));

        jLabelCharDesc.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCharDesc.setText("Características:");

        jTextFieldCharDesc.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCharDesc.setForeground(new java.awt.Color(0, 0, 0));

        jLabelCharCasa.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCharCasa.setText("Casa:");

        jComboBoxCharCasa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ningunha", "Griffindor", "Hufflepuff", "Ravenclaw", "Slytherin", " " }));

        jLabelCurso.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCurso.setText("Curso:");

        jLabelQuidditchCV.setForeground(new java.awt.Color(0, 0, 0));
        jLabelQuidditchCV.setText("Quidditch:");

        jTextFieldCurso.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCurso.setForeground(new java.awt.Color(0, 0, 0));
        jTextFieldCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCursoActionPerformed(evt);
            }
        });

        jTextFieldCV.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCV.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanelInfoCharacterLayout = new javax.swing.GroupLayout(jPanelInfoCharacter);
        jPanelInfoCharacter.setLayout(jPanelInfoCharacterLayout);
        jPanelInfoCharacterLayout.setHorizontalGroup(
            jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoCharacterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelInfoCharacterLayout.createSequentialGroup()
                        .addComponent(jLabelCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInfoCharacterLayout.createSequentialGroup()
                        .addComponent(jLabelCharName)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCharName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInfoCharacterLayout.createSequentialGroup()
                        .addComponent(jLabelCharCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCharCode)))
                .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoCharacterLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelCharDesc))
                    .addGroup(jPanelInfoCharacterLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelQuidditchCV)
                            .addComponent(jLabelCharCasa))))
                .addGap(11, 11, 11)
                .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldCharDesc)
                        .addComponent(jComboBoxCharCasa, 0, 328, Short.MAX_VALUE))
                    .addComponent(jTextFieldCV, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInfoCharacterLayout.setVerticalGroup(
            jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoCharacterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCharName)
                    .addComponent(jTextFieldCharName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCharDesc)
                    .addComponent(jTextFieldCharDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCharCode)
                        .addComponent(jTextFieldCharCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCharCasa)
                        .addComponent(jComboBoxCharCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoCharacterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelCurso)
                        .addComponent(jTextFieldCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelQuidditchCV)
                    .addComponent(jTextFieldCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanelInfoPet.setBackground(new java.awt.Color(204, 204, 204));
        jPanelInfoPet.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Mascota", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanelInfoPet.setForeground(new java.awt.Color(0, 0, 0));

        jLabelPetName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPetName.setText("Nome:");

        jLabelAnimal.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAnimal.setText("Animal:");

        jTextFieldPetName.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPetName.setForeground(new java.awt.Color(0, 0, 0));

        jTextFieldAnimal.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldAnimal.setForeground(new java.awt.Color(0, 0, 0));

        jLabelPetAge.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPetAge.setText("Idade:");

        jTextFieldPetAge.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldPetAge.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanelInfoPetLayout = new javax.swing.GroupLayout(jPanelInfoPet);
        jPanelInfoPet.setLayout(jPanelInfoPetLayout);
        jPanelInfoPetLayout.setHorizontalGroup(
            jPanelInfoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoPetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoPetLayout.createSequentialGroup()
                        .addComponent(jLabelPetName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(jTextFieldPetName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInfoPetLayout.createSequentialGroup()
                        .addComponent(jLabelAnimal)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldAnimal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPetAge)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldPetAge, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
        );
        jPanelInfoPetLayout.setVerticalGroup(
            jPanelInfoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoPetLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanelInfoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPetName)
                    .addComponent(jTextFieldPetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPetAge)
                    .addComponent(jTextFieldPetAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfoPetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAnimal)
                    .addComponent(jTextFieldAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButtonCharSave.setText("GardarCambios");

        javax.swing.GroupLayout jPanelCharDescriptionLayout = new javax.swing.GroupLayout(jPanelCharDescription);
        jPanelCharDescription.setLayout(jPanelCharDescriptionLayout);
        jPanelCharDescriptionLayout.setHorizontalGroup(
            jPanelCharDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCharDescriptionLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelCharDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonCharSave)
                    .addGroup(jPanelCharDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelInfoPet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelInfoCharacter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanelCharDescriptionLayout.setVerticalGroup(
            jPanelCharDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCharDescriptionLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanelInfoCharacter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelInfoPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(jButtonCharSave)
                .addGap(16, 16, 16))
        );

        jSplitPaneCharacters.setRightComponent(jPanelCharDescription);

        jPanelCharList.setBackground(new java.awt.Color(204, 204, 204));

        jButtonCharNew.setText("Novo");
        jButtonCharNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCharNewActionPerformed(evt);
            }
        });

        jButtonCharDelete.setText("Eliminar");

        jListCharacters.setBackground(new java.awt.Color(255, 255, 255));
        jListCharacters.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPaneCharList.setViewportView(jListCharacters);

        javax.swing.GroupLayout jPanelCharListLayout = new javax.swing.GroupLayout(jPanelCharList);
        jPanelCharList.setLayout(jPanelCharListLayout);
        jPanelCharListLayout.setHorizontalGroup(
            jPanelCharListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCharListLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelCharListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCharListLayout.createSequentialGroup()
                        .addComponent(jButtonCharNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCharDelete))
                    .addComponent(jScrollPaneCharList, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCharListLayout.setVerticalGroup(
            jPanelCharListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCharListLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPaneCharList, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCharListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCharNew)
                    .addComponent(jButtonCharDelete))
                .addGap(20, 20, 20))
        );

        jSplitPaneCharacters.setLeftComponent(jPanelCharList);

        jTabbedPaneMain.addTab("Personaxes", jSplitPaneCharacters);

        jPanelSubjectList.setBackground(new java.awt.Color(204, 204, 204));

        jButtonSubjectNew.setText("Novo");

        jButtonSubjectDelete.setText("Eliminar");
        jButtonSubjectDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubjectDeleteActionPerformed(evt);
            }
        });

        jListSubjects.setBackground(new java.awt.Color(255, 255, 255));
        jListSubjects.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPaneSubjectList.setViewportView(jListSubjects);

        javax.swing.GroupLayout jPanelSubjectListLayout = new javax.swing.GroupLayout(jPanelSubjectList);
        jPanelSubjectList.setLayout(jPanelSubjectListLayout);
        jPanelSubjectListLayout.setHorizontalGroup(
            jPanelSubjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubjectListLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelSubjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneSubjectList, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelSubjectListLayout.createSequentialGroup()
                        .addComponent(jButtonSubjectNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSubjectDelete)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelSubjectListLayout.setVerticalGroup(
            jPanelSubjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubjectListLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPaneSubjectList, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSubjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSubjectNew)
                    .addComponent(jButtonSubjectDelete))
                .addGap(18, 18, 18))
        );

        jSplitPane1.setLeftComponent(jPanelSubjectList);

        jPanelSubjectDescription.setBackground(new java.awt.Color(204, 204, 204));

        jPanelInfoSubject.setBackground(new java.awt.Color(204, 204, 204));
        jPanelInfoSubject.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos da materia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabelSubjectCode.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSubjectCode.setText("Código:");

        jLabelSubjectName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSubjectName.setText("Nome:");

        jTextFieldSubjectCode.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSubjectCode.setForeground(new java.awt.Color(0, 0, 0));

        jTextFieldSubjectName.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSubjectName.setForeground(new java.awt.Color(0, 0, 0));

        jLabelSubjectCurso.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSubjectCurso.setText("Curso:");

        jLabelSubjectTeacher.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSubjectTeacher.setText("Docente:");

        jComboBoxSubjectTeacher.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxSubjectTeacher.setForeground(new java.awt.Color(0, 0, 0));

        jTextFieldSubjectCurso.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSubjectCurso.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanelInfoSubjectLayout = new javax.swing.GroupLayout(jPanelInfoSubject);
        jPanelInfoSubject.setLayout(jPanelInfoSubjectLayout);
        jPanelInfoSubjectLayout.setHorizontalGroup(
            jPanelInfoSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoSubjectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelInfoSubjectLayout.createSequentialGroup()
                        .addComponent(jLabelSubjectCode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInfoSubjectLayout.createSequentialGroup()
                        .addComponent(jLabelSubjectName)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldSubjectName)))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfoSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSubjectTeacher)
                    .addComponent(jLabelSubjectCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInfoSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSubjectTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSubjectCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanelInfoSubjectLayout.setVerticalGroup(
            jPanelInfoSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoSubjectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSubjectCode)
                    .addComponent(jTextFieldSubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSubjectCurso)
                    .addComponent(jTextFieldSubjectCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelInfoSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelSubjectName)
                        .addComponent(jTextFieldSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInfoSubjectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelSubjectTeacher)
                        .addComponent(jComboBoxSubjectTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanelInfoStudents.setBackground(new java.awt.Color(204, 204, 204));
        jPanelInfoStudents.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Alumnado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabelStudentsAvaliable.setForeground(new java.awt.Color(0, 0, 0));
        jLabelStudentsAvaliable.setText("Alumnado dispoñinle:");

        jLabelSubjectStudents.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSubjectStudents.setText("AlumnadoMatriculado");

        jLabelRigthArow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrows-147752_640.png"))); // NOI18N

        jLabelLeftArrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/arrows-147754_640.png"))); // NOI18N

        jListAvaliableStudents.setBackground(new java.awt.Color(255, 255, 255));
        jListAvaliableStudents.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPaneAvbStudents.setViewportView(jListAvaliableStudents);

        jListSubjectStudents.setBackground(new java.awt.Color(255, 255, 255));
        jListSubjectStudents.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPaneSubjectStudents.setViewportView(jListSubjectStudents);

        javax.swing.GroupLayout jPanelInfoStudentsLayout = new javax.swing.GroupLayout(jPanelInfoStudents);
        jPanelInfoStudents.setLayout(jPanelInfoStudentsLayout);
        jPanelInfoStudentsLayout.setHorizontalGroup(
            jPanelInfoStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStudentsAvaliable)
                    .addComponent(jScrollPaneAvbStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelInfoStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoStudentsLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabelSubjectStudents))
                    .addGroup(jPanelInfoStudentsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelInfoStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLeftArrow)
                            .addComponent(jLabelRigthArow))
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPaneSubjectStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInfoStudentsLayout.setVerticalGroup(
            jPanelInfoStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInfoStudentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInfoStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStudentsAvaliable)
                    .addComponent(jLabelSubjectStudents))
                .addGroup(jPanelInfoStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInfoStudentsLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabelRigthArow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jLabelLeftArrow)
                        .addGap(72, 72, 72))
                    .addGroup(jPanelInfoStudentsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInfoStudentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPaneSubjectStudents, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(jScrollPaneAvbStudents))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jButtonSubjectSave.setText("Gardar Cambios");

        javax.swing.GroupLayout jPanelSubjectDescriptionLayout = new javax.swing.GroupLayout(jPanelSubjectDescription);
        jPanelSubjectDescription.setLayout(jPanelSubjectDescriptionLayout);
        jPanelSubjectDescriptionLayout.setHorizontalGroup(
            jPanelSubjectDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubjectDescriptionLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelSubjectDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSubjectSave)
                    .addComponent(jPanelInfoStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelSubjectDescriptionLayout.createSequentialGroup()
                        .addComponent(jPanelInfoSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelSubjectDescriptionLayout.setVerticalGroup(
            jPanelSubjectDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSubjectDescriptionLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanelInfoSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelInfoStudents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSubjectSave)
                .addGap(19, 19, 19))
        );

        jSplitPane1.setRightComponent(jPanelSubjectDescription);

        jTabbedPaneMain.addTab("Materias", jSplitPane1);

        getContentPane().add(jTabbedPaneMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCharNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCharNewActionPerformed
        clearCharacterData(true);
    }//GEN-LAST:event_jButtonCharNewActionPerformed

    private void jButtonSubjectDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubjectDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSubjectDeleteActionPerformed

    private void jTextFieldCharNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCharNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCharNameActionPerformed

    private void jTextFieldCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCursoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameHogwarts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameHogwarts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameHogwarts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameHogwarts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameHogwarts(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCharDelete;
    private javax.swing.JButton jButtonCharNew;
    private javax.swing.JButton jButtonCharSave;
    private javax.swing.JButton jButtonSubjectDelete;
    private javax.swing.JButton jButtonSubjectNew;
    private javax.swing.JButton jButtonSubjectSave;
    private javax.swing.JComboBox<String> jComboBoxCharCasa;
    private javax.swing.JComboBox<String> jComboBoxSubjectTeacher;
    private javax.swing.JLabel jLabelAnimal;
    private javax.swing.JLabel jLabelCharCasa;
    private javax.swing.JLabel jLabelCharCode;
    private javax.swing.JLabel jLabelCharDesc;
    private javax.swing.JLabel jLabelCharName;
    private javax.swing.JLabel jLabelCurso;
    private javax.swing.JLabel jLabelLeftArrow;
    private javax.swing.JLabel jLabelPetAge;
    private javax.swing.JLabel jLabelPetName;
    private javax.swing.JLabel jLabelQuidditchCV;
    private javax.swing.JLabel jLabelRigthArow;
    private javax.swing.JLabel jLabelStudentsAvaliable;
    private javax.swing.JLabel jLabelSubjectCode;
    private javax.swing.JLabel jLabelSubjectCurso;
    private javax.swing.JLabel jLabelSubjectName;
    private javax.swing.JLabel jLabelSubjectStudents;
    private javax.swing.JLabel jLabelSubjectTeacher;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList<String> jListAvaliableStudents;
    private javax.swing.JList<String> jListCharacters;
    private javax.swing.JList<String> jListSubjectStudents;
    private javax.swing.JList<String> jListSubjects;
    private javax.swing.JPanel jPanelCharDescription;
    private javax.swing.JPanel jPanelCharList;
    private javax.swing.JPanel jPanelInfoCharacter;
    private javax.swing.JPanel jPanelInfoPet;
    private javax.swing.JPanel jPanelInfoStudents;
    private javax.swing.JPanel jPanelInfoSubject;
    private javax.swing.JPanel jPanelSubjectDescription;
    private javax.swing.JPanel jPanelSubjectList;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JScrollPane jScrollPaneAvbStudents;
    private javax.swing.JScrollPane jScrollPaneCharList;
    private javax.swing.JScrollPane jScrollPaneSubjectList;
    private javax.swing.JScrollPane jScrollPaneSubjectStudents;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPaneCharacters;
    private javax.swing.JTabbedPane jTabbedPaneMain;
    private javax.swing.JTextField jTextFieldAnimal;
    private javax.swing.JTextField jTextFieldCV;
    private javax.swing.JTextField jTextFieldCharCode;
    private javax.swing.JTextField jTextFieldCharDesc;
    private javax.swing.JTextField jTextFieldCharName;
    private javax.swing.JTextField jTextFieldCurso;
    private javax.swing.JTextField jTextFieldPetAge;
    private javax.swing.JTextField jTextFieldPetName;
    private javax.swing.JTextField jTextFieldSubjectCode;
    private javax.swing.JTextField jTextFieldSubjectCurso;
    private javax.swing.JTextField jTextFieldSubjectName;
    // End of variables declaration//GEN-END:variables
}
