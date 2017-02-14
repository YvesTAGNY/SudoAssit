package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Score {

	private StringProperty name;
	private StringProperty scoreString;
	private IntegerProperty score;
	
	public Score(String name, int score) {
		this.name = new SimpleStringProperty(name);
		this.score = new SimpleIntegerProperty(score);
		this.scoreString = new SimpleStringProperty(""+score);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		 this.name.set(name);
	}
	
	public StringProperty nameProperty() {
        return name;
    }

	public int getScore() {
		return score.get();
	}

	public void setScore(int score) {
		this.score.set(score);
	}
	
	public IntegerProperty scoreProperty() {
        return score;
    }
	
	public String getScoreString() {
		return scoreString.get();
	}

	public void setScoreString(int score) {
		this.scoreString.set(""+score);
	}
	
	public StringProperty scoreStringProperty() {
        return scoreString;
    }
	
}
