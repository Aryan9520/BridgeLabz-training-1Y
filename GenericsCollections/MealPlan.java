import java.util.*;

interface MealPlan {
    String getMealName();
}

class VegetarianMeal implements MealPlan {
    public String getMealName() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMealName() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMealName() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealName() {
        return "High Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    private T meal;

    public void setMeal(T meal) {
        this.meal = meal;
    }

    public T getMeal() {
        return meal;
    }
}

public class Main {

    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal, T plan) {
        meal.setMeal(plan);
        System.out.println("Generated: " + meal.getMeal().getMealName());
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> vegMeal = new Meal<>();
        Meal<VeganMeal> veganMeal = new Meal<>();
        Meal<KetoMeal> ketoMeal = new Meal<>();
        Meal<HighProteinMeal> proteinMeal = new Meal<>();

        generateMealPlan(vegMeal, new VegetarianMeal());
        generateMealPlan(veganMeal, new VeganMeal());
        generateMealPlan(ketoMeal, new KetoMeal());
        generateMealPlan(proteinMeal, new HighProteinMeal());
    }
}