package InvoiceSQL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class main1 {
	
	
	// create an array of invoices to store all invices in the system
		public static ArrayList<Invoice1> invoices = new ArrayList<Invoice1>();
		
		// create an array of items to store all items in the system
		public static ArrayList<Items1> items = new ArrayList<Items1>();
		
		public static setting1 settings = new setting1();
		
		public static HashMap<String,Integer> MenuOptions = new HashMap<String,Integer>();
		
		
		public static void main(String[] args) {
			
			String url = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=invoice;encrypt=true;"
					+ "trustServerCertificate=true";
			 Scanner scanner = new Scanner(System.in);
			System.out.println("enter user");
			 String user = scanner.nextLine();
			 System.out.println(user);
			 System.out.println("enter pass");
			 String pass = scanner.nextLine();
			 System.out.println(pass);

//			 if (user.equals(user) && pass.equals(pass)) {}else {
//			 System.out.println("worng username and password ");
//			 }
//			 Connection con = null;
//			 System.out.println("System is in prograss:");
//			 try {
//			 // create a new table
//			 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//			 DriverManager.registerDriver(driver);
//			 con = DriverManager.getConnection(url, user, pass);
//			 Statement st = con.createStatement();
			
			statisticsOptions();
			printMenu(1);
			MenuOptions.put("Case 0", MenuOptions.get("Case 0")+1);
	        System.out.println("Enter Your option:");
	        Scanner sc = new Scanner(System.in);

	        int select = sc.nextInt();

	        switch (select) {
		        case 1:
		        	//Shop Settings print
		        	MenuOptions.put("Case 1", MenuOptions.get("Case 1")+1);
		        	printMenu(2);
		        	settingsMenu();
		        	break;
		        case 2:
		        	//Shop Items
		        	MenuOptions.put("Case 2", MenuOptions.get("Case 2")+1);
		        	printMenu(3);
		        	itemsMenu();
		        	break;
		        case 3:
		        	// Create New Invoice
		        	MenuOptions.put("Case 3", MenuOptions.get("Case 3")+1);
		        	addNewInvoice();
		        case 4:
		        	//Report: Statistics
		        	MenuOptions.put("Case 4", MenuOptions.get("Case 4")+1);
		        	statistics();
		        case 5:
		        	//All Invoices
		        	MenuOptions.put("Case 5", MenuOptions.get("Case 5")+1);
		        	printAllInvoices();
		        case 6:
		        	//search Invoice
		        	MenuOptions.put("Case 6", MenuOptions.get("Case 6")+1);
		        	searchInvoice(); 
		        case 7:
		        	//Program Statistics
		        	MenuOptions.put("Case 7", MenuOptions.get("Case 7")+1);
		        	programStatistics(); 
		        case 8:
		        	//exit
		        	MenuOptions.put("Case 8", MenuOptions.get("Case 8")+1);
		        	System.out.println("Are you sure you want to Exit? (yes/no)");
		        	if(sc.next().equals("yes")) {
		        	 System.exit(0);
		        	}else {
		        		main(null);
		        	}
		        	break;
	        }		
	}
		
		//the program will call this function if want to print menus (main, settings and items)
		private static void printMenu(int menuNum) {
	        switch (menuNum) {
	        case 1: // main menu
	        	System.out.println("\r\n");
				System.out.println(" Welcome to Invoice Store ");
				System.out.println(" ===================================== ");
				System.out.println("1 Shop Settings");
		        System.out.println("2 Manage items");
		        System.out.println("3 Create New Invoice");
		        System.out.println("4 Statistics");
		        System.out.println("5 All Invoices");
		        System.out.println("6 Search Invoice");
		        System.out.println("7 Program Statistics");
		        System.out.println("8 Exit");
		        break;
	        case 2: // setting menu
				System.out.println("1 Load Data (Items and invoices)");
		        System.out.println("2 Set Shop Name");
		        System.out.println("3 Set Invoice Header (Tel/Fax/Email/Website)");
		        System.out.println("4 Go Back");
		        break;
	        case 3: // items menu
				System.out.println("1 Add Items");
		        System.out.println("2 Delete Items");
		        System.out.println("3 Change Item Price");
		        System.out.println("4 Report All Items");
		        System.out.println("5 Go Back");
		        break;
	        }
		}
		
		//options for settings menu
		private static void settingsMenu() {
	        Scanner sc = new Scanner(System.in);
	        int select = sc.nextInt();
	        
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=invoice;"
	        		+ "encrypt=true;"
	        		+ "trustServerCertificate=true";

	        Scanner scanner = new Scanner(System.in);
	       	System.out.println("enter user");
	       	 String user = scanner.nextLine();
	       	 System.out.println(user);
	       	 System.out.println("enter pass");
	       	 String pass = scanner.nextLine();
	       	 System.out.println(pass);

	       	 if (user.equals(user) && pass.equals(pass)) {}else {
	       	 System.out.println("worng username and password ");
	       	 }
	       	 Connection con = null;
	       	 System.out.println("System is in prograss:");
	       	 try {
	       	 // create a new table
	       	 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	       	 DriverManager.registerDriver(driver);
	       	 con = DriverManager.getConnection(url, user, pass);
	       	 Statement st = con.createStatement();
	        
	       	 setting1 sett1=new setting1();

	    	
			 String sql1="CREATE TABLE setting1 (" 
					 + "shopName varchar(50) not null,"
					 +"TelNum Integer  ,"
					 +"faxNo Integer ,"
					 + "Email varchar(50) not null, "
					 +"Website varchar(50) not null "
					 + ");";
			 
	    	 System.out.println("craeted to SQL database");
	    		//st.execute(sql1);
	
	        
	        // Load Data
	        if(select == 1) {
	        	//load settings from file
	        	loadSettings();
	        	//load items from file
	        	loadItems();
	        	//load invoices from file
	        	loadInvoices();
	        	System.out.println("Data Loaded Seccssfully");
	        	
	        }else if(select == 2) {
	        	System.out.println("Enter Shop Name:");
				String shopName = sc.next();
				settings.setShopName(shopName);
				System.out.println("New Shop Name Saved");
				saveSettings();

	        	
	        }else if(select == 3) {
	        	System.out.println("Enter phone Number:");
				int TelNum = sc.nextInt();
				main1.settings.setTelNum(TelNum);
				
				System.out.println("Enter Fax:");
				int faxNo = sc.nextInt();
				main1.settings.setFaxNo(faxNo);
				
				System.out.println("Enter Email  Address:");
				String Email = sc.next();
				main1.settings.setEmail(Email);
				
				System.out.println("Enter website:");
				String Website = sc.next();
				main1.settings.setWebsite(Website);
				
				
				 String sql = "INSERT INTO setting1 (shopName,TelNum,faxNo,Email,Website)"+
						 "VALUES ("+"'"+settings.getShopName()+"','"+settings.getTelNum()+"','"+settings.getFaxNo()+"','"+settings.getEmail()+"','"+settings.getWebsite()+ "')";
				System.out.println(sql);
				 st.execute(sql);
				 
				 
				saveSettings();
				System.out.println("New Shop Data Saved");

				
	        }else if(select == 4) {
	        	main(null);
	        }
	        
	        // repete menu if get here
			printMenu(2);
			settingsMenu();
			
			
			con.close();
	     	}catch (Exception e) {
	     		System.err.println(e);     
		}
		}
		
		//options for item menu
		private static void itemsMenu() {
	        Scanner sc = new Scanner(System.in);
	        int select = sc.nextInt();
	        
	        String url = "jdbc:sqlserver://localhost:1433;databaseName=invoice;"
	        		+ "encrypt=true;"
	        		+ "trustServerCertificate=true";

	        Scanner scanner = new Scanner(System.in);
	       	System.out.println("enter user");
	       	 String user = scanner.nextLine();
	       	 System.out.println(user);
	       	 System.out.println("enter pass");
	       	 String pass = scanner.nextLine();
	       	 System.out.println(pass);

	       	 if (user.equals(user) && pass.equals(pass)) {}else {
	       	 System.out.println("worng username and password ");
	       	 }
	       	 Connection con = null;
	       	 System.out.println("System is in prograss:");
	       	 try {
	       	 // create a new table
	       	 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	       	 DriverManager.registerDriver(driver);
	       	 con = DriverManager.getConnection(url, user, pass);
	       	 Statement st = con.createStatement();
	        
	       	// setting1 sett1=new setting1();
	     	
			 String sql1="CREATE TABLE Items1 (" 
					 + "itemName varchar(50) not null,"
					 +"itemId Integer,"
					 +"itemprice float,"
					 +"stock Integer, "
					 +"quantity Integer"
					 + ");";
			 
	    	 System.out.println("craeted to SQL database");
	    
	    	   // st.execute(sql1);
	        
	        // add new item
	        if(select == 1) {
	        	
	        	//ask user to enter item data
	        	Items1 newitem = new Items1();
	        	
	        	System.out.println("Enter item ID: ");
	        	int idOfItem = sc.nextInt();
				newitem.setItemId(idOfItem);
				
	        	System.out.println("Enter item Name: ");
				String nameOfItem = sc.next();
				newitem.setItemName(nameOfItem);
				
				System.out.println("Enter item Price: ");
				double itemPrice = sc.nextDouble();
				newitem.setitemPrice(itemPrice);
				
				System.out.println("Enter the Stock: ");
				int stockOfItems = sc.nextInt();
				newitem.setStock(stockOfItems);
				
			
					
				//add new item to the global items array
				main1.items.add(newitem);
				saveItems();
				System.out.println("New Item Saved");
				
				
//	        	String sql = "INSERT INTO Items1 (itemName,itemId,itemprice,stock,quantity)"+
//						 "VALUES ("+"'"+newitem.getItemName()+"','"+newitem.getItemId()+"','"+newitem.getitemPrice()+"','"+newitem.getStock()+"','"+newitem.getQuantity()+ "')";
//				st.execute(sql);
//			System.out.println(sql);
				
				//delete item
	        }else if(select == 2) {
	        	
	        	boolean found = false;
	        
	        	System.out.println("Enter item ID: ");
	        	int idOfItem = sc.nextInt();
	        	
	        	for(int i =0; i < main1.items.size(); i++) {
	        		if(main1.items.get(i).getItemId() == idOfItem) {
	        			main1.items.remove(i);
	        			found = true;
	        		}
	        	}
	        	
	        	if(found) {
		        	saveItems();
					System.out.println("Item Deleted");
	        	}else {
	        		System.out.println("Item not Found");
	        	}

	        	//change item price
	        }else if(select == 3) {
	        	
	        	System.out.println("Enter item ID: ");
	        	int idOfItem = sc.nextInt();
	        	
	        	for(int i =0; i < main1.items.size(); i++) {
	        		if(main1.items.get(i).getItemId() == idOfItem) {
	        			
	        			System.out.println("Item Found Enter New Price: ");
	        			double priceOfItem = sc.nextDouble();
	        			
	        			main1.items.get(i).setitemPrice(priceOfItem);
	        			System.out.println("New Item Price Saved");
	        			saveItems();
	        		}
	        	}
	        	
	       
	        	
	        	//print all items
	        }else if(select == 4) {
	        	System.out.println("-------------------");
	        	
	        	for(Items1 item : main1.items) {
	        		System.out.format("ID:%d Name%s Price:%f Stock:%d \r\n",item.getItemId(), item.getItemName(), item.getitemPrice(), item.getStock());
	        	}

	        	System.out.println("-------------------");
	        }else if(select == 5) {
	        	main(null);
	        }
	        
			printMenu(3);
			itemsMenu();
			
			con.close();
		     	}catch (Exception e) {
		     		System.err.println(e);     
			}
		}
		
		//save settings to file
		private static void saveSettings() {
			FileOutputStream fileOutputStream;

			try {
				
				fileOutputStream = new FileOutputStream("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\src\\InvoicingProgect\\settings.txt");
			    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			    
			    objectOutputStream.writeObject(main1.settings);
			    objectOutputStream.flush();
			    objectOutputStream.close();
		    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    
		}
		
		//load settings from file
		private static void loadSettings() {

			try {
				FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\src\\InvoicingProgect\\settings.txt");
				
			    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		    
			    //cast object to type setting
			    main1.settings = (setting1) objectInputStream.readObject();

			    objectInputStream.close();
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//save items to file
		private static void saveItems() {
			FileOutputStream fileOutputStream;

			try {
				
				fileOutputStream = new FileOutputStream("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\src\\InvoicingProgect\\items.txt");
			    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			    
			    objectOutputStream.writeObject(main1.items);
			    objectOutputStream.flush();
			    objectOutputStream.close();
		    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		}
		
		//load items from file
		private static void loadItems() {

			try {
				FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\src\\InvoicingProgect\\items.txt");
				
			    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		    
			    main1.items = (ArrayList<Items1>) objectInputStream.readObject();

			    objectInputStream.close();
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//save invoices to file
		private static void saveInvoices() {
			FileOutputStream fileOutputStream;

			try {
				
				fileOutputStream = new FileOutputStream("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\src\\InvoicingProgect\\invoices.txt");
			    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			    
			    objectOutputStream.writeObject(main1.invoices );
			    objectOutputStream.flush();
			    objectOutputStream.close();
		    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    
		}
		
		//load invoices from file
		private static void loadInvoices() {

			try {
				FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\InvoicingSystem\\src\\InvoicingProgect\\invoices.txt");
				
			    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		    
			    main1.invoices = (ArrayList<Invoice1>) objectInputStream.readObject();

			    objectInputStream.close();
			 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// add new invoice
		private static void addNewInvoice() {
			
	        Scanner sc = new Scanner(System.in);
	    	Invoice1 newInvoice = new Invoice1();
	    	
	    	 String url = "jdbc:sqlserver://localhost:1433;databaseName=invoice;"
		        		+ "encrypt=true;"
		        		+ "trustServerCertificate=true";

		        Scanner scanner = new Scanner(System.in);
		       	System.out.println("enter user");
		       	 String user = scanner.nextLine();
		       	 System.out.println(user);
		       	 System.out.println("enter pass");
		       	 String pass = scanner.nextLine();
		       	 System.out.println(pass);

		       	 if (user.equals(user) && pass.equals(pass)) {}else {
		       	 System.out.println("worng username and password ");
		       	 }
		       	 Connection con = null;
		       	 System.out.println("System is in prograss:");
		       	 try {
		       	 // create a new table
		       	 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		       	 DriverManager.registerDriver(driver);
		       	 con = DriverManager.getConnection(url, user, pass);
		       	 Statement st = con.createStatement();
		       	 
		       	 String sql1="CREATE TABLE Invoice1 (" 
						 + "invoiceNo Integer primary key,"
						 +"invoiceDate varchar(50) not null,"
						 +"CustomerName varchar(50) not null,"
						 +"CustomerNumber Integer,"
						 +"noOfItems Integer,"
						 +"totalAmount float,"
						 +"balance float,"
						 +"paidAmount float,"
						 +");";
				 
		    	 System.out.println("craeted to SQL database");
		    		//st.execute(sql1);
		
		    	 
	    	
	    	//get current date in string format
	    	Date date = new Date();
	    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    	newInvoice.setInvoiceDate( formatter.format(date));
	    	
	    	//if no invoices size = 0 then this it the first invoice so id should be 1
	    	int newInvoiceId = 1;

	    	//if there is an invoice get last one number and add 1 to it
	    	if(main1.invoices.size() != 0) {
	    		newInvoiceId = (main1.invoices.get( main1.invoices.size() - 1 ).getInvoiceNo()) + 1;
	    	}
	    	newInvoice.setInvoiceNo(newInvoiceId);
	    	
	    	
	    	System.out.println("Enter Customer Name: ");
	    	String customerName = sc.next();
	    	newInvoice.setCustomerName(customerName);
	    	
	    	System.out.println("Enter Customer Phone: ");
	    	int customerphone = sc.nextInt();
	    	newInvoice.setCustomerNumber(customerphone);
	    	

	    	//start loop to select items
	    	boolean checkout = false;
	    	
	    	ArrayList<Items1> newInvoiceItems = newInvoice.getItemsList();
	    	
	    	while (!checkout) {
	    		System.out.println("Select Item: ");
	    		
	    		//print all items list
	    		for(Items1 item : main1.items) {
	    			System.out.format("ID:%d Name:%s\r\n",item.getItemId(), item.getItemName());
	    		}
	    		
	    		int itemId = sc.nextInt();
	    		
	    		System.out.println("Enter Quantity: ");
	    		int itemQuantity = sc.nextInt();
	    		
	    		//search for the item and add it to invoice items + set quantity
	    		for(int i=0 ; i < main1.items.size(); i++) {
	    			if(main1.items.get(i).getItemId() == itemId) {
	    				
	    				Items1 newItem = main1.items.get(i);
	    				newItem.setQuantity(itemQuantity);
	    				newInvoiceItems.add(main1.items.get(i));
	    				
	    			}
	    		}
	        	
	    		System.out.println("Do you weant to Add Another Item?");
	    		int next = sc.nextInt();
	    		
	    		if(next == 0) {
	    			checkout = true;
	    		}
	    		
	    	}
	    	
	    	//calculate total price and items 
	    	double totalAmount = 0;
	    	
	    	for(int i=0 ; i < newInvoiceItems.size(); i++) {
	    		//price = item price * quantity
	    		totalAmount += ( newInvoiceItems.get(i).getitemPrice() * newInvoiceItems.get(i).getQuantity());
			}
	    	
	    	// save items to the invoice
			newInvoice.setItemsList(newInvoiceItems);
			

			//save total price and quantity to invoice
			newInvoice.setNoOfItems(newInvoiceItems.size());
	    	newInvoice.setTotalAmount(totalAmount);
	    	
	    	System.out.format("Total Amount:%f\r\n",newInvoice.getTotalAmount());
	    	
			System.out.println("How much did the customer pay?");
			double paid = sc.nextDouble();
			
			newInvoice.setPaidAmount(paid);
			
			double remaining = paid - newInvoice.getTotalAmount();
			newInvoice.setPaymentPrice(remaining);
			
			System.out.format("you should return:%f to the customer\r\n",remaining);

			
			//add new invoice to the list
			main1.invoices.add(newInvoice);
			//save to file
			saveInvoices();
			
			 String sql = "INSERT INTO Invoice1 (invoiceNo,invoiceDate,CustomerName,CustomerNumber,noOfItems,totalAmount,paidAmount,balance)"+
					 "VALUES ("+"'"+newInvoice.getInvoiceNo()+"','"+newInvoice.getInvoiceDate()+"','"+newInvoice.getCustomerName()+"','"+newInvoice.getCustomerNumber()+"','"+newInvoice.getNoOfItems()+"','"+newInvoice.getTotalAmount()+"','"+newInvoice.getPaidAmount()+"','"+newInvoice.getPaymentPrice()+"')";
			System.out.println(sql);
			st.execute(sql);
			 
			
			System.out.print("Invoice Saved Successfully");
			//return to main menu
			main(null);
			con.close();
			     	}catch (Exception e) {
			     		System.err.println(e);     
				}
		}

		//Report: Statistics
		private static void statistics() {
			System.out.println("Number of Items: " + main1.items.size());
			
			System.out.println("Number of Invoices: " + + main1.invoices.size());
			
			
			
			double total = 0;
			for(int i = 0; i < main1.invoices.size(); i++ ) {
				total += main1.invoices.get(i).getTotalAmount();
			
			}
			
			System.out.println("Total Sales:" + total);
			
			main(null);
		}

		//All Invoices
		private static void printAllInvoices() {
			for(Invoice1 invoice : main1.invoices ) {
				
				System.out.format("#%s | Date:%s | Customer Name:%s | Customer Number:%s  | Price:%s \r\n", invoice.getInvoiceNo(), invoice.getInvoiceDate(), invoice.getCustomerName(), invoice.getCustomerNumber(), invoice.getTotalAmount());
				
				for(Items1 item : invoice.getItemsList() ) {
					System.out.format("---- #%d | Name:%s | Price:%f | Quantity:%d | Total:%f \r\n", item.getItemId(), item.getItemName(), item.getitemPrice(), item.getQuantity(), (item.getitemPrice()*item.getQuantity()) );
				}
			}
			
			main(null);
		}

		//search Invoice
		private static void searchInvoice() {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Invoice ID:");
			int invoiceNumber = sc.nextInt();
			
			boolean found = false;
			for(Invoice1 invoice : main1.invoices ) {
				
				if(invoice.getInvoiceNo() == invoiceNumber) {	
					found = true;
					System.out.format("#%s | Date:%s | Customer Name:%s | Customer Number:%s  | Price:%s \r\n", invoice.getInvoiceNo(), invoice.getInvoiceDate(), invoice.getCustomerName(), invoice.getCustomerNumber(), invoice.getTotalAmount());
					
					for(Items1 item : invoice.getItemsList() ) {
						System.out.format("---- #%d | Name:%s | Price:%f | Quantity:%d | Total:%f \r\n", item.getItemId(), item.getItemName(), item.getitemPrice(), item.getQuantity(), (item.getitemPrice()*item.getQuantity()) );
					}
					break;
				}
			}
			
			if(!found) {
				System.out.println("Invoice Not Found!");
			}
			
			main(null);
		}

		//Program Statistics
		private static void programStatistics() {
		
			System.out.println("Main menu open time: " + MenuOptions.get("Case 0"));
			System.out.println("Setting menu open time: " + MenuOptions.get("Case 1"));
			System.out.println("Items menu  open time: " + MenuOptions.get("Case 2"));
			System.out.println("Create New Invoice menu open time: " + MenuOptions.get("Case 3"));
			System.out.println("Statistics menu open time: " + MenuOptions.get("Case 4"));
			System.out.println("All Invoices open time: " + MenuOptions.get("Case 5"));
			System.out.println("Search Invoice menu open time: " + MenuOptions.get("Case 6"));
			System.out.println("Program Statistics menu open time: " + MenuOptions.get("Case 7"));
			System.out.println("Exit open time: " + MenuOptions.get("Case 8"));
			
			
			main(null);
			
		}
		
		private static void statisticsOptions() {
		if(!MenuOptions.containsKey("Case 0")) {
			
			MenuOptions.put("Case 0", 0);
			MenuOptions.put("Case 1", 0);
			MenuOptions.put("Case 2", 0);
			MenuOptions.put("Case 3", 0);
			MenuOptions.put("Case 4", 0);
			MenuOptions.put("Case 5", 0);
			MenuOptions.put("Case 6", 0);
			MenuOptions.put("Case 7", 0);
			MenuOptions.put("Case 8", 0);
			
		}
		}
		
	}
    



