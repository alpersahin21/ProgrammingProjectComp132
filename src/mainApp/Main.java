/* Pledge of Honor *************************************************************************************
I hereby certify that I have completed this programming project on my own without any help from anyone else.
The effort in the project thus belongs completely to me. 
I did not search for a solution, or I did not consult to any program written by others or did not copy any program from other sources.
I read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Alper Sahin, 80417> 
************************************************************************************************************/

package mainApp;

import javax.swing.ImageIcon;

import GUIClasses.LoginPage;
import GUIClasses.SignUpPage;
import ObjectClasses.Content;
import ObjectClasses.Group;
import ObjectClasses.User;


public class Main {

	public static void main(String[] args) {
		
		//Creating user classes
		
		User user1 = new User("oguz","123","Oguz","Alpkan","19","alpkan@hotmail.com");
		User user2 = new User("NihasRepla","123456789","Alper","Şahin","18","alpersahin@gmail.com");
		User user3 = new User("skelleci","sarpsarp","Sarp","Kelleci","19","skelleci21@ku.edu.tr");
		User user4 = new User("matedeav","heydude","Mate","High","27","mhigh@yahoo.com");
		User user5 = new User("notch","minecraft","Notch","Cool","35","ncool@hotmail.com");
		User user6 = new User("rikean","12345","Alex","Hunter","21","alexxx@gmail.com");
		User user7 = new User("fellas","imcool","Samwell","Tarly","24","gotsucks@gmail.com");
		User user8 = new User("naruspot","whatisanime","Naruto","Uzumaki","17","rasengan@hotmail.com");
		User user9 = new User("command","altdel","Fred","Dutch","24","heyfred@gmail.com");
		User user10 = new User("boomer","zoomer","Vex","Lady","56","vlax@gmail.com");
		User user11 = new User("account","password","Reek","Theon","34","iamreek@hotmail.com");
		User user12 = new User("lastone","finally","Love","Lovegood","24","impsycho@gmail.com");
		
		// Creating group classes
		
		Group group1 = new Group("Banditsr", "USA",user1);
		Group group2 = new Group("RockNCoke", "Turkey",user2);
		Group group3 = new Group("Team Gaming", "Germany",user3);
		Group group4 = new Group("Boomers", "Sweden",user4);
		
		// Creating image icons to be used on photo posts.
		ImageIcon defaultpng1 = new ImageIcon("default.png");
		ImageIcon defaultpng2 = new ImageIcon("default2.png");
		ImageIcon defaultpng3 = new ImageIcon("default3.png");
		ImageIcon defaultpng4 = new ImageIcon("default4.png");
		ImageIcon defaultpng5 = new ImageIcon("default5.png");
		ImageIcon defaultpng6 = new ImageIcon("default6.png");
		ImageIcon defaultpng7 = new ImageIcon("default7.png");
		ImageIcon defaultpng8 = new ImageIcon("default8.png");
		ImageIcon defaultpng9 = new ImageIcon("default9.png");
		ImageIcon defaultpng10= new ImageIcon("default10.png");
		ImageIcon defaultpng11 = new ImageIcon("default11.png");
		ImageIcon defaultpng12 = new ImageIcon("default12.png");
		
		//creating contents.
		
		Content con1 = new Content("Default","NihasRepla","default photo",defaultpng1);
		Content con2 = new Content("Daily Life","NihasRepla","It Sucks");
		Content con3 = new Content("Hey","NihasRepla","I am premium");
		Content con4 = new Content("Woooow","NihasRepla","what a day!");
		
		Content con5 = new Content("Sarp","skelleci","Selam abi naber");
		Content con6 = new Content("İyi","skelleci","iyiyim sağol sen");
		Content con7 = new Content("Manzara","skelleci",defaultpng2);
		Content con8 = new Content("Fotograf","skelleci","Çok iyi fotolar var ya");
		
		Content con9 = new Content("Sup","matedeav","first post here");
		Content con10 = new Content("raccoonn","matedeav","Its Mine!!!",defaultpng3);
		Content con11 = new Content("yeahhhh","matedeav","i kile this");
		Content con12 = new Content("last","matedeav","goodbye!!!");
		
		Content con13 = new Content("Turk100","notch","orta zor");
		Content con14 = new Content("Fotograf","notch","bi tane foto işte",defaultpng4);
		Content con15 = new Content("Phoy102","notch","ahoy captain!!!");
		Content con16 = new Content("sa","notch","as");
		
		Content con17 = new Content("cterseesa","rikean","i am nonsense");
		Content con18 = new Content("posting is amezing","rikean","amezing is posting");
		Content con19 = new Content("thatsmypicture","rikean",defaultpng5);
		Content con20 = new Content("haahahahah","rikean","its so funnyyyyy");
		
		Content con21 = new Content("fella1","fellas","supbro");
		Content con22 = new Content("fella2","fellas","supbro");
		Content con23 = new Content("fotografgirdiaraya","fellas",defaultpng6);
		Content con24 = new Content("fella4","fellas","supbro");
		
		Content con25 = new Content("anime","naruspot","çizgi film");
		Content con26 = new Content("myphoto","naruspot","",defaultpng7);
		Content con27 = new Content("sıkıldım","naruspot","yazmaktan");
		Content con28 = new Content("selammmmlarrrr","naruspot","bendeniz ahmet aga");
		
		Content con29 = new Content("ayransu","command","its my water");
		Content con30 = new Content("faeqweqwdsa","command",defaultpng8);
		Content con31 = new Content("sadasdasdqwdwqa","command","asdqwdqwadasdwad");
		Content con32 = new Content("dasdqwdqadswad","command","sadqwadwwqd");
		
		Content con33 = new Content("okboomer","boomer","",defaultpng9);
		Content con34 = new Content("yaslı","boomer","adadm");
		Content con35 = new Content("sanki yapamadım","boomer","iyi şarkı");
		Content con36 = new Content("dinleyin","boomer"," teşekkürler");
		
		Content con37 = new Content("hesabına","account","hesabına oynadık",defaultpng10);
		Content con38 = new Content("wsaewqdd","account","sadasdasdqwda");
		Content con39 = new Content("heheuehyeye","account","heuehueheuehuehe");
		Content con40 = new Content("sdsadsad","account","pssssssst");
		
		Content con41 = new Content("sonuncu","lastone","degil");
		Content con42 = new Content("guzelfoto","lastone",defaultpng11);
		Content con43 = new Content("oguzu eklemeyi","lastone","unutmuşum");
		Content con44 = new Content("sadasdasdsawqd","lastone","dasdqwddasd");
		
		Content con45 = new Content("ilkeklenen","oguz","fotografff",defaultpng12);
		Content con46 = new Content("vfer","oguz","feridun");
		Content con47 = new Content("qweqweqwq","oguz","sadasdasdasdqwdqddwdasdawdadasd");
		Content con48 = new Content("sonundaaaaaa","oguz","bittttttiiiiiiiii");
		
		//adding contents to groups
		
		group1.addContents(con45);
		group2.addContents(con4);
		group3.addContents(con7);
		group4.addContents(con9);
		
		group1.addContents(con26);
		group2.addContents(con23);
		group3.addContents(con20);
		group4.addContents(con14);
		
		group1.addContents(con42);
		group2.addContents(con38);
		group3.addContents(con33);
		group4.addContents(con31);
		
		//adding contents to users.
		
		user1.addContent(con48);
		user1.addContent(con47);
		user1.addContent(con46);
		
		user2.addContent(con1);
		user2.addContent(con2);
		user2.addContent(con3);
		
		user3.addContent(con5);
		user3.addContent(con6);
		user3.addContent(con8);
		
		user4.addContent(con10);
		user4.addContent(con11);
		user4.addContent(con12);
		
		user5.addContent(con13);
		user5.addContent(con15);
		user5.addContent(con16);
		
		user6.addContent(con17);
		user6.addContent(con18);
		user6.addContent(con19);
		
		user7.addContent(con21);
		user7.addContent(con22);
		user7.addContent(con24);
		
		user8.addContent(con25);
		user8.addContent(con27);
		user8.addContent(con28);
		
		user9.addContent(con29);
		user9.addContent(con30);
		user9.addContent(con32);
		
		user10.addContent(con34);
		user10.addContent(con35);
		user10.addContent(con36);
		
		user11.addContent(con37);
		user11.addContent(con39);
		user11.addContent(con40);
		
		user12.addContent(con41);
		user12.addContent(con43);
		user12.addContent(con44);
		
		
		// adding users to groups
		
		
		user12.joinGroup(group1);
		user11.joinGroup(group2);
		user10.joinGroup(group3);
		user9.joinGroup(group4);
		user8.joinGroup(group1);
		user7.joinGroup(group2);
		user6.joinGroup(group3);
		user5.joinGroup(group4);
	
		// following users
		
		user1.follow(user12);
		user1.follow(user9);
		user1.follow(user6);
		
		user2.follow(user4);
		user2.follow(user11);
		user2.follow(user9);
		
		user3.follow(user2);
		user3.follow(user4);
		user3.follow(user7);
		
		user4.follow(user2);
		user4.follow(user1);
		user4.follow(user10);
		
		user5.follow(user2);
		user5.follow(user3);
		user5.follow(user4);
		
		user6.follow(user7);
		user6.follow(user4);
		user6.follow(user1);
		
		user7.follow(user9);
		user7.follow(user6);
		user7.follow(user2);
		
		user8.follow(user10);
		user8.follow(user11);
		user8.follow(user12);
		
		user9.follow(user3);
		user9.follow(user2);
		user9.follow(user8);
		
		user10.follow(user1);
		user10.follow(user5);
		user10.follow(user11);
		
		user11.follow(user8);
		user11.follow(user6);
		user11.follow(user2);
		
		user12.follow(user3);
		user12.follow(user6);
		user12.follow(user4);
		
		// adding hobbies to groups
		
		group1.addHobbies("Skating");
		group1.addHobbies("Football");
		group1.addHobbies("Stealing");
		
		group2.addHobbies("Music");
		group2.addHobbies("Dance");
		group2.addHobbies("Football");
		group2.addHobbies("Singing");
		
		group3.addHobbies("Walking");
		group3.addHobbies("Skating");
		
		group4.addHobbies("Running");
		group4.addHobbies("Gaming");
		group4.addHobbies("Drinking");
		group4.addHobbies("Gambling");
	
		// adding premium users
		 
		user1.setPremium(true);
		user2.setPremium(true);
		user3.setPremium(true);
		user4.setPremium(true);
		
		// creating login page and sign up page classes
		
		
		LoginPage Login = new LoginPage();
		SignUpPage Signup = new SignUpPage();
		
		// adding the classes to each others frame map.
		
		Login.addOtherFrames("Signup", Signup);
		Signup.addOtherFrames("Login", Login);
		
		// enabling login gui
		Login.setVisible(true);
		
		
		
	}

}
