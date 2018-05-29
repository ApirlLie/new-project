package org.lanqiao.entity;

public class User {
		private String userName ;
		private String passWord ;
		public User(){
			
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassWord() {
			return passWord;
		}
		@Override
		public String toString() {
			return "User [userName=" + userName + ", passWord=" + passWord + "]";
		}
		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}
		
}
