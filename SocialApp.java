import java.util.*;

public class SocialApp {
	private ArrayList<User> users = new ArrayList<User>();

	private static  Scanner keyboard ;
	
	public User addUser(String name) {
		User u = new User(name);
		users.add(u);
		return u;
	}
		
	public void printUsers() {
		for (User u:users)
			System.out.println(u.getName());
	}
	
	/*
	 * Below checkIndex method, program checks if user-name, which is 
	 * taken by parameter "String userName", is in our list or not.
	 * The variable "x" represents index of user-name.
	 * If user-name is not in our list, checkIndex method returns -1.
	 * The mean of "-1" is user-name is not in user list.
	 */
	public int checkIndex(String userName){
		int x=0;
		for(User name:users){
			if(name.getName().equals(userName)){
				return x;
			}
			x++;
		}
		return -1;
	}
	
	public void run() {
		
		keyboard = new Scanner(System.in); //"keyboard" is used to take entry from user.
		Menu menu = new Menu();
		
		menu.addItem(new MenuItem("Add User", new MenuCommand() {
			
			@Override
			public void run() {
			   System.out.println("Please enter your name.");
			   String userName = keyboard.nextLine();
			   addUser(userName);
			}
		}));
		
		menu.addItem(new MenuItem("List Users",new MenuCommand() {
			
			@Override
			public void run() {
				System.out.println("List of all users:");
				printUsers();
			}
		}));
		
		menu.addItem(new MenuItem("Post Message", new MenuCommand() {
			
			@Override
			public void run() {
				//As I said above, the mean of "-1" is user-name is not in user list.
				int indexNumOfUser = -1;
				while(true){
				   System.out.println("Please enter a user name to post message.");
				   String userName = keyboard.nextLine();
				   indexNumOfUser = checkIndex(userName);
				   if(indexNumOfUser != -1){
					   break;
				   }
			   }
			   System.out.println("Please enter your post message.");
			   String postMsg = keyboard.nextLine();
			   users.get(indexNumOfUser).postMessage(postMsg);
			}
		}));
		
		menu.addItem(new MenuItem("Message List", new MenuCommand() {
			
			@Override
			public void run(){
				int indexNumOfUser = -1;
				while(true){
					System.out.println("Please enter a user name to list her/his messages.");
					String userName = keyboard.nextLine();
					indexNumOfUser = checkIndex(userName);
					if(indexNumOfUser != -1){
						break;
						}
					}
				users.get(indexNumOfUser).getMessage();
			}
		}));
		
		menu.addItem(new MenuItem("Follow", new MenuCommand() {
			
			@Override
			public void run() {
				int indexNumOfUser = -1;
				int indexNumOfUsertoFollow = -1;
				while(true){
					System.out.println("Please enter your user name.");
					String userName = keyboard.nextLine();
					System.out.println("Please enter a user name to follow.");
					String userNameToFollow = keyboard.nextLine();
					indexNumOfUser = checkIndex(userName);
					indexNumOfUsertoFollow = checkIndex(userNameToFollow);
					if(indexNumOfUser != -1 || indexNumOfUsertoFollow != -1 ){
						break;
						}
					}
				/*
				 * Plase look "follow" method (in User.java file) to understand
				 * what program is doing with the line in below. 
				 */
				users.get(indexNumOfUser).follow(users.get(indexNumOfUsertoFollow),users.get(indexNumOfUser));
			}
		}));
		
		menu.addItem(new MenuItem("Following List", new MenuCommand() {
			
			@Override
			public void run() {
				int indexNumOfUser = -1;
				while(true){
					System.out.println("Please enter a user name to list his/her follow list.");
					String userName = keyboard.nextLine();
					indexNumOfUser = checkIndex(userName);
					if(indexNumOfUser != -1){
						break;
						}
					}
				users.get(indexNumOfUser).getFollowing();
			}
		}));
		
		menu.addItem(new MenuItem("Follower List", new MenuCommand() {
			
			@Override
			public void run() {
				int indexNumOfUser = -1;
				while(true){
					System.out.println("Please enter a user name to list his/her follow list.");
					String userName = keyboard.nextLine();
					indexNumOfUser = checkIndex(userName);
					if(indexNumOfUser != -1){
						break;
						}
					}
				users.get(indexNumOfUser).getFollower();
			}
		}));
		
		menu.addItem(new MenuItem("Quit", new MenuCommand() {
			
			@Override
			public void run() {
				System.out.println("Program ends");
				System.exit(0);		
			}
		}));
		
		while(true)
			menu.display();
	}

}
