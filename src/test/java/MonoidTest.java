import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MonoidTest {

    public static final Food BREAD = new Food(true, Diet.VEGAN, new NutritionFacts(2, 0.2, 100000));
    public static final Food SALAD = new Food(true, Diet.VEGAN, new NutritionFacts(0, 0, 50));
    public static final Food CHEESE = new Food(false, Diet.VEGETARIAN, new NutritionFacts(80, 0, 20000));
    public static final Food TUNA = new Food(false, Diet.PESCITARIAN, new NutritionFacts(150, 0.1, 30000));


    @Test
    void should_return_vegan_when_two_vegan_ingredients_are_combined() {
        // When
        Food result = BREAD.combine(SALAD);
        // Then
        assertThat(result.isOkFor(Diet.VEGAN)).isTrue();
        assertThat(result.isOrganic()).isTrue();

        NutritionFacts resultNutritionFacts = result.getNutritionFacts();
        assertThat(resultNutritionFacts.getFat()).isEqualTo(2);
        assertThat(resultNutritionFacts.getSalt()).isEqualTo(0.2);
        assertThat(resultNutritionFacts.getCalories()).isEqualTo(100050);
    }

    @Test
    void should_return_vegetarian_when_one_vegan_one_vegetarian_ingredients_are_combined() {
        // When
        Food result = CHEESE.combine(SALAD);
        // Then
        assertThat(result.isOkFor(Diet.VEGETARIAN)).isTrue();
        assertThat(result.isOrganic()).isFalse();
    }


    @Test
    void should_return_pescitarian_when_two_vegan_one_vegetarian_one_pescitarian_are_combined() {

        Food result = BREAD.combine(SALAD).combine(CHEESE).combine(TUNA);

        assertThat(result.isOkFor(Diet.PESCITARIAN)).isTrue();

    }
}
