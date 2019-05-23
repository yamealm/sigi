package com.args.sigi.complement;



import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import java.util.ArrayList;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Image;

public class FooterController extends GenericForwardComposer {

    private static final long serialVersionUID = -9145887024839938515L;
    private Hlayout hltImages;


    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        initialize();
    }

    public void initialize() {

        try {
            loadBanners();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadBanners() {
       
    }
}
