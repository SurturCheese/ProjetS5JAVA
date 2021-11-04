package projetS5;

public class Pellet {
	private String color; //blue, purple, orange, green
	private int points; //blue=100, purple=300, orange=500, green=0
	
	Pellet(){
		this.color = "blue";
		if(this.color.equals("blue"))this.points=100;
		if(this.color.equals("purple"))this.points=300;
		if(this.color.equals("orange"))this.points=500;
		if(this.color.equals("green"))this.points=0;
		else this.points=100;
	}
}
