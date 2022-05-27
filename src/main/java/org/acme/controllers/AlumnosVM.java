package org.acme.controllers;

import org.acme.models.Alumno;
import org.acme.repositories.AlumnoRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

@Controller
public class AlumnosVM {

    private static final Logger LOGGER = Logger.getLogger(AlumnosVM.class);

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Wire
    private Textbox keywordBox;

    @Wire
    private Listbox alumnoListBox;

    @Wire
    private Label nombreLabel;

    @Wire
    private Label apPaternoLabel;

    @Wire
    private Label apMaternoLabel;

    private ListModelList<Alumno> dataModel = new ListModelList<>();

    /*
    public void doAfterCompose(Component comp) throws Exception {
        LOGGER.info("||||| doAfterCompose |||||");
        super.doAfterCompose(comp);

        var alumno1 = new Alumno( "Juan", "Perez", "Perez", true);
        var alumno2 = new Alumno( "Jose", "Lopez", "Gonzalez", true);

        alumnoRepository.save(alumno1);
        alumnoRepository.save(alumno2);

        dataModel.clear();
        alumnoListBox.setModel(dataModel);

        alumnoRepository.findAll().forEach(dataModel::add);
    }

     */
}
