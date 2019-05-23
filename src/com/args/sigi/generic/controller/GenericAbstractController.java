package com.args.sigi.generic.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.util.resource.Labels;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Separator;

public class GenericAbstractController extends GenericForwardComposer implements GenericDistributionController {

    public Integer eventType = null;
    public boolean permissionEdit;
    public boolean permissionAdd;
    public boolean permissionRead;
    public Long languageId = 1L;
    public Div divInfo;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        eventType = (Executions.getCurrent().getArg().get("eventType") != null) ? (Integer) Executions.getCurrent().getArg().get("eventType") : -1;

        super.doAfterCompose(comp);
    }

    @Override
    public void initialize() {

    }

 

    public void showMessage(String message, boolean isError, Exception exception) {
        divInfo.getChildren().clear();
        divInfo.setVisible(true);
        Hlayout hlayout = new Hlayout();
        Separator separator = new Separator();
        separator.setOrient("horizontal");
        separator.setParent(hlayout);
        Image icon = new Image();
        //icon.setSrc(isError? "/images/icon-cancel.png" : "/images/icon-enable.png");
        icon.setParent(hlayout);
        separator = new Separator();
        separator.setOrient("horizontal");
        separator.setParent(hlayout);
        Label lblMessage = new Label();
        lblMessage.setStyle("font-size:16px; font-weight: bold;font-style: italic;color: #424242;");
        lblMessage.setValue(Labels.getLabel(message) == null || Labels.getLabel(message).isEmpty() ? message : Labels.getLabel(message));
        lblMessage.setParent(hlayout);
        separator = new Separator();
        separator.setParent(divInfo);
        hlayout.setParent(divInfo);

        divInfo.setStyle(isError ? "background:#F4AFAF;border-radius:5px;" : "background:#B6E59E;border-radius:5px;");
        divInfo.setHeight("25px");
        if (exception != null) {
            exception.printStackTrace();
        }
    }
    
    
   
    public void clearMessage(){
        divInfo.setVisible(false);
        divInfo.getChildren().clear();
    }
}
