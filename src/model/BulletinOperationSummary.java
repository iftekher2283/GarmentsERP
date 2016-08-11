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
    private ObservableList<BulletinOperationDetails> summaries;
    private BulletinOperationDetails front;
    private BulletinOperationDetails back;
    private BulletinOperationDetails sleeve;
    private BulletinOperationDetails flap;
    private BulletinOperationDetails assemble;
    private BulletinOperationDetails collar;
    private BulletinOperationDetails cuff;
    private BulletinOperationDetails button;
    private BulletinOperationDetails total;

    public BulletinOperationSummary() {
    }

    public BulletinOperationSummary(List<BulletinOperationDetails> details) {
        front = new BulletinOperationDetails(0, "Front", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, "");
        back = new BulletinOperationDetails(1, "Back", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, "");
        sleeve = new BulletinOperationDetails(2, "Sleeve", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, "");
        flap = new BulletinOperationDetails(3, "Flap", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, "");
        assemble = new BulletinOperationDetails(4, "Assemble", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, "");
        collar = new BulletinOperationDetails(5, "Collar", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, "");
        cuff = new BulletinOperationDetails(6, "Cuff", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, "");
        button = new BulletinOperationDetails(7, "Button", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, "");
        total = new BulletinOperationDetails(8, "Total", "", "", "", 0, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, "");
        
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
            BulletinOperationDetails detail = details.get(i);
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
            summaries.get(componentCode).setIndTgt(summaries.get(componentCode).getIndTgt() + detail.getIndTgt());
            summaries.get(componentCode).setHundredTgt(summaries.get(componentCode).getHundredTgt() + detail.getHundredTgt());
            summaries.get(componentCode).setRequiredMp(summaries.get(componentCode).getRequiredMp() + detail.getRequiredMp());
            summaries.get(componentCode).setMpAllocation(summaries.get(componentCode).getMpAllocation() + detail.getMpAllocation());
            summaries.get(componentCode).setMachineQuantity(summaries.get(componentCode).getMachineQuantity() + detail.getMachineQuantity());
            summaries.get(componentCode).setOp(summaries.get(componentCode).getOp() + detail.getOp());
            summaries.get(componentCode).setHp(summaries.get(componentCode).getHp() + detail.getHp());
            summaries.get(componentCode).setIm(summaries.get(componentCode).getIm() + detail.getIm());
            summaries.get(componentCode).setAcTgt(summaries.get(componentCode).getAcTgt() + detail.getAcTgt());
            
            summaries.get(8).setSmv(summaries.get(8).getSmv() + detail.getSmv());
            summaries.get(8).setIndTgt(summaries.get(8).getIndTgt() + detail.getIndTgt());
            summaries.get(8).setHundredTgt(summaries.get(8).getHundredTgt() + detail.getHundredTgt());
            summaries.get(8).setRequiredMp(summaries.get(8).getRequiredMp() + detail.getRequiredMp());
            summaries.get(8).setMpAllocation(summaries.get(8).getMpAllocation() + detail.getMpAllocation());
            summaries.get(8).setMachineQuantity(summaries.get(8).getMachineQuantity() + detail.getMachineQuantity());
            summaries.get(8).setOp(summaries.get(8).getOp() + detail.getOp());
            summaries.get(8).setHp(summaries.get(8).getHp() + detail.getHp());
            summaries.get(8).setIm(summaries.get(8).getIm() + detail.getIm());
            summaries.get(8).setAcTgt(summaries.get(8).getAcTgt() + detail.getAcTgt());
        }
    }

    public ObservableList<BulletinOperationDetails> getSummaries() {
        return summaries;
    }

    @Override
    public String toString() {
        return "BulletinOperationSummary{" + "summaries=" + summaries + '}';
    }
}
