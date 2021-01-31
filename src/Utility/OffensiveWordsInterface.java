package Utility;

import model.Post;

//interface
public interface OffensiveWordsInterface {
	boolean checkPostTitle(Post post);
	boolean checkPostDescription(Post post);
	boolean checkskillsrequired(Post post);
}
