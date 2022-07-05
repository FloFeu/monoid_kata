import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DietTest {

    @Test
    void should_return_vegan_when_combine_vegan() {
        assertThat(Diet.VEGAN.combine(Diet.VEGAN)).isEqualTo(Diet.VEGAN);
    }

    @Test
    void should_return_vegetarian_when_combine_vegan_and_vegetarian() {
        assertThat(Diet.VEGETARIAN.combine(Diet.VEGAN)).isEqualTo(Diet.VEGETARIAN);
    }

}
