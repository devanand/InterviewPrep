/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.others;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author anand
 */
public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        Collection <Friend> closeFriends = this.getFriends();
        if (closeFriends == null || closeFriends.isEmpty())
        {
            return false;
        }
        for (Friend closeFriend : closeFriends)
        {
            if(closeFriend == friend)
            {
                return true;
            }
            return canBeConnected(closeFriend);
        }
        return false;
    }
    
    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
        Friend d = new Friend("D");

        a.addFriendship(b);
        b.addFriendship(c);
        c.addFriendship(d);

        System.out.println(a.canBeConnected(d));
    }
}
