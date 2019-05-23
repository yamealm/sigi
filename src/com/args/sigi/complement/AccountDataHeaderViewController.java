package com.args.sigi.complement;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DecimalFormat;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Menubar;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueue;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zk.ui.Sessions;


public class AccountDataHeaderViewController extends GenericForwardComposer {

    private static final long serialVersionUID = -9145887024839938515L;

    Label lblCurrentBalance;
    Label lblCurrentBalanceValue;
    Label lblAccountName;
    Label lblAccountType;
    //testing
    Label lblAlopointsBalancecategoryElectonicPin;
    Label lblAlopointsBalancecategoryElectonicPinValue;
    //Label lblAlopointsBalancecategoryToUp;
    //Label lblAlopointsBalancecategoryToUpValue;
    Label lblInfo;
    Menubar menuOptions;
    Button btnRSBuyBalance;
    String currencySymbol = "";

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initialize();
        loadSummaryData();
    }

    public void initialize() {
        try {
            startListener();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(AccountDataHeaderViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startListener() {
        EventQueue que = EventQueues.lookup("loadSummaryData", EventQueues.APPLICATION, true);
        que.subscribe(new EventListener() {

            public void onEvent(Event evt) {
                try {
                    loadSummaryData();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void loadSummaryData() {
       
    }
}
