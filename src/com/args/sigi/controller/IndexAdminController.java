package com.args.sigi.controller;


import java.sql.SQLException;
import java.util.List;

import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vlayout;

import com.args.sigi.dao.UserDao;
import com.args.sigi.exception.UserNotFoundException;
import com.args.sigi.generic.controller.GenericAbstractController;
import com.args.sigi.generic.controller.GenericDistributionController;
import com.args.sigi.object.User;

public class IndexAdminController extends GenericAbstractController implements GenericDistributionController {

    private static final long serialVersionUID = -9145887024839938515L;
    private Textbox txtLogin;
    private Textbox txtPassword;
    private Label lblInfo;
    private Row rowPassword;
    private Vlayout vltLogin;
    private Vlayout vltPasswordRecovery;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initialize();
    }

    @Override
    public void initialize() {
        super.initialize();
        txtLogin.setFocus(true);
    }

    public boolean validateEmpty() {
        boolean valid = false;
        if (txtLogin.getText().isEmpty()) {
            lblInfo.setValue(Labels.getLabel("error.field.cannotNull"));
            txtLogin.setFocus(true);
        } else if (txtPassword.getText().isEmpty()) {
            lblInfo.setValue(Labels.getLabel("error.field.cannotNull"));
            txtPassword.setFocus(true);
        } else {
            valid = true;
        }
        return valid;
    }

    public void onClick$btnLogin() throws InterruptedException {
    	if(validateEmpty()){
    		User user = new User();
    		try {
				user = UserDao.getUserByLoginPassword(txtLogin.getText(), txtPassword.getText());
				List<User> users = UserDao.listUser();
				Executions.sendRedirect("loggedAccountView.zul");
			} catch (UserNotFoundException e) {
				   lblInfo.setValue(Labels.getLabel("error.invalid.login"));
			} catch (WrongValueException e) {
				lblInfo.setValue(Labels.getLabel("error.general"));
				e.printStackTrace();
			} catch (SQLException e) {
				lblInfo.setValue(Labels.getLabel("error.general"));
				e.printStackTrace();
			} catch (Exception e) {
				lblInfo.setValue(Labels.getLabel("error.general"));
				e.printStackTrace();
			}
    	}
    }

    public void onOK$txtLogin() {
       
    }

    public void onOK$txtPassword() {
    
    }

    public void onClick$btnRecoverPassword() throws InterruptedException {
        //Executions.sendRedirect("userPasswordRecovery.zul");
        rowPassword.setVisible(false);
        vltLogin.setVisible(false);
        vltPasswordRecovery.setVisible(true);
    }

    public void onClick$btnBack() throws InterruptedException {
        rowPassword.setVisible(true);
        vltPasswordRecovery.setVisible(false);
        vltLogin.setVisible(true);

    }

    public void onClick$btnGeneratePassword() throws InterruptedException {

    }

    public Boolean validateEmpty2() {
        if (txtLogin.getText().isEmpty()) {
            lblInfo.setValue(Labels.getLabel("error.field.cannotNull"));
            txtLogin.setFocus(true);
        } else {
            return true;
        }
        return false;
    }


}