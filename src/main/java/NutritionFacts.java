import lombok.Value;

@Value
public class NutritionFacts {
    double fat;
    double salt;
    double calories;

    public NutritionFacts combine(NutritionFacts nutritionFacts) {
        double fat = this.fat + nutritionFacts.getFat();
        double salt = this.salt + nutritionFacts.getSalt();
        double calories = this.calories + nutritionFacts.getCalories();
        return new NutritionFacts(fat, salt, calories);
    }
}
