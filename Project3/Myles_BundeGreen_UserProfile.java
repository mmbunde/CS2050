import java.awt.image.BufferedImage;

public class Myles_BundeGreen_UserProfile {
    private BufferedImage profilePicture;
    private UserName profileName;
    private String status;
    private AList<Myles_BundeGreen_UserProfile> friend;
    
    Myles_BundeGreen_UserProfile friends = new Myles_BundeGreen_UserProfile();

    public Myles_BundeGreen_UserProfile(){
        profilePicture = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
    }
    
    public BufferedImage getProfilePicture(){
        return profilePicture;
    }

    public void setProfilePicture(BufferedImage newPicture){
        profilePicture = newPicture;
    }

    public UserName getName(){
        return profileName;
    }

    public void setName(String first, String last){
        profileName = new UserName(first, last);
    }

    public void setName(UserName name){
        profileName = name;
    }

    public void setStatus(String stat){
        status = stat;
    }

    public String getStatus(){
        return status;
    }

    public AList<Myles_BundeGreen_UserProfile> getFriends(){
        return friends;
    }

    public void addFriend(Myles_BundeGreen_UserProfile p){
        if(!friends.contains(p)){
            friends.add(p);
        }
    }

    public void removeFriend(Myles_BundeGreen_UserProfile p){
        int foundIndex = -1;
        if(friends.contains(p)){
            for(int i = 1; i <= friends.getLength(); i++){
                if(friends.getEntry(i) == p){
                    foundIndex = i;
            }
            friends.remove(foundIndex);
        
            }
        }
    }

    public String toString(){
        return "Name: " + getName() + "\n\tStatus: " + getStatus()
        + "\n\tPicture: " +  getProfilePicture().toString().substring(0, 20)
        + "\n\t# of friends: " + friends.getLength() + "\n";
    }

    public void display(){
        System.out.println(toString());
        System.out.println("Friends: ");
        for(int i = 1; i <= friends.getLength(); i++){
            System.out.println("\t" + friends.getEntry(i).getName());
        }
    }


}
