package InvoiceSQL;

	import java.io.Serializable;

	public class setting1 implements Serializable {
		//hidder....shop name//Tel / Fax / Email / Website
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String shopName;
		private Integer TelNum;
		private Integer faxNo;
		private String Email;
		private String Website;
		
		
		public String getShopName() {
			return shopName;
		}
		public void setShopName(String shopName) {
			this.shopName = shopName;
		}
		public Integer getTelNum() {
			return TelNum;
		}
		public void setTelNum(Integer telNum) {
			TelNum = telNum;
		}
		public Integer getFaxNo() {
			return faxNo;
		}
		public void setFaxNo(Integer faxNo) {
			this.faxNo = faxNo;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getWebsite() {
			return Website;
		}
		public void setWebsite(String website) {
			Website = website;
		}
		

	}