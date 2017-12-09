package tn.esprit.utils;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Column;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import tn.esprit.entities.Admin;
import tn.esprit.entities.Product;
import tn.esprit.services.AdminServicesRemote;
import tn.esprit.services.ProductServices;
import tn.esprit.services.ProductServicesRemote;

@SuppressWarnings("serial")
public class DisplayProductsAdmin extends AbstractTableModel {
	
  
	
    public String[]  product_admin_Jtable_columnNames = {"Type Product","Price Product","Availability"}; 
    public List<Product> list_products_admin;
    Admin admin = new Admin();
    
  /*  public static void sizeColumnsToFit(JTable table) {
        sizeColumnsToFit(table, 5);
    }
 
    public static void sizeColumnsToFit(JTable table, int columnMargin) {
        JTableHeader tableHeader = table.getTableHeader();
    }*/
    
    
	public DisplayProductsAdmin(String[] product_admin_Jtable_columnNames, List<Product> list_products_admin) {
		super();
		this.product_admin_Jtable_columnNames = product_admin_Jtable_columnNames;
		this.list_products_admin = list_products_admin;
	}
 
	public DisplayProductsAdmin(Admin a,String[] Columns) throws NamingException {
		super();
		this.product_admin_Jtable_columnNames = Columns;
		Context context = new InitialContext();
		AdminServicesRemote adminServicesRemote = (AdminServicesRemote) context.lookup("nature-spirit-ear/nature-spirit-ejb/AdminServices!tn.esprit.services.AdminServicesRemote");
		ProductServicesRemote productServicesRemote = (ProductServicesRemote) context.lookup("nature-spirit-ear/nature-spirit-ejb/ProductServices!tn.esprit.services.ProductServicesRemote");

		this.admin=a;
		adminServicesRemote.findAdminById(a.getId_Admin());
		//ProductServices productServices = new ProductServices();
		list_products_admin =productServicesRemote.findAllAdminProducts2(a) ;
	}

	@Override
	public int getColumnCount() {
		return product_admin_Jtable_columnNames.length;
	}

	@Override
	public int getRowCount() {
		return list_products_admin.size();
	}
	
	 @Override
	 public String getColumnName(int i) {  
		return product_admin_Jtable_columnNames[i];
      }  

   public void setColumnsheadersNames(){
	   TableColumnModel columns = new DefaultTableColumnModel();
	   int count = getColumnCount();
	   
	   for (int i = 1; i < count; i++)
	   {
	       TableColumn c = new TableColumn(i);
	       c.setHeaderValue(getColumnName(i));
	       columns.addColumn(c);
	   }
   }
    
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) 
		{
		
   /*case 0:
            return list_products_admin.get(rowIndex).getId_Product();*/
   case 0:
            return list_products_admin.get(rowIndex).getType_Product();
   case 1:
            return list_products_admin.get(rowIndex).getPrice();        
   case 2:
             if(list_products_admin.get(rowIndex).getAvailability()==1){
            	 return "Available";
             }else{
            	 return "Not Available";
             }
  /* case 4:
            return list_products_admin.get(rowIndex).getAdmin().getId_Admin();*/
   default:
           return null;
        }
    }
	
	
	
   
}
