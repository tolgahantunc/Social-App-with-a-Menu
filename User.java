import java.util.ArrayList;

public class User {
	private String name;
	private ArrayList<String> posts = new ArrayList<String>();
	private ArrayList<User> following = new ArrayList<User>();
	private ArrayList<User> follower = new ArrayList<User>();
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	//"getMessage" method is used to list of all messages of any users.
	public void getMessage() {
		System.out.println(name + " have " + posts.size() + " posts:");
		for (String u: posts)
			System.out.println(u);
	}
	
	public void postMessage(String message) {
		posts.add(message);
	}
	
	/*In "follow" method, when selected user "t" starts to following to 
	 * other user "u"; at the same time this situaiton have the same meaning with
	 * u is followed by t. That is why, in "u.follower.add(t)" line, program adds
	 * user t as a follower of u.
	*/
	public void follow(User u, User t) {
		following.add(u);
		u.follower.add(t);
	}
	
	//"getFollowing" method is used to list of all users which are following from selected user.
	public void getFollowing() {
		System.out.println(name + " is following " + following.size() + " users:");
		for (User u: following)
			System.out.println(u.getName());
	}
	
	//"getFollower" method is used to list of all followers of selected user.
	public void getFollower() {
		System.out.println(name + " has " + follower.size() + " followers:");
		for (User u: follower)
			System.out.println(u.getName());
	}

}
