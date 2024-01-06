/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import javase.oop.customers.Company;
import javase.oop.customers.CompanyHandler;
import javase.oop.customers.Customer;
import javase.oop.customers.CustomerHandler;
import javase.oop.interfaces.ParametersHandler;
import javase.oop.products.Hardware;
import javase.oop.products.HardwareHandler;
import javase.oop.products.Manual;
import javase.oop.products.ManualHandler;
import javase.oop.products.Software;
import javase.oop.products.SoftwareHandler;

/**
 *
 * @author Administrator
 */
public class TestJDBC {
    public static void main(String[] args){
        
      // Test insert new Customer
     /*
         Customer customer = new Customer("Omar Afandi Co. ", "011654879899", "Cairo - Egypt");
         CustomerHandler.insertCustomer(customer);
     */

        /*
         ArrayList<Customer> customersList = CustomerHandler.getAllCustomers();
         for(Customer customer : customersList){
         System.out.println("Customer id = "+customer.getId());
         System.out.println("Customer Name = "+customer.getName());
         System.out.println("Customer Phone = "+customer.getPhone());
         System.out.println("Customer Address = "+customer.getAddress());
         System.out.println("--------------");
         }   
         */
        /*
        Customer customer = CustomerHandler.getCustomerById(101);
        System.out.println("Customer id = " + customer.getId());
        System.out.println("Customer Name = " + customer.getName());
        System.out.println("Customer Phone = " + customer.getPhone());
        System.out.println("Customer Address = " + customer.getAddress());
        */
       /* 
         Company company = new Company("Misr Air. ", "010123121131", "Alex", "Ahmed Mahmoud", 10);
         CompanyHandler.insertCompany(company);
        System.out.println("--------------- Retrieve all ArrayList ------------");
        
          ArrayList<Company> companyList = CompanyHandler.getAllCompanies();
         for(Company companyItem : companyList){
         System.out.println("Company id = "+companyItem.getId());
         System.out.println("Company Name = "+companyItem.getName());
         System.out.println("Company Phone = "+companyItem.getPhone());
         System.out.println("Company Address = "+companyItem.getAddress());
         System.out.println("Company Contact = "+companyItem.getContact());
         System.out.println("Company Discount = "+companyItem.getDiscount());
         System.out.println("--------------");
         }
         
         
         
         
        company = CompanyHandler.getCompanyById(104);
        System.out.println("Company id = " + company.getId());
        System.out.println("Company Name = " + company.getName());
        System.out.println("Company Phone = " + company.getPhone());
        System.out.println("Company Address = " + company.getAddress());
               */
        
        
        /*
        Manual m1 = new Manual("EA Footbal", 150.0, "Sports Magazine", "EA Sports");
            ManualHandler.insertManual(m1);
        
          ArrayList<Manual> manualsList =  ManualHandler.getAllManuals();
            for(Manual manual : manualsList){
                    System.out.println("Product Id : "+manual.getId());
                    System.out.println("Product Name : "+manual.getName());
                    System.out.println("Product Retail Price : "+manual.getRetialPrice());
                    System.out.println("Product Desc : "+manual.getDescription());
                    System.out.println("Manual Publisher : "+manual.getPublishar());
                    System.out.println("----------------------");
            }
      */
        /*
            Manual manual = ManualHandler.getManualById(101);
                    System.out.println("Product Id : "+manual.getId());
                    System.out.println("Product Name : "+manual.getName());
                    System.out.println("Product Retail Price : "+manual.getRetialPrice());
                    System.out.println("Product Desc : "+manual.getDescription());
                    System.out.println("Manual Publisher : "+manual.getPublishar());
    */
        
       
      //  Hardware printerXerox = new Hardware("Xerox Printer",400.0,"Printers",2);
      //      HardwareHandler.insertHardware(printerXerox);
          
        
            /*     ArrayList<Hardware> hardwareList =   HardwareHandler.getAllHardware();
                    for(Hardware hardware : hardwareList){
                    System.out.println("Product Id : "+hardware.getId());
                    System.out.println("Product Name : "+hardware.getName());
                    System.out.println("Product Retail Price : "+hardware.getRetialPrice());
                    System.out.println("Product Desc : "+hardware.getDescription());
                    System.out.println("Hardware Warranty Period : "+hardware.getWarrantyPeriod());
                    System.out.println("----------------------");
            }       
        */
        /*    
               Hardware hardware = HardwareHandler.getHardwareById(121);
                System.out.println("Product Id : "+hardware.getId());
                    System.out.println("Product Name : "+hardware.getName());
                    System.out.println("Product Retail Price : "+hardware.getRetialPrice());
                    System.out.println("Product Desc : "+hardware.getDescription());
                    System.out.println("Hardware Warranty Period : "+hardware.getWarrantyPeriod());
                    System.out.println("----------------------");
          */   
        
       // System.out.println(ParametersHandler.getParameterValue("TAX_PCT"));
        
            //    Software office97 = new Software(3, "Office 97", 100.0, "Office Ms", "32432");
          //  SoftwareHandler.insertSoftware(office97);
       
       //    double paramValue =  ParametersHandler.getParamValueByName("TAX_PCT");
      //  System.out.println("Param Value = "+paramValue);
    
    }
}