package InvoiceSQL;

import java.io.Serializable;
import java.util.ArrayList;

public class Invoice1 implements Serializable{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			//data of invoice
			private Integer invoiceNo;
			private String invoiceDate;
			//data of customer in invoice
			private String CustomerName;
			private Integer CustomerNumber;
			//data of items in invoice with price
			
			private Integer noOfItems;
			
			private double totalAmount;
			private double paidAmount;
			private double balance;
			
			ArrayList<Items1> itemsList = new ArrayList<Items1>();

			//git/set 
			
			public Integer getInvoiceNo() {
				return invoiceNo;
			}
			public void setInvoiceNo(Integer invoiceNo) {
				this.invoiceNo = invoiceNo;
			}
			public String getInvoiceDate() {
				return invoiceDate;
			}
			public void setInvoiceDate(String invoiceDate) {
				this.invoiceDate = invoiceDate;
			}
			public String getCustomerName() {
				return CustomerName;
			}
			public void setCustomerName(String customerName) {
				CustomerName = customerName;
			}
			public Integer getCustomerNumber() {
				return CustomerNumber;
			}
			public void setCustomerNumber(Integer customerNumber) {
				CustomerNumber = customerNumber;
			}
			public Integer getNoOfItems() {
				return noOfItems;
			}
			public void setNoOfItems(Integer noOfItems) {
				this.noOfItems = noOfItems;
			}
			public double getPaymentPrice() {
				return balance;
			}
			public void setPaymentPrice(double paymentPrice) {
				this.balance = paymentPrice;
			}
			public double getTotalAmount() {
				return totalAmount;
			}
			public void setTotalAmount(double itemPrice) {
				this.totalAmount = itemPrice;
			}
			public double getPaidAmount() {
				return paidAmount;
			}
			public void setPaidAmount(double paidAmount) {
				this.paidAmount = paidAmount;
			}
			public ArrayList<Items1> getItemsList() {
				return itemsList;
			}
			public void setItemsList(ArrayList<Items1> itemsList) {
				this.itemsList = itemsList;
			}
			


			
		}
