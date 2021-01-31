package Utility;

import model.Post;

//checks for offensive words
//extends OffensiveWordsChecker class and implements OffensiveWordsInterface 
public class CheckPost extends OffensiveWordsChecker implements OffensiveWordsInterface{
	
	//offensive words
	String[] bad_words = {"2 girls 1 cup","2g1c","arsehole","ass","5hit","a$$","a$$hole","a_s_s","a2m","a54","a55","a55hole","acrotomophilia","ass fuck","ahole","alabama hot pocket","alaskan pipeline","anal","anal impaler","anal leakage","ass hole","anilingus","anus","apeshit","b1tch"};
	
	private boolean Check(String str) {
		String[] sample=str.split(" ");
		for(int i=0;i<sample.length;i++) {
			for(int j=0;j<bad_words.length;j++) {
				if (sample[i].equalsIgnoreCase(bad_words[j]))
					return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean checkPostTitle(Post post) {
		if (Check(post.getJobtitle()))
			return true;
		return false;
	}

	@Override
	public boolean checkPostDescription(Post post) {
		if(Check(post.getDescription()))
			return true;
		return false;
	}
	
	@Override
	public boolean checkskillsrequired(Post post) {
		if(Check(post.getSkillsrequired()))
			return true;
		return false;
	}
	
	//checks for description,title,skills required
	@Override
	public boolean checkPost(Post post) {
		if(post == null)
			return false;
		if(checkPostDescription(post) && checkPostTitle(post) && checkskillsrequired(post))
			return true;
		return false;
	}
	

}
