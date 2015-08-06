package interfaces;

import gameobjects.enhancements.Enhancement;

public interface Enhanceable {
	Iterable<Enhancement> getEnhancements();

	void addEnhancement(Enhancement enhancement);
}
