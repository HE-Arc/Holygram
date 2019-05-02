package ch.hearc.holygram.data;

import ch.hearc.holygram.models.Exorcist;
import ch.hearc.holygram.models.User;

/**
 * Mini data classes to store the search results
 */
public class SearchResultDataWrapper {
	private Exorcist exorcist;
	private User user;
	private float price;

	public SearchResultDataWrapper(Exorcist exorcist, User user, float price) {
		this.setExorcist(exorcist);
		this.setUser(user);
		this.setPrice(price);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Exorcist getExorcist() {
		return exorcist;
	}

	public void setExorcist(Exorcist exorcist) {
		this.exorcist = exorcist;
	}
}
