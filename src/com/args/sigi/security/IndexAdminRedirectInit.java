package com.args.sigi.security;
import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Initiator;

import com.args.sigi.util.WebConstants;

public class IndexAdminRedirectInit implements Initiator {

    public void doInit(Page page, Map map) throws Exception {
        if (Sessions.getCurrent().getAttribute(WebConstants.SESSION_USER) != null) {
            Executions.sendRedirect("loggedUserView.zul");
        }
    }

    public void doAfterCompose(Page page) throws Exception {
    }

    public boolean doCatch(Throwable thrwbl) throws Exception {
        return true;
    }

    public void doFinally() throws Exception {
    }
}