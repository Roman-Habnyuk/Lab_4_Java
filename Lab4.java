import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Клас, що представляє зоопарк.
 */
public class Zoo {
    private final String name;
    private final String location;

    private Zoo(Builder builder) {
        this.name = validateName(builder.name);
        this.location = builder.location;
    }

    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return name;
    }

    /**
     * Порівнює два зоопарки за їхнім іменем та розташуванням.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return Objects.equals(name, zoo.name) &&
                Objects.equals(location, zoo.location);
    }

    /**
     * Генерує хеш-код для зоопарку.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    /**
     * Клас для створення об'єкту зоопарку за допомогою патерну Builder.
     */
    public static class Builder {
        private String name;
        private String location;

        public Builder(String name) {
            this.name = name;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Zoo build() {
            return new Zoo(this);
        }
    }
}

/**
 * Клас, що представляє тварину в зоопарку.
 */
public class Animal {
    private final String species;
    private final int age;

    public Animal(String species, int age) {
        this.species = validateSpecies(species);
        this.age = validateAge(age);
    }

    private String validateSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species cannot be null or empty");
        }
        return species;
    }

    private int validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        return age;
    }

    /**
     * Генерує хеш-код для тварини.
     */
    @Override
    public int hashCode() {
        return Objects.hash(species, age);
    }
}

public static class Builder {
        private String species;
        private int age;

        public Builder(String species) {
            this.species = species;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }
}

/**
 * Клас, що представляє вольєр для тварин в зоопарку.
 */
public class Enclosure {
    private final String type;
    private final int capacity;

    public Enclosure(String type, int capacity) {
        this.type = validateType(type);
        this.capacity = validateCapacity(capacity);
    }

    private String validateType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        return type;
    }

    private int validateCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        return capacity;
    }

    /**
     * Порівнює два вольєри за їхнім типом та вмісткістю.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enclosure enclosure = (Enclosure) o;
        return capacity == enclosure.capacity &&
                Objects.equals(type, enclosure.type);
    }

    /**
     * Генерує хеш-код для вольєру.
     */
    @Override
    public int hashCode() {
        return Objects.hash(type, capacity);
    }
}

public static class Builder {
        private String type;
        private int capacity;

        public Builder(String type) {
            this.type = type;
        }

        public Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Enclosure build() {
            return new Enclosure(this);
        }
    }
}
