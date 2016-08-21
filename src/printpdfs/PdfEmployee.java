/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printpdfs;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.SalaryDetails;
import textileerp.TextileERP;

/**
 *
 * @author iftekher
 */
public class PdfEmployee {
    private Employee employee;

    public PdfEmployee() {
    }

    public PdfEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Document getPdfDocumet(){
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("generatedPdfs/Employee.pdf"));
            document.open();
            document.addTitle("Employee's Details");
            document.addSubject("A document where information of an employee is written");
            document.addAuthor("@Atoms@");
            document.addCreator("@Atoms@");
            
            PdfPTable table1 = new PdfPTable(4);
            table1.setWidthPercentage(100); //Width 100%
            table1.setSpacingBefore(10f); //Space before table
            table1.setSpacingAfter(10f); //Space after table
            
            float[] columnWidthsTable1 = {1f, 1f, 1f, 1f};
            table1.setWidths(columnWidthsTable1);
            
            Paragraph heading = new Paragraph("Detail Information of Employee", FontFactory.getFont(FontFactory.HELVETICA, 22, Font.BOLD, new CMYKColor(255, 255, 50, 60)));
            PdfPCell cell1 = new PdfPCell(heading);
            cell1.setColspan(4);            
            cell1.setBorderColor(BaseColor.WHITE);
            cell1.setPaddingLeft(10);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Paragraph heading2 = new Paragraph("ID: " + employee.getId(), FontFactory.getFont(FontFactory.HELVETICA, 22, Font.BOLD, new CMYKColor(255, 255, 50, 60)));
            PdfPCell cell2 = new PdfPCell(heading2);
            cell2.setColspan(4);            
            cell2.setBorderColor(BaseColor.WHITE);
            cell2.setPaddingLeft(10);
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Paragraph space = new Paragraph("");
            PdfPCell cell3 = new PdfPCell(space);
            cell3.setColspan(4);            
            cell3.setBorderColor(BaseColor.WHITE);
            cell3.setPaddingLeft(10);
            cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell3.setFixedHeight(10);
            
            table1.addCell(cell1);
            table1.addCell(cell2);
            table1.addCell(cell3);
            document.add(table1);
            
            float[] columnWidthsTableName = {19f, 1f, 20f, 19f, 1f, 20f};
            PdfPTable tableName = new PdfPTable(columnWidthsTableName);
            tableName.setWidthPercentage(100); //Width 100%
            tableName.setSpacingBefore(10f); //Space before table
            tableName.setSpacingAfter(10f); //Space after table
            
            Paragraph spaceRow = new Paragraph("");
            Phrase colon = new Phrase(":", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            
            Paragraph subHeading1 = new Paragraph("Basic Information", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, new CMYKColor(225, 225, 20, 40)));
            PdfPCell r0cSubheading = new PdfPCell(subHeading1);
            r0cSubheading.setColspan(6);            
            r0cSubheading.setBorderColor(BaseColor.WHITE);
            r0cSubheading.setPaddingLeft(10);
            r0cSubheading.setHorizontalAlignment(Element.ALIGN_LEFT);
            r0cSubheading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r0Space = new PdfPCell(spaceRow);
            r0Space.setColspan(6);            
            r0Space.setBorderColor(BaseColor.WHITE);
            r0Space.setPaddingLeft(10);
            r0Space.setHorizontalAlignment(Element.ALIGN_LEFT);
            r0Space.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r0Space.setFixedHeight(10);
            
