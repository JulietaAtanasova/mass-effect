package interfaces;

import java.util.List;

import gameobjects.enhancements.Enhancement;

public interface Enhanceable {
	List<Enhancement> getEnhancements();

	void addEnhancement(Enhancement enhancement);
}
