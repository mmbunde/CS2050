public class Myles_BundeGreen_UserProfileManager {
    private AList<Myles_BundeGreen_UserProfile> allProfiles;

    public Myles_BundeGreen_UserProfileManager(){
        allProfiles = new AList<>();
    }

    public void addProfile(Myles_BundeGreen_UserProfile p){
        allProfiles.add(p);
    }

    public void removeProfile(Myles_BundeGreen_UserProfile p){
        if(allProfiles.contains(p)){
            for(int i = 1; i <= allProfiles.getLength(); i++){
                allProfiles.getEntry(i).removeFriend(p);
            }
            int foundIndex = -1;
            for(int i = 1; i <= allProfiles.getLength() && foundIndex == -1; i++){
                if(allProfiles.getEntry(i) == p){
                    foundIndex = i;
                }
            }
            allProfiles.remove(foundIndex);
        }
    }
    public void createFriendship(Myles_BundeGreen_UserProfile a, Myles_BundeGreen_UserProfile b){
        a.addFriend(b);
        b.addFriend(a);
    }

    public void endFriendship(Myles_BundeGreen_UserProfile a, Myles_BundeGreen_UserProfile b){
        a.removeFriend(b);
        b.removeFriend(a);
    }

    public void display(){
        for(int i = 1; i <+ allProfiles.getLength(); i++){
            allProfiles.getEntry(i).display();
            System.out.println();
        }
    }
}