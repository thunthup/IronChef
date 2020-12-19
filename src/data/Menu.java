package data;

import java.util.ArrayList;

import javafx.scene.layout.Pane;

public class Menu {
	
	private ArrayList<Ingredient> allIngredient = new ArrayList<Ingredient>();
	
	private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private ArrayList<String> nameList = new ArrayList<String>();
	
	private int score;
	
		
	public Menu() {
		Pane temp = new Pane();
		allIngredient.add(new Bacon(temp));
		allIngredient.add(new Bacon(temp).fried());
		allIngredient.add(new Basil(temp));
		allIngredient.add(new Bread(temp));
		allIngredient.add(new Bread(temp).fried());
		allIngredient.add(new Broccoli(temp));
		allIngredient.add(new Broccoli(temp).fried());
		allIngredient.add(new Carrot(temp));
		allIngredient.add(new Cheese(temp));
		allIngredient.add(new Cheese(temp).fried());
		allIngredient.add(new Egg(temp));
		allIngredient.add(new Egg(temp).fried());
		allIngredient.add(new Fish(temp));
		allIngredient.add(new Fish(temp).boiled());
		allIngredient.add(new Fish(temp).chopped());
		allIngredient.add(new Tomato(temp));
		allIngredient.add(new Tomato(temp).boiled());
		allIngredient.add(new Tomato(temp).chopped());
		int randomNum = 1+ (int) Math.round(Math.random()*2);
		score = randomNum * 600;
		for(int i = 0;i<randomNum;i++) {
			ingredientList.add(allIngredient.get((int)Math.round(Math.random()*(allIngredient.size()-1))));
		}
		for(Ingredient ingredient : ingredientList) {
			nameList.add(ingredient.getIngredientName());
		}
	
		for(String name : nameList) {
			System.out.println(name);
		}
	}


	public ArrayList<Ingredient> getAllIngredient() {
		return allIngredient;
	}


	public void setAllIngredient(ArrayList<Ingredient> allIngredient) {
		this.allIngredient = allIngredient;
	}


	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}


	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public ArrayList<String> getNameList() {
		return nameList;
	}


	public void setNameList(ArrayList<String> nameList) {
		this.nameList = nameList;
	}
	
		
}
