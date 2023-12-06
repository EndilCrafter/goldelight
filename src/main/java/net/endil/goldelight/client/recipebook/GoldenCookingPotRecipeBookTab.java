package net.endil.goldelight.client.recipebook;

public enum GoldenCookingPotRecipeBookTab {
    GOLDEN_MEALS("golden_meals"),
    GOLDEN_DRINKS("golden_drinks"),
    GOLDEN_MISC("golden_misc");

    public final String name;

    GoldenCookingPotRecipeBookTab(String name) {
        this.name = name;
    }

    public static GoldenCookingPotRecipeBookTab findByName(String name) {
        for (GoldenCookingPotRecipeBookTab value : values()) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
