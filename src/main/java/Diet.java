public enum Diet {
    VEGAN(0),
    VEGETARIAN(1),
    PESCITARIAN(2);

    private final int priority;

    Diet(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public Diet combine(Diet diet) {
        return this.getPriority() > diet.getPriority() ? this : diet;
    }
}
