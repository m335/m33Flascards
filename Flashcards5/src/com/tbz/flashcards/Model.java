package com.tbz.flashcards;

public class Model {

	  private String name;
	  private boolean selected;

	  /**
	   * 
	   * @param name
	   */
	  public Model(String name) {
	    this.name = name;
	    selected = false;
	  }

	  /**
	   * 
	   * @return
	   */
	  public String getName() {
	    return name;
	  }

	  /**
	   * 
	   * @param name
	   */
	  public void setName(String name) {
	    this.name = name;
	  }

	  /**
	   * 
	   * @return
	   */
	  public boolean isSelected() {
	    return selected;
	  }

	  /**
	   * 
	   * @param selected
	   */
	  public void setSelected(boolean selected) {
	    this.selected = selected;
	  }

	} 