            Phrase nameLabel = new Phrase("Name", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r1c1 = new PdfPCell(nameLabel);          
            r1c1.setBorderColor(BaseColor.WHITE);
            r1c1.setPaddingLeft(10);
            r1c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r1c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r1c2 = new PdfPCell(colon);           
            r1c2.setBorderColor(BaseColor.WHITE);
            r1c2.setPaddingLeft(1);
            r1c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r1c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase nameValue = new Phrase(employee.getName());
            PdfPCell r1c3 = new PdfPCell(nameValue);  
            r1c3.setColspan(4);
            r1c3.setBorderColor(BaseColor.WHITE);
            r1c3.setPaddingLeft(1);
            r1c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r1c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
           /* 
            tableName.addCell(r1c1);
            tableName.addCell(r1c2);
            tableName.addCell(r1c3);
            document.add(tableName);
            
            PdfPTable tableDesignation = new PdfPTable(3);
            tableDesignation.setWidthPercentage(100); //Width 100%
            tableDesignation.setSpacingBefore(10f); //Space before table
            tableDesignation.setSpacingAfter(10f); //Space after table
            */
            Phrase designationLabel = new Phrase("Designation", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r2c1 = new PdfPCell(designationLabel);   
            r2c1.setBorderColor(BaseColor.WHITE);
            r2c1.setPaddingLeft(10);
            r2c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r2c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r2c2 = new PdfPCell(colon);           
            r2c1.setRight(2);
            r2c2.setBorderColor(BaseColor.WHITE);
            r2c2.setPaddingLeft(1);
            r2c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r2c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase designationValue = new Phrase(employee.getDesignation());
            PdfPCell r2c3 = new PdfPCell(designationValue);           
            r2c3.setBorderColor(BaseColor.WHITE);
            r2c3.setPaddingLeft(1);
            r2c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r2c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase companyLabel = new Phrase("Company No", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r2c4 = new PdfPCell(companyLabel);          
            r2c4.setBorderColor(BaseColor.WHITE);
            r2c4.setPaddingLeft(10);
            r2c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r2c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r2c5 = new PdfPCell(colon);           
            r2c5.setBorderColor(BaseColor.WHITE);
            r2c5.setPaddingLeft(1);
            r2c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r2c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase companyValue = new Phrase(employee.getCompanyNo() + "");
            PdfPCell r2c6 = new PdfPCell(companyValue);           
            r2c6.setBorderColor(BaseColor.WHITE);
            r2c6.setPaddingLeft(1);
            r2c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r2c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase departmentLabel = new Phrase("Department", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r3c1 = new PdfPCell(departmentLabel);          
            r3c1.setBorderColor(BaseColor.WHITE);
            r3c1.setPaddingLeft(10);
            r3c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r3c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r3c2 = new PdfPCell(colon);           
            r3c2.setBorderColor(BaseColor.WHITE);
            r3c2.setPaddingLeft(1);
            r3c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r3c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase deartmentValue = new Phrase(employee.getDepartmentCode());
            PdfPCell r3c3 = new PdfPCell(deartmentValue);           
            r3c3.setBorderColor(BaseColor.WHITE);
            r3c3.setPaddingLeft(1);
            r3c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r3c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase branchLabel = new Phrase("Branch", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r3c4 = new PdfPCell(branchLabel);          
            r3c4.setBorderColor(BaseColor.WHITE);
            r3c4.setPaddingLeft(10);
            r3c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r3c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r3c5 = new PdfPCell(colon);           
            r3c5.setBorderColor(BaseColor.WHITE);
            r3c5.setPaddingLeft(1);
            r3c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r3c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase branchValue = new Phrase(employee.getBranchId());
            PdfPCell r3c6 = new PdfPCell(branchValue);           
            r3c6.setBorderColor(BaseColor.WHITE);
            r3c6.setPaddingLeft(1);
            r3c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r3c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase confirmationLabel = new Phrase("Confirmation Date", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r4c1 = new PdfPCell(confirmationLabel);          
            r4c1.setBorderColor(BaseColor.WHITE);
            r4c1.setPaddingLeft(10);
            r4c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r4c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r4c2 = new PdfPCell(colon);           
            r4c2.setBorderColor(BaseColor.WHITE);
            r4c2.setPaddingLeft(1);
            r4c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r4c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase comfirmationValue = new Phrase(employee.getConfirmationDate());
            PdfPCell r4c3 = new PdfPCell(comfirmationValue);           
            r4c3.setBorderColor(BaseColor.WHITE);
            r4c3.setPaddingLeft(1);
            r4c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r4c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase joiningLabel = new Phrase("Joining Date", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r4c4 = new PdfPCell(joiningLabel);          
            r4c4.setBorderColor(BaseColor.WHITE);
            r4c4.setPaddingLeft(10);
            r4c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r4c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r4c5 = new PdfPCell(colon);           
            r4c5.setBorderColor(BaseColor.WHITE);
            r4c5.setPaddingLeft(1);
            r4c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r4c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase joiningValue = new Phrase(employee.getJoiningDate());
            PdfPCell r4c6 = new PdfPCell(joiningValue);           
            r4c6.setBorderColor(BaseColor.WHITE);
            r4c6.setPaddingLeft(1);
            r4c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r4c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Paragraph space2 = new Paragraph("");
            PdfPCell r5cSpace = new PdfPCell(space2);
            r5cSpace.setColspan(6);            
            r5cSpace.setBorderColor(BaseColor.WHITE);
            r5cSpace.setPaddingLeft(10);
            r5cSpace.setHorizontalAlignment(Element.ALIGN_LEFT);
            r5cSpace.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r5cSpace.setFixedHeight(20);
            
            Paragraph subHeading2 = new Paragraph("Salary Information", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, new CMYKColor(225, 225, 20, 40)));
            PdfPCell r6cSubheading = new PdfPCell(subHeading2);
            r6cSubheading.setColspan(6);            
            r6cSubheading.setBorderColor(BaseColor.WHITE);
            r6cSubheading.setPaddingLeft(10);
            r6cSubheading.setHorizontalAlignment(Element.ALIGN_LEFT);
            r6cSubheading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r6Space = new PdfPCell(spaceRow);
            r6Space.setColspan(6);            
            r6Space.setBorderColor(BaseColor.WHITE);
            r6Space.setPaddingLeft(10);
            r6Space.setHorizontalAlignment(Element.ALIGN_LEFT);
            r6Space.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r6Space.setFixedHeight(10);
            
            SalaryDetails salaryDetails = new SalaryDetails(employee.getId(), employee.getSalaryInfo().getBasic_salary(), employee.getJoiningDate(), employee.getSalaryInfo().getBank_code(), employee.getSalaryInfo().getAc_no());
            
            Phrase basicSalaryLabel = new Phrase("Basic Salary", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r7c1 = new PdfPCell(basicSalaryLabel);          
            r7c1.setBorderColor(BaseColor.WHITE);
            r7c1.setPaddingLeft(10);
            r7c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r7c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r7c2 = new PdfPCell(colon);           
            r7c2.setBorderColor(BaseColor.WHITE);
            r7c2.setPaddingLeft(1);
            r7c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r7c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase basicSalaryValue = new Phrase(salaryDetails.getBasicSalary() + "");
            PdfPCell r7c3 = new PdfPCell(basicSalaryValue);           
            r7c3.setBorderColor(BaseColor.WHITE);
            r7c3.setPaddingLeft(1);
            r7c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r7c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase runningBasicLabel = new Phrase("Running Basic", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r7c4 = new PdfPCell(runningBasicLabel);          
            r7c4.setBorderColor(BaseColor.WHITE);
            r7c4.setPaddingLeft(10);
            r7c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r7c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r7c5 = new PdfPCell(colon);           
            r7c5.setBorderColor(BaseColor.WHITE);
            r7c5.setPaddingLeft(1);
            r7c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r7c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase runningBasicValue = new Phrase(salaryDetails.getRunningBasic() + "");
            PdfPCell r7c6 = new PdfPCell(runningBasicValue);           
            r7c6.setBorderColor(BaseColor.WHITE);
            r7c6.setPaddingLeft(1);
            r7c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r7c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase houseRentLabel = new Phrase("House Rent", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r8c1 = new PdfPCell(houseRentLabel);          
            r8c1.setBorderColor(BaseColor.WHITE);
            r8c1.setPaddingLeft(10);
            r8c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r8c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r8c2 = new PdfPCell(colon);           
            r8c2.setBorderColor(BaseColor.WHITE);
            r8c2.setPaddingLeft(1);
            r8c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r8c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase houseRentValue = new Phrase(salaryDetails.getHouseRent() + "");
            PdfPCell r8c3 = new PdfPCell(houseRentValue);           
            r8c3.setBorderColor(BaseColor.WHITE);
            r8c3.setPaddingLeft(1);
            r8c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r8c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase medicalLabel = new Phrase("Medical", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r8c4 = new PdfPCell(medicalLabel);          
            r8c4.setBorderColor(BaseColor.WHITE);
            r8c4.setPaddingLeft(10);
            r8c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r8c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r8c5 = new PdfPCell(colon);           
            r8c5.setBorderColor(BaseColor.WHITE);
            r8c5.setPaddingLeft(1);
            r8c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r8c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase medicalValue = new Phrase(salaryDetails.getMedical() + "");
            PdfPCell r8c6 = new PdfPCell(medicalValue);           
            r8c6.setBorderColor(BaseColor.WHITE);
            r8c6.setPaddingLeft(1);
            r8c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r8c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase conveyanceLabel = new Phrase("Conveyance", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r9c1 = new PdfPCell(conveyanceLabel);          
            r9c1.setBorderColor(BaseColor.WHITE);
            r9c1.setPaddingLeft(10);
            r9c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r9c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r9c2 = new PdfPCell(colon);           
            r9c2.setBorderColor(BaseColor.WHITE);
            r9c2.setPaddingLeft(1);
            r9c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r9c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase conveyanceValue = new Phrase(salaryDetails.getConveyance() + "");
            PdfPCell r9c3 = new PdfPCell(conveyanceValue);           
            r9c3.setBorderColor(BaseColor.WHITE);
            r9c3.setPaddingLeft(1);
            r9c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r9c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase carAllowanceLabel = new Phrase("Car Allowance", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r9c4 = new PdfPCell(carAllowanceLabel);          
            r9c4.setBorderColor(BaseColor.WHITE);
            r9c4.setPaddingLeft(10);
            r9c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r9c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r9c5 = new PdfPCell(colon);           
            r9c5.setBorderColor(BaseColor.WHITE);
            r9c5.setPaddingLeft(1);
            r9c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r9c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase carAllowanceValue = new Phrase(salaryDetails.getCarAllow() + "");
            PdfPCell r9c6 = new PdfPCell(carAllowanceValue);           
            r9c6.setBorderColor(BaseColor.WHITE);
            r9c6.setPaddingLeft(1);
            r9c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r9c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase othersLabel = new Phrase("Others", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r10c1 = new PdfPCell(othersLabel);          
            r10c1.setBorderColor(BaseColor.WHITE);
            r10c1.setPaddingLeft(10);
            r10c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r10c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r10c2 = new PdfPCell(colon);           
            r10c2.setBorderColor(BaseColor.WHITE);
            r10c2.setPaddingLeft(1);
            r10c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r10c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase othersValue = new Phrase(salaryDetails.getOthers() + "");
            PdfPCell r10c3 = new PdfPCell(othersValue);           
            r10c3.setBorderColor(BaseColor.WHITE);
            r10c3.setPaddingLeft(1);
            r10c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r10c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase grossSalaryLabel = new Phrase("Gross Salary", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r10c4 = new PdfPCell(grossSalaryLabel);          
            r10c4.setBorderColor(BaseColor.WHITE);
            r10c4.setPaddingLeft(10);
            r10c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r10c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r10c5 = new PdfPCell(colon);           
            r10c5.setBorderColor(BaseColor.WHITE);
            r10c5.setPaddingLeft(1);
            r10c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r10c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase grossSalryValue = new Phrase(salaryDetails.getGrossSalary() + "");
            PdfPCell r10c6 = new PdfPCell(grossSalryValue);           
            r10c6.setBorderColor(BaseColor.WHITE);
            r10c6.setPaddingLeft(1);
            r10c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r10c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase bankCodeLabel = new Phrase("Bank Code", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r11c1 = new PdfPCell(bankCodeLabel);          
            r11c1.setBorderColor(BaseColor.WHITE);
            r11c1.setPaddingLeft(10);
            r11c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r11c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r11c2 = new PdfPCell(colon);           
            r11c2.setBorderColor(BaseColor.WHITE);
            r11c2.setPaddingLeft(1);
            r11c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r11c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase bankCodeValue = new Phrase(salaryDetails.getBankCode());
            PdfPCell r11c3 = new PdfPCell(bankCodeValue);           
            r11c3.setBorderColor(BaseColor.WHITE);
            r11c3.setPaddingLeft(1);
            r11c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r11c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase acNoLabel = new Phrase("Account No.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r11c4 = new PdfPCell(acNoLabel);          
            r11c4.setBorderColor(BaseColor.WHITE);
            r11c4.setPaddingLeft(10);
            r11c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r11c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r11c5 = new PdfPCell(colon);           
            r11c5.setBorderColor(BaseColor.WHITE);
            r11c5.setPaddingLeft(1);
            r11c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r11c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase acNoValue = new Phrase(salaryDetails.getAcNo() + "");
            PdfPCell r11c6 = new PdfPCell(acNoValue);           
            r11c6.setBorderColor(BaseColor.WHITE);
            r11c6.setPaddingLeft(1);
            r11c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r11c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Paragraph space3 = new Paragraph("");
            PdfPCell r12cSpace = new PdfPCell(space3);
            r12cSpace.setColspan(6);            
            r12cSpace.setBorderColor(BaseColor.WHITE);
            r12cSpace.setPaddingLeft(10);
            r12cSpace.setHorizontalAlignment(Element.ALIGN_LEFT);
            r12cSpace.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r12cSpace.setFixedHeight(20);
            
            Paragraph subHeading3 = new Paragraph("Personal Information", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD, new CMYKColor(225, 225, 20, 40)));
            PdfPCell r13cSubheading = new PdfPCell(subHeading3);
            r13cSubheading.setColspan(6);            
            r13cSubheading.setBorderColor(BaseColor.WHITE);
            r13cSubheading.setPaddingLeft(10);
            r13cSubheading.setHorizontalAlignment(Element.ALIGN_LEFT);
            r13cSubheading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r13Space = new PdfPCell(spaceRow);
            r13Space.setColspan(6);            
            r13Space.setBorderColor(BaseColor.WHITE);
            r13Space.setPaddingLeft(10);
            r13Space.setHorizontalAlignment(Element.ALIGN_LEFT);
            r13Space.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r13Space.setFixedHeight(10);
            
            Phrase fatherLabel = new Phrase("Father's Name", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r14c1 = new PdfPCell(fatherLabel);          
            r14c1.setBorderColor(BaseColor.WHITE);
            r14c1.setPaddingLeft(10);
            r14c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r14c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r14c2 = new PdfPCell(colon);           
            r14c2.setBorderColor(BaseColor.WHITE);
            r14c2.setPaddingLeft(1);
            r14c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r14c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase fatherValue = new Phrase(employee.getPersonalInfo().getFathersName());
            PdfPCell r14c3 = new PdfPCell(fatherValue);           
            r14c3.setBorderColor(BaseColor.WHITE);
            r14c3.setPaddingLeft(1);
            r14c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r14c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase motherLabel = new Phrase("Mother's Name", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r14c4 = new PdfPCell(motherLabel);          
            r14c4.setBorderColor(BaseColor.WHITE);
            r14c4.setPaddingLeft(10);
            r14c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r14c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r14c5 = new PdfPCell(colon);           
            r14c5.setBorderColor(BaseColor.WHITE);
            r14c5.setPaddingLeft(1);
            r14c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r14c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase motherValue = new Phrase(employee.getPersonalInfo().getMothersName());
            PdfPCell r14c6 = new PdfPCell(motherValue);           
            r14c6.setBorderColor(BaseColor.WHITE);
            r14c6.setPaddingLeft(1);
            r14c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r14c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase dobLabel = new Phrase("Date of Birth", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r15c1 = new PdfPCell(dobLabel);          
            r15c1.setBorderColor(BaseColor.WHITE);
            r15c1.setPaddingLeft(10);
            r15c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r15c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r15c2 = new PdfPCell(colon);           
            r15c2.setBorderColor(BaseColor.WHITE);
            r15c2.setPaddingLeft(1);
            r15c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r15c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase dobValue = new Phrase(employee.getPersonalInfo().getDateOfBirth());
            PdfPCell r15c3 = new PdfPCell(dobValue);           
            r15c3.setBorderColor(BaseColor.WHITE);
            r15c3.setPaddingLeft(1);
            r15c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r15c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase genderLabel = new Phrase("Gender", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r15c4 = new PdfPCell(genderLabel);          
            r15c4.setBorderColor(BaseColor.WHITE);
            r15c4.setPaddingLeft(10);
            r15c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r15c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r15c5 = new PdfPCell(colon);           
            r15c5.setBorderColor(BaseColor.WHITE);
            r15c5.setPaddingLeft(1);
            r15c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r15c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase genderValue = new Phrase(employee.getSex());
            PdfPCell r15c6 = new PdfPCell(genderValue);           
            r15c6.setBorderColor(BaseColor.WHITE);
            r15c6.setPaddingLeft(1);
            r15c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r15c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase religionLabel = new Phrase("Religion", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r16c1 = new PdfPCell(religionLabel);          
            r16c1.setBorderColor(BaseColor.WHITE);
            r16c1.setPaddingLeft(10);
            r16c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r16c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r16c2 = new PdfPCell(colon);           
            r16c2.setBorderColor(BaseColor.WHITE);
            r16c2.setPaddingLeft(1);
            r16c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r16c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase religionValue = new Phrase(employee.getPersonalInfo().getReligion());
            PdfPCell r16c3 = new PdfPCell(religionValue);           
            r16c3.setBorderColor(BaseColor.WHITE);
            r16c3.setPaddingLeft(1);
            r16c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r16c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase nationalityLabel = new Phrase("Nationality", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r16c4 = new PdfPCell(nationalityLabel);          
            r16c4.setBorderColor(BaseColor.WHITE);
            r16c4.setPaddingLeft(10);
            r16c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r16c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r16c5 = new PdfPCell(colon);           
            r16c5.setBorderColor(BaseColor.WHITE);
            r16c5.setPaddingLeft(1);
            r16c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r16c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase nationalityValue = new Phrase(employee.getPersonalInfo().getNationality());
            PdfPCell r16c6 = new PdfPCell(nationalityValue);           
            r16c6.setBorderColor(BaseColor.WHITE);
            r16c6.setPaddingLeft(1);
            r16c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r16c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase maritalStatusLabel = new Phrase("Marital Status", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r17c1 = new PdfPCell(maritalStatusLabel);          
            r17c1.setBorderColor(BaseColor.WHITE);
            r17c1.setPaddingLeft(10);
            r17c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r17c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r17c2 = new PdfPCell(colon);           
            r17c2.setBorderColor(BaseColor.WHITE);
            r17c2.setPaddingLeft(1);
            r17c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r17c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase maritalStatusValue = new Phrase(employee.getPersonalInfo().getMaritalStatus());
            PdfPCell r17c3 = new PdfPCell(maritalStatusValue);           
            r17c3.setBorderColor(BaseColor.WHITE);
            r17c3.setPaddingLeft(1);
            r17c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r17c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase bloodGroupLabel = new Phrase("Blood Group", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r17c4 = new PdfPCell(bloodGroupLabel);          
            r17c4.setBorderColor(BaseColor.WHITE);
            r17c4.setPaddingLeft(10);
            r17c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r17c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r17c5 = new PdfPCell(colon);           
            r17c5.setBorderColor(BaseColor.WHITE);
            r17c5.setPaddingLeft(1);
            r17c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r17c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase bloodGroupValue = new Phrase(employee.getPersonalInfo().getBloodGroup());
            PdfPCell r17c6 = new PdfPCell(bloodGroupValue);           
            r17c6.setBorderColor(BaseColor.WHITE);
            r17c6.setPaddingLeft(1);
            r17c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r17c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase mobileLabel = new Phrase("Mobile", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r18c1 = new PdfPCell(mobileLabel);          
            r18c1.setBorderColor(BaseColor.WHITE);
            r18c1.setPaddingLeft(10);
            r18c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r18c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r18c2 = new PdfPCell(colon);           
            r18c2.setBorderColor(BaseColor.WHITE);
            r18c2.setPaddingLeft(1);
            r18c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r18c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase mobileValue = new Phrase(employee.getPersonalInfo().getMobileNo());
            PdfPCell r18c3 = new PdfPCell(mobileValue);           
            r18c3.setBorderColor(BaseColor.WHITE);
            r18c3.setPaddingLeft(1);
            r18c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r18c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase emailLabel = new Phrase("E-mail", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r18c4 = new PdfPCell(emailLabel);          
            r18c4.setBorderColor(BaseColor.WHITE);
            r18c4.setPaddingLeft(10);
            r18c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r18c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r18c5 = new PdfPCell(colon);           
            r18c5.setBorderColor(BaseColor.WHITE);
            r18c5.setPaddingLeft(1);
            r18c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r18c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase emailValue = new Phrase(employee.getPersonalInfo().getEmail());
            PdfPCell r18c6 = new PdfPCell(emailValue);           
            r18c6.setBorderColor(BaseColor.WHITE);
            r18c6.setPaddingLeft(1);
            r18c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r18c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase emerContLabel = new Phrase("Emergency Cont.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r19c1 = new PdfPCell(emerContLabel);          
            r19c1.setBorderColor(BaseColor.WHITE);
            r19c1.setPaddingLeft(10);
            r19c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r19c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r19c2 = new PdfPCell(colon);           
            r19c2.setBorderColor(BaseColor.WHITE);
            r19c2.setPaddingLeft(1);
            r19c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r19c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase emerContValue = new Phrase(employee.getPersonalInfo().getEmerContNo());
            PdfPCell r19c3 = new PdfPCell(emerContValue);           
            r19c3.setBorderColor(BaseColor.WHITE);
            r19c3.setPaddingLeft(1);
            r19c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r19c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase nidLabel = new Phrase("NID No.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r19c4 = new PdfPCell(nidLabel);          
            r19c4.setBorderColor(BaseColor.WHITE);
            r19c4.setPaddingLeft(10);
            r19c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r19c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r19c5 = new PdfPCell(colon);           
            r19c5.setBorderColor(BaseColor.WHITE);
            r19c5.setPaddingLeft(1);
            r19c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r19c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase nidValue = new Phrase(employee.getPersonalInfo().getNidNo());
            PdfPCell r19c6 = new PdfPCell(nidValue);           
            r19c6.setBorderColor(BaseColor.WHITE);
            r19c6.setPaddingLeft(1);
            r19c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r19c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase passportLabel = new Phrase("Passport No", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r20c1 = new PdfPCell(passportLabel);          
            r20c1.setBorderColor(BaseColor.WHITE);
            r20c1.setPaddingLeft(10);
            r20c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r20c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r20c2 = new PdfPCell(colon);           
            r20c2.setBorderColor(BaseColor.WHITE);
            r20c2.setPaddingLeft(1);
            r20c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r20c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase passportValue = new Phrase(employee.getPersonalInfo().getPassportNo());
            PdfPCell r20c3 = new PdfPCell(passportValue);           
            r20c3.setBorderColor(BaseColor.WHITE);
            r20c3.setPaddingLeft(1);
            r20c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r20c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase tinLabel = new Phrase("TIN No.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r20c4 = new PdfPCell(tinLabel);          
            r20c4.setBorderColor(BaseColor.WHITE);
            r20c4.setPaddingLeft(10);
            r20c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r20c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r20c5 = new PdfPCell(colon);           
            r20c5.setBorderColor(BaseColor.WHITE);
            r20c5.setPaddingLeft(1);
            r20c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r20c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase tinValue = new Phrase(employee.getPersonalInfo().getTinNo());
            PdfPCell r20c6 = new PdfPCell(tinValue);           
            r20c6.setBorderColor(BaseColor.WHITE);
            r20c6.setPaddingLeft(1);
            r20c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r20c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase eduQualiLabel = new Phrase("Edu. Qualification", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r21c1 = new PdfPCell(eduQualiLabel);          
            r21c1.setBorderColor(BaseColor.WHITE);
            r21c1.setPaddingLeft(10);
            r21c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r21c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r21c2 = new PdfPCell(colon);           
            r21c2.setBorderColor(BaseColor.WHITE);
            r21c2.setPaddingLeft(1);
            r21c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r21c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase eduQualiValue = new Phrase(employee.getPersonalInfo().getEduQuali());
            PdfPCell r21c3 = new PdfPCell(eduQualiValue);           
            r21c3.setBorderColor(BaseColor.WHITE);
            r21c3.setPaddingLeft(1);
            r21c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r21c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase techQualiLabel = new Phrase("Tech. Quali.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r21c4 = new PdfPCell(techQualiLabel);          
            r21c4.setBorderColor(BaseColor.WHITE);
            r21c4.setPaddingLeft(10);
            r21c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r21c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r21c5 = new PdfPCell(colon);           
            r21c5.setBorderColor(BaseColor.WHITE);
            r21c5.setPaddingLeft(1);
            r21c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r21c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase techQualiValue = new Phrase(employee.getPersonalInfo().getTechQuali());
            PdfPCell r21c6 = new PdfPCell(techQualiValue);           
            r21c6.setBorderColor(BaseColor.WHITE);
            r21c6.setPaddingLeft(1);
            r21c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r21c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r21Space = new PdfPCell(spaceRow);
            r21Space.setColspan(6);            
            r21Space.setBorderColor(BaseColor.WHITE);
            r21Space.setPaddingLeft(10);
            r21Space.setHorizontalAlignment(Element.ALIGN_LEFT);
            r21Space.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r21Space.setFixedHeight(10);
            
            Paragraph subHeading3a = new Paragraph("Permanent Address", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(225, 225, 20, 40)));
            PdfPCell r22cSubheading = new PdfPCell(subHeading3a);
            r22cSubheading.setColspan(6);            
            r22cSubheading.setBorderColor(BaseColor.WHITE);
            r22cSubheading.setPaddingLeft(10);
            r22cSubheading.setHorizontalAlignment(Element.ALIGN_LEFT);
            r22cSubheading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r22Space = new PdfPCell(spaceRow);
            r22Space.setColspan(6);            
            r22Space.setBorderColor(BaseColor.WHITE);
            r22Space.setPaddingLeft(10);
            r22Space.setHorizontalAlignment(Element.ALIGN_LEFT);
            r22Space.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r22Space.setFixedHeight(5);
            
            Phrase permHouseLabel = new Phrase("House No.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r23c1 = new PdfPCell(permHouseLabel);          
            r23c1.setBorderColor(BaseColor.WHITE);
            r23c1.setPaddingLeft(10);
            r23c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r23c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r23c2 = new PdfPCell(colon);           
            r23c2.setBorderColor(BaseColor.WHITE);
            r23c2.setPaddingLeft(1);
            r23c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r23c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permHouseValue = new Phrase(employee.getAddress().getPermHouseNo());
            PdfPCell r23c3 = new PdfPCell(permHouseValue);           
            r23c3.setBorderColor(BaseColor.WHITE);
            r23c3.setPaddingLeft(1);
            r23c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r23c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permRoadLabel = new Phrase("Road No.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r23c4 = new PdfPCell(permRoadLabel);          
            r23c4.setBorderColor(BaseColor.WHITE);
            r23c4.setPaddingLeft(10);
            r23c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r23c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r23c5 = new PdfPCell(colon);           
            r23c5.setBorderColor(BaseColor.WHITE);
            r23c5.setPaddingLeft(1);
            r23c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r23c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permRoadValue = new Phrase(employee.getAddress().getPermRoadNo());
            PdfPCell r23c6 = new PdfPCell(permRoadValue);           
            r23c6.setBorderColor(BaseColor.WHITE);
            r23c6.setPaddingLeft(1);
            r23c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r23c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permVillLabel = new Phrase("Village", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r24c1 = new PdfPCell(permVillLabel);          
            r24c1.setBorderColor(BaseColor.WHITE);
            r24c1.setPaddingLeft(10);
            r24c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r24c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r24c2 = new PdfPCell(colon);           
            r24c2.setBorderColor(BaseColor.WHITE);
            r24c2.setPaddingLeft(1);
            r24c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r24c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permVillValue = new Phrase(employee.getAddress().getPermVillage());
            PdfPCell r24c3 = new PdfPCell(permVillValue);           
            r24c3.setBorderColor(BaseColor.WHITE);
            r24c3.setPaddingLeft(1);
            r24c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r24c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permPOLabel = new Phrase("Post Office", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r24c4 = new PdfPCell(permPOLabel);          
            r24c4.setBorderColor(BaseColor.WHITE);
            r24c4.setPaddingLeft(10);
            r24c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r24c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r24c5 = new PdfPCell(colon);           
            r24c5.setBorderColor(BaseColor.WHITE);
            r24c5.setPaddingLeft(1);
            r24c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r24c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permPOValue = new Phrase(employee.getAddress().getPermPO());
            PdfPCell r24c6 = new PdfPCell(permPOValue);           
            r24c6.setBorderColor(BaseColor.WHITE);
            r24c6.setPaddingLeft(1);
            r24c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r24c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permPSLabel = new Phrase("Police Station", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r25c1 = new PdfPCell(permPSLabel);          
            r25c1.setBorderColor(BaseColor.WHITE);
            r25c1.setPaddingLeft(10);
            r25c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r25c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r25c2 = new PdfPCell(colon);           
            r25c2.setBorderColor(BaseColor.WHITE);
            r25c2.setPaddingLeft(1);
            r25c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r25c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permPSValue = new Phrase(employee.getAddress().getPermPS());
            PdfPCell r25c3 = new PdfPCell(permPSValue);           
            r25c3.setBorderColor(BaseColor.WHITE);
            r25c3.setPaddingLeft(1);
            r25c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r25c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permDistLabel = new Phrase("District", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r25c4 = new PdfPCell(permDistLabel);          
            r25c4.setBorderColor(BaseColor.WHITE);
            r25c4.setPaddingLeft(10);
            r25c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r25c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r25c5 = new PdfPCell(colon);           
            r25c5.setBorderColor(BaseColor.WHITE);
            r25c5.setPaddingLeft(1);
            r25c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r25c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permDistValue = new Phrase(employee.getAddress().getPermDist());
            PdfPCell r25c6 = new PdfPCell(permDistValue);           
            r25c6.setBorderColor(BaseColor.WHITE);
            r25c6.setPaddingLeft(1);
            r25c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r25c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permPhnLabel = new Phrase("Phone No.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r26c1 = new PdfPCell(permPhnLabel);          
            r26c1.setBorderColor(BaseColor.WHITE);
            r26c1.setPaddingLeft(10);
            r26c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r26c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r26c2 = new PdfPCell(colon);           
            r26c2.setBorderColor(BaseColor.WHITE);
            r26c2.setPaddingLeft(1);
            r26c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r26c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase permPhnValue = new Phrase(employee.getAddress().getPermPhn());
            PdfPCell r26c3 = new PdfPCell(permPhnValue); 
            r26c3.setColspan(4); 
            r26c3.setBorderColor(BaseColor.WHITE);
            r26c3.setPaddingLeft(1);
            r26c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r26c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r26Space = new PdfPCell(spaceRow);
            r26Space.setColspan(6);            
            r26Space.setBorderColor(BaseColor.WHITE);
            r26Space.setPaddingLeft(10);
            r26Space.setHorizontalAlignment(Element.ALIGN_LEFT);
            r26Space.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r26Space.setFixedHeight(10);
            
            Paragraph subHeading3b = new Paragraph("Present Address", FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new CMYKColor(225, 225, 20, 40)));
            PdfPCell r27cSubheading = new PdfPCell(subHeading3b);
            r27cSubheading.setColspan(6);            
            r27cSubheading.setBorderColor(BaseColor.WHITE);
            r27cSubheading.setPaddingLeft(10);
            r27cSubheading.setHorizontalAlignment(Element.ALIGN_LEFT);
            r27cSubheading.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r27Space = new PdfPCell(spaceRow);
            r27Space.setColspan(6);            
            r27Space.setBorderColor(BaseColor.WHITE);
            r27Space.setPaddingLeft(10);
            r27Space.setHorizontalAlignment(Element.ALIGN_LEFT);
            r27Space.setVerticalAlignment(Element.ALIGN_MIDDLE);
            r27Space.setFixedHeight(5);
            
            Phrase presHouseLabel = new Phrase("House No.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r28c1 = new PdfPCell(presHouseLabel);          
            r28c1.setBorderColor(BaseColor.WHITE);
            r28c1.setPaddingLeft(10);
            r28c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r28c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r28c2 = new PdfPCell(colon);           
            r28c2.setBorderColor(BaseColor.WHITE);
            r28c2.setPaddingLeft(1);
            r28c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r28c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presHouseValue = new Phrase(employee.getAddress().getPresHouseNo());
            PdfPCell r28c3 = new PdfPCell(presHouseValue);           
            r28c3.setBorderColor(BaseColor.WHITE);
            r28c3.setPaddingLeft(1);
            r28c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r28c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presRoadLabel = new Phrase("Road No.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r28c4 = new PdfPCell(presRoadLabel);          
            r28c4.setBorderColor(BaseColor.WHITE);
            r28c4.setPaddingLeft(10);
            r28c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r28c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r28c5 = new PdfPCell(colon);           
            r28c5.setBorderColor(BaseColor.WHITE);
            r28c5.setPaddingLeft(1);
            r28c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r28c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presRoadValue = new Phrase(employee.getAddress().getPresRoadNo());
            PdfPCell r28c6 = new PdfPCell(presRoadValue);           
            r28c6.setBorderColor(BaseColor.WHITE);
            r28c6.setPaddingLeft(1);
            r28c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r28c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presVillLabel = new Phrase("Village", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r29c1 = new PdfPCell(presVillLabel);          
            r29c1.setBorderColor(BaseColor.WHITE);
            r29c1.setPaddingLeft(10);
            r29c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r29c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r29c2 = new PdfPCell(colon);           
            r29c2.setBorderColor(BaseColor.WHITE);
            r29c2.setPaddingLeft(1);
            r29c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r29c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presVillValue = new Phrase(employee.getAddress().getPresVillage());
            PdfPCell r29c3 = new PdfPCell(presVillValue);           
            r29c3.setBorderColor(BaseColor.WHITE);
            r29c3.setPaddingLeft(1);
            r29c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r29c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presPOLabel = new Phrase("Post Office", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r29c4 = new PdfPCell(presPOLabel);          
            r29c4.setBorderColor(BaseColor.WHITE);
            r29c4.setPaddingLeft(10);
            r29c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r29c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r29c5 = new PdfPCell(colon);           
            r29c5.setBorderColor(BaseColor.WHITE);
            r29c5.setPaddingLeft(1);
            r29c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r29c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presPOValue = new Phrase(employee.getAddress().getPresPO());
            PdfPCell r29c6 = new PdfPCell(presPOValue);           
            r29c6.setBorderColor(BaseColor.WHITE);
            r29c6.setPaddingLeft(1);
            r29c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r29c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presPSLabel = new Phrase("Police Station", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r30c1 = new PdfPCell(presPSLabel);          
            r30c1.setBorderColor(BaseColor.WHITE);
            r30c1.setPaddingLeft(10);
            r30c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r30c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r30c2 = new PdfPCell(colon);           
            r30c2.setBorderColor(BaseColor.WHITE);
            r30c2.setPaddingLeft(1);
            r30c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r30c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presPSValue = new Phrase(employee.getAddress().getPresPS());
            PdfPCell r30c3 = new PdfPCell(presPSValue);           
            r30c3.setBorderColor(BaseColor.WHITE);
            r30c3.setPaddingLeft(1);
            r30c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r30c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presDistLabel = new Phrase("District", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r30c4 = new PdfPCell(presDistLabel);          
            r30c4.setBorderColor(BaseColor.WHITE);
            r30c4.setPaddingLeft(10);
            r30c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            r30c4.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r30c5 = new PdfPCell(colon);           
            r30c5.setBorderColor(BaseColor.WHITE);
            r30c5.setPaddingLeft(1);
            r30c5.setHorizontalAlignment(Element.ALIGN_LEFT);
            r30c5.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presDistValue = new Phrase(employee.getAddress().getPresDist());
            PdfPCell r30c6 = new PdfPCell(presDistValue);           
            r30c6.setBorderColor(BaseColor.WHITE);
            r30c6.setPaddingLeft(1);
            r30c6.setHorizontalAlignment(Element.ALIGN_LEFT);
            r30c6.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presPhnLabel = new Phrase("Phone No.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new CMYKColor(200, 200, 0, 20)));
            PdfPCell r31c1 = new PdfPCell(presPhnLabel);          
            r31c1.setBorderColor(BaseColor.WHITE);
            r31c1.setPaddingLeft(10);
            r31c1.setHorizontalAlignment(Element.ALIGN_LEFT);
            r31c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            PdfPCell r31c2 = new PdfPCell(colon);           
            r31c2.setBorderColor(BaseColor.WHITE);
            r31c2.setPaddingLeft(1);
            r31c2.setHorizontalAlignment(Element.ALIGN_LEFT);
            r31c2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            Phrase presPhnValue = new Phrase(employee.getAddress().getPresPhn());
            PdfPCell r31c3 = new PdfPCell(presPhnValue); 
            r31c3.setColspan(4); 
            r31c3.setBorderColor(BaseColor.WHITE);
            r31c3.setPaddingLeft(1);
            r31c3.setHorizontalAlignment(Element.ALIGN_LEFT);
            r31c3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
            tableName.addCell(r0cSubheading);
            tableName.addCell(r0Space);
            tableName.addCell(r1c1);
            tableName.addCell(r1c2);
            tableName.addCell(r1c3);
            tableName.addCell(r2c1);
            tableName.addCell(r2c2);
            tableName.addCell(r2c3);
            tableName.addCell(r2c4);
            tableName.addCell(r2c5);
            tableName.addCell(r2c6);
            tableName.addCell(r3c1);
            tableName.addCell(r3c2);
            tableName.addCell(r3c3);
            tableName.addCell(r3c4);
            tableName.addCell(r3c5);
            tableName.addCell(r3c6);
            tableName.addCell(r4c1);
            tableName.addCell(r4c2);
            tableName.addCell(r4c3);
            tableName.addCell(r4c4);
            tableName.addCell(r4c5);
            tableName.addCell(r4c6);
            tableName.addCell(r5cSpace);
            tableName.addCell(r6cSubheading);
            tableName.addCell(r6Space);
            tableName.addCell(r7c1);
            tableName.addCell(r7c2);
            tableName.addCell(r7c3);
            tableName.addCell(r7c4);
            tableName.addCell(r7c5);
            tableName.addCell(r7c6);
            tableName.addCell(r8c1);
            tableName.addCell(r8c2);
            tableName.addCell(r8c3);
            tableName.addCell(r8c4);
            tableName.addCell(r8c5);
            tableName.addCell(r8c6);
            tableName.addCell(r9c1);
            tableName.addCell(r9c2);
            tableName.addCell(r9c3);
            tableName.addCell(r9c4);
            tableName.addCell(r9c5);
            tableName.addCell(r9c6);
            tableName.addCell(r10c1);
            tableName.addCell(r10c2);
            tableName.addCell(r10c3);
            tableName.addCell(r10c4);
            tableName.addCell(r10c5);
            tableName.addCell(r10c6);
            tableName.addCell(r11c1);
            tableName.addCell(r11c2);
            tableName.addCell(r11c3);
            tableName.addCell(r11c4);
            tableName.addCell(r11c5);
            tableName.addCell(r11c6);
            tableName.addCell(r12cSpace);
            tableName.addCell(r13cSubheading);
            tableName.addCell(r13Space);
            tableName.addCell(r14c1);
            tableName.addCell(r14c2);
            tableName.addCell(r14c3);
            tableName.addCell(r14c4);
            tableName.addCell(r14c5);
            tableName.addCell(r14c6);
            tableName.addCell(r15c1);
            tableName.addCell(r15c2);
            tableName.addCell(r15c3);
            tableName.addCell(r15c4);
            tableName.addCell(r15c5);
            tableName.addCell(r15c6);
            tableName.addCell(r16c1);
            tableName.addCell(r16c2);
            tableName.addCell(r16c3);
            tableName.addCell(r16c4);
            tableName.addCell(r16c5);
            tableName.addCell(r16c6);
            tableName.addCell(r17c1);
            tableName.addCell(r17c2);
            tableName.addCell(r17c3);
            tableName.addCell(r17c4);
            tableName.addCell(r17c5);
            tableName.addCell(r17c6);
            tableName.addCell(r18c1);
            tableName.addCell(r18c2);
            tableName.addCell(r18c3);
            tableName.addCell(r18c4);
            tableName.addCell(r18c5);
            tableName.addCell(r18c6);
            tableName.addCell(r19c1);
            tableName.addCell(r19c2);
            tableName.addCell(r19c3);
            tableName.addCell(r19c4);
            tableName.addCell(r19c5);
            tableName.addCell(r19c6);
            tableName.addCell(r20c1);
            tableName.addCell(r20c2);
            tableName.addCell(r20c3);
            tableName.addCell(r20c4);
            tableName.addCell(r20c5);
            tableName.addCell(r20c6);
            tableName.addCell(r21c1);
            tableName.addCell(r21c2);
            tableName.addCell(r21c3);
            tableName.addCell(r21c4);
            tableName.addCell(r21c5);
            tableName.addCell(r21c6);
            tableName.addCell(r21Space);
            tableName.addCell(r22cSubheading);
            tableName.addCell(r22Space);
            tableName.addCell(r23c1);
            tableName.addCell(r23c2);
            tableName.addCell(r23c3);
            tableName.addCell(r23c4);
            tableName.addCell(r23c5);
            tableName.addCell(r23c6);
            tableName.addCell(r24c1);
            tableName.addCell(r24c2);
            tableName.addCell(r24c3);
            tableName.addCell(r24c4);
            tableName.addCell(r24c5);
            tableName.addCell(r24c6);
            tableName.addCell(r25c1);
            tableName.addCell(r25c2);
            tableName.addCell(r25c3);
            tableName.addCell(r25c4);
            tableName.addCell(r25c5);
            tableName.addCell(r25c6);
            tableName.addCell(r26c1);
            tableName.addCell(r26c2);
            tableName.addCell(r26c3);
            tableName.addCell(r26Space);
            tableName.addCell(r27cSubheading);
            tableName.addCell(r27Space);
            tableName.addCell(r28c1);
            tableName.addCell(r28c2);
            tableName.addCell(r28c3);
            tableName.addCell(r28c4);
            tableName.addCell(r28c5);
            tableName.addCell(r28c6);
            tableName.addCell(r29c1);
            tableName.addCell(r29c2);
            tableName.addCell(r29c3);
            tableName.addCell(r29c4);
            tableName.addCell(r29c5);
            tableName.addCell(r29c6);
            tableName.addCell(r30c1);
            tableName.addCell(r30c2);
            tableName.addCell(r30c3);
            tableName.addCell(r30c4);
            tableName.addCell(r30c5);
            tableName.addCell(r30c6);
            tableName.addCell(r31c1);
            tableName.addCell(r31c2);
            tableName.addCell(r31c3);
            document.add(tableName);
            
            document.close();
            writer.close();
            System.out.println("Document prepared");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextileERP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(TextileERP.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return document;
    }
}
