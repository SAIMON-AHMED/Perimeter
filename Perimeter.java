import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner extends HelloWorld {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count = 0;
        for (Point point : s.getPoints()) {
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double avg = getPerimeter(s) / getNumPoints(s);
        return avg;
    }

    public double getLargestSide(Shape s) {
        double largestSide = 0;
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if (currDist > largestSide) {
                largestSide = currDist;
            } 
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        int x = 0;
        for (Point point : s.getPoints()) {
            if (point.getX() > x) {
                x = point.getX();
            }
        }    
        return (double)x;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource();
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if (largestPerimeter < perimeter) {
                largestPerimeter = perimeter;
            }    
        }    
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0;
        File temp = null;// replace this code
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource();
            Shape s = new Shape(fr);
            double perimeter = getPerimeter(s);
            if (perimeter > largestPerimeter) {
                temp = f;
                largestPerimeter = perimeter;
            }
        }    
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numberOfPoints = getNumPoints(s);
        System.out.println("Number of Points in the given shape is " +
        numberOfPoints);
        double average = getAverageLength(s);
        System.out.println("Average length of sides is " + average);
        double largestSide = getLargestSide(s);
        System.out.println("Largest value of the sides is " + largestSide);
        double x = getLargestX(s);
        System.out.println("The largest x value of the points is " + x);
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter is " + largestPerimeter);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter is " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        String temp = getFileWithLargestPerimeter();
        System.out.println("The name of file is " + temp);
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testFileWithLargestPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
