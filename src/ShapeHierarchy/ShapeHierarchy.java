// File: Shape.java
abstract class Shape {
    protected String name;
    
    public Shape(String name) {
        this.name = name;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateArea();
    
    // Concrete method - can be used by all subclasses
    public void displayInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Area: " + calculateArea());
        System.out.println("------------------------");
    }
}

// File: Rectangle.java
class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Width: " + width + ", Height: " + height);
        System.out.println("Area: " + calculateArea());
        System.out.println("------------------------");
    }
}

// File: Circle.java
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("------------------------");
    }
}

// File: Triangle.java
class Triangle extends Shape {
    private double base;
    private double height;
    
    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Base: " + base + ", Height: " + height);
        System.out.println("Area: " + calculateArea());
        System.out.println("------------------------");
    }
}

// File: ShapeHierarchy.java (Main file - matches your file name)
class ShapeHierarchy {
    public static void main(String[] args) {
        System.out.println("=== SHAPE HIERARCHY DEMONSTRATION ===\n");
        
        // Create an array of different shapes using polymorphism
        Shape[] shapes = {
            new Rectangle(5.0, 3.0),
            new Circle(4.0),
            new Triangle(6.0, 8.0),
            new Rectangle(7.5, 2.0),
            new Circle(2.5),
            new Triangle(10.0, 5.0)
        };
        
        // Display information for each shape
        System.out.println("Individual Shape Information:");
        System.out.println("============================");
        for (Shape shape : shapes) {
            shape.displayInfo(); // Polymorphism in action!
        }
        
        // Calculate and display total area
        double totalArea = 0.0;
        System.out.println("\nCalculating Total Area Using Polymorphism:");
        System.out.println("==========================================");
        
        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            System.out.println(shape.name + " area: " + String.format("%.2f", area));
            totalArea += area;
        }
        
        System.out.println("\n*** TOTAL AREA OF ALL SHAPES: " + String.format("%.2f", totalArea) + " ***");
        
        // Demonstrate polymorphism with method calls
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION ===");
        System.out.println("Same method call, different behavior:");
        
        Shape rect = new Rectangle(4.0, 6.0);
        Shape circ = new Circle(3.0);
        Shape tri = new Triangle(5.0, 4.0);
        
        demonstratePolymorphism(rect);
        demonstratePolymorphism(circ);
        demonstratePolymorphism(tri);
    }
    
    // Method that accepts any Shape object - demonstrates polymorphism
    public static void demonstratePolymorphism(Shape shape) {
        System.out.println("Processing a " + shape.name + 
                         " with area: " + String.format("%.2f", shape.calculateArea()));
    }
}
