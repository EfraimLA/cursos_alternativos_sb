package org.acme.vm;

import lombok.Getter;
import lombok.Setter;
import org.acme.models.Alumno;
import org.acme.services.AlumnoService;
import org.jboss.logging.Logger;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModelList;

import java.util.List;

@VariableResolver({DelegatingVariableResolver.class})
public class AlumnosVM {

    private static final Logger LOGGER = Logger.getLogger(AlumnosVM.class);

    @WireVariable
    AlumnoService alumnoService;

    @Getter
    @Setter
    private String keyword;

    @Getter
    private List<Alumno> alumnoList = new ListModelList<>();

    @Getter
    @Setter
    private Alumno selectedAlumno;

    @Init
    public void init(){
        alumnoList.addAll(alumnoService.findAll());
    }

    @Command
    @NotifyChange("alumnoList")
    public void search() {
        LOGGER.info("||||| Searching |||||");
        alumnoList.clear();
        LOGGER.info("||||| Filtering |||||");
        alumnoList.addAll(alumnoService.search(keyword));
        LOGGER.info("||||| Filtered |||||");
    }
}
