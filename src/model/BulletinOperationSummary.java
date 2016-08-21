/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author iftekher
 */
public class BulletinOperationSummary {
    private ObservableList<BulletinOperation> summaries;
    private BulletinOperation front;
    private BulletinOperation back;
    private BulletinOperation sleeve;
    private BulletinOperation flap;
    private BulletinOperation assemble;
    private BulletinOperation collar;
    private BulletinOperation cuff;
    private BulletinOperation button;
    private BulletinOperation total;

    public BulletinOperationSummary() {
    }

    public BulletinOperationSummary(List<BulletinOperation> details) {
        front = new BulletinOperation(0, "Front", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0, "");
        back = new BulletinOperation(1, "Back", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0, "");
        sleeve = new BulletinOperation(2, "Sleeve", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0, "");
        flap = new BulletinOperation(3, "Flap", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0, "");
        assemble = new BulletinOperation(4, "Assemble", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0, "");
        collar = new BulletinOperation(5, "Collar", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0, "");
        cuff = new BulletinOperation(6, "Cuff", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0, "");
        button = new BulletinOperation(7, "Button", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0, "");
        total = new BulletinOperation(8, "Total", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0, "");
        
        summaries = FXCollections.observableArrayList();
        summaries.add(front);
        summaries.add(back);
        summaries.add(sleeve);
        summaries.add(flap);
        summaries.add(assemble);
        summaries.add(collar);
        summaries.add(cuff);
        summaries.add(button);
        summaries.add(total);
        
        for(int i = 0; i < details.size(); i++){
            int componentCode = 0;
            BulletinOperation detail = details.get(i);
            if(detail.getComponent().equals("Front")){
                componentCode = 0;
            }
            else if(detail.getComponent().equals("Back")){
                componentCode = 1;
            }
            else if(detail.getComponent().equals("Sleeve")){
                componentCode = 2;
            }
            else if(detail.getComponent().equals("Flap")){
                componentCode = 3;
            }
            else if(detail.getComponent().equals("Assemble")){
                componentCode = 4;
            }
            else if(detail.getComponent().equals("Collar")){
                componentCode = 5;
            }
            else if(detail.getComponent().equals("Cuff")){
                componentCode = 6;
            }
            else if(detail.getComponent().equals("Button")){
                componentCode = 7;
            }
            summaries.get(componentCode).setSmv(summaries.get(componentCode).getSmv() + detail.getSmv());
            summaries.get(componentCode).setIndividualTarget(summaries.get(componentCode).getIndividualTarget() + detail.getIndividualTarget());
            summaries.get(componentCode).setHundredTarget(summaries.get(componentCode).getHundredTarget() + detail.getHundredTarget());
            summaries.get(componentCode).setRequiredManpower(summaries.get(componentCode).getRequiredManpower() + detail.getRequiredManpower());
            summaries.get(componentCode).setManpowerAllocation(summaries.get(componentCode).getManpowerAllocation() + detail.getManpowerAllocation());
            summaries.get(componentCode).setMachineQuantity(summaries.get(componentCode).getMachineQuantity() + detail.getMachineQuantity());
            summaries.get(componentCode).setOperator(summaries.get(componentCode).getOperator() + detail.getOperator());
            summaries.get(componentCode).setHelper(summaries.get(componentCode).getHelper() + detail.getHelper());
            summaries.get(componentCode).setIm(summaries.get(componentCode).getIm() + detail.getIm());
            summaries.get(componentCode).setAcTarget(summaries.get(componentCode).getAcTarget() + detail.getAcTarget());
            
            summaries.get(8).setSmv(summaries.get(8).getSmv() + detail.getSmv());
            summaries.get(8).setIndividualTarget(summaries.get(8).getIndividualTarget()+ detail.getIndividualTarget());
            summaries.get(8).setHundredTarget(summaries.get(8).getHundredTarget() + detail.getHundredTarget());
            summaries.get(8).setRequiredManpower(summaries.get(8).getRequiredManpower() + detail.getRequiredManpower());
            summaries.get(8).setManpowerAllocation(summaries.get(8).getManpowerAllocation() + detail.getManpowerAllocation());
            summaries.get(8).setMachineQuantity(summaries.get(8).getMachineQuantity() + detail.getMachineQuantity());
            summaries.get(8).setOperator(summaries.get(8).getOperator() + detail.getOperator());
            summaries.get(8).setHelper(summaries.get(8).getHelper() + detail.getHelper());
            summaries.get(8).setIm(summaries.get(8).getIm() + detail.getIm());
            summaries.get(8).setAcTarget(summaries.get(8).getAcTarget() + detail.getAcTarget());
        }
    }

    public ObservableList<BulletinOperation> getSummaries() {
        return summaries;
    }

    @Override
    public String toString() {
        return "BulletinOperationSummary{" + "summaries=" + summaries + '}';
    }
}
