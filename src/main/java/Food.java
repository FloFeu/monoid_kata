import lombok.Value;

@Value
public class Food {
    boolean isOrganic;
    Diet diet;
    NutritionFacts nutritionFacts;

    public Food combine(Food food) {
        Diet diet = this.diet.combine(food.getDiet());
        boolean isOrganic = this.isOrganic && food.isOrganic;
        NutritionFacts nutritionFacts = this.nutritionFacts.combine(food.nutritionFacts);
        return new Food(isOrganic, diet, nutritionFacts);
    }

    public boolean isOkFor(Diet diet) {
        return this.diet == diet;
    }
}
