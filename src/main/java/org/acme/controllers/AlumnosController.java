package org.acme.controllers;

import org.acme.models.Alumno;
import org.acme.repositories.AlumnoRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.ApplicationScope;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

@ApplicationScope
public class AlumnosController extends SelectorComposer<Component> {

    private static final Logger LOGGER = Logger.getLogger(AlumnosController.class);

    @Autowired
    AlumnoRepository alumnoRepository;

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

    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        var alumno1 = new Alumno( "Juan", "Perez", "Perez", 1);
        var alumno2 = new Alumno( "Jose", "Lopez", "Gonzalez", 1);

        alumnoRepository.save(alumno1);
        alumnoRepository.save(alumno2);

        dataModel.clear();
        alumnoListBox.setModel(dataModel);
        dataModel.addAll(alumnoRepository.findAll());
    }

}
