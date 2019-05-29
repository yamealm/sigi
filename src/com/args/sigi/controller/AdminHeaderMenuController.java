package com.args.sigi.controller;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.util.Locale;
import org.zkoss.util.Locales;
import org.zkoss.zul.Hlayout;
import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Menuitem;

import com.args.sigi.util.AccessControl;

public class AdminHeaderMenuController extends GenericForwardComposer {

    private static final long serialVersionUID = -9145887024839938515L;
    Hlayout hltImages;
    Menuitem mniLogout;
    Menuitem mniSpanish;
    Menuitem mniMyAccout;
    Menuitem mniEnglish;
    Menuitem mniGoToMobileSite;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initialize();
    }

    public void initialize() {
        try {
            if (Locales.getCurrent().getLanguage().equals("en")) {
                mniSpanish.setVisible(true);
                mniEnglish.setVisible(false);
            } else {
                mniSpanish.setVisible(false);
                mniEnglish.setVisible(true);
            }
            if (AccessControl.loadCurrentAccount() != null) {
                mniLogout.setVisible(true);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onClick$mniLogout() {
      //  AccessControl.logout();
        Executions.sendRedirect("./admin.zul");
    }

    public void onClick$mniMyAccout() {
       Executions.sendRedirect("myAccount.zul");
    }



    public void onClick$mniEnglish() {

        if (!Locales.getCurrent().getLanguage().equals("en")) {
            Locale _newLocal = new Locale("en", "US", "en");
            session.setAttribute(Attributes.PREFERRED_LOCALE, _newLocal);
            Executions.sendRedirect(null);
        }
    }

    public void onClick$mniSpanish() {
        mniSpanish.setVisible(false);
        mniEnglish.setVisible(true);
        if (!Locales.getCurrent().getLanguage().equals("es")) {
            Locale _newLocal = new Locale("es", "ES", "es");
            session.setAttribute(Attributes.PREFERRED_LOCALE, _newLocal);
            Executions.sendRedirect(null);
        }
    }

    public void onClick$mniEnglish1() {
        mniEnglish.setVisible(false);
        mniSpanish.setVisible(true);
        if (!Locales.getCurrent().getLanguage().equals("en")) {
            Locale _newLocal = new Locale("en", "US", "en");
            session.setAttribute(Attributes.PREFERRED_LOCALE, _newLocal);
            Executions.sendRedirect(null);
        }
    }

    public void onClick$mniSpanish1() {
        if (!Locales.getCurrent().getLanguage().equals("es")) {
            Locale _newLocal = new Locale("es", "ES", "es");
            session.setAttribute(Attributes.PREFERRED_LOCALE, _newLocal);
            Executions.sendRedirect(null);
        }
    }
}
